package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* renamed from: fF */
    private final int f1499fF;

    GooglePlayServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.f1499fF = i;
    }

    public int getConnectionStatusCode() {
        return this.f1499fF;
    }
}
