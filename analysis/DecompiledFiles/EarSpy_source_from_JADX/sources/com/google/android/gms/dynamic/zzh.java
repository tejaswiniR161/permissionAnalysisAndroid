package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.zzc;

public final class zzh extends zzc.zza {

    /* renamed from: Ov */
    private Fragment f1914Ov;

    private zzh(Fragment fragment) {
        this.f1914Ov = fragment;
    }

    public static zzh zza(Fragment fragment) {
        if (fragment != null) {
            return new zzh(fragment);
        }
        return null;
    }

    public Bundle getArguments() {
        return this.f1914Ov.getArguments();
    }

    public int getId() {
        return this.f1914Ov.getId();
    }

    public boolean getRetainInstance() {
        return this.f1914Ov.getRetainInstance();
    }

    public String getTag() {
        return this.f1914Ov.getTag();
    }

    public int getTargetRequestCode() {
        return this.f1914Ov.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.f1914Ov.getUserVisibleHint();
    }

    public zzd getView() {
        return zze.zzac(this.f1914Ov.getView());
    }

    public boolean isAdded() {
        return this.f1914Ov.isAdded();
    }

    public boolean isDetached() {
        return this.f1914Ov.isDetached();
    }

    public boolean isHidden() {
        return this.f1914Ov.isHidden();
    }

    public boolean isInLayout() {
        return this.f1914Ov.isInLayout();
    }

    public boolean isRemoving() {
        return this.f1914Ov.isRemoving();
    }

    public boolean isResumed() {
        return this.f1914Ov.isResumed();
    }

    public boolean isVisible() {
        return this.f1914Ov.isVisible();
    }

    public void setHasOptionsMenu(boolean z) {
        this.f1914Ov.setHasOptionsMenu(z);
    }

    public void setMenuVisibility(boolean z) {
        this.f1914Ov.setMenuVisibility(z);
    }

    public void setRetainInstance(boolean z) {
        this.f1914Ov.setRetainInstance(z);
    }

    public void setUserVisibleHint(boolean z) {
        this.f1914Ov.setUserVisibleHint(z);
    }

    public void startActivity(Intent intent) {
        this.f1914Ov.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f1914Ov.startActivityForResult(intent, i);
    }

    public void zzac(zzd zzd) {
        this.f1914Ov.registerForContextMenu((View) zze.zzae(zzd));
    }

    public void zzad(zzd zzd) {
        this.f1914Ov.unregisterForContextMenu((View) zze.zzae(zzd));
    }

    public zzd zzbdu() {
        return zze.zzac(this.f1914Ov.getActivity());
    }

    public zzc zzbdv() {
        return zza(this.f1914Ov.getParentFragment());
    }

    public zzd zzbdw() {
        return zze.zzac(this.f1914Ov.getResources());
    }

    public zzc zzbdx() {
        return zza(this.f1914Ov.getTargetFragment());
    }
}
