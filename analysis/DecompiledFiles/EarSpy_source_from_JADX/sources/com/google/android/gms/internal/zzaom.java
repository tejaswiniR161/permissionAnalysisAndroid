package com.google.android.gms.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class zzaom {
    public zzaoh zza(Reader reader) throws zzaoi, zzaoq {
        try {
            zzapy zzapy = new zzapy(reader);
            zzaoh zzh = zzh(zzapy);
            if (zzh.mo8851aV() || zzapy.mo8968bn() == zzapz.END_DOCUMENT) {
                return zzh;
            }
            throw new zzaoq("Did not consume the entire document.");
        } catch (zzaqb e) {
            throw new zzaoq((Throwable) e);
        } catch (IOException e2) {
            throw new zzaoi((Throwable) e2);
        } catch (NumberFormatException e3) {
            throw new zzaoq((Throwable) e3);
        }
    }

    public zzaoh zzh(zzapy zzapy) throws zzaoi, zzaoq {
        boolean isLenient = zzapy.isLenient();
        zzapy.setLenient(true);
        try {
            zzaoh zzh = zzapi.zzh(zzapy);
            zzapy.setLenient(isLenient);
            return zzh;
        } catch (StackOverflowError e) {
            String valueOf = String.valueOf(zzapy);
            throw new zzaol(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed parsing JSON source: ").append(valueOf).append(" to Json").toString(), e);
        } catch (OutOfMemoryError e2) {
            String valueOf2 = String.valueOf(zzapy);
            throw new zzaol(new StringBuilder(String.valueOf(valueOf2).length() + 36).append("Failed parsing JSON source: ").append(valueOf2).append(" to Json").toString(), e2);
        } catch (Throwable th) {
            zzapy.setLenient(isLenient);
            throw th;
        }
    }

    public zzaoh zzuq(String str) throws zzaoq {
        return zza(new StringReader(str));
    }
}
