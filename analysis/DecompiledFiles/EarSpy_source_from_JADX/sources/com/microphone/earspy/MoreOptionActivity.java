package com.microphone.earspy;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.Locale;

public class MoreOptionActivity extends Activity {
    private static final String APP_TAG = "Microphone_EarSpy";
    private String[] listData;
    /* access modifiers changed from: private */
    public String[] listDataStr;
    private Locale locale;
    private Dialog mLanguage_Dialog;
    /* access modifiers changed from: private */
    public SharedPreferences mSharedPreferences;
    /* access modifiers changed from: private */
    public Resources resource;
    private String strLocale;

    /* access modifiers changed from: protected */
    public void onStart() {
        EasyTracker.getInstance().activityStart(this);
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        EasyTracker.getInstance().activityStop(this);
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1206R.layout.more_options_activity);
        this.resource = getResources();
        this.listData = new String[7];
        this.listDataStr = new String[7];
        this.listData[0] = this.resource.getString(C1206R.string.mp3_gallery);
        this.listData[1] = this.resource.getString(C1206R.string.recover_unsaved_recorded_files);
        this.listData[2] = this.resource.getString(C1206R.string.follow_on_twitter);
        this.listData[3] = this.resource.getString(C1206R.string.share_ear_spy);
        this.listData[4] = this.resource.getString(C1206R.string.rate_ear_spy);
        this.listData[5] = this.resource.getString(C1206R.string.other_overpass_apps);
        this.listData[6] = this.resource.getString(C1206R.string.about_ear_spy);
        this.listDataStr[0] = "Mp3_gallery";
        this.listDataStr[1] = "Recover_unsaved_recorded_files";
        this.listDataStr[2] = "Follow_on_twitter";
        this.listDataStr[3] = "Share_ear_spy";
        this.listDataStr[4] = "Rate_ear_spy";
        this.listDataStr[5] = "Other_overpass_apps";
        this.listDataStr[6] = "About_ear_spy";
        this.mSharedPreferences = getSharedPreferences("Microphone_EarSpy", 0);
        this.strLocale = this.mSharedPreferences.getString("locale", "en");
        ListView listView = (ListView) findViewById(C1206R.C1208id.list);
        listView.setAdapter(new ArrayAdapter(getBaseContext(), C1206R.layout.more_option_item, this.listData));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View arg1, int arg2, long arg3) {
                EasyTracker.getTracker().trackEvent("More Options", "On Click: " + MoreOptionActivity.this.listDataStr[arg2], " more option", 200);
                EasyTracker.getTracker().sendEvent("More Options", "On Click: " + MoreOptionActivity.this.listDataStr[arg2], " more option", 200);
                switch (arg2) {
                    case 0:
                        MoreOptionActivity.this.startActivity(new Intent(MoreOptionActivity.this, Mp3Listing.class));
                        return;
                    case 1:
                        MoreOptionActivity.this.startActivity(new Intent(MoreOptionActivity.this, WavListing.class));
                        return;
                    case 2:
                        EasyTracker.getTracker().trackEvent("More Options", " Follow On Twitter", " Twitter", 200);
                        EasyTracker.getTracker().sendEvent("More Options", " Follow On Twitter", " Twitter", 200);
                        MoreOptionActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(MicrophoneActivity.URL_TWITTER_FOLLOW)));
                        return;
                    case 3:
                        Intent sharingIntent = new Intent("android.intent.action.SEND");
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra("android.intent.extra.SUBJECT", "Check out \"EAR SPY\"");
                        sharingIntent.putExtra("android.intent.extra.TEXT", "https://play.google.com/store/apps/details?id=" + MoreOptionActivity.this.getApplicationContext().getPackageName());
                        MoreOptionActivity.this.startActivity(Intent.createChooser(sharingIntent, MoreOptionActivity.this.resource.getString(C1206R.string.share_via)));
                        return;
                    case 4:
                        MoreOptionActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MoreOptionActivity.this.getApplicationContext().getPackageName())));
                        return;
                    case 5:
                        MoreOptionActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pub:\"Overpass Apps : Super-Human Apps and Games\"")));
                        return;
                    case 6:
                        MoreOptionActivity.this.startActivity(new Intent(MoreOptionActivity.this, About_Us.class));
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT > 13) {
            overridePendingTransition(17432578, 17432579);
        }
    }

    private void initLanguageDialog() {
        this.mLanguage_Dialog = new Dialog(this);
        this.mLanguage_Dialog.requestWindowFeature(1);
        this.mLanguage_Dialog.setContentView(C1206R.layout.language_dialog);
        ListView listView = (ListView) this.mLanguage_Dialog.findViewById(C1206R.C1208id.list);
        listView.setAdapter(new ArrayAdapter(this, 17367055, 16908308, getResources().getStringArray(C1206R.array.array_language)));
        listView.setChoiceMode(1);
        if (this.strLocale.equals("en")) {
            listView.setSelection(0);
        } else {
            listView.setSelection(1);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View myView, int position, long mylng) {
                SharedPreferences.Editor e = MoreOptionActivity.this.mSharedPreferences.edit();
                switch (position) {
                    case 0:
                        MoreOptionActivity.this.setLocale("en");
                        e.putString("locale", "en");
                        e.commit();
                        break;
                    case 1:
                        MoreOptionActivity.this.setLocale("hi");
                        e.putString("locale", "hi");
                        e.commit();
                        break;
                    case 2:
                        MoreOptionActivity.this.setLocale("zh");
                        e.putString("locale", "zh");
                        e.commit();
                        break;
                }
                MoreOptionActivity.this.changeLabelLanguage();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setLocale(String localeCode) {
        this.locale = new Locale(localeCode);
        Locale.setDefault(this.locale);
        Configuration config = new Configuration();
        config.locale = this.locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: private */
    public void changeLabelLanguage() {
    }
}
