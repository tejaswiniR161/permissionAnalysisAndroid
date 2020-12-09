package com.google.android.gms.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class zzaqa implements Closeable, Flushable {
    private static final String[] bov = new String[128];
    private static final String[] bow = ((String[]) bov.clone());
    private boolean bkN;
    private boolean bkO;
    private boolean bnY;
    private int[] bog = new int[32];
    private int boh = 0;
    private String box;
    private String boy;
    private final Writer out;
    private String separator;

    static {
        for (int i = 0; i <= 31; i++) {
            bov[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        bov[34] = "\\\"";
        bov[92] = "\\\\";
        bov[9] = "\\t";
        bov[8] = "\\b";
        bov[10] = "\\n";
        bov[13] = "\\r";
        bov[12] = "\\f";
        bow[60] = "\\u003c";
        bow[62] = "\\u003e";
        bow[38] = "\\u0026";
        bow[61] = "\\u003d";
        bow[39] = "\\u0027";
    }

    public zzaqa(Writer writer) {
        zzagw(6);
        this.separator = ":";
        this.bkN = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    /* renamed from: bL */
    private int m1424bL() {
        if (this.boh != 0) {
            return this.bog[this.boh - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: bM */
    private void m1425bM() throws IOException {
        if (this.boy != null) {
            m1427bO();
            zzuw(this.boy);
            this.boy = null;
        }
    }

    /* renamed from: bN */
    private void m1426bN() throws IOException {
        if (this.box != null) {
            this.out.write("\n");
            int i = this.boh;
            for (int i2 = 1; i2 < i; i2++) {
                this.out.write(this.box);
            }
        }
    }

    /* renamed from: bO */
    private void m1427bO() throws IOException {
        int bL = m1424bL();
        if (bL == 5) {
            this.out.write(44);
        } else if (bL != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m1426bN();
        zzagy(4);
    }

    private void zzagw(int i) {
        if (this.boh == this.bog.length) {
            int[] iArr = new int[(this.boh * 2)];
            System.arraycopy(this.bog, 0, iArr, 0, this.boh);
            this.bog = iArr;
        }
        int[] iArr2 = this.bog;
        int i2 = this.boh;
        this.boh = i2 + 1;
        iArr2[i2] = i;
    }

    private void zzagy(int i) {
        this.bog[this.boh - 1] = i;
    }

    private zzaqa zzc(int i, int i2, String str) throws IOException {
        int bL = m1424bL();
        if (bL != i2 && bL != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.boy != null) {
            String valueOf = String.valueOf(this.boy);
            throw new IllegalStateException(valueOf.length() != 0 ? "Dangling name: ".concat(valueOf) : new String("Dangling name: "));
        } else {
            this.boh--;
            if (bL == i2) {
                m1426bN();
            }
            this.out.write(str);
            return this;
        }
    }

    private void zzdj(boolean z) throws IOException {
        switch (m1424bL()) {
            case 1:
                zzagy(2);
                m1426bN();
                return;
            case 2:
                this.out.append(',');
                m1426bN();
                return;
            case 4:
                this.out.append(this.separator);
                zzagy(5);
                return;
            case 6:
                break;
            case 7:
                if (!this.bnY) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
            default:
                throw new IllegalStateException("Nesting problem.");
        }
        if (this.bnY || z) {
            zzagy(7);
            return;
        }
        throw new IllegalStateException("JSON must start with an array or an object.");
    }

    private zzaqa zzq(int i, String str) throws IOException {
        zzdj(true);
        zzagw(i);
        this.out.write(str);
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzuw(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            r1 = 0
            boolean r0 = r7.bkO
            if (r0 == 0) goto L_0x0025
            java.lang.String[] r0 = bow
        L_0x0007:
            java.io.Writer r2 = r7.out
            java.lang.String r3 = "\""
            r2.write(r3)
            int r4 = r8.length()
            r3 = r1
        L_0x0013:
            if (r3 >= r4) goto L_0x0046
            char r2 = r8.charAt(r3)
            r5 = 128(0x80, float:1.794E-43)
            if (r2 >= r5) goto L_0x0028
            r2 = r0[r2]
            if (r2 != 0) goto L_0x002e
        L_0x0021:
            int r2 = r3 + 1
            r3 = r2
            goto L_0x0013
        L_0x0025:
            java.lang.String[] r0 = bov
            goto L_0x0007
        L_0x0028:
            r5 = 8232(0x2028, float:1.1535E-41)
            if (r2 != r5) goto L_0x003f
            java.lang.String r2 = "\\u2028"
        L_0x002e:
            if (r1 >= r3) goto L_0x0037
            java.io.Writer r5 = r7.out
            int r6 = r3 - r1
            r5.write(r8, r1, r6)
        L_0x0037:
            java.io.Writer r1 = r7.out
            r1.write(r2)
            int r1 = r3 + 1
            goto L_0x0021
        L_0x003f:
            r5 = 8233(0x2029, float:1.1537E-41)
            if (r2 != r5) goto L_0x0021
            java.lang.String r2 = "\\u2029"
            goto L_0x002e
        L_0x0046:
            if (r1 >= r4) goto L_0x004f
            java.io.Writer r0 = r7.out
            int r2 = r4 - r1
            r0.write(r8, r1, r2)
        L_0x004f:
            java.io.Writer r0 = r7.out
            java.lang.String r1 = "\""
            r0.write(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaqa.zzuw(java.lang.String):void");
    }

    /* renamed from: bJ */
    public final boolean mo9080bJ() {
        return this.bkO;
    }

    /* renamed from: bK */
    public final boolean mo9081bK() {
        return this.bkN;
    }

    /* renamed from: bt */
    public zzaqa mo8986bt() throws IOException {
        m1425bM();
        return zzq(1, "[");
    }

    /* renamed from: bu */
    public zzaqa mo8987bu() throws IOException {
        return zzc(1, 2, "]");
    }

    /* renamed from: bv */
    public zzaqa mo8988bv() throws IOException {
        m1425bM();
        return zzq(3, "{");
    }

    /* renamed from: bw */
    public zzaqa mo8989bw() throws IOException {
        return zzc(3, 5, "}");
    }

    /* renamed from: bx */
    public zzaqa mo8990bx() throws IOException {
        if (this.boy != null) {
            if (this.bkN) {
                m1425bM();
            } else {
                this.boy = null;
                return this;
            }
        }
        zzdj(false);
        this.out.write("null");
        return this;
    }

    public void close() throws IOException {
        this.out.close();
        int i = this.boh;
        if (i > 1 || (i == 1 && this.bog[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.boh = 0;
    }

    public void flush() throws IOException {
        if (this.boh == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public boolean isLenient() {
        return this.bnY;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.box = null;
            this.separator = ":";
            return;
        }
        this.box = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.bnY = z;
    }

    public zzaqa zza(Number number) throws IOException {
        if (number == null) {
            return mo8990bx();
        }
        m1425bM();
        String obj = number.toString();
        if (this.bnY || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            zzdj(false);
            this.out.append(obj);
            return this;
        }
        String valueOf = String.valueOf(number);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 39).append("Numeric values must be finite, but was ").append(valueOf).toString());
    }

    public zzaqa zzcu(long j) throws IOException {
        m1425bM();
        zzdj(false);
        this.out.write(Long.toString(j));
        return this;
    }

    public zzaqa zzdf(boolean z) throws IOException {
        m1425bM();
        zzdj(false);
        this.out.write(z ? "true" : "false");
        return this;
    }

    public final void zzdh(boolean z) {
        this.bkO = z;
    }

    public final void zzdi(boolean z) {
        this.bkN = z;
    }

    public zzaqa zzus(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.boy != null) {
            throw new IllegalStateException();
        } else if (this.boh == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.boy = str;
            return this;
        }
    }

    public zzaqa zzut(String str) throws IOException {
        if (str == null) {
            return mo8990bx();
        }
        m1425bM();
        zzdj(false);
        zzuw(str);
        return this;
    }
}
