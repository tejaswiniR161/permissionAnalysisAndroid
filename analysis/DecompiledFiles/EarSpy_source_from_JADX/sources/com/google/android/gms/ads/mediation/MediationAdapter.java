package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public interface MediationAdapter {

    public static class zza {
        private int zzcxf;

        public zza zzbh(int i) {
            this.zzcxf = i;
            return this;
        }

        public Bundle zzxg() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzcxf);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
