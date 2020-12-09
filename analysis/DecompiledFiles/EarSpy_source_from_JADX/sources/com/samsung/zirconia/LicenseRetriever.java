package com.samsung.zirconia;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

class LicenseRetriever {
    private String applicationID;
    private String deviceIMEI;
    private String deviceIMSI;
    private String deviceMIN;
    private String deviceModel;
    private int errorCode = 0;
    private String executableFilePath;
    private URL httpURL;
    private HttpURLConnection httpUrlConnection;
    private String licenseFilePath;
    private int numRedirects;

    public LicenseRetriever(String deviceIMEI2, String applicationID2, String deviceIMSI2, String deviceModel2, String deviceMIN2, String licenseFilePath2, String executableFilePath2) {
        this.deviceIMEI = deviceIMEI2;
        this.applicationID = applicationID2;
        this.deviceIMSI = deviceIMSI2;
        this.deviceModel = deviceModel2;
        this.deviceMIN = deviceMIN2;
        this.licenseFilePath = licenseFilePath2;
        this.executableFilePath = executableFilePath2;
    }

    public int retrieveLicense() {
        try {
            this.errorCode = 62;
            open();
            sendRequest();
            this.errorCode = 61;
            receiveResponse();
            close();
        } catch (LicenseRetrieverException | IOException | MalformedURLException e) {
        }
        return this.errorCode;
    }

    private String urlEncode(String s) {
        return URLEncoder.encode(s).replaceAll("\\+", "%20");
    }

    private String makeParameter() {
        return String.format("deviceid=%s&applicationid=%s&subscriberid=%s&model=%s&min=%s&version=%s", new Object[]{urlEncode(this.deviceIMEI), urlEncode(this.applicationID), urlEncode(this.deviceIMSI), urlEncode(this.deviceModel), urlEncode(this.deviceMIN), urlEncode(String.format("%02d%03d", new Object[]{1, 120}))});
    }

    private void open() throws MalformedURLException {
        String urlString = "https://zirconia.samsungapps.com:443/chkLicense.as";
        if ("POST".compareToIgnoreCase("GET") == 0) {
            urlString = String.valueOf(urlString) + "?" + makeParameter();
        }
        this.numRedirects = 0;
        this.httpURL = new URL(urlString);
        this.httpUrlConnection = null;
        HttpURLConnection.setFollowRedirects(false);
    }

    private void sendRequest() throws MalformedURLException, IOException {
        this.httpUrlConnection = (HttpURLConnection) this.httpURL.openConnection();
        this.httpUrlConnection.setRequestProperty("Acceept", "*/*");
        this.httpUrlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        this.httpUrlConnection.setRequestProperty("User-agent", "ZrO2-ADR");
        this.httpUrlConnection.setDefaultUseCaches(false);
        this.httpUrlConnection.setUseCaches(false);
        if (this.numRedirects == 0 && "POST".compareToIgnoreCase("POST") == 0) {
            String postParameterData = makeParameter();
            this.httpUrlConnection.setDoOutput(true);
            this.httpUrlConnection.setRequestMethod("POST");
            OutputStream outputStream = this.httpUrlConnection.getOutputStream();
            outputStream.write(postParameterData.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();
        }
        int responseCode = this.httpUrlConnection.getResponseCode();
        if (responseCode >= 300 && responseCode <= 307 && responseCode != 306 && responseCode != 304) {
            URL base = this.httpUrlConnection.getURL();
            String loc = this.httpUrlConnection.getHeaderField("Location");
            if (loc != null) {
                this.httpURL = new URL(base, loc);
            }
            this.httpUrlConnection.disconnect();
            if (this.httpURL == null || this.numRedirects >= 5) {
                throw new SecurityException("illegal URL redirect");
            }
            this.numRedirects++;
            sendRequest();
        }
    }

    private void receiveResponse() throws IOException, LicenseRetrieverException {
        byte[] buffer = new byte[512];
        new DataInputStream(new BufferedInputStream(this.httpUrlConnection.getInputStream())).read(buffer, 0, buffer.length);
        byte[] bufferHeader = new byte[12];
        System.arraycopy(buffer, 0, bufferHeader, 0, 11);
        String licenseResponseHeader = new String(bufferHeader);
        if (!licenseResponseHeader.startsWith("ZrO2")) {
            this.errorCode = 71;
            throw new LicenseRetrieverException(this, (LicenseRetrieverException) null);
        }
        int serverResponseCode = Integer.valueOf(licenseResponseHeader.substring(9, 11)).intValue();
        if (serverResponseCode != 12) {
            this.errorCode = serverResponseCode;
            throw new LicenseRetrieverException(this, (LicenseRetrieverException) null);
        }
        byte[] licenseKey = new byte[40];
        System.arraycopy(buffer, 11, licenseKey, 0, 20);
        if (!NativeInterface.storeLicenseKey(this.licenseFilePath, licenseKey, this.executableFilePath)) {
            this.errorCode = 81;
            throw new LicenseRetrieverException(this, (LicenseRetrieverException) null);
        } else {
            this.errorCode = 50;
        }
    }

    private void close() {
        this.httpURL = null;
        if (this.httpUrlConnection != null) {
            this.httpUrlConnection.disconnect();
        }
        this.httpUrlConnection = null;
    }

    private static void disableSSLCertificateChecking() {
        TrustManager[] trustAllCerts = {new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
            }
        }};
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init((KeyManager[]) null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
    }

    private class LicenseRetrieverException extends Exception {
        private static final long serialVersionUID = 1;

        private LicenseRetrieverException() {
        }

        /* synthetic */ LicenseRetrieverException(LicenseRetriever licenseRetriever, LicenseRetrieverException licenseRetrieverException) {
            this();
        }
    }

    static {
        disableSSLCertificateChecking();
    }
}
