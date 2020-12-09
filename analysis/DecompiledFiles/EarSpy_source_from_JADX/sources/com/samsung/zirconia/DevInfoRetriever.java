package com.samsung.zirconia;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

class DevInfoRetriever {
    private String deviceMIN;
    private String deviceOEMInfo = Build.PRODUCT;
    private String deviceSerialNumber;
    private String deviceSubscriberNumber;
    private boolean isEmulator;

    public DevInfoRetriever(Activity activity) {
        Context mAppContext = activity.getApplicationContext();
        TelephonyManager tMgr = (TelephonyManager) mAppContext.getSystemService("phone");
        String deviceIMEI = tMgr.getDeviceId();
        String flashSerialNumber = getSystemProperties(mAppContext, "ro.serialno", "Unknown");
        this.deviceSubscriberNumber = tMgr.getSubscriberId();
        this.deviceMIN = tMgr.getLine1Number();
        if (deviceIMEI == null || deviceIMEI.compareTo("000000000000000") != 0) {
            this.isEmulator = false;
        } else {
            this.isEmulator = true;
        }
        if (this.isEmulator || tMgr.getPhoneType() != 0) {
            this.deviceSerialNumber = deviceIMEI;
        } else if (flashSerialNumber == null || flashSerialNumber.equals("Unknown")) {
            this.deviceSerialNumber = "000000000000000";
        } else {
            this.deviceSerialNumber = flashSerialNumber;
        }
    }

    public String getIMEI() {
        return this.deviceSerialNumber == null ? "" : this.deviceSerialNumber;
    }

    public String getIMSI() {
        return this.deviceSubscriberNumber == null ? "" : this.deviceSubscriberNumber;
    }

    public String getModel() {
        return this.deviceOEMInfo == null ? "" : this.deviceOEMInfo;
    }

    public String getMIN() {
        return this.deviceMIN == null ? "" : this.deviceMIN;
    }

    public boolean isEmulator() {
        return this.isEmulator;
    }

    private static String getSystemProperties(Context context, String key, String def) {
        String str = def;
        try {
            Class SystemProperties = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) SystemProperties.getMethod("get", new Class[]{String.class, String.class}).invoke(SystemProperties, new Object[]{new String(key), new String(def)});
        } catch (IllegalArgumentException e) {
            return def;
        } catch (Exception e2) {
            return def;
        }
    }
}
