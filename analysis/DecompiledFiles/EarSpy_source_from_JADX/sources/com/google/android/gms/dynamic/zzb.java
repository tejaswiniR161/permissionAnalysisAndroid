package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.zzc;

@SuppressLint({"NewApi"})
public final class zzb extends zzc.zza {

    /* renamed from: Os */
    private Fragment f1911Os;

    private zzb(Fragment fragment) {
        this.f1911Os = fragment;
    }

    public static zzb zza(Fragment fragment) {
        if (fragment != null) {
            return new zzb(fragment);
        }
        return null;
    }

    public Bundle getArguments() {
        return this.f1911Os.getArguments();
    }

    public int getId() {
        return this.f1911Os.getId();
    }

    public boolean getRetainInstance() {
        return this.f1911Os.getRetainInstance();
    }

    public String getTag() {
        return this.f1911Os.getTag();
    }

    public int getTargetRequestCode() {
        return this.f1911Os.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.f1911Os.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzac(this.f1911Os.getView());
    }

    public boolean isAdded() {
        return this.f1911Os.isAdded();
    }

    public boolean isDetached() {
        return this.f1911Os.isDetached();
    }

    public boolean isHidden() {
        return this.f1911Os.isHidden();
    }

    public boolean isInLayout() {
        return this.f1911Os.isInLayout();
    }

    public boolean isRemoving() {
        return this.f1911Os.isRemoving();
    }

    public boolean isResumed() {
        return this.f1911Os.isResumed();
    }

    public boolean isVisible() {
        return this.f1911Os.isVisible();
    }

    public void setHasOptionsMenu(boolean z) {
        this.f1911Os.setHasOptionsMenu(z);
    }

    public void setMenuVisibility(boolean z) {
        this.f1911Os.setMenuVisibility(z);
    }

    public void setRetainInstance(boolean z) {
        this.f1911Os.setRetainInstance(z);
    }

    public void setUserVisibleHint(boolean z) {
        this.f1911Os.setUserVisibleHint(z);
    }

    public void startActivity(Intent intent) {
        this.f1911Os.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f1911Os.startActivityForResult(intent, i);
    }

    public void zzac(zzd zzd) {
        this.f1911Os.registerForContextMenu((View) zze.zzae(zzd));
    }

    public void zzad(zzd zzd) {
        this.f1911Os.unregisterForContextMenu((View) zze.zzae(zzd));
    }

    public zzd zzbdu() {
        return zze.zzac(this.f1911Os.getActivity());
    }

    public zzc zzbdv() {
        return zza(this.f1911Os.getParentFragment());
    }

    public zzd zzbdw() {
        return zze.zzac(this.f1911Os.getResources());
    }

    public zzc zzbdx() {
        return zza(this.f1911Os.getTargetFragment());
    }
}
