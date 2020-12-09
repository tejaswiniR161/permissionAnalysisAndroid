package com.applovin.impl.sdk;

import android.support.p000v4.p002os.EnvironmentCompat;
import com.facebook.ads.AdError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.bw */
class C0343bw {

    /* renamed from: A */
    public static final C0345by f441A = m386a("ad_refresh_seconds", 120L);

    /* renamed from: B */
    public static final C0345by f442B = m386a("mrec_ad_refresh_enabled", true);

    /* renamed from: C */
    public static final C0345by f443C = m386a("mrec_ad_refresh_seconds", 120L);

    /* renamed from: D */
    public static final C0345by f444D = m386a("leader_ad_refresh_enabled", true);

    /* renamed from: E */
    public static final C0345by f445E = m386a("leader_ad_refresh_seconds", 120L);

    /* renamed from: F */
    public static final C0345by f446F = m386a("plugin_version", "");

    /* renamed from: G */
    public static final C0345by f447G = m386a("ad_preload_enabled", true);

    /* renamed from: H */
    public static final C0345by f448H = m386a("ad_resource_caching_enabled", true);

    /* renamed from: I */
    public static final C0345by f449I = m386a("resource_cache_prefix", "https://vid.applovin.com/,https://pdn.applovin.com/,https://img.applovin.com/,https://d.applovin.com/,https://assets.applovin.com/,https://cdnjs.cloudflare.com/,http://vid.applovin.com/,http://pdn.applovin.com/,http://img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://cdnjs.cloudflare.com/");

    /* renamed from: J */
    public static final C0345by f450J = m386a("ad_auto_preload_sizes", "BANNER,INTER");

    /* renamed from: K */
    public static final C0345by f451K = m386a("ad_auto_preload_incent", true);
    @Deprecated

    /* renamed from: L */
    public static final C0345by f452L = m386a("session_expiration_time", 300L);
    @Deprecated

    /* renamed from: M */
    public static final C0345by f453M = m386a("track_installed_apps", true);

    /* renamed from: N */
    public static final C0345by f454N = m386a("is_tracking_enabled", true);

    /* renamed from: O */
    public static final C0345by f455O = m386a("force_back_button_enabled_always", false);
    @Deprecated

    /* renamed from: P */
    public static final C0345by f456P = m386a("is_first_install", EnvironmentCompat.MEDIA_UNKNOWN);
    @Deprecated

    /* renamed from: Q */
    public static final C0345by f457Q = m386a("countdown_direction", "right_to_left");

    /* renamed from: R */
    public static final C0345by f458R = m386a("countdown_color", "#C8FFFFFF");
    @Deprecated

    /* renamed from: S */
    public static final C0345by f459S = m386a("countdown_height", 2);

    /* renamed from: T */
    public static final C0345by f460T = m386a("close_fade_in_time", 400);
    @Deprecated

    /* renamed from: U */
    public static final C0345by f461U = m386a("draw_countdown_text", true);
    @Deprecated

    /* renamed from: V */
    public static final C0345by f462V = m386a("draw_countdown_bar", true);

    /* renamed from: W */
    public static final C0345by f463W = m386a("show_close_on_exit", true);

    /* renamed from: X */
    public static final C0345by f464X = m386a("text_incent_prompt_title", "Earn a Reward");

    /* renamed from: Y */
    public static final C0345by f465Y = m386a("text_incent_prompt_body", "Would you like to watch a video for a reward?");

    /* renamed from: Z */
    public static final C0345by f466Z = m386a("text_incent_prompt_yes_option", "Watch Now");

    /* renamed from: a */
    public static final C0345by f467a = m386a("is_disabled", false);

    /* renamed from: aA */
    public static final C0345by f468aA = m386a("cache_cleanup_enabled", false);

    /* renamed from: aB */
    public static final C0345by f469aB = m386a("cache_file_ttl_seconds", 86400L);

    /* renamed from: aC */
    public static final C0345by f470aC = m386a("cache_max_size_mb", -1);

    /* renamed from: aD */
    public static final C0345by f471aD = m386a("preload_merge_init_tasks_incent", true);

    /* renamed from: aE */
    public static final C0345by f472aE = m386a("preload_merge_init_tasks_inter", false);

    /* renamed from: aF */
    public static final C0345by f473aF = m386a("submit_postback_timeout", 10000);

    /* renamed from: aG */
    public static final C0345by f474aG = m386a("submit_postback_retries", 10);

    /* renamed from: aH */
    public static final C0345by f475aH = m386a("widget_imp_tracking_delay", Integer.valueOf(AdError.SERVER_ERROR_CODE));

    /* renamed from: aI */
    public static final C0345by f476aI = m386a("draw_countdown_clock", true);

    /* renamed from: aJ */
    public static final C0345by f477aJ = m386a("countdown_clock_size", 32);

    /* renamed from: aK */
    public static final C0345by f478aK = m386a("countdown_clock_stroke_size", 4);

    /* renamed from: aL */
    public static final C0345by f479aL = m386a("countdown_clock_text_size", 28);

    /* renamed from: aM */
    public static final C0345by f480aM = m386a("ad_auto_preload_native", true);

    /* renamed from: aN */
    public static final C0345by f481aN = m386a("widget_fail_on_slot_count_diff", true);

    /* renamed from: aO */
    public static final C0345by f482aO = m386a("video_zero_length_as_computed", false);

    /* renamed from: aP */
    public static final C0345by f483aP = m386a("video_countdown_clock_margin", 10);

    /* renamed from: aQ */
    public static final C0345by f484aQ = m386a("video_countdown_clock_gravity", 83);

    /* renamed from: aR */
    public static final C0345by f485aR = m386a("preload_capacity_widget", 1);

    /* renamed from: aS */
    public static final C0345by f486aS = m386a("widget_latch_timeout_ms", 500);

    /* renamed from: aT */
    public static final C0345by f487aT = m386a("android_gc_on_widget_detach", true);

    /* renamed from: aU */
    public static final C0345by f488aU = m386a("lhs_close_button_video", false);

    /* renamed from: aV */
    public static final C0345by f489aV = m386a("lhs_close_button_graphic", false);

    /* renamed from: aW */
    public static final C0345by f490aW = m386a("lhs_skip_button", true);

    /* renamed from: aX */
    public static final C0345by f491aX = m386a("countdown_toggleable", false);

    /* renamed from: aY */
    public static final C0345by f492aY = m386a("native_batch_precache_count", 1);

    /* renamed from: aZ */
    public static final C0345by f493aZ = m386a("mute_controls_enabled", false);

    /* renamed from: aa */
    public static final C0345by f494aa = m386a("text_incent_prompt_no_option", "No Thanks");

    /* renamed from: ab */
    public static final C0345by f495ab = m386a("text_incent_completion_title", "Video Reward");

    /* renamed from: ac */
    public static final C0345by f496ac = m386a("text_incent_completion_body_success", "You have earned a reward!");

    /* renamed from: ad */
    public static final C0345by f497ad = m386a("text_incent_completion_body_quota_exceeded", "You have already earned the maximum reward for today.");

    /* renamed from: ae */
    public static final C0345by f498ae = m386a("text_incent_completion_body_reward_rejected", "Your reward was rejected.");

    /* renamed from: af */
    public static final C0345by f499af = m386a("text_incent_completion_body_network_failure", "We were unable to contact the rewards server. Please try again later.");

    /* renamed from: ag */
    public static final C0345by f500ag = m386a("text_incent_completion_close_option", "Okay");

    /* renamed from: ah */
    public static final C0345by f501ah = m386a("show_incent_prepopup", true);

    /* renamed from: ai */
    public static final C0345by f502ai = m386a("show_incent_postpopup", true);

    /* renamed from: aj */
    public static final C0345by f503aj = m386a("preload_capacity_banner", 1);

    /* renamed from: ak */
    public static final C0345by f504ak = m386a("preload_capacity_mrec", 1);

    /* renamed from: al */
    public static final C0345by f505al = m386a("preload_capacity_inter", 1);

    /* renamed from: am */
    public static final C0345by f506am = m386a("preload_capacity_leader", 1);

    /* renamed from: an */
    public static final C0345by f507an = m386a("preload_capacity_incent", 2);

    /* renamed from: ao */
    public static final C0345by f508ao = m386a("dismiss_video_on_error", true);

    /* renamed from: ap */
    public static final C0345by f509ap = m386a("precache_delimiters", ")]',");

    /* renamed from: aq */
    public static final C0345by f510aq = m386a("close_button_size_graphic", 27);

    /* renamed from: ar */
    public static final C0345by f511ar = m386a("close_button_size_video", 30);

    /* renamed from: as */
    public static final C0345by f512as = m386a("close_button_top_margin_graphic", 10);

    /* renamed from: at */
    public static final C0345by f513at = m386a("close_button_right_margin_graphic", 10);

    /* renamed from: au */
    public static final C0345by f514au = m386a("close_button_top_margin_video", 8);

    /* renamed from: av */
    public static final C0345by f515av = m386a("close_button_right_margin_video", 4);

    /* renamed from: aw */
    public static final C0345by f516aw = m386a("force_back_button_enabled_poststitial", false);

    /* renamed from: ax */
    public static final C0345by f517ax = m386a("force_back_button_enabled_close_button", false);

    /* renamed from: ay */
    public static final C0345by f518ay = m386a("close_button_touch_area", 0);

    /* renamed from: az */
    public static final C0345by f519az = m386a("is_video_skippable", false);

    /* renamed from: b */
    public static final C0345by f520b = m386a("honor_publisher_settings", true);

    /* renamed from: ba */
    public static final C0345by f521ba = m386a("allow_user_muting", true);

    /* renamed from: bb */
    public static final C0345by f522bb = m386a("mute_button_size", 32);

    /* renamed from: bc */
    public static final C0345by f523bc = m386a("mute_button_margin", 10);

    /* renamed from: bd */
    public static final C0345by f524bd = m386a("mute_button_gravity", 85);

    /* renamed from: be */
    public static final C0345by f525be = m386a("qq", false);

    /* renamed from: bf */
    public static final C0345by f526bf = m386a("hw_accelerate_webviews", false);

    /* renamed from: bg */
    public static final C0345by f527bg = m386a("mute_videos", false);

    /* renamed from: bh */
    public static final C0345by f528bh = m386a("event_tracking_endpoint", "http://rt.applovin.com/pix");

    /* renamed from: bi */
    public static final C0345by f529bi = m386a("top_level_events", "landing,checkout,iap");

    /* renamed from: bj */
    public static final C0345by f530bj = m386a("events_enabled", true);

    /* renamed from: bk */
    public static final C0345by f531bk = m386a("force_ssl", false);

    /* renamed from: bl */
    public static final C0345by f532bl = m386a("postback_service_max_queue_size", 100);

    /* renamed from: bm */
    public static final C0345by f533bm = m386a("max_postback_attempts", 3);

    /* renamed from: bn */
    public static final C0345by f534bn = m386a("click_overlay_enabled", false);

    /* renamed from: bo */
    public static final C0345by f535bo = m386a("click_overlay_color", "#66000000");

    /* renamed from: bp */
    public static final C0345by f536bp = m386a("click_tracking_retry_count", 3);

    /* renamed from: bq */
    public static final C0345by f537bq = m386a("click_tracking_retry_delay", Integer.valueOf(AdError.SERVER_ERROR_CODE));

    /* renamed from: br */
    public static final C0345by f538br = m386a("click_tracking_timeout", 10000);

    /* renamed from: bs */
    public static final C0345by f539bs = m386a("android_click_spinner_size", 50);

    /* renamed from: bt */
    public static final C0345by f540bt = m386a("android_click_spinner_style", 16973853);

    /* renamed from: bu */
    public static final C0345by f541bu = m386a("android_dismiss_inters_on_click", false);

    /* renamed from: bv */
    public static final C0345by f542bv = m386a("android_require_external_storage_permission", true);

    /* renamed from: bw */
    private static final List f543bw = Arrays.asList(new Class[]{Boolean.class, Float.class, Integer.class, Long.class, String.class});

    /* renamed from: bx */
    private static final List f544bx = new ArrayList();

    /* renamed from: c */
    public static final C0345by f545c = m386a("device_id", "");

    /* renamed from: d */
    public static final C0345by f546d = m386a("publisher_id", "");

    /* renamed from: e */
    public static final C0345by f547e = m386a("device_token", "");
    @Deprecated

    /* renamed from: f */
    public static final C0345by f548f = m386a("init_retry_count", 1);

    /* renamed from: g */
    public static final C0345by f549g = m386a("submit_data_retry_count", 1);

    /* renamed from: h */
    public static final C0345by f550h = m386a("vr_retry_count", 1);

    /* renamed from: i */
    public static final C0345by f551i = m386a("fetch_ad_retry_count", 1);

    /* renamed from: j */
    public static final C0345by f552j = m386a("is_verbose_logging", false);

    /* renamed from: k */
    public static final C0345by f553k = m386a("api_endpoint", "http://d.applovin.com/");

    /* renamed from: l */
    public static final C0345by f554l = m386a("adserver_endpoint", "http://a.applovin.com/");

    /* renamed from: m */
    public static final C0345by f555m = m386a("next_device_init", 0L);

    /* renamed from: n */
    public static final C0345by f556n = m386a("get_retry_delay", 10000L);
    @Deprecated

    /* renamed from: o */
    public static final C0345by f557o = m386a("max_apps_to_send", 100);
    @Deprecated

    /* renamed from: p */
    public static final C0345by f558p = m386a("is_app_list_shared", true);
    @Deprecated

    /* renamed from: q */
    public static final C0345by f559q = m386a("next_app_list_update", 0L);

    /* renamed from: r */
    public static final C0345by f560r = m386a("hash_algorithm", "SHA-1");

    /* renamed from: s */
    public static final C0345by f561s = m386a("short_hash_size", 16);

    /* renamed from: t */
    public static final C0345by f562t = m386a("http_connection_timeout", 30000);

    /* renamed from: u */
    public static final C0345by f563u = m386a("fetch_ad_connection_timeout", 30000);

    /* renamed from: v */
    public static final C0345by f564v = m386a("http_socket_timeout", 20000);
    @Deprecated

    /* renamed from: w */
    public static final C0345by f565w = m386a("error_save_count", 15);

    /* renamed from: x */
    public static final C0345by f566x = m386a("ad_session_minutes", 60);

    /* renamed from: y */
    public static final C0345by f567y = m386a("ad_request_parameters", "");

    /* renamed from: z */
    public static final C0345by f568z = m386a("ad_refresh_enabled", true);

    /* renamed from: a */
    private static C0345by m386a(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("No default value specified");
        } else if (!f543bw.contains(obj.getClass())) {
            throw new IllegalArgumentException("Unsupported value type: " + obj.getClass());
        } else {
            C0345by byVar = new C0345by(str, obj);
            f544bx.add(byVar);
            return byVar;
        }
    }

    /* renamed from: a */
    public static Collection m387a() {
        return Collections.unmodifiableList(f544bx);
    }

    /* renamed from: b */
    public static int m388b() {
        return f544bx.size();
    }
}
