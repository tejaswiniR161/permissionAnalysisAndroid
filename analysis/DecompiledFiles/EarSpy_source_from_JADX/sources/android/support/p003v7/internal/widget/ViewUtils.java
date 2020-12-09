package android.support.p003v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.appcompat.C0167R;
import android.support.p003v7.internal.view.ContextThemeWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.internal.widget.ViewUtils */
public class ViewUtils {
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                sComputeFitSystemWindowsMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                if (!sComputeFitSystemWindowsMethod.isAccessible()) {
                    sComputeFitSystemWindowsMethod.setAccessible(true);
                }
            } catch (NoSuchMethodException e) {
                Log.d(TAG, "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    private ViewUtils() {
    }

    public static boolean isLayoutRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static int combineMeasuredStates(int curState, int newState) {
        return curState | newState;
    }

    public static void computeFitSystemWindows(View view, Rect inoutInsets, Rect outLocalInsets) {
        if (sComputeFitSystemWindowsMethod != null) {
            try {
                sComputeFitSystemWindowsMethod.invoke(view, new Object[]{inoutInsets, outLocalInsets});
            } catch (Exception e) {
                Log.d(TAG, "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    public static void makeOptionalFitsSystemWindows(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (NoSuchMethodException e) {
                Log.d(TAG, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            } catch (InvocationTargetException e2) {
                Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e2);
            } catch (IllegalAccessException e3) {
                Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e3);
            }
        }
    }

    public static Context themifyContext(Context context, AttributeSet attrs, boolean useAndroidTheme, boolean useAppTheme) {
        TypedArray a = context.obtainStyledAttributes(attrs, C0167R.styleable.View, 0, 0);
        int themeId = 0;
        if (useAndroidTheme) {
            themeId = a.getResourceId(C0167R.styleable.View_android_theme, 0);
        }
        if (useAppTheme && themeId == 0 && (themeId = a.getResourceId(C0167R.styleable.View_theme, 0)) != 0) {
            Log.i(TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        a.recycle();
        if (themeId == 0) {
            return context;
        }
        if (!(context instanceof ContextThemeWrapper) || ((ContextThemeWrapper) context).getThemeResId() != themeId) {
            return new ContextThemeWrapper(context, themeId);
        }
        return context;
    }
}
