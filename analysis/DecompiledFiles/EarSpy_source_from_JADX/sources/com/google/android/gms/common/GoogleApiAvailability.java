package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzrb;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

public class GoogleApiAvailability extends zzc {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    /* renamed from: uM */
    private static final GoogleApiAvailability f1498uM = new GoogleApiAvailability();

    GoogleApiAvailability() {
    }

    public static GoogleApiAvailability getInstance() {
        return f1498uM;
    }

    public Dialog getErrorDialog(Activity activity, int i, int i2) {
        return getErrorDialog(activity, i, i2, (DialogInterface.OnCancelListener) null);
    }

    public Dialog getErrorDialog(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return zza((Context) activity, i, zzj.zza(activity, zza((Context) activity, i, "d"), i2), onCancelListener);
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        return super.getErrorResolutionPendingIntent(context, i, i2);
    }

    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(Context context, ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            return connectionResult.getResolution();
        }
        int errorCode = connectionResult.getErrorCode();
        if (zzi.zzcl(context) && errorCode == 2) {
            errorCode = 42;
        }
        return getErrorResolutionPendingIntent(context, errorCode, 0);
    }

    public final String getErrorString(int i) {
        return super.getErrorString(i);
    }

    @Nullable
    public String getOpenSourceSoftwareLicenseInfo(Context context) {
        return super.getOpenSourceSoftwareLicenseInfo(context);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    public final boolean isUserResolvableError(int i) {
        return super.isUserResolvableError(i);
    }

    @MainThread
    public Task<Void> makeGooglePlayServicesAvailable(Activity activity) {
        zzac.zzhq("makeGooglePlayServicesAvailable must be called from the main thread");
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable == 0) {
            return Tasks.forResult(null);
        }
        zzrf zzu = zzrf.zzu(activity);
        zzu.zzk(new ConnectionResult(isGooglePlayServicesAvailable, (PendingIntent) null));
        return zzu.getTask();
    }

    public boolean showErrorDialogFragment(Activity activity, int i, int i2) {
        return showErrorDialogFragment(activity, i, i2, (DialogInterface.OnCancelListener) null);
    }

    public boolean showErrorDialogFragment(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i, i2, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        zza(activity, errorDialog, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public void showErrorNotification(Context context, int i) {
        if (i == 6) {
            Log.e("GoogleApiAvailability", "showErrorNotification(context, errorCode) is called for RESOLUTION_REQUIRED when showErrorNotification(context, result) should be called");
        }
        if (isUserResolvableError(i)) {
            GooglePlayServicesUtil.showErrorNotification(i, context);
        }
    }

    public void showErrorNotification(Context context, ConnectionResult connectionResult) {
        PendingIntent errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult);
        if (errorResolutionPendingIntent != null) {
            GooglePlayServicesUtil.zza(connectionResult.getErrorCode(), context, errorResolutionPendingIntent);
        }
    }

    public Dialog zza(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(com.google.android.gms.common.internal.zzi.zzi(activity, 18));
        builder.setTitle(com.google.android.gms.common.internal.zzi.zzg(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        zza(activity, (Dialog) create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public Dialog zza(Context context, int i, zzj zzj, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (zzi.zzcl(context) && i == 2) {
            i = 42;
        }
        if (zzs.zzaxn()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new AlertDialog.Builder(context, 5);
            }
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.zzi.zzi(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String zzk = com.google.android.gms.common.internal.zzi.zzk(context, i);
        if (zzk != null) {
            builder.setPositiveButton(zzk, zzj);
        }
        String zzg = com.google.android.gms.common.internal.zzi.zzg(context, i);
        if (zzg != null) {
            builder.setTitle(zzg);
        }
        return builder.create();
    }

    @Nullable
    public PendingIntent zza(Context context, int i, int i2, @Nullable String str) {
        return super.zza(context, i, i2, str);
    }

    @Nullable
    public Intent zza(Context context, int i, @Nullable String str) {
        return super.zza(context, i, str);
    }

    @Nullable
    public zzqv zza(Context context, zzqv.zza zza) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zzqv zzqv = new zzqv(zza);
        context.registerReceiver(zzqv, intentFilter);
        zzqv.setContext(context);
        if (zzs(context, "com.google.android.gms")) {
            return zzqv;
        }
        zza.zzaqp();
        zzqv.unregister();
        return null;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(11)
    public void zza(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        boolean z;
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
        } else if (zzs.zzaxk()) {
            ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    public void zza(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult);
        if (errorResolutionPendingIntent != null) {
            GooglePlayServicesUtil.zza(connectionResult.getErrorCode(), context, GoogleApiActivity.zza(context, errorResolutionPendingIntent, i));
        }
    }

    public boolean zza(Activity activity, @NonNull zzrb zzrb, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog zza = zza((Context) activity, i, zzj.zza(zzrb, zza((Context) activity, i, "d"), i2), onCancelListener);
        if (zza == null) {
            return false;
        }
        zza(activity, zza, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public int zzbo(Context context) {
        return super.zzbo(context);
    }

    public boolean zzd(Context context, int i) {
        return super.zzd(context, i);
    }

    @Nullable
    @Deprecated
    public Intent zzfl(int i) {
        return super.zzfl(i);
    }
}
