package android.support.p003v7.internal.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.p003v7.internal.widget.ViewUtils;
import android.support.p003v7.widget.AppCompatAutoCompleteTextView;
import android.support.p003v7.widget.AppCompatButton;
import android.support.p003v7.widget.AppCompatCheckBox;
import android.support.p003v7.widget.AppCompatCheckedTextView;
import android.support.p003v7.widget.AppCompatEditText;
import android.support.p003v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.p003v7.widget.AppCompatRadioButton;
import android.support.p003v7.widget.AppCompatRatingBar;
import android.support.p003v7.widget.AppCompatSpinner;
import android.support.p003v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* renamed from: android.support.v7.internal.app.AppCompatViewInflater */
public class AppCompatViewInflater {
    private static final Map<String, Constructor<? extends View>> sConstructorMap = new HashMap();
    static final Class<?>[] sConstructorSignature = {Context.class, AttributeSet.class};
    private final Object[] mConstructorArgs = new Object[2];
    private final Context mContext;

    public AppCompatViewInflater(Context context) {
        this.mContext = context;
    }

    public final View createView(View parent, String name, @NonNull Context context, @NonNull AttributeSet attrs, boolean inheritContext, boolean themeContext) {
        Context originalContext = context;
        if (inheritContext && parent != null) {
            context = parent.getContext();
        }
        if (themeContext) {
            context = ViewUtils.themifyContext(context, attrs, true, true);
        }
        char c = 65535;
        switch (name.hashCode()) {
            case -1946472170:
                if (name.equals("RatingBar")) {
                    c = 7;
                    break;
                }
                break;
            case -1455429095:
                if (name.equals("CheckedTextView")) {
                    c = 4;
                    break;
                }
                break;
            case -1346021293:
                if (name.equals("MultiAutoCompleteTextView")) {
                    c = 6;
                    break;
                }
                break;
            case -938935918:
                if (name.equals("TextView")) {
                    c = 9;
                    break;
                }
                break;
            case -339785223:
                if (name.equals("Spinner")) {
                    c = 1;
                    break;
                }
                break;
            case 776382189:
                if (name.equals("RadioButton")) {
                    c = 3;
                    break;
                }
                break;
            case 1413872058:
                if (name.equals("AutoCompleteTextView")) {
                    c = 5;
                    break;
                }
                break;
            case 1601505219:
                if (name.equals("CheckBox")) {
                    c = 2;
                    break;
                }
                break;
            case 1666676343:
                if (name.equals("EditText")) {
                    c = 0;
                    break;
                }
                break;
            case 2001146706:
                if (name.equals("Button")) {
                    c = 8;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new AppCompatEditText(context, attrs);
            case 1:
                return new AppCompatSpinner(context, attrs);
            case 2:
                return new AppCompatCheckBox(context, attrs);
            case 3:
                return new AppCompatRadioButton(context, attrs);
            case 4:
                return new AppCompatCheckedTextView(context, attrs);
            case 5:
                return new AppCompatAutoCompleteTextView(context, attrs);
            case 6:
                return new AppCompatMultiAutoCompleteTextView(context, attrs);
            case 7:
                return new AppCompatRatingBar(context, attrs);
            case 8:
                return new AppCompatButton(context, attrs);
            case 9:
                return new AppCompatTextView(context, attrs);
            default:
                if (originalContext != context) {
                    return createViewFromTag(context, name, attrs);
                }
                return null;
        }
    }

    /* JADX INFO: finally extract failed */
    private View createViewFromTag(Context context, String name, AttributeSet attrs) {
        if (name.equals("view")) {
            name = attrs.getAttributeValue((String) null, "class");
        }
        try {
            this.mConstructorArgs[0] = context;
            this.mConstructorArgs[1] = attrs;
            if (-1 == name.indexOf(46)) {
                View createView = createView(name, "android.widget.");
                this.mConstructorArgs[0] = null;
                this.mConstructorArgs[1] = null;
                return createView;
            }
            View createView2 = createView(name, (String) null);
            this.mConstructorArgs[0] = null;
            this.mConstructorArgs[1] = null;
            return createView2;
        } catch (Exception e) {
            this.mConstructorArgs[0] = null;
            this.mConstructorArgs[1] = null;
            return null;
        } catch (Throwable th) {
            this.mConstructorArgs[0] = null;
            this.mConstructorArgs[1] = null;
            throw th;
        }
    }

    private View createView(String name, String prefix) throws ClassNotFoundException, InflateException {
        Constructor<? extends U> constructor = sConstructorMap.get(name);
        if (constructor == null) {
            try {
                constructor = this.mContext.getClassLoader().loadClass(prefix != null ? prefix + name : name).asSubclass(View.class).getConstructor(sConstructorSignature);
                sConstructorMap.put(name, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.mConstructorArgs);
    }
}
