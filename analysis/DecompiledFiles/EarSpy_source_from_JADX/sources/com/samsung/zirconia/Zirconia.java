package com.samsung.zirconia;

import android.app.Activity;
import android.util.Log;
import java.io.File;

public class Zirconia {
    public static final int EZIRCONIA_APPLICATION_MODIFIED = 82;
    public static final int EZIRCONIA_CANNOT_CHECK = 31;
    public static final int EZIRCONIA_CLIENT_MISMATCH = 21;
    public static final int EZIRCONIA_INVALID_VALUE = 23;
    public static final int EZIRCONIA_KEY_CREATION_FAILED = 81;
    public static final int EZIRCONIA_LICENSE_MISMATCH = 50;
    public static final int EZIRCONIA_NOT_PURCHASED = 11;
    public static final int EZIRCONIA_RECEIVE_FAILED = 61;
    public static final int EZIRCONIA_SEND_FAILED = 62;
    public static final int EZIRCONIA_SERVER_MISMATCH = 71;
    public static final int EZIRCONIA_SUCCESS = 0;
    public static final int EZIRCONIA_VERSION_MISMATCH = 22;
    /* access modifiers changed from: private */
    public String applicationID;
    /* access modifiers changed from: private */
    public boolean checkLocalOnly;
    /* access modifiers changed from: private */
    public Activity currentActivity;
    /* access modifiers changed from: private */
    public String deviceIMEI;
    /* access modifiers changed from: private */
    public String deviceIMSI;
    /* access modifiers changed from: private */
    public String deviceMIN;
    /* access modifiers changed from: private */
    public String deviceModel;
    /* access modifiers changed from: private */
    public boolean isApplicationHacked;
    private boolean isEmulator;
    /* access modifiers changed from: private */
    public boolean isWorking;
    /* access modifiers changed from: private */
    public LicenseCheckListener licenseCheckListener = null;
    /* access modifiers changed from: private */
    public String licenseFilePath;
    private int threadPriority;
    /* access modifiers changed from: private */
    public int zirconiaError;

    public Zirconia(Activity activity) {
        this.currentActivity = activity;
        DevInfoRetriever devInfoRetriever = new DevInfoRetriever(this.currentActivity);
        this.isEmulator = devInfoRetriever.isEmulator();
        this.isApplicationHacked = false;
        this.threadPriority = 5;
        this.zirconiaError = 0;
        this.checkLocalOnly = false;
        this.applicationID = activity.getPackageName();
        this.deviceIMEI = devInfoRetriever.getIMEI();
        this.deviceIMSI = devInfoRetriever.getIMSI();
        this.deviceModel = devInfoRetriever.getModel();
        this.deviceMIN = devInfoRetriever.getMIN();
        this.licenseFilePath = String.valueOf(activity.getDir("zirconia", 0).getAbsolutePath()) + "/" + "zirconia.dat";
        this.isWorking = false;
    }

    public void setLicenseCheckListener(LicenseCheckListener listener) {
        this.licenseCheckListener = listener;
    }

    public void setThreadPriority(int newPriority) {
        if (newPriority < 1) {
            newPriority = 1;
        }
        if (newPriority < 10) {
            newPriority = 1;
        }
        this.threadPriority = newPriority;
    }

    public void setBogusIMEI(String bogusIMEI) {
        if (this.isEmulator) {
            this.deviceIMEI = bogusIMEI;
        }
    }

    public void checkLicense(boolean checkLocalOnly2, boolean dontUseThread) {
        if (!isWorking()) {
            this.isWorking = true;
            this.checkLocalOnly = checkLocalOnly2;
            CheckerRunnable checkerRunnable = new CheckerRunnable(this, (CheckerRunnable) null);
            if (dontUseThread) {
                checkerRunnable.run();
                return;
            }
            Thread checkerThread = new Thread(checkerRunnable);
            checkerThread.setPriority(this.threadPriority);
            checkerThread.start();
        }
    }

    public boolean deleteLicense() {
        File file = new File(this.licenseFilePath);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    public boolean isWorking() {
        return this.isWorking;
    }

    public int getError() {
        return this.zirconiaError;
    }

    public ZirconiaVersion version() {
        return new ZirconiaVersion(1, 120, 0);
    }

    private class CheckerRunnable implements Runnable {
        private CheckerRunnable() {
        }

        /* synthetic */ CheckerRunnable(Zirconia zirconia, CheckerRunnable checkerRunnable) {
            this();
        }

        public void run() {
            checkerThreadWorker();
        }

        /* access modifiers changed from: package-private */
        public void checkerThreadWorker() {
            boolean unlocked = false;
            Zirconia.this.zirconiaError = 11;
            if (checkLicenseFile()) {
                if (checkLicenseFilePhase2()) {
                    Zirconia.this.zirconiaError = 0;
                    unlocked = true;
                } else {
                    Zirconia.this.zirconiaError = 82;
                    Zirconia.this.isApplicationHacked = true;
                }
            } else if (!Zirconia.this.checkLocalOnly) {
                Zirconia.this.zirconiaError = new LicenseRetriever(Zirconia.this.deviceIMEI, Zirconia.this.applicationID, Zirconia.this.deviceIMSI, Zirconia.this.deviceModel, Zirconia.this.deviceMIN, Zirconia.this.licenseFilePath, Zirconia.this.currentActivity.getPackageCodePath()).retrieveLicense();
                if (Zirconia.this.zirconiaError == 50 && checkLicenseFile()) {
                    Zirconia.this.zirconiaError = 0;
                    unlocked = true;
                }
            }
            if (unlocked) {
                if (Zirconia.this.licenseCheckListener != null) {
                    Zirconia.this.licenseCheckListener.licenseCheckedAsValid();
                }
            } else if (Zirconia.this.licenseCheckListener != null) {
                Zirconia.this.licenseCheckListener.licenseCheckedAsInvalid();
            }
            Zirconia.this.isWorking = false;
        }

        /* access modifiers changed from: package-private */
        public boolean checkLicenseFile() {
            return NativeInterface.checkLicenseFile(Zirconia.this.licenseFilePath, Zirconia.this.deviceIMEI, Zirconia.this.applicationID);
        }

        /* access modifiers changed from: package-private */
        public boolean checkLicenseFilePhase2() {
            return NativeInterface.checkLicenseFile2(Zirconia.this.licenseFilePath, Zirconia.this.currentActivity.getPackageCodePath());
        }
    }

    public void doVariablesTest() {
        Log.d("Zirconia", "isEmulator: " + this.isEmulator);
        Log.d("Zirconia", "isApplicationHacked: " + this.isApplicationHacked);
        Log.d("Zirconia", "threadPriority :" + this.threadPriority);
        Log.d("Zirconia", "zirconiaError :" + this.zirconiaError);
        Log.d("Zirconia", "checkLocalOnly :" + this.checkLocalOnly);
        Log.d("Zirconia", "applicationID :" + this.applicationID);
        Log.d("Zirconia", "deviceIMEI :" + this.deviceIMEI);
        Log.d("Zirconia", "deviceIMSI :" + this.deviceIMSI);
        Log.d("Zirconia", "deviceModel :" + this.deviceModel);
        Log.d("Zirconia", "deviceMIN :" + this.deviceMIN);
        Log.d("Zirconia", "licenseFilePath :" + this.licenseFilePath);
    }
}
