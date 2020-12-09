package android.support.p003v7.internal.app;

import android.support.p003v7.app.ActionBar;
import android.support.p003v7.internal.widget.AdapterViewCompat;
import android.view.View;

/* renamed from: android.support.v7.internal.app.NavItemSelectedListener */
class NavItemSelectedListener implements AdapterViewCompat.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener mListener;

    public NavItemSelectedListener(ActionBar.OnNavigationListener listener) {
        this.mListener = listener;
    }

    public void onItemSelected(AdapterViewCompat<?> adapterViewCompat, View view, int position, long id) {
        if (this.mListener != null) {
            this.mListener.onNavigationItemSelected(position, id);
        }
    }

    public void onNothingSelected(AdapterViewCompat<?> adapterViewCompat) {
    }
}
