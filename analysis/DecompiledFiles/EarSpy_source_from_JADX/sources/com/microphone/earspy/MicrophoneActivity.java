package com.microphone.earspy;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.NoiseSuppressor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.p003v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microphone.earspy.VerticalSeekBar;
import com.microphone.earspy.constant.Constant;
import com.microphone.earspy.inappbilling.Passport;
import com.microphone.earspy.widget.WidgetProvider;
import com.microphone.earspy.widget.WidgetService;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class MicrophoneActivity extends MP3Recording implements SharedPreferences.OnSharedPreferenceChangeListener, View.OnClickListener {
    public static final String APP_TAG = "Microphone_EarSpy";
    static final String AUDIO_RECORDER_FILE_EXT_WAV = ".wav";
    public static final String AUDIO_RECORDER_FOLDER = "Ear Spy";
    private static final String INTERSTITIAL_AD_UNIT_ID = "ca-app-pub-7088873759995662/8833603233";
    protected static final String IS_ACTIVITY_RESUME = "Is_Activity_Resume";
    public static boolean IsActive = false;
    public static boolean IsRecording = false;
    private static final String NUMBER_OF_OPENS = "numberOfOpens";
    private static final String SHOW_HEADPHONE_ALERT = "Show Headphone Alert";
    public static final String URL_TWITTER_FOLLOW = "http://mobile.twitter.com/earspyapp";
    static AcousticEchoCanceler acousticEchoCanceler = null;
    static AutomaticGainControl automaticGainControl = null;
    public static short cAmplitude = 0;
    static LinearLayout eqaulizer_container;
    static LayoutInflater inflater;
    public static VisualizerView mVisualizerView = null;
    static NoiseSuppressor noiseSuppressor = null;
    public static Button[] recordButton = null;
    static int stopClicks = 0;
    public static CharSequence titleText = null;
    public static VerticalSeekBar[] vSeekBar = null;
    public static String wavFileName = null;
    private final int UNLOCK_MENU_ID = 999;
    private VerticalSeekBar.OnSeekBarChangeListener VolumeChange = new VerticalSeekBar.OnSeekBarChangeListener() {
        public void onProgressChanged(VerticalSeekBar seekBar, int progress, boolean fromUser) {
            MicrophoneActivity.this.f2319am.setStreamVolume(3, MicrophoneActivity.this.seekbar.getProgress(), 0);
        }

        public void onStartTrackingTouch(VerticalSeekBar seekBar) {
        }

        public void onStopTrackingTouch(VerticalSeekBar seekBar) {
        }
    };
    int adCount;
    boolean adOpenStatus;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public AudioManager f2319am = null;
    private AppLovinInterstitialAdDialog appLovinInterstitialAd;
    /* access modifiers changed from: private */
    public ArrayList<String> arrConfigFiles = null;
    int bands = 5;
    int bass_counter = 3;
    ImageView[] bass_img = null;
    private Button btnRecord = null;
    private Button btnStop = null;
    private Context context;
    private int[] drawIdsNormal = {C1206R.C1207drawable.f2328b1, C1206R.C1207drawable.f2329b2, C1206R.C1207drawable.f2330b3, C1206R.C1207drawable.f2331b4, C1206R.C1207drawable.f2332b5, C1206R.C1207drawable.f2333b6};
    private int[] idsRecordBtn = {C1206R.C1208id.RecordButton1, C1206R.C1208id.RecordButton2, C1206R.C1208id.RecordButton3, C1206R.C1208id.RecordButton4, C1206R.C1208id.RecordButton5, C1206R.C1208id.RecordButton6};
    /* access modifiers changed from: private */
    public InterstitialAd interstitialAd;
    boolean isEchoCancelerOn = false;
    boolean isGainControlOn = false;
    boolean isNoiseSuppressorOn = false;
    private Locale locale = null;
    /* access modifiers changed from: private */
    public boolean mActive = false;
    private final BroadcastReceiver mBluetoothHeadsetBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") && intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0) == 0) {
                MicrophoneActivity.this.stopApp();
            }
        }
    };
    /* access modifiers changed from: private */
    public Dialog mCongig_Dialog = null;
    /* access modifiers changed from: private */
    public SharedPreferences.Editor mEditor = null;
    private FirebaseAnalytics mFirebaseAnalytics;
    private Dialog mLanguage_Dialog = null;
    private Dialog mNag_Screen = null;
    /* access modifiers changed from: private */
    public SharedPreferences mSharedPreferences = null;
    private final BroadcastReceiver mWiredHeadsetBroadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            boolean isConnected = true;
            if (intent.getIntExtra("state", 0) != 1) {
                isConnected = false;
            }
            if (!isConnected && MicrophoneActivity.this.mActive) {
                MicrophoneActivity.this.stopApp();
            }
        }
    };
    private Menu menu = null;
    /* access modifiers changed from: private */
    public AppLovinIncentivizedInterstitial myIncent;
    int openCount;
    private SharedPreferences pref;
    public int random_feature = 0;
    /* access modifiers changed from: private */
    public VerticalSeekBar seekbar = null;
    private String strLocale = null;
    /* access modifiers changed from: private */
    public ViewFlipper viewFlipper;
    /* access modifiers changed from: private */
    public View view_effects;
    /* access modifiers changed from: private */
    public View view_eq;
    int vr_counter = 3;
    ImageView[] vr_img = null;

    public interface InterstitialAdClosed {
        void addClosed();
    }

    public void onBackPressed() {
        Log.d("Microphone_EarSpy", "onBackPressed Called");
        this.btnRecord.setBackgroundResource(C1206R.C1207drawable.record_bg);
        this.btnStop.setBackgroundResource(C1206R.C1207drawable.push_lite);
        this.btnRecord.setEnabled(true);
        this.btnStop.setEnabled(false);
        if (!IsRecording || !this.mActive) {
            super.onBackPressed();
            return;
        }
        IsRecording = false;
        stopRecording();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Log.v("Microphone_EarSpy", "onNewIntent is called!");
        super.onNewIntent(intent);
        if (IsRecording) {
            IsRecording = false;
            stopRecording();
        }
        this.btnRecord.setBackgroundResource(C1206R.C1207drawable.record_bg);
        this.btnStop.setBackgroundResource(C1206R.C1207drawable.push_lite);
        this.btnRecord.setEnabled(true);
        this.btnStop.setEnabled(false);
    }

    private void stopRecording() {
        stopService(new Intent(this, MicrophoneService.class));
        IsActive = false;
        showDialog();
    }

    private void setLocale(String localeCode) {
        this.locale = new Locale(localeCode);
        Locale.setDefault(this.locale);
        Configuration config = new Configuration();
        config.locale = this.locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    public void onCreate(Bundle savedInstanceState) {
        int device_width;
        Object valueOf;
        String str;
        super.onCreate(savedInstanceState);
        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Log.d("Microphone_EarSpy", "Opening mic activity");
        this.mSharedPreferences = getSharedPreferences("Microphone_EarSpy", 0);
        this.mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.mEditor = this.mSharedPreferences.edit();
        this.context = this;
        this.mActive = this.mSharedPreferences.getBoolean("active", false);
        this.strLocale = this.mSharedPreferences.getString("locale", "en");
        setContentView(C1206R.layout.ear_spy);
        setSupportActionBar((Toolbar) findViewById(C1206R.C1208id.my_toolbar));
        AppLovinSdk.initializeSdk(this.context);
        this.myIncent = AppLovinIncentivizedInterstitial.create(this.context);
        this.myIncent.preload((AppLovinAdLoadListener) null);
        this.arrConfigFiles = new ArrayList<>();
        int size = this.mSharedPreferences.getInt("size", 0);
        for (int i = 0; i < size; i++) {
            this.arrConfigFiles.add(this.mSharedPreferences.getString("config" + i, (String) null));
        }
        this.btnRecord = (Button) findViewById(C1206R.C1208id.record);
        this.btnStop = (Button) findViewById(C1206R.C1208id.stop);
        if (!IsHeadsetAttached()) {
            showCautionDialog();
        }
        initConfigDialog();
        eqaulizer_container = (LinearLayout) findViewById(C1206R.C1208id.equalizer_container);
        HorizontalScrollView sc = (HorizontalScrollView) eqaulizer_container.getParent();
        final HorizontalScrollView horizontalScrollView = sc;
        findViewById(C1206R.C1208id.scroll_left).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                horizontalScrollView.scrollTo(MicrophoneActivity.eqaulizer_container.getLeft(), 0);
            }
        });
        final HorizontalScrollView horizontalScrollView2 = sc;
        findViewById(C1206R.C1208id.scroll_right).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                horizontalScrollView2.scrollTo(MicrophoneActivity.eqaulizer_container.getRight(), 0);
            }
        });
        this.viewFlipper = (ViewFlipper) findViewById(C1206R.C1208id.view_flipper);
        this.view_eq = findViewById(C1206R.C1208id.view_eq);
        this.view_effects = findViewById(C1206R.C1208id.view_effects);
        findViewById(C1206R.C1208id.linear_equlizer).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (MicrophoneActivity.this.view_effects.isShown()) {
                    MicrophoneActivity.this.viewFlipper.setDisplayedChild(0);
                    MicrophoneActivity.this.view_effects.setVisibility(4);
                    MicrophoneActivity.this.view_eq.setVisibility(0);
                }
            }
        });
        findViewById(C1206R.C1208id.linear_effects).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (MicrophoneActivity.this.view_eq.isShown()) {
                    MicrophoneActivity.this.viewFlipper.setDisplayedChild(1);
                    MicrophoneActivity.this.view_effects.setVisibility(0);
                    MicrophoneActivity.this.view_eq.setVisibility(4);
                }
            }
        });
        if (this.mSharedPreferences.getBoolean(Passport.PKG_ID_EXTENDED_EQU + "0", false)) {
            this.bands = this.mSharedPreferences.getInt("No_Equalizers", 5);
        }
        vSeekBar = new VerticalSeekBar[this.bands];
        inflater = getLayoutInflater();
        for (int i2 = 0; i2 < this.bands; i2++) {
            View view_equalizer = inflater.inflate(C1206R.layout.equalizer, (ViewGroup) null);
            eqaulizer_container.addView(view_equalizer);
            vSeekBar[i2] = (VerticalSeekBar) view_equalizer.findViewById(C1206R.C1208id.SeekBar01);
            int maxEQLevel = this.mSharedPreferences.getInt("maxEQLevel", -1);
            int minEQLevel = this.mSharedPreferences.getInt("minEQLevel", -1);
            if (maxEQLevel != -1) {
                vSeekBar[i2].setMax(maxEQLevel - minEQLevel);
                vSeekBar[i2].setProgress(this.mSharedPreferences.getInt("seekBarValues" + i2, (maxEQLevel - minEQLevel) / 2));
            }
            int freq = this.mSharedPreferences.getInt("freq" + i2, 60);
            TextView textView = (TextView) view_equalizer.findViewById(C1206R.C1208id.txt_equ1);
            StringBuilder append = new StringBuilder().append("");
            if (freq > 999) {
                StringBuilder sb = new StringBuilder();
                if ((freq / 100) % 10 == 0) {
                    str = "" + (freq / AdError.NETWORK_ERROR_CODE);
                } else {
                    str = "" + (((float) freq) / 1000.0f);
                }
                valueOf = sb.append(str).append("k").toString();
            } else {
                valueOf = Integer.valueOf(freq);
            }
            textView.setText(append.append(valueOf).toString());
            ((HorizontalScrollView) eqaulizer_container.getParent()).setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    v.findViewById(C1206R.C1208id.SeekBar01).getParent().requestDisallowInterceptTouchEvent(false);
                    return false;
                }
            });
            vSeekBar[i2].setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    v.getParent().getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
            });
        }
        Display display = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 13) {
            Point psize = new Point();
            display.getSize(psize);
            device_width = psize.x;
        } else {
            device_width = display.getWidth();
        }
        eqaulizer_container.measure(0, 0);
        if (device_width > eqaulizer_container.getMeasuredWidth() + 40) {
            findViewById(C1206R.C1208id.scroll_right).setVisibility(4);
            findViewById(C1206R.C1208id.scroll_left).setVisibility(4);
        }
        final HorizontalScrollView horizontalScrollView3 = sc;
        findViewById(C1206R.C1208id.scroll_right).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                horizontalScrollView3.scrollTo(MicrophoneActivity.eqaulizer_container.getRight(), 0);
            }
        });
        int[] bass_id = {C1206R.C1208id.bass1, C1206R.C1208id.bass2, C1206R.C1208id.bass3, C1206R.C1208id.bass4, C1206R.C1208id.bass5};
        this.bass_img = new ImageView[5];
        for (int i3 = 0; i3 < 5; i3++) {
            this.bass_img[i3] = (ImageView) findViewById(bass_id[i3]);
        }
        int[] vr_id = {C1206R.C1208id.vr1, C1206R.C1208id.vr2, C1206R.C1208id.vr3, C1206R.C1208id.vr4, C1206R.C1208id.vr5};
        this.vr_img = new ImageView[5];
        for (int i4 = 0; i4 < 5; i4++) {
            this.vr_img[i4] = (ImageView) findViewById(vr_id[i4]);
        }
        this.bass_counter = this.mSharedPreferences.getInt(Constant.PREF_BASS_VOL, 3);
        this.vr_counter = this.mSharedPreferences.getInt(Constant.PREF_VR_VOL, 3);
        ((ImageView) findViewById(C1206R.C1208id.bass_circle)).setImageResource(this.bass_counter == 0 ? C1206R.C1207drawable.img_default : C1206R.C1207drawable.img);
        ((ImageView) findViewById(C1206R.C1208id.vr_circle)).setImageResource(this.vr_counter == 0 ? C1206R.C1207drawable.img_default : C1206R.C1207drawable.img);
        for (int i5 = 0; i5 < this.bass_counter; i5++) {
            this.bass_img[i5].setVisibility(0);
        }
        for (int i6 = 0; i6 < this.mSharedPreferences.getInt(Constant.PREF_VR_VOL, 3); i6++) {
            this.vr_img[i6].setVisibility(0);
        }
        this.isEchoCancelerOn = this.mSharedPreferences.getBoolean(Constant.PREF_AEC, false);
        this.isGainControlOn = this.mSharedPreferences.getBoolean(Constant.PREF_AGC, true);
        this.isNoiseSuppressorOn = this.mSharedPreferences.getBoolean(Constant.PREF_NS, true);
        findViewById(C1206R.C1208id.img_echo).setVisibility(this.isEchoCancelerOn ? 0 : 4);
        findViewById(C1206R.C1208id.img_gain).setVisibility(this.isGainControlOn ? 0 : 4);
        findViewById(C1206R.C1208id.img_noise).setVisibility(this.isNoiseSuppressorOn ? 0 : 4);
        ((ImageView) findViewById(C1206R.C1208id.bass_circle)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                try {
                    if (MicrophoneActivity.this.bass_counter >= 5) {
                        for (int i = 0; i < 5; i++) {
                            MicrophoneActivity.this.bass_img[i].setVisibility(4);
                        }
                        MicrophoneActivity.this.bass_counter = 0;
                        ((ImageView) MicrophoneActivity.this.findViewById(C1206R.C1208id.bass_circle)).setImageResource(C1206R.C1207drawable.img_default);
                        Toast.makeText(MicrophoneActivity.this, "Bass: Off", 0).show();
                    } else {
                        MicrophoneActivity.this.bass_img[MicrophoneActivity.this.bass_counter].setVisibility(0);
                        MicrophoneActivity.this.bass_counter++;
                        ((ImageView) MicrophoneActivity.this.findViewById(C1206R.C1208id.bass_circle)).setImageResource(C1206R.C1207drawable.img);
                        Toast.makeText(MicrophoneActivity.this, "Bass: " + (MicrophoneActivity.this.bass_counter * 20) + "%", 0).show();
                        MicrophoneService.mBassBoost.setStrength((short) (MicrophoneActivity.this.bass_counter * 200));
                    }
                } catch (Exception e) {
                }
                MicrophoneActivity.this.mEditor.putInt(Constant.PREF_BASS_VOL, MicrophoneActivity.this.bass_counter);
                MicrophoneActivity.this.mEditor.commit();
            }
        });
        ((ImageView) findViewById(C1206R.C1208id.vr_circle)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                try {
                    if (MicrophoneActivity.this.vr_counter >= 5) {
                        for (int i = 0; i < 5; i++) {
                            MicrophoneActivity.this.vr_img[i].setVisibility(4);
                        }
                        MicrophoneActivity.this.vr_counter = 0;
                        ((ImageView) MicrophoneActivity.this.findViewById(C1206R.C1208id.vr_circle)).setImageResource(C1206R.C1207drawable.img_default);
                        Toast.makeText(MicrophoneActivity.this, "Virtualizer: Off", 0).show();
                    } else {
                        MicrophoneActivity.this.vr_img[MicrophoneActivity.this.vr_counter].setVisibility(0);
                        MicrophoneActivity.this.vr_counter++;
                        ((ImageView) MicrophoneActivity.this.findViewById(C1206R.C1208id.vr_circle)).setImageResource(C1206R.C1207drawable.img);
                        Toast.makeText(MicrophoneActivity.this, "Virtualizer: " + (MicrophoneActivity.this.vr_counter * 20) + "%", 0).show();
                        MicrophoneService.mVirtualizer.setStrength((short) (MicrophoneActivity.this.vr_counter * 200));
                    }
                } catch (Exception e) {
                }
                MicrophoneActivity.this.mEditor.putInt(Constant.PREF_VR_VOL, MicrophoneActivity.this.vr_counter);
                MicrophoneActivity.this.mEditor.commit();
            }
        });
        ((LinearLayout) findViewById(C1206R.C1208id.echo_group)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                int i = 0;
                MicrophoneActivity.this.isEchoCancelerOn = !MicrophoneActivity.this.isEchoCancelerOn;
                try {
                    View findViewById = MicrophoneActivity.this.findViewById(C1206R.C1208id.img_echo);
                    if (!MicrophoneActivity.this.isEchoCancelerOn) {
                        i = 4;
                    }
                    findViewById.setVisibility(i);
                    if (MicrophoneActivity.acousticEchoCanceler != null) {
                        MicrophoneActivity.acousticEchoCanceler.setEnabled(MicrophoneActivity.this.isEchoCancelerOn);
                    }
                    Toast.makeText(MicrophoneActivity.this, "Acoustic Echo Canceler: " + (MicrophoneActivity.this.isEchoCancelerOn ? "On" : "Off"), 0).show();
                } catch (Exception e) {
                }
                MicrophoneActivity.this.mEditor.putBoolean(Constant.PREF_AEC, MicrophoneActivity.this.isEchoCancelerOn);
                MicrophoneActivity.this.mEditor.commit();
            }
        });
        ((LinearLayout) findViewById(C1206R.C1208id.gain_group)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                int i = 0;
                MicrophoneActivity.this.isGainControlOn = !MicrophoneActivity.this.isGainControlOn;
                try {
                    View findViewById = MicrophoneActivity.this.findViewById(C1206R.C1208id.img_gain);
                    if (!MicrophoneActivity.this.isGainControlOn) {
                        i = 4;
                    }
                    findViewById.setVisibility(i);
                    if (MicrophoneActivity.automaticGainControl != null) {
                        MicrophoneActivity.automaticGainControl.setEnabled(MicrophoneActivity.this.isGainControlOn);
                    }
                    Toast.makeText(MicrophoneActivity.this, "Automatic Gain Control: " + (MicrophoneActivity.this.isGainControlOn ? "On" : "Off"), 0).show();
                } catch (Exception e) {
                }
                MicrophoneActivity.this.mEditor.putBoolean(Constant.PREF_AGC, MicrophoneActivity.this.isGainControlOn);
                MicrophoneActivity.this.mEditor.commit();
            }
        });
        ((LinearLayout) findViewById(C1206R.C1208id.noise_group)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                int i = 0;
                MicrophoneActivity.this.isNoiseSuppressorOn = !MicrophoneActivity.this.isNoiseSuppressorOn;
                try {
                    View findViewById = MicrophoneActivity.this.findViewById(C1206R.C1208id.img_noise);
                    if (!MicrophoneActivity.this.isNoiseSuppressorOn) {
                        i = 4;
                    }
                    findViewById.setVisibility(i);
                    if (MicrophoneActivity.noiseSuppressor != null) {
                        MicrophoneActivity.noiseSuppressor.setEnabled(MicrophoneActivity.this.isNoiseSuppressorOn);
                    }
                    Toast.makeText(MicrophoneActivity.this, "Noise Suppressor: " + (MicrophoneActivity.this.isNoiseSuppressorOn ? "On" : "Off"), 0).show();
                } catch (Exception e) {
                }
                MicrophoneActivity.this.mEditor.putBoolean(Constant.PREF_NS, MicrophoneActivity.this.isNoiseSuppressorOn);
                MicrophoneActivity.this.mEditor.commit();
            }
        });
        ((Button) findViewById(C1206R.C1208id.btnAddFeaturesFromHome)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                EasyTracker.getTracker().trackEvent("Menu", " Add Features", " Add Features", 200);
                EasyTracker.getTracker().sendEvent("Menu", " Add Features", " Add Features", 200);
                MicrophoneActivity.this.showInterstitial(MicrophoneActivity.this, new InterstitialAdClosed() {
                    public void addClosed() {
                        MicrophoneActivity.this.startActivity(new Intent(MicrophoneActivity.this, Add_Feature.class));
                    }
                });
            }
        });
        if (allFeaturesInstalled()) {
            findViewById(C1206R.C1208id.btnAddFeaturesFromHome).setVisibility(4);
        }
        TextView txt_audiovolume = (TextView) findViewById(C1206R.C1208id.txt_audiovolume);
        txt_audiovolume.setText(getString(C1206R.string.audio_volume));
        RotateAnimation ranim = (RotateAnimation) AnimationUtils.loadAnimation(this, C1206R.anim.rotate_anim);
        ranim.setFillAfter(true);
        txt_audiovolume.setAnimation(ranim);
        recordButton = new Button[6];
        for (int j = 0; j < this.idsRecordBtn.length; j++) {
            recordButton[j] = (Button) findViewById(this.idsRecordBtn[j]);
        }
        Button b = (Button) findViewById(C1206R.C1208id.RecordButton7);
        b.setOnClickListener(this);
        ((Button) findViewById(C1206R.C1208id.record)).setOnClickListener(this);
        ((Button) findViewById(C1206R.C1208id.stop)).setOnClickListener(this);
        b.setBackgroundResource(this.mActive ? C1206R.C1207drawable.f2334b7 : C1206R.C1207drawable.f2327a7);
        if (!this.mActive) {
            disActive();
        }
        this.seekbar = (VerticalSeekBar) findViewById(C1206R.C1208id.SeekBar_audio);
        this.f2319am = (AudioManager) getSystemService("audio");
        this.seekbar.setMax(this.f2319am.getStreamMaxVolume(3));
        this.f2319am.setStreamVolume(3, this.f2319am.getStreamMaxVolume(3), 0);
        this.seekbar.setProgress(this.f2319am.getStreamVolume(3));
        this.seekbar.setOnSeekBarChangeListener(this.VolumeChange);
        mVisualizerView = new VisualizerView(this, this.mSharedPreferences);
        mVisualizerView.setLayoutParams(new LinearLayout.LayoutParams((int) (60.0f * getResources().getDisplayMetrics().density), -1));
        ((LinearLayout) findViewById(C1206R.C1208id.LinearLayout_mic)).addView(mVisualizerView);
        if (this.mSharedPreferences.getBoolean(Passport.PKG_ID_REMOVE_ADS + "3", false)) {
            findViewById(C1206R.C1208id.adParent).setVisibility(8);
        } else {
            ((AdView) findViewById(C1206R.C1208id.adView)).loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("B2B1A2A4DF98842760F6411891496A6B").build());
        }
        chkIfHeadphonesConnected();
    }

    @SuppressLint({"InlinedApi"})
    private void chkIfHeadphonesConnected() {
        if (Build.VERSION.SDK_INT >= 11) {
            registerReceiver(this.mBluetoothHeadsetBroadcastReceiver, new IntentFilter("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED"));
        }
        registerReceiver(this.mWiredHeadsetBroadcastReceiver, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    }

    /* access modifiers changed from: private */
    public void stopApp() {
        SharedPreferences.Editor e = this.mSharedPreferences.edit();
        e.putBoolean("active", !this.mActive);
        e.commit();
        this.btnRecord.setBackgroundResource(C1206R.C1207drawable.record_bg);
        this.btnStop.setBackgroundResource(C1206R.C1207drawable.push_lite);
        this.btnRecord.setEnabled(true);
        this.btnStop.setEnabled(false);
        if (IsRecording) {
            IsRecording = false;
            showDialog();
        }
    }

    private boolean IsHeadsetAttached() {
        boolean mShow_headphone_alert = this.mSharedPreferences.getBoolean(SHOW_HEADPHONE_ALERT, true);
        this.f2319am = (AudioManager) getSystemService("audio");
        if (this.f2319am.isWiredHeadsetOn() || this.f2319am.isBluetoothA2dpOn() || !mShow_headphone_alert) {
            return true;
        }
        return false;
    }

    private void showCautionDialog() {
        final Dialog mHeadphone_Alert_Dialog = new Dialog(this);
        mHeadphone_Alert_Dialog.requestWindowFeature(1);
        mHeadphone_Alert_Dialog.setContentView(C1206R.layout.headphone_alert_dialog);
        mHeadphone_Alert_Dialog.show();
        mHeadphone_Alert_Dialog.findViewById(C1206R.C1208id.f2335ok).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mHeadphone_Alert_Dialog.cancel();
                if (((CheckBox) mHeadphone_Alert_Dialog.findViewById(C1206R.C1208id.chk_headphone)).isChecked()) {
                    SharedPreferences.Editor e = MicrophoneActivity.this.mSharedPreferences.edit();
                    e.putBoolean(MicrophoneActivity.SHOW_HEADPHONE_ALERT, false);
                    e.commit();
                }
            }
        });
    }

    private void initConfigDialog() {
        this.mCongig_Dialog = new Dialog(this);
        this.mCongig_Dialog.requestWindowFeature(1);
        this.mCongig_Dialog.setContentView(C1206R.layout.config_dialog);
        this.mCongig_Dialog.findViewById(C1206R.C1208id.cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MicrophoneActivity.this.mCongig_Dialog.cancel();
            }
        });
        this.mCongig_Dialog.findViewById(C1206R.C1208id.save).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor e = MicrophoneActivity.this.mSharedPreferences.edit();
                String strConfig = ((EditText) MicrophoneActivity.this.mCongig_Dialog.findViewById(C1206R.C1208id.config_name)).getText().toString().trim();
                if (strConfig.length() > 0) {
                    e.putString("config" + MicrophoneActivity.this.arrConfigFiles.size(), strConfig);
                    MicrophoneActivity.this.arrConfigFiles.add(strConfig);
                    e.putInt("size", MicrophoneActivity.this.arrConfigFiles.size());
                    for (int i = 0; i < MicrophoneActivity.this.bands; i++) {
                        e.putInt("band" + MicrophoneActivity.this.arrConfigFiles.size() + i, MicrophoneActivity.vSeekBar[i].getProgress());
                    }
                    e.putInt("audio" + MicrophoneActivity.this.arrConfigFiles.size(), MicrophoneActivity.this.seekbar.getProgress());
                    e.commit();
                    Toast.makeText(MicrophoneActivity.this.getApplicationContext(), MicrophoneActivity.this.getString(C1206R.string.toast_config_saved), 0).show();
                } else {
                    Toast.makeText(MicrophoneActivity.this.getApplicationContext(), MicrophoneActivity.this.getString(C1206R.string.toast_valid_filename), 0).show();
                }
                MicrophoneActivity.this.mCongig_Dialog.cancel();
            }
        });
    }

    public void onDestroy() {
        SharedPreferences.Editor e = this.mSharedPreferences.edit();
        e.putBoolean("active", false);
        e.commit();
        this.mSharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        unregisterReceiver(this.mWiredHeadsetBroadcastReceiver);
        if (Build.VERSION.SDK_INT >= 11) {
            unregisterReceiver(this.mBluetoothHeadsetBroadcastReceiver);
        }
        Log.d("Microphone_EarSpy", "Closing mic activity");
        super.onDestroy();
        Log.d("Microphone_EarSpy", "Closing mic activity");
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        getMenuInflater().inflate(C1206R.C1209menu.options_menu, menu2);
        this.menu = menu2;
        if (allFeaturesInstalled()) {
            return true;
        }
        menu2.add(0, 999, 104, getString(C1206R.string.unlock_feature));
        return true;
    }

    private boolean allFeaturesInstalled() {
        if (this.mSharedPreferences.getBoolean(Constant.PREF_TWEET_USED, false)) {
            return true;
        }
        if (!this.mSharedPreferences.getBoolean(Passport.PKG_ID_EXTENDED_EQU + "0", false)) {
            return false;
        }
        if (!this.mSharedPreferences.getBoolean(Passport.PKG_ID_HOME_SCREEN_WIDGET + "1", false)) {
            return false;
        }
        if (!this.mSharedPreferences.getBoolean(Passport.PKG_ID_MP3_RECORDING + "2", false)) {
            return false;
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 999:
                EasyTracker.getTracker().trackEvent("Menu", "Unlock Feature", "Unlock Feature", 200);
                EasyTracker.getTracker().sendEvent("Menu", "Unlock Feature", "Unlock Feature", 200);
                if (this.myIncent.isAdReadyToDisplay()) {
                    ArrayList<Integer> arrList = new ArrayList<>();
                    if (!this.mSharedPreferences.getBoolean(Passport.PKG_ID_EXTENDED_EQU + "0", false)) {
                        arrList.add(0);
                    }
                    if (!this.mSharedPreferences.getBoolean(Passport.PKG_ID_HOME_SCREEN_WIDGET + "1", false)) {
                        arrList.add(1);
                    }
                    if (!this.mSharedPreferences.getBoolean(Passport.PKG_ID_MP3_RECORDING + "2", false)) {
                        arrList.add(2);
                    }
                    try {
                        this.random_feature = arrList.get(new Random().nextInt(arrList.size())).intValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                        finish();
                    }
                    this.myIncent.show(this, new AppLovinAdRewardListener() {
                        public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
                            Log.d(Constant.AUDIO_RECORDER_FOLDER, "Awarded");
                            if (MicrophoneActivity.this.random_feature == 0) {
                                Log.d("Microphone_EarSpy", "PKG_ID_EXTENDED_EQU purchased.");
                                SharedPreferences.Editor mEditor = MicrophoneActivity.this.mSharedPreferences.edit();
                                mEditor.putBoolean(Passport.PKG_ID_EXTENDED_EQU + "0", true);
                                mEditor.commit();
                                Toast.makeText(MicrophoneActivity.this.getApplicationContext(), "Feature Unlocked: Extended Equalizer", 1).show();
                            }
                            if (MicrophoneActivity.this.random_feature == 1) {
                                Log.d("Microphone_EarSpy", "PKG_ID_HOME_SCREEN_WIDGET purchased.");
                                SharedPreferences.Editor mEditor2 = MicrophoneActivity.this.mSharedPreferences.edit();
                                mEditor2.putBoolean(Passport.PKG_ID_HOME_SCREEN_WIDGET + "1", true);
                                mEditor2.commit();
                                Toast.makeText(MicrophoneActivity.this.getApplicationContext(), "Feature Unlocked: Home Screen Widget", 1).show();
                            }
                            if (MicrophoneActivity.this.random_feature == 2) {
                                Log.d("Microphone_EarSpy", "PKG_ID_MP3_RECORDING purchased.");
                                SharedPreferences.Editor mEditor3 = MicrophoneActivity.this.mSharedPreferences.edit();
                                mEditor3.putBoolean(Passport.PKG_ID_MP3_RECORDING + "2", true);
                                mEditor3.commit();
                                Toast.makeText(MicrophoneActivity.this.getApplicationContext(), "Feature Unlocked: MP3 Recording", 1).show();
                            }
                            if (MicrophoneActivity.this.random_feature == 3) {
                                Log.d("Microphone_EarSpy", "PKG_ID_REMOVE_ADS purchased.");
                                SharedPreferences.Editor mEditor4 = MicrophoneActivity.this.mSharedPreferences.edit();
                                mEditor4.putBoolean(Passport.PKG_ID_REMOVE_ADS + "3", true);
                                mEditor4.commit();
                                Toast.makeText(MicrophoneActivity.this.getApplicationContext(), "Feature Unlocked: Remove Ads", 1).show();
                            }
                        }

                        public void userOverQuota(AppLovinAd appLovinAd, Map map) {
                        }

                        public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
                        }

                        public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
                        }

                        public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
                        }
                    }, (AppLovinAdVideoPlaybackListener) null, new AppLovinAdDisplayListener() {
                        public void adDisplayed(AppLovinAd appLovinAd) {
                        }

                        public void adHidden(AppLovinAd appLovinAd) {
                            MicrophoneActivity.this.myIncent.preload((AppLovinAdLoadListener) null);
                        }
                    });
                } else {
                    startActivity(new Intent(this, Unlock_Feature.class));
                }
                return true;
            case C1206R.C1208id.save /*2131361893*/:
                EasyTracker.getTracker().trackEvent("Menu", " Save Configuration", " Save", 200);
                EasyTracker.getTracker().sendEvent("Menu", " Save Configuration", " Save", 200);
                showInterstitial(this, new InterstitialAdClosed() {
                    public void addClosed() {
                        MicrophoneActivity.this.showConfigDialog();
                    }
                });
                return true;
            case C1206R.C1208id.add_feature /*2131362001*/:
                EasyTracker.getTracker().trackEvent("Menu", " Add Features", " Add Features", 200);
                EasyTracker.getTracker().sendEvent("Menu", " Add Features", " Add Features", 200);
                showInterstitial(this, new InterstitialAdClosed() {
                    public void addClosed() {
                        MicrophoneActivity.this.startActivity(new Intent(MicrophoneActivity.this, Add_Feature.class));
                    }
                });
                return true;
            case C1206R.C1208id.load /*2131362002*/:
                EasyTracker.getTracker().trackEvent("Menu", " Load Configuration", " Load Configuration", 200);
                EasyTracker.getTracker().sendEvent("Menu", " Load Configuration", "  Load Configuration", 200);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getString(C1206R.string.load_configuration));
                builder.setItems((CharSequence[]) this.arrConfigFiles.toArray(new CharSequence[this.arrConfigFiles.size()]), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int position) {
                        for (int i = 0; i < MicrophoneActivity.this.bands; i++) {
                            MicrophoneActivity.vSeekBar[i].setProgress(MicrophoneActivity.this.mSharedPreferences.getInt("band" + (position + 1) + i, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED));
                        }
                        int index = MicrophoneActivity.this.mSharedPreferences.getInt("audio" + (position + 1), MicrophoneActivity.this.f2319am.getStreamMaxVolume(3));
                        MicrophoneActivity.this.f2319am.setStreamVolume(3, index, 0);
                        MicrophoneActivity.this.seekbar.setProgress(index);
                        SharedPreferences.Editor editor = MicrophoneActivity.this.mSharedPreferences.edit();
                        editor.putBoolean("active", MicrophoneActivity.this.mActive);
                        editor.commit();
                        Toast.makeText(MicrophoneActivity.this.getApplicationContext(), MicrophoneActivity.this.getString(C1206R.string.toast_config_loaded), 0).show();
                    }
                });
                AlertDialog alert = builder.create();
                if (this.arrConfigFiles.size() > 0) {
                    alert.show();
                } else {
                    Toast.makeText(getApplicationContext(), getString(C1206R.string.toast_not_saved_config), 0).show();
                }
                return true;
            case C1206R.C1208id.spytraining /*2131362003*/:
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.overpass.co.uk/android-iphone/spy-training-ear-spy/")));
                return true;
            case C1206R.C1208id.more_optoins /*2131362004*/:
                EasyTracker.getTracker().trackEvent("Menu", " More Options", " More Options", 200);
                EasyTracker.getTracker().trackEvent("Menu", " More Options", " More Options", 200);
                startActivity(new Intent(this, MoreOptionActivity.class));
                if (Build.VERSION.SDK_INT > 13) {
                    overridePendingTransition(C1206R.anim.slide_in_right, C1206R.anim.slide_out_left);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick(View v) {
        boolean z;
        if (v.getId() == C1206R.C1208id.RecordButton7) {
            SharedPreferences.Editor e = this.mSharedPreferences.edit();
            if (!this.mActive) {
                z = true;
            } else {
                z = false;
            }
            e.putBoolean("active", z);
            e.commit();
            if (this.mActive) {
                this.btnRecord.setBackgroundResource(C1206R.C1207drawable.record_lite);
                this.btnStop.setBackgroundResource(C1206R.C1207drawable.push_lite);
                this.btnRecord.setEnabled(false);
                this.btnStop.setEnabled(false);
                titleText = getString(C1206R.string.mic_active);
            } else if (!this.mActive) {
                this.btnRecord.setBackgroundResource(C1206R.C1207drawable.record_bg);
                this.btnStop.setBackgroundResource(C1206R.C1207drawable.push_lite);
                this.btnRecord.setEnabled(true);
                this.btnStop.setEnabled(false);
                stopClicks++;
                if (stopClicks > 2) {
                    showInterstitial(this, new InterstitialAdClosed() {
                        public void addClosed() {
                            if (MicrophoneActivity.IsRecording) {
                                MicrophoneActivity.IsRecording = false;
                                MicrophoneActivity.this.showDialog();
                            }
                            MicrophoneActivity.stopClicks = 0;
                        }
                    });
                } else if (IsRecording) {
                    IsRecording = false;
                    showDialog();
                }
            }
        }
        if (v.getId() == C1206R.C1208id.record) {
            EasyTracker.getTracker().trackEvent("EarSpyServer", "Start Recording", "Start Recording", 200);
            EasyTracker.getTracker().trackEvent("EarSpyServer", "Start Recording", "Start Recording", 200);
            titleText = getString(C1206R.string.mic_active_recording);
            IsRecording = true;
            SharedPreferences.Editor e2 = this.mSharedPreferences.edit();
            e2.putBoolean("active", !this.mActive);
            e2.commit();
            findViewById(C1206R.C1208id.record).setBackgroundResource(C1206R.C1207drawable.record_lite);
            findViewById(C1206R.C1208id.stop).setBackgroundResource(C1206R.C1207drawable.push_bg);
            this.btnRecord.setEnabled(false);
            this.btnStop.setEnabled(true);
        }
        if (v.getId() == C1206R.C1208id.stop) {
            EasyTracker.getTracker().trackEvent("EarSpyServer", "Stop Recording", "Stop Recording", 200);
            EasyTracker.getTracker().trackEvent("EarSpyServer", "Stop Recording", "Stop Recording", 200);
            IsRecording = false;
            SharedPreferences.Editor e3 = this.mSharedPreferences.edit();
            e3.putBoolean("active", !this.mActive);
            e3.putString("wav_filename", getFilename());
            e3.commit();
            findViewById(C1206R.C1208id.record).setBackgroundResource(C1206R.C1207drawable.record_bg);
            findViewById(C1206R.C1208id.stop).setBackgroundResource(C1206R.C1207drawable.push_lite);
            this.btnRecord.setEnabled(true);
            this.btnStop.setEnabled(false);
            this.convertFile = this.mSharedPreferences.getString("wav_filename", getFilename());
            showDialog();
        }
    }

    private String getFilename() {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), AUDIO_RECORDER_FOLDER);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath() + "/" + System.currentTimeMillis() + AUDIO_RECORDER_FILE_EXT_WAV;
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        boolean bActive;
        if (key.equals("active") && (bActive = sharedPreferences.getBoolean("active", false)) != this.mActive) {
            if (bActive) {
                EasyTracker.getTracker().trackEvent("EarSpyServer", " Ear Spy Server start", "start", 200);
                EasyTracker.getTracker().sendEvent("EarSpyServer", " Ear Spy Server start", "start", 200);
                startService(new Intent(this, MicrophoneService.class));
                IsActive = true;
                if (!this.f2319am.isWiredHeadsetOn() && !this.f2319am.isBluetoothA2dpOn()) {
                    Toast.makeText(getApplicationContext(), getString(C1206R.string.toast_use_headphone), 0).show();
                }
            } else {
                EasyTracker.getTracker().trackEvent("EarSpyServer", " Ear Spy Server stop", "stop", 200);
                EasyTracker.getTracker().sendEvent("EarSpyServer", " Ear Spy Server stop", "stop", 200);
                stopService(new Intent(this, MicrophoneService.class));
                IsActive = false;
                disActive();
            }
            this.mActive = bActive;
            updateWidgetCenterCircle();
            runOnUiThread(new Runnable() {
                public void run() {
                    ((Button) MicrophoneActivity.this.findViewById(C1206R.C1208id.RecordButton7)).setBackgroundResource(MicrophoneActivity.this.mActive ? C1206R.C1207drawable.f2334b7 : C1206R.C1207drawable.f2327a7);
                    if (!MicrophoneActivity.this.mActive) {
                        MicrophoneActivity.IsActive = false;
                        MicrophoneActivity.this.disActive();
                    }
                }
            });
        }
    }

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

    private void updateWidgetCenterCircle() {
        RemoteViews remoteView = new RemoteViews(getApplicationContext().getPackageName(), C1206R.layout.widget_layout);
        remoteView.setImageViewResource(C1206R.C1208id.WidgetImageView5, this.mActive ? C1206R.C1207drawable.widget_black_5 : C1206R.C1207drawable.widget_red_5);
        if (!this.mActive) {
            remoteView.setImageViewResource(C1206R.C1208id.WidgetImageView1, C1206R.C1207drawable.widget_black_1);
            remoteView.setImageViewResource(C1206R.C1208id.WidgetImageView2, C1206R.C1207drawable.widget_black_2);
            remoteView.setImageViewResource(C1206R.C1208id.WidgetImageView3, C1206R.C1207drawable.widget_black_3);
            remoteView.setImageViewResource(C1206R.C1208id.WidgetImageView4, C1206R.C1207drawable.widget_black_4);
        }
        AppWidgetManager.getInstance(getApplicationContext()).updateAppWidget(new ComponentName(this, WidgetProvider.class), remoteView);
    }

    /* access modifiers changed from: private */
    public void showConfigDialog() {
        Date date = new Date();
        ((EditText) this.mCongig_Dialog.findViewById(C1206R.C1208id.config_name)).setText("Config_" + date.getDate() + getResources().getStringArray(C1206R.array.Months)[date.getMonth()] + (date.getYear() + 1900) + "_" + date.getHours() + "_" + date.getMinutes() + "_" + date.getSeconds());
        this.mCongig_Dialog.show();
    }

    /* access modifiers changed from: private */
    public void disActive() {
        for (int i = 0; i < recordButton.length; i++) {
            recordButton[i].setBackgroundResource(this.drawIdsNormal[i]);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor e = this.mSharedPreferences.edit();
        e.putBoolean(IS_ACTIVITY_RESUME, false);
        e.commit();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mSharedPreferences = getSharedPreferences("Microphone_EarSpy", 0);
        SharedPreferences.Editor e = this.mSharedPreferences.edit();
        if (this.mSharedPreferences.getBoolean(Passport.PKG_ID_EXTENDED_EQU + "0", false)) {
            if (((ViewFlipper) findViewById(C1206R.C1208id.view_flipper)).getDisplayedChild() == 0) {
                findViewById(C1206R.C1208id.view_eq).setVisibility(0);
            } else {
                findViewById(C1206R.C1208id.view_effects).setVisibility(0);
            }
            findViewById(C1206R.C1208id.view_line).setVisibility(0);
            ((TextView) findViewById(C1206R.C1208id.txt_effects)).setVisibility(0);
            ((LinearLayout) findViewById(C1206R.C1208id.bass_group)).setVisibility(0);
            if (Build.VERSION.SDK_INT >= 16) {
                ((LinearLayout) findViewById(C1206R.C1208id.other_effect_group)).setVisibility(0);
            }
        }
        if (this.mSharedPreferences.getBoolean(Passport.PKG_ID_MP3_RECORDING + "2", false)) {
            if (((ViewFlipper) findViewById(C1206R.C1208id.view_flipper)).getDisplayedChild() == 0) {
                findViewById(C1206R.C1208id.view_eq).setVisibility(0);
            } else {
                findViewById(C1206R.C1208id.view_effects).setVisibility(0);
            }
            findViewById(C1206R.C1208id.view_line).setVisibility(0);
            ((TextView) findViewById(C1206R.C1208id.txt_effects)).setVisibility(0);
            ((LinearLayout) findViewById(C1206R.C1208id.record_group)).setVisibility(0);
        }
        if (!this.mSharedPreferences.getBoolean(Passport.PKG_ID_HOME_SCREEN_WIDGET + "1", false)) {
            PackageManager pm = getPackageManager();
            pm.setComponentEnabledSetting(new ComponentName(this, WidgetProvider.class), 2, 1);
            pm.setComponentEnabledSetting(new ComponentName(this, WidgetService.class), 2, 1);
        } else {
            PackageManager pm2 = getPackageManager();
            pm2.setComponentEnabledSetting(new ComponentName(this, WidgetProvider.class), 1, 1);
            pm2.setComponentEnabledSetting(new ComponentName(this, WidgetService.class), 1, 1);
        }
        e.putBoolean(IS_ACTIVITY_RESUME, true);
        e.commit();
        if (allFeaturesInstalled() && this.menu != null) {
            this.menu.removeItem(999);
            findViewById(C1206R.C1208id.btnAddFeaturesFromHome).setVisibility(4);
        }
        if (!IsRecording && !this.mActive) {
            this.btnRecord.setBackgroundResource(C1206R.C1207drawable.record_bg);
            this.btnStop.setBackgroundResource(C1206R.C1207drawable.push_lite);
            this.btnRecord.setEnabled(true);
            this.btnStop.setEnabled(false);
        } else if (!IsRecording && this.mActive) {
            this.btnRecord.setBackgroundResource(C1206R.C1207drawable.record_lite);
            this.btnStop.setBackgroundResource(C1206R.C1207drawable.push_lite);
            this.btnRecord.setEnabled(false);
            this.btnStop.setEnabled(false);
        }
        boolean z = this.mSharedPreferences.getBoolean(SHOW_HEADPHONE_ALERT, true);
        loadInterstitial();
    }

    public void showInterstitial(Activity activity, final InterstitialAdClosed callback) {
        if (this.mSharedPreferences.getBoolean(Passport.PKG_ID_REMOVE_ADS + "3", false)) {
            callback.addClosed();
            return;
        }
        this.interstitialAd.setAdListener(new AdListener() {
            public void onAdClosed() {
                AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("2e5b74ce20f0f233ddb913f42e279eda").addTestDevice("B2B1A2A4DF98842760F6411891496A6B").build();
                Log.d(Constant.AUDIO_RECORDER_FOLDER, "Ad closed");
                MicrophoneActivity.this.interstitialAd.loadAd(adRequest);
                super.onAdClosed();
                callback.addClosed();
            }
        });
        if (this.interstitialAd.isLoaded()) {
            this.interstitialAd.show();
            return;
        }
        this.interstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("2e5b74ce20f0f233ddb913f42e279eda").addTestDevice("B2B1A2A4DF98842760F6411891496A6B").build());
        callback.addClosed();
    }

    /* access modifiers changed from: package-private */
    public void loadInterstitial() {
        boolean isAdRemoved = this.mSharedPreferences.getBoolean(Passport.PKG_ID_REMOVE_ADS + "3", false);
        SharedPreferences.Editor e = this.mSharedPreferences.edit();
        if (isAdRemoved) {
            return;
        }
        if (this.mNag_Screen == null || !this.mNag_Screen.isShowing()) {
            e.putInt(NUMBER_OF_OPENS, this.mSharedPreferences.getInt(NUMBER_OF_OPENS, 0) + 1);
            e.commit();
            this.pref = PreferenceManager.getDefaultSharedPreferences(this.context);
            SharedPreferences.Editor editor = this.pref.edit();
            if (this.adOpenStatus) {
                return;
            }
            if (!this.mSharedPreferences.getBoolean(Passport.PKG_ID_REMOVE_ADS + "3", false)) {
                this.adCount = this.pref.getInt("adCount", 0);
                this.adCount++;
                this.openCount = this.pref.getInt("openCount", 0);
                this.openCount++;
                editor.putInt("adCount", this.adCount);
                editor.putInt("openCount", this.openCount);
                editor.commit();
                this.interstitialAd = new InterstitialAd(this);
                this.interstitialAd.setAdUnitId(INTERSTITIAL_AD_UNIT_ID);
                this.interstitialAd.setAdListener(new AdListener() {
                    public void onAdLoaded() {
                        Log.d(Constant.AUDIO_RECORDER_FOLDER, "Ad Loaded");
                    }

                    public void onAdFailedToLoad(int errorCode) {
                        Log.d(Constant.AUDIO_RECORDER_FOLDER, "Ad failed " + String.format("onAdFailedToLoad (%s)", new Object[]{MicrophoneActivity.this.getErrorReason(errorCode)}));
                    }
                });
                this.interstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("2e5b74ce20f0f233ddb913f42e279eda").addTestDevice("B2B1A2A4DF98842760F6411891496A6B").build());
                this.adOpenStatus = true;
                return;
            }
            this.adOpenStatus = true;
            this.adCount = this.pref.getInt("adCount", 0);
            this.adCount++;
            editor.putInt("adCount", this.adCount);
            editor.commit();
        }
    }

    /* access modifiers changed from: private */
    public String getErrorReason(int errorCode) {
        switch (errorCode) {
            case 0:
                return "Internal error";
            case 1:
                return "Invalid request";
            case 2:
                return "Network Error";
            case 3:
                return "No fill";
            default:
                return "";
        }
    }
}
