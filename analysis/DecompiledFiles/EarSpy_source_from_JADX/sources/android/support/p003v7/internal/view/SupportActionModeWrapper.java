package android.support.p003v7.internal.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.internal.view.SupportMenuItem;
import android.support.p000v4.util.SimpleArrayMap;
import android.support.p003v7.internal.view.menu.MenuWrapperFactory;
import android.support.p003v7.view.ActionMode;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

@TargetApi(11)
/* renamed from: android.support.v7.internal.view.SupportActionModeWrapper */
public class SupportActionModeWrapper extends ActionMode {
    final Context mContext;
    final android.support.p003v7.view.ActionMode mWrappedObject;

    public SupportActionModeWrapper(Context context, android.support.p003v7.view.ActionMode supportActionMode) {
        this.mContext = context;
        this.mWrappedObject = supportActionMode;
    }

    public Object getTag() {
        return this.mWrappedObject.getTag();
    }

    public void setTag(Object tag) {
        this.mWrappedObject.setTag(tag);
    }

    public void setTitle(CharSequence title) {
        this.mWrappedObject.setTitle(title);
    }

    public void setSubtitle(CharSequence subtitle) {
        this.mWrappedObject.setSubtitle(subtitle);
    }

    public void invalidate() {
        this.mWrappedObject.invalidate();
    }

    public void finish() {
        this.mWrappedObject.finish();
    }

    public Menu getMenu() {
        return MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu) this.mWrappedObject.getMenu());
    }

    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    public void setTitle(int resId) {
        this.mWrappedObject.setTitle(resId);
    }

    public CharSequence getSubtitle() {
        return this.mWrappedObject.getSubtitle();
    }

    public void setSubtitle(int resId) {
        this.mWrappedObject.setSubtitle(resId);
    }

    public View getCustomView() {
        return this.mWrappedObject.getCustomView();
    }

    public void setCustomView(View view) {
        this.mWrappedObject.setCustomView(view);
    }

    public MenuInflater getMenuInflater() {
        return this.mWrappedObject.getMenuInflater();
    }

    public boolean getTitleOptionalHint() {
        return this.mWrappedObject.getTitleOptionalHint();
    }

    public void setTitleOptionalHint(boolean titleOptional) {
        this.mWrappedObject.setTitleOptionalHint(titleOptional);
    }

    public boolean isTitleOptional() {
        return this.mWrappedObject.isTitleOptional();
    }

    /* renamed from: android.support.v7.internal.view.SupportActionModeWrapper$CallbackWrapper */
    public static class CallbackWrapper implements ActionMode.Callback {
        final SimpleArrayMap<android.support.p003v7.view.ActionMode, SupportActionModeWrapper> mActionModes = new SimpleArrayMap<>();
        final Context mContext;
        final SimpleArrayMap<Menu, Menu> mMenus = new SimpleArrayMap<>();
        final ActionMode.Callback mWrappedCallback;

        public CallbackWrapper(Context context, ActionMode.Callback supportCallback) {
            this.mContext = context;
            this.mWrappedCallback = supportCallback;
        }

        public boolean onCreateActionMode(android.support.p003v7.view.ActionMode mode, Menu menu) {
            return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(mode), getMenuWrapper(menu));
        }

        public boolean onPrepareActionMode(android.support.p003v7.view.ActionMode mode, Menu menu) {
            return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(mode), getMenuWrapper(menu));
        }

        public boolean onActionItemClicked(android.support.p003v7.view.ActionMode mode, MenuItem item) {
            return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(mode), MenuWrapperFactory.wrapSupportMenuItem(this.mContext, (SupportMenuItem) item));
        }

        public void onDestroyActionMode(android.support.p003v7.view.ActionMode mode) {
            this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(mode));
        }

        private Menu getMenuWrapper(Menu menu) {
            Menu wrapper = this.mMenus.get(menu);
            if (wrapper != null) {
                return wrapper;
            }
            Menu wrapper2 = MenuWrapperFactory.wrapSupportMenu(this.mContext, (SupportMenu) menu);
            this.mMenus.put(menu, wrapper2);
            return wrapper2;
        }

        private android.view.ActionMode getActionModeWrapper(android.support.p003v7.view.ActionMode mode) {
            SupportActionModeWrapper wrapper = this.mActionModes.get(mode);
            if (wrapper != null) {
                return wrapper;
            }
            SupportActionModeWrapper wrapper2 = new SupportActionModeWrapper(this.mContext, mode);
            this.mActionModes.put(mode, wrapper2);
            return wrapper2;
        }
    }
}
