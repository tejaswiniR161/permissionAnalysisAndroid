package com.facebook.ads.internal.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/* renamed from: com.facebook.ads.internal.util.m */
public class C0546m {
    /* renamed from: a */
    static Bitmap m1230a(Context context, String str) {
        return BitmapFactory.decodeFile(new File(context.getCacheDir(), String.format("%d.png", new Object[]{Integer.valueOf(str.hashCode())})).getAbsolutePath());
    }

    /* renamed from: a */
    static void m1231a(Context context, String str, Bitmap bitmap) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getCacheDir(), String.format("%d.png", new Object[]{Integer.valueOf(str.hashCode())})));
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static void m1232a(Context context, List<String> list, final C0545l lVar) {
        final int[] iArr = {list.size()};
        if (iArr[0] != 0) {
            for (String str : list) {
                new C0544k(context).mo6128a((C0545l) new C0545l() {
                    /* renamed from: a */
                    public void mo5820a() {
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] - 1;
                        if (iArr[0] == 0 && lVar != null) {
                            lVar.mo5820a();
                        }
                    }
                }).execute(new String[]{str});
            }
        } else if (lVar != null) {
            lVar.mo5820a();
        }
    }
}
