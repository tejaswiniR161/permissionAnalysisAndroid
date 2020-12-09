package com.google.android.gms.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class zzapi {

    private static final class zza extends Writer {
        private final Appendable bmi;
        private final C1290zza bmj;

        /* renamed from: com.google.android.gms.internal.zzapi$zza$zza  reason: collision with other inner class name */
        static class C1290zza implements CharSequence {
            char[] bmk;

            C1290zza() {
            }

            public char charAt(int i) {
                return this.bmk[i];
            }

            public int length() {
                return this.bmk.length;
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.bmk, i, i2 - i);
            }
        }

        private zza(Appendable appendable) {
            this.bmj = new C1290zza();
            this.bmi = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int i) throws IOException {
            this.bmi.append((char) i);
        }

        public void write(char[] cArr, int i, int i2) throws IOException {
            this.bmj.bmk = cArr;
            this.bmi.append(this.bmj, i, i + i2);
        }
    }

    public static Writer zza(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new zza(appendable);
    }

    public static void zzb(zzaoh zzaoh, zzaqa zzaqa) throws IOException {
        zzapw.bnH.zza(zzaqa, zzaoh);
    }

    public static zzaoh zzh(zzapy zzapy) throws zzaol {
        boolean z = true;
        try {
            zzapy.mo8968bn();
            z = false;
            return zzapw.bnH.zzb(zzapy);
        } catch (EOFException e) {
            if (z) {
                return zzaoj.bld;
            }
            throw new zzaoq((Throwable) e);
        } catch (zzaqb e2) {
            throw new zzaoq((Throwable) e2);
        } catch (IOException e3) {
            throw new zzaoi((Throwable) e3);
        } catch (NumberFormatException e4) {
            throw new zzaoq((Throwable) e4);
        }
    }
}
