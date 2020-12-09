package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@zziy
public class zzhu extends Handler {
    private final zzht zzcaz;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzhu(Context context) {
        this((zzht) new zzhv(context.getApplicationContext() != null ? context.getApplicationContext() : context));
    }

    public zzhu(zzht zzht) {
        this.zzcaz = zzht;
    }

    private void zze(JSONObject jSONObject) {
        try {
            this.zzcaz.zza(jSONObject.getString("request_id"), jSONObject.getString("base_url"), jSONObject.getString("html"));
        } catch (Exception e) {
        }
    }

    public void handleMessage(Message message) {
        try {
            Bundle data = message.getData();
            if (data != null) {
                JSONObject jSONObject = new JSONObject(data.getString("data"));
                if ("fetch_html".equals(jSONObject.getString("message_name"))) {
                    zze(jSONObject);
                }
            }
        } catch (Exception e) {
        }
    }
}
