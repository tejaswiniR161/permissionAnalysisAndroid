package android.support.p003v7.widget;

import android.content.Context;
import android.support.p003v7.appcompat.C0167R;
import android.support.p003v7.internal.view.SupportMenuInflater;
import android.support.p003v7.internal.view.menu.MenuBuilder;
import android.support.p003v7.internal.view.menu.MenuPopupHelper;
import android.support.p003v7.internal.view.menu.MenuPresenter;
import android.support.p003v7.internal.view.menu.SubMenuBuilder;
import android.support.p003v7.widget.ListPopupWindow;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.widget.PopupMenu */
public class PopupMenu implements MenuBuilder.Callback, MenuPresenter.Callback {
    private View mAnchor;
    private Context mContext;
    private OnDismissListener mDismissListener;
    private View.OnTouchListener mDragListener;
    private MenuBuilder mMenu;
    private OnMenuItemClickListener mMenuItemClickListener;
    /* access modifiers changed from: private */
    public MenuPopupHelper mPopup;

    /* renamed from: android.support.v7.widget.PopupMenu$OnDismissListener */
    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    /* renamed from: android.support.v7.widget.PopupMenu$OnMenuItemClickListener */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(Context context, View anchor) {
        this(context, anchor, 0);
    }

    public PopupMenu(Context context, View anchor, int gravity) {
        this(context, anchor, gravity, C0167R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View anchor, int gravity, int popupStyleAttr, int popupStyleRes) {
        this.mContext = context;
        this.mMenu = new MenuBuilder(context);
        this.mMenu.setCallback(this);
        this.mAnchor = anchor;
        this.mPopup = new MenuPopupHelper(context, this.mMenu, anchor, false, popupStyleAttr, popupStyleRes);
        this.mPopup.setGravity(gravity);
        this.mPopup.setCallback(this);
    }

    public View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = new ListPopupWindow.ForwardingListener(this.mAnchor) {
                /* access modifiers changed from: protected */
                public boolean onForwardingStarted() {
                    PopupMenu.this.show();
                    return true;
                }

                /* access modifiers changed from: protected */
                public boolean onForwardingStopped() {
                    PopupMenu.this.dismiss();
                    return true;
                }

                public ListPopupWindow getPopup() {
                    return PopupMenu.this.mPopup.getPopup();
                }
            };
        }
        return this.mDragListener;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    public void inflate(int menuRes) {
        getMenuInflater().inflate(menuRes, this.mMenu);
    }

    public void show() {
        this.mPopup.show();
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        this.mMenuItemClickListener = listener;
    }

    public void setOnDismissListener(OnDismissListener listener) {
        this.mDismissListener = listener;
    }

    public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
        if (this.mMenuItemClickListener != null) {
            return this.mMenuItemClickListener.onMenuItemClick(item);
        }
        return false;
    }

    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        if (this.mDismissListener != null) {
            this.mDismissListener.onDismiss(this);
        }
    }

    public boolean onOpenSubMenu(MenuBuilder subMenu) {
        if (subMenu == null) {
            return false;
        }
        if (!subMenu.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.mContext, subMenu, this.mAnchor).show();
        return true;
    }

    public void onCloseSubMenu(SubMenuBuilder menu) {
    }

    public void onMenuModeChange(MenuBuilder menu) {
    }
}
