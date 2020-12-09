package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzgm {
    public List<String> zza(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void zza(Context context, String str, zzke zzke, String str2, boolean z, List<String> list) {
        if (list != null && !list.isEmpty()) {
            String str3 = z ? "1" : "0";
            for (String replaceAll : list) {
                String replaceAll2 = replaceAll.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", zzke.zzcof.zzbsi).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", zzu.zzgd().getSessionId()).replaceAll("@gw_seqnum@", zzke.zzcfx);
                if (!TextUtils.isEmpty(zzke.zzcog)) {
                    replaceAll2 = replaceAll2.replaceAll("@gw_adnetstatus@", zzke.zzcog);
                }
                if (zzke.zzbte != null) {
                    replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", zzke.zzbte.zzbrm).replaceAll("@gw_allocid@", zzke.zzbte.zzbro);
                }
                Future future = (Future) new zzlb(context, str, replaceAll2).zzqw();
            }
        }
    }
}
