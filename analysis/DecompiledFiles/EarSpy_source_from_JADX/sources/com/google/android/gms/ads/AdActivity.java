package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzhp;

public class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    public static final String SIMPLE_CLASS_NAME = "AdActivity";
    private zzhp zzajq;

    private void zzdf() {
        if (this.zzajq != null) {
            try {
                this.zzajq.zzdf();
            } catch (RemoteException e) {
                zzb.zzd("Could not forward setContentViewSet to ad overlay:", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            this.zzajq.onActivityResult(i, i2, intent);
        } catch (Exception e) {
            zzb.zzd("Could not forward onActivityResult to ad overlay:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        boolean z = true;
        try {
            if (this.zzajq != null) {
                z = this.zzajq.zzou();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onBackPressed to ad overlay:", e);
        }
        if (z) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            this.zzajq.zzn(zze.zzac(configuration));
        } catch (RemoteException e) {
            zzb.zzd("Failed to wrap configuration.", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzajq = zzm.zzjs().zzc((Activity) this);
        if (this.zzajq == null) {
            zzb.zzdf("Could not create ad overlay.");
            finish();
            return;
        }
        try {
            this.zzajq.onCreate(bundle);
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onCreate to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.zzajq != null) {
                this.zzajq.onDestroy();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onDestroy to ad overlay:", e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        try {
            if (this.zzajq != null) {
                this.zzajq.onPause();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onPause to ad overlay:", e);
            finish();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        try {
            if (this.zzajq != null) {
                this.zzajq.onRestart();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onRestart to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            if (this.zzajq != null) {
                this.zzajq.onResume();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onResume to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        try {
            if (this.zzajq != null) {
                this.zzajq.onSaveInstanceState(bundle);
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onSaveInstanceState to ad overlay:", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            if (this.zzajq != null) {
                this.zzajq.onStart();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onStart to ad overlay:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        try {
            if (this.zzajq != null) {
                this.zzajq.onStop();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onStop to ad overlay:", e);
            finish();
        }
        super.onStop();
    }

    public void setContentView(int i) {
        super.setContentView(i);
        zzdf();
    }

    public void setContentView(View view) {
        super.setContentView(view);
        zzdf();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zzdf();
    }
}
