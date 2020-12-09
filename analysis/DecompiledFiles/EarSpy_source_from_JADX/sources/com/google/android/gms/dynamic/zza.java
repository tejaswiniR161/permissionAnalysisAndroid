package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    /* access modifiers changed from: private */

    /* renamed from: Oi */
    public T f1894Oi;
    /* access modifiers changed from: private */

    /* renamed from: Oj */
    public Bundle f1895Oj;
    /* access modifiers changed from: private */

    /* renamed from: Ok */
    public LinkedList<C1282zza> f1896Ok;

    /* renamed from: Ol */
    private final zzf<T> f1897Ol = new zzf<T>() {
        public void zza(T t) {
            LifecycleDelegate unused = zza.this.f1894Oi = t;
            Iterator it = zza.this.f1896Ok.iterator();
            while (it.hasNext()) {
                ((C1282zza) it.next()).zzb(zza.this.f1894Oi);
            }
            zza.this.f1896Ok.clear();
            Bundle unused2 = zza.this.f1895Oj = null;
        }
    };

    /* renamed from: com.google.android.gms.dynamic.zza$zza  reason: collision with other inner class name */
    private interface C1282zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    private void zza(Bundle bundle, C1282zza zza) {
        if (this.f1894Oi != null) {
            zza.zzb(this.f1894Oi);
            return;
        }
        if (this.f1896Ok == null) {
            this.f1896Ok = new LinkedList<>();
        }
        this.f1896Ok.add(zza);
        if (bundle != null) {
            if (this.f1895Oj == null) {
                this.f1895Oj = (Bundle) bundle.clone();
            } else {
                this.f1895Oj.putAll(bundle);
            }
        }
        zza(this.f1897Ol);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String zzi = zzi.zzi(context, isGooglePlayServicesAvailable);
        String zzk = zzi.zzk(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(zzi);
        linearLayout.addView(textView);
        if (zzk != null) {
            Button button = new Button(context);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(zzk);
            linearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    context.startActivity(GooglePlayServicesUtil.zzfm(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzno(int i) {
        while (!this.f1896Ok.isEmpty() && this.f1896Ok.getLast().getState() >= i) {
            this.f1896Ok.removeLast();
        }
    }

    public void onCreate(final Bundle bundle) {
        zza(bundle, (C1282zza) new C1282zza() {
            public int getState() {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.f1894Oi.onCreate(bundle);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        final LayoutInflater layoutInflater2 = layoutInflater;
        final ViewGroup viewGroup2 = viewGroup;
        final Bundle bundle2 = bundle;
        zza(bundle, (C1282zza) new C1282zza() {
            public int getState() {
                return 2;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(zza.this.f1894Oi.onCreateView(layoutInflater2, viewGroup2, bundle2));
            }
        });
        if (this.f1894Oi == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.f1894Oi != null) {
            this.f1894Oi.onDestroy();
        } else {
            zzno(1);
        }
    }

    public void onDestroyView() {
        if (this.f1894Oi != null) {
            this.f1894Oi.onDestroyView();
        } else {
            zzno(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle bundle, final Bundle bundle2) {
        zza(bundle2, (C1282zza) new C1282zza() {
            public int getState() {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.f1894Oi.onInflate(activity, bundle, bundle2);
            }
        });
    }

    public void onLowMemory() {
        if (this.f1894Oi != null) {
            this.f1894Oi.onLowMemory();
        }
    }

    public void onPause() {
        if (this.f1894Oi != null) {
            this.f1894Oi.onPause();
        } else {
            zzno(5);
        }
    }

    public void onResume() {
        zza((Bundle) null, (C1282zza) new C1282zza() {
            public int getState() {
                return 5;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.f1894Oi.onResume();
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.f1894Oi != null) {
            this.f1894Oi.onSaveInstanceState(bundle);
        } else if (this.f1895Oj != null) {
            bundle.putAll(this.f1895Oj);
        }
    }

    public void onStart() {
        zza((Bundle) null, (C1282zza) new C1282zza() {
            public int getState() {
                return 4;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.f1894Oi.onStart();
            }
        });
    }

    public void onStop() {
        if (this.f1894Oi != null) {
            this.f1894Oi.onStop();
        } else {
            zzno(4);
        }
    }

    /* access modifiers changed from: protected */
    public void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzf<T> zzf);

    public T zzbdt() {
        return this.f1894Oi;
    }
}
