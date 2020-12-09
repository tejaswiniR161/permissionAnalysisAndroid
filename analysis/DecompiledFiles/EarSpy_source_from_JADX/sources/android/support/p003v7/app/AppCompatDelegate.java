package android.support.p003v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p003v7.app.ActionBarDrawerToggle;
import android.support.p003v7.view.ActionMode;
import android.support.p003v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v7.app.AppCompatDelegate */
public abstract class AppCompatDelegate {
    static final String TAG = "AppCompatDelegate";

    public abstract void addContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract View createView(View view, String str, @NonNull Context context, @NonNull AttributeSet attributeSet);

    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle bundle);

    public abstract void onPostResume();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void setSupportActionBar(Toolbar toolbar);

    public abstract void setTitle(CharSequence charSequence);

    public abstract ActionMode startSupportActionMode(ActionMode.Callback callback);

    public static AppCompatDelegate create(Activity activity, AppCompatCallback callback) {
        if (Build.VERSION.SDK_INT >= 11) {
            return new AppCompatDelegateImplV11(activity, activity.getWindow(), callback);
        }
        return new AppCompatDelegateImplV7(activity, activity.getWindow(), callback);
    }

    public static AppCompatDelegate create(Dialog dialog, AppCompatCallback callback) {
        if (Build.VERSION.SDK_INT >= 11) {
            return new AppCompatDelegateImplV11(dialog.getContext(), dialog.getWindow(), callback);
        }
        return new AppCompatDelegateImplV7(dialog.getContext(), dialog.getWindow(), callback);
    }

    AppCompatDelegate() {
    }
}
