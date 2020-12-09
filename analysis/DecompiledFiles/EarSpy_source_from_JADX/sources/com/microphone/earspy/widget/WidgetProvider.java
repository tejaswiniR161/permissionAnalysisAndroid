package com.microphone.earspy.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.RemoteViews;
import com.microphone.earspy.C1206R;

public class WidgetProvider extends AppWidgetProvider {
    private static final String APP_TAG = "Microphone_EarSpy";
    public static final String TAG = "APP_WIDGET";
    boolean mActive;
    public Long refTimeMS;
    public RemoteViews remoteView;

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.i("APP_WIDGET", "onUpdate of SimpleWidgetProvider called");
        this.remoteView = new RemoteViews(context.getPackageName(), C1206R.layout.widget_layout);
        Intent intent = new Intent(context, WidgetService.class);
        intent.putExtra("appWidgetIds", appWidgetIds);
        this.remoteView.setOnClickPendingIntent(C1206R.C1208id.WidgetImageView5, PendingIntent.getService(context, 0, intent, 134217728));
        appWidgetManager.updateAppWidget(appWidgetIds, this.remoteView);
        Log.i("APP_WIDGET", "Click listeners added in onUpdate");
        this.mActive = context.getSharedPreferences("Microphone_EarSpy", 0).getBoolean("active", false);
        updateWidgetCenterCircle(context);
        if (this.mActive) {
            context.startService(intent);
        }
    }

    private void updateWidgetCenterCircle(Context context) {
        RemoteViews remoteView2 = new RemoteViews(context.getPackageName(), C1206R.layout.widget_layout);
        remoteView2.setImageViewResource(C1206R.C1208id.WidgetImageView5, this.mActive ? C1206R.C1207drawable.widget_black_5 : C1206R.C1207drawable.widget_red_5);
        AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName(context, WidgetProvider.class), remoteView2);
    }

    public void onEnabled(Context context) {
        super.onEnabled(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("Microphone_EarSpy", 0);
        PackageManager packageManager = context.getPackageManager();
    }

    public void onDeleted(Context context, int[] appWidgetId) {
        super.onDeleted(context, appWidgetId);
        Log.i("APP_WIDGET", "Removing instance of App Widget");
    }

    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.i("APP_WIDGET", "Removing last App Widget instance.");
    }
}
