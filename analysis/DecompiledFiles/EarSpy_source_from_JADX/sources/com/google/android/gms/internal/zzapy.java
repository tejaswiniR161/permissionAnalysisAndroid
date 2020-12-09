package com.google.android.gms.internal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class zzapy implements Closeable {
    private static final char[] bnX = ")]}'\n".toCharArray();
    private boolean bnY = false;
    private final char[] bnZ = new char[1024];
    private int boa = 0;
    private int bob = 0;
    /* access modifiers changed from: private */
    public int boc = 0;
    private long bod;
    private int boe;
    private String bof;
    private int[] bog = new int[32];
    private int boh = 0;
    private String[] boi;
    private int[] boj;

    /* renamed from: in */
    private final Reader f1930in;
    private int limit = 0;
    private int pos = 0;

    static {
        zzapd.blQ = new zzapd() {
            public void zzi(zzapy zzapy) throws IOException {
                if (zzapy instanceof zzapo) {
                    ((zzapo) zzapy).mo8969bq();
                    return;
                }
                int zzag = zzapy.boc;
                if (zzag == 0) {
                    zzag = zzapy.m1414bA();
                }
                if (zzag == 13) {
                    int unused = zzapy.boc = 9;
                } else if (zzag == 12) {
                    int unused2 = zzapy.boc = 8;
                } else if (zzag == 14) {
                    int unused3 = zzapy.boc = 10;
                } else {
                    String valueOf = String.valueOf(zzapy.mo8968bn());
                    int zzai = zzapy.getLineNumber();
                    int zzaj = zzapy.getColumnNumber();
                    String path = zzapy.getPath();
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" ").append(" at line ").append(zzai).append(" column ").append(zzaj).append(" path ").append(path).toString());
                }
            }
        };
    }

    public zzapy(Reader reader) {
        int[] iArr = this.bog;
        int i = this.boh;
        this.boh = i + 1;
        iArr[i] = 6;
        this.boi = new String[32];
        this.boj = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f1930in = reader;
    }

    /* access modifiers changed from: private */
    /* renamed from: bA */
    public int m1414bA() throws IOException {
        int i = this.bog[this.boh - 1];
        if (i == 1) {
            this.bog[this.boh - 1] = 2;
        } else if (i == 2) {
            switch (zzdg(true)) {
                case 44:
                    break;
                case 59:
                    m1419bF();
                    break;
                case 93:
                    this.boc = 4;
                    return 4;
                default:
                    throw zzuv("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.bog[this.boh - 1] = 4;
            if (i == 5) {
                switch (zzdg(true)) {
                    case 44:
                        break;
                    case 59:
                        m1419bF();
                        break;
                    case 125:
                        this.boc = 2;
                        return 2;
                    default:
                        throw zzuv("Unterminated object");
                }
            }
            int zzdg = zzdg(true);
            switch (zzdg) {
                case 34:
                    this.boc = 13;
                    return 13;
                case 39:
                    m1419bF();
                    this.boc = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.boc = 2;
                        return 2;
                    }
                    throw zzuv("Expected name");
                default:
                    m1419bF();
                    this.pos--;
                    if (zze((char) zzdg)) {
                        this.boc = 14;
                        return 14;
                    }
                    throw zzuv("Expected name");
            }
        } else if (i == 4) {
            this.bog[this.boh - 1] = 5;
            switch (zzdg(true)) {
                case 58:
                    break;
                case 61:
                    m1419bF();
                    if ((this.pos < this.limit || zzagx(1)) && this.bnZ[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                default:
                    throw zzuv("Expected ':'");
            }
        } else if (i == 6) {
            if (this.bnY) {
                m1422bI();
            }
            this.bog[this.boh - 1] = 7;
        } else if (i == 7) {
            if (zzdg(false) == -1) {
                this.boc = 17;
                return 17;
            }
            m1419bF();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (zzdg(true)) {
            case 34:
                if (this.boh == 1) {
                    m1419bF();
                }
                this.boc = 9;
                return 9;
            case 39:
                m1419bF();
                this.boc = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.boc = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.boc = 4;
                    return 4;
                }
                break;
            case 123:
                this.boc = 1;
                return 1;
            default:
                this.pos--;
                if (this.boh == 1) {
                    m1419bF();
                }
                int bB = m1415bB();
                if (bB != 0) {
                    return bB;
                }
                int bC = m1416bC();
                if (bC != 0) {
                    return bC;
                }
                if (!zze(this.bnZ[this.pos])) {
                    throw zzuv("Expected value");
                }
                m1419bF();
                this.boc = 10;
                return 10;
        }
        if (i == 1 || i == 2) {
            m1419bF();
            this.pos--;
            this.boc = 7;
            return 7;
        }
        throw zzuv("Unexpected value");
    }

    /* renamed from: bB */
    private int m1415bB() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.bnZ[this.pos];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.pos + i2 >= this.limit && !zzagx(i2 + 1)) {
                return 0;
            }
            char c2 = this.bnZ[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || zzagx(length + 1)) && zze(this.bnZ[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.boc = i;
        return i;
    }

    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: type inference failed for: r2v22 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: bC */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m1416bC() throws java.io.IOException {
        /*
            r15 = this;
            char[] r11 = r15.bnZ
            int r2 = r15.pos
            int r1 = r15.limit
            r6 = 0
            r5 = 0
            r4 = 1
            r3 = 0
            r0 = 0
            r10 = r0
            r0 = r1
            r1 = r2
        L_0x000f:
            int r2 = r1 + r10
            if (r2 != r0) goto L_0x003f
            int r0 = r11.length
            if (r10 != r0) goto L_0x0018
            r0 = 0
        L_0x0017:
            return r0
        L_0x0018:
            int r0 = r10 + 1
            boolean r0 = r15.zzagx(r0)
            if (r0 != 0) goto L_0x003b
        L_0x0020:
            r0 = 2
            if (r3 != r0) goto L_0x00df
            if (r4 == 0) goto L_0x00df
            r0 = -9223372036854775808
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x002d
            if (r5 == 0) goto L_0x00df
        L_0x002d:
            if (r5 == 0) goto L_0x00dc
        L_0x002f:
            r15.bod = r6
            int r0 = r15.pos
            int r0 = r0 + r10
            r15.pos = r0
            r0 = 15
            r15.boc = r0
            goto L_0x0017
        L_0x003b:
            int r1 = r15.pos
            int r0 = r15.limit
        L_0x003f:
            int r2 = r1 + r10
            char r2 = r11[r2]
            switch(r2) {
                case 43: goto L_0x006d;
                case 45: goto L_0x0056;
                case 46: goto L_0x0082;
                case 69: goto L_0x0076;
                case 101: goto L_0x0076;
                default: goto L_0x0046;
            }
        L_0x0046:
            r8 = 48
            if (r2 < r8) goto L_0x004e
            r8 = 57
            if (r2 <= r8) goto L_0x008b
        L_0x004e:
            boolean r0 = r15.zze(r2)
            if (r0 == 0) goto L_0x0020
            r0 = 0
            goto L_0x0017
        L_0x0056:
            if (r3 != 0) goto L_0x0064
            r3 = 1
            r2 = 1
            r14 = r4
            r4 = r3
            r3 = r14
        L_0x005d:
            int r5 = r10 + 1
            r10 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            goto L_0x000f
        L_0x0064:
            r2 = 5
            if (r3 != r2) goto L_0x006b
            r2 = 6
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x006b:
            r0 = 0
            goto L_0x0017
        L_0x006d:
            r2 = 5
            if (r3 != r2) goto L_0x0074
            r2 = 6
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0074:
            r0 = 0
            goto L_0x0017
        L_0x0076:
            r2 = 2
            if (r3 == r2) goto L_0x007c
            r2 = 4
            if (r3 != r2) goto L_0x0080
        L_0x007c:
            r2 = 5
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0080:
            r0 = 0
            goto L_0x0017
        L_0x0082:
            r2 = 2
            if (r3 != r2) goto L_0x0089
            r2 = 3
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0089:
            r0 = 0
            goto L_0x0017
        L_0x008b:
            r8 = 1
            if (r3 == r8) goto L_0x0090
            if (r3 != 0) goto L_0x0098
        L_0x0090:
            int r2 = r2 + -48
            int r2 = -r2
            long r6 = (long) r2
            r2 = 2
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x0098:
            r8 = 2
            if (r3 != r8) goto L_0x00cb
            r8 = 0
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x00a4
            r0 = 0
            goto L_0x0017
        L_0x00a4:
            r8 = 10
            long r8 = r8 * r6
            int r2 = r2 + -48
            long r12 = (long) r2
            long r8 = r8 - r12
            r12 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r2 > 0) goto L_0x00c1
            r12 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r2 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x00c9
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x00c9
        L_0x00c1:
            r2 = 1
        L_0x00c2:
            r2 = r2 & r4
            r4 = r5
            r6 = r8
            r14 = r3
            r3 = r2
            r2 = r14
            goto L_0x005d
        L_0x00c9:
            r2 = 0
            goto L_0x00c2
        L_0x00cb:
            r2 = 3
            if (r3 != r2) goto L_0x00d2
            r2 = 4
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x00d2:
            r2 = 5
            if (r3 == r2) goto L_0x00d8
            r2 = 6
            if (r3 != r2) goto L_0x00f3
        L_0x00d8:
            r2 = 7
            r3 = r4
            r4 = r5
            goto L_0x005d
        L_0x00dc:
            long r6 = -r6
            goto L_0x002f
        L_0x00df:
            r0 = 2
            if (r3 == r0) goto L_0x00e8
            r0 = 4
            if (r3 == r0) goto L_0x00e8
            r0 = 7
            if (r3 != r0) goto L_0x00f0
        L_0x00e8:
            r15.boe = r10
            r0 = 16
            r15.boc = r0
            goto L_0x0017
        L_0x00f0:
            r0 = 0
            goto L_0x0017
        L_0x00f3:
            r2 = r3
            r3 = r4
            r4 = r5
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzapy.m1416bC():int");
    }

    /* renamed from: bD */
    private String m1417bD() throws IOException {
        String sb;
        StringBuilder sb2 = null;
        int i = 0;
        while (true) {
            if (this.pos + i < this.limit) {
                switch (this.bnZ[this.pos + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m1419bF();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.bnZ.length) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.bnZ, this.pos, i);
                this.pos = i + this.pos;
                if (!zzagx(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (zzagx(i + 1)) {
            }
        }
        if (sb2 == null) {
            sb = new String(this.bnZ, this.pos, i);
        } else {
            sb2.append(this.bnZ, this.pos, i);
            sb = sb2.toString();
        }
        this.pos = i + this.pos;
        return sb;
    }

    /* renamed from: bE */
    private void m1418bE() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.bnZ[this.pos + i]) {
                    case 9:
                    case 10:
                    case 12:
                    case 13:
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        m1419bF();
                        break;
                    default:
                        i++;
                }
                this.pos = i + this.pos;
                return;
            }
            this.pos = i + this.pos;
        } while (zzagx(1));
    }

    /* renamed from: bF */
    private void m1419bF() throws IOException {
        if (!this.bnY) {
            throw zzuv("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: bG */
    private void m1420bG() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || zzagx(1)) {
                char[] cArr = this.bnZ;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == 10) {
                    this.boa++;
                    this.bob = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    /* renamed from: bH */
    private char m1421bH() throws IOException {
        int i;
        if (this.pos != this.limit || zzagx(1)) {
            char[] cArr = this.bnZ;
            int i2 = this.pos;
            this.pos = i2 + 1;
            char c = cArr[i2];
            switch (c) {
                case 10:
                    this.boa++;
                    this.bob = this.pos;
                    return c;
                case 'b':
                    return 8;
                case 'f':
                    return 12;
                case 'n':
                    return 10;
                case 'r':
                    return 13;
                case 't':
                    return 9;
                case 'u':
                    if (this.pos + 4 <= this.limit || zzagx(4)) {
                        int i3 = this.pos;
                        int i4 = i3 + 4;
                        int i5 = i3;
                        char c2 = 0;
                        for (int i6 = i5; i6 < i4; i6++) {
                            char c3 = this.bnZ[i6];
                            char c4 = (char) (c2 << 4);
                            if (c3 >= '0' && c3 <= '9') {
                                i = c3 - '0';
                            } else if (c3 >= 'a' && c3 <= 'f') {
                                i = (c3 - 'a') + 10;
                            } else if (c3 < 'A' || c3 > 'F') {
                                String valueOf = String.valueOf(new String(this.bnZ, this.pos, 4));
                                throw new NumberFormatException(valueOf.length() != 0 ? "\\u".concat(valueOf) : new String("\\u"));
                            } else {
                                i = (c3 - 'A') + 10;
                            }
                            c2 = (char) (c4 + i);
                        }
                        this.pos += 4;
                        return c2;
                    }
                    throw zzuv("Unterminated escape sequence");
                default:
                    return c;
            }
        } else {
            throw zzuv("Unterminated escape sequence");
        }
    }

    /* renamed from: bI */
    private void m1422bI() throws IOException {
        zzdg(true);
        this.pos--;
        if (this.pos + bnX.length <= this.limit || zzagx(bnX.length)) {
            int i = 0;
            while (i < bnX.length) {
                if (this.bnZ[this.pos + i] == bnX[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.pos += bnX.length;
        }
    }

    /* access modifiers changed from: private */
    public int getColumnNumber() {
        return (this.pos - this.bob) + 1;
    }

    /* access modifiers changed from: private */
    public int getLineNumber() {
        return this.boa + 1;
    }

    private void zzagw(int i) {
        if (this.boh == this.bog.length) {
            int[] iArr = new int[(this.boh * 2)];
            int[] iArr2 = new int[(this.boh * 2)];
            String[] strArr = new String[(this.boh * 2)];
            System.arraycopy(this.bog, 0, iArr, 0, this.boh);
            System.arraycopy(this.boj, 0, iArr2, 0, this.boh);
            System.arraycopy(this.boi, 0, strArr, 0, this.boh);
            this.bog = iArr;
            this.boj = iArr2;
            this.boi = strArr;
        }
        int[] iArr3 = this.bog;
        int i2 = this.boh;
        this.boh = i2 + 1;
        iArr3[i2] = i;
    }

    private boolean zzagx(int i) throws IOException {
        char[] cArr = this.bnZ;
        this.bob -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(cArr, this.pos, cArr, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.f1930in.read(cArr, this.limit, cArr.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit = read + this.limit;
            if (this.boa == 0 && this.bob == 0 && this.limit > 0 && cArr[0] == 65279) {
                this.pos++;
                this.bob++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int zzdg(boolean z) throws IOException {
        char[] cArr = this.bnZ;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (zzagx(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (!z) {
                    return -1;
                } else {
                    String valueOf = String.valueOf("End of input at line ");
                    throw new EOFException(new StringBuilder(String.valueOf(valueOf).length() + 30).append(valueOf).append(getLineNumber()).append(" column ").append(getColumnNumber()).toString());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 10) {
                this.boa++;
                this.bob = i3;
                i = i3;
            } else if (c == ' ' || c == 13) {
                i = i3;
            } else if (c == 9) {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean zzagx = zzagx(2);
                    this.pos++;
                    if (!zzagx) {
                        return c;
                    }
                }
                m1419bF();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (zzuu("*/")) {
                            i = this.pos + 2;
                            i2 = this.limit;
                            break;
                        } else {
                            throw zzuv("Unterminated comment");
                        }
                    case '/':
                        this.pos++;
                        m1420bG();
                        i = this.pos;
                        i2 = this.limit;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.pos = i3;
                m1419bF();
                m1420bG();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private boolean zze(char c) throws IOException {
        switch (c) {
            case 9:
            case 10:
            case 12:
            case 13:
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                m1419bF();
                break;
            default:
                return true;
        }
        return false;
    }

    private String zzf(char c) throws IOException {
        char[] cArr = this.bnZ;
        StringBuilder sb = new StringBuilder();
        do {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    return sb.toString();
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    sb.append(cArr, i, (i4 - i) - 1);
                    sb.append(m1421bH());
                    i = this.pos;
                    i2 = this.limit;
                    i4 = i;
                } else if (c2 == 10) {
                    this.boa++;
                    this.bob = i4;
                }
                i3 = i4;
            }
            sb.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (zzagx(1));
        throw zzuv("Unterminated string");
    }

    private void zzg(char c) throws IOException {
        char[] cArr = this.bnZ;
        do {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    return;
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    m1421bH();
                    i4 = this.pos;
                    i2 = this.limit;
                } else if (c2 == 10) {
                    this.boa++;
                    this.bob = i4;
                }
                i3 = i4;
            }
            this.pos = i3;
        } while (zzagx(1));
        throw zzuv("Unterminated string");
    }

    private boolean zzuu(String str) throws IOException {
        while (true) {
            if (this.pos + str.length() > this.limit && !zzagx(str.length())) {
                return false;
            }
            if (this.bnZ[this.pos] == 10) {
                this.boa++;
                this.bob = this.pos + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.bnZ[this.pos + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private IOException zzuv(String str) throws IOException {
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new zzaqb(new StringBuilder(String.valueOf(str).length() + 45 + String.valueOf(path).length()).append(str).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void beginArray() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        if (i == 3) {
            zzagw(1);
            this.boj[this.boh - 1] = 0;
            this.boc = 0;
            return;
        }
        String valueOf = String.valueOf(mo8968bn());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 74 + String.valueOf(path).length()).append("Expected BEGIN_ARRAY but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void beginObject() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        if (i == 1) {
            zzagw(3);
            this.boc = 0;
            return;
        }
        String valueOf = String.valueOf(mo8968bn());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 75 + String.valueOf(path).length()).append("Expected BEGIN_OBJECT but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    /* renamed from: bn */
    public zzapz mo8968bn() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        switch (i) {
            case 1:
                return zzapz.BEGIN_OBJECT;
            case 2:
                return zzapz.END_OBJECT;
            case 3:
                return zzapz.BEGIN_ARRAY;
            case 4:
                return zzapz.END_ARRAY;
            case 5:
            case 6:
                return zzapz.BOOLEAN;
            case 7:
                return zzapz.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return zzapz.STRING;
            case 12:
            case 13:
            case 14:
                return zzapz.NAME;
            case 15:
            case 16:
                return zzapz.NUMBER;
            case 17:
                return zzapz.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void close() throws IOException {
        this.boc = 0;
        this.bog[0] = 8;
        this.boh = 1;
        this.f1930in.close();
    }

    public void endArray() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        if (i == 4) {
            this.boh--;
            int[] iArr = this.boj;
            int i2 = this.boh - 1;
            iArr[i2] = iArr[i2] + 1;
            this.boc = 0;
            return;
        }
        String valueOf = String.valueOf(mo8968bn());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 72 + String.valueOf(path).length()).append("Expected END_ARRAY but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public void endObject() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        if (i == 2) {
            this.boh--;
            this.boi[this.boh] = null;
            int[] iArr = this.boj;
            int i2 = this.boh - 1;
            iArr[i2] = iArr[i2] + 1;
            this.boc = 0;
            return;
        }
        String valueOf = String.valueOf(mo8968bn());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 73 + String.valueOf(path).length()).append("Expected END_OBJECT but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.boh;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.bog[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.boj[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.boi[i2] == null) {
                        break;
                    } else {
                        append.append(this.boi[i2]);
                        break;
                    }
            }
        }
        return append.toString();
    }

    public boolean hasNext() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.bnY;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        if (i == 5) {
            this.boc = 0;
            int[] iArr = this.boj;
            int i2 = this.boh - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.boc = 0;
            int[] iArr2 = this.boj;
            int i3 = this.boh - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            String valueOf = String.valueOf(mo8968bn());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 72 + String.valueOf(path).length()).append("Expected a boolean but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
    }

    public double nextDouble() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        if (i == 15) {
            this.boc = 0;
            int[] iArr = this.boj;
            int i2 = this.boh - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.bod;
        }
        if (i == 16) {
            this.bof = new String(this.bnZ, this.pos, this.boe);
            this.pos += this.boe;
        } else if (i == 8 || i == 9) {
            this.bof = zzf(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.bof = m1417bD();
        } else if (i != 11) {
            String valueOf = String.valueOf(mo8968bn());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(path).length()).append("Expected a double but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.boc = 11;
        double parseDouble = Double.parseDouble(this.bof);
        if (this.bnY || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.bof = null;
            this.boc = 0;
            int[] iArr2 = this.boj;
            int i3 = this.boh - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        int lineNumber2 = getLineNumber();
        int columnNumber2 = getColumnNumber();
        String path2 = getPath();
        throw new zzaqb(new StringBuilder(String.valueOf(path2).length() + 102).append("JSON forbids NaN and infinities: ").append(parseDouble).append(" at line ").append(lineNumber2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
    }

    public int nextInt() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        if (i == 15) {
            int i2 = (int) this.bod;
            if (this.bod != ((long) i2)) {
                long j = this.bod;
                int lineNumber = getLineNumber();
                int columnNumber = getColumnNumber();
                String path = getPath();
                throw new NumberFormatException(new StringBuilder(String.valueOf(path).length() + 89).append("Expected an int but was ").append(j).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
            }
            this.boc = 0;
            int[] iArr = this.boj;
            int i3 = this.boh - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 16) {
            this.bof = new String(this.bnZ, this.pos, this.boe);
            this.pos += this.boe;
        } else if (i == 8 || i == 9) {
            this.bof = zzf(i == 8 ? '\'' : '\"');
            try {
                int parseInt = Integer.parseInt(this.bof);
                this.boc = 0;
                int[] iArr2 = this.boj;
                int i4 = this.boh - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException e) {
            }
        } else {
            String valueOf = String.valueOf(mo8968bn());
            int lineNumber2 = getLineNumber();
            int columnNumber2 = getColumnNumber();
            String path2 = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path2).length()).append("Expected an int but was ").append(valueOf).append(" at line ").append(lineNumber2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
        }
        this.boc = 11;
        double parseDouble = Double.parseDouble(this.bof);
        int i5 = (int) parseDouble;
        if (((double) i5) != parseDouble) {
            String str = this.bof;
            int lineNumber3 = getLineNumber();
            int columnNumber3 = getColumnNumber();
            String path3 = getPath();
            throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path3).length()).append("Expected an int but was ").append(str).append(" at line ").append(lineNumber3).append(" column ").append(columnNumber3).append(" path ").append(path3).toString());
        }
        this.bof = null;
        this.boc = 0;
        int[] iArr3 = this.boj;
        int i6 = this.boh - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    public long nextLong() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        if (i == 15) {
            this.boc = 0;
            int[] iArr = this.boj;
            int i2 = this.boh - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.bod;
        }
        if (i == 16) {
            this.bof = new String(this.bnZ, this.pos, this.boe);
            this.pos += this.boe;
        } else if (i == 8 || i == 9) {
            this.bof = zzf(i == 8 ? '\'' : '\"');
            try {
                long parseLong = Long.parseLong(this.bof);
                this.boc = 0;
                int[] iArr2 = this.boj;
                int i3 = this.boh - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            String valueOf = String.valueOf(mo8968bn());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path).length()).append("Expected a long but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.boc = 11;
        double parseDouble = Double.parseDouble(this.bof);
        long j = (long) parseDouble;
        if (((double) j) != parseDouble) {
            String str = this.bof;
            int lineNumber2 = getLineNumber();
            int columnNumber2 = getColumnNumber();
            String path2 = getPath();
            throw new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 69 + String.valueOf(path2).length()).append("Expected a long but was ").append(str).append(" at line ").append(lineNumber2).append(" column ").append(columnNumber2).append(" path ").append(path2).toString());
        }
        this.bof = null;
        this.boc = 0;
        int[] iArr3 = this.boj;
        int i4 = this.boh - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j;
    }

    public String nextName() throws IOException {
        String zzf;
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        if (i == 14) {
            zzf = m1417bD();
        } else if (i == 12) {
            zzf = zzf('\'');
        } else if (i == 13) {
            zzf = zzf('\"');
        } else {
            String valueOf = String.valueOf(mo8968bn());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 69 + String.valueOf(path).length()).append("Expected a name but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.boc = 0;
        this.boi[this.boh - 1] = zzf;
        return zzf;
    }

    public void nextNull() throws IOException {
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        if (i == 7) {
            this.boc = 0;
            int[] iArr = this.boj;
            int i2 = this.boh - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        String valueOf = String.valueOf(mo8968bn());
        int lineNumber = getLineNumber();
        int columnNumber = getColumnNumber();
        String path = getPath();
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 67 + String.valueOf(path).length()).append("Expected null but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
    }

    public String nextString() throws IOException {
        String str;
        int i = this.boc;
        if (i == 0) {
            i = m1414bA();
        }
        if (i == 10) {
            str = m1417bD();
        } else if (i == 8) {
            str = zzf('\'');
        } else if (i == 9) {
            str = zzf('\"');
        } else if (i == 11) {
            str = this.bof;
            this.bof = null;
        } else if (i == 15) {
            str = Long.toString(this.bod);
        } else if (i == 16) {
            str = new String(this.bnZ, this.pos, this.boe);
            this.pos += this.boe;
        } else {
            String valueOf = String.valueOf(mo8968bn());
            int lineNumber = getLineNumber();
            int columnNumber = getColumnNumber();
            String path = getPath();
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(path).length()).append("Expected a string but was ").append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(columnNumber).append(" path ").append(path).toString());
        }
        this.boc = 0;
        int[] iArr = this.boj;
        int i2 = this.boh - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final void setLenient(boolean z) {
        this.bnY = z;
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.boc;
            if (i2 == 0) {
                i2 = m1414bA();
            }
            if (i2 == 3) {
                zzagw(1);
                i++;
            } else if (i2 == 1) {
                zzagw(3);
                i++;
            } else if (i2 == 4) {
                this.boh--;
                i--;
            } else if (i2 == 2) {
                this.boh--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                m1418bE();
            } else if (i2 == 8 || i2 == 12) {
                zzg('\'');
            } else if (i2 == 9 || i2 == 13) {
                zzg('\"');
            } else if (i2 == 16) {
                this.pos += this.boe;
            }
            this.boc = 0;
        } while (i != 0);
        int[] iArr = this.boj;
        int i3 = this.boh - 1;
        iArr[i3] = iArr[i3] + 1;
        this.boi[this.boh - 1] = "null";
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getSimpleName());
        int lineNumber = getLineNumber();
        return new StringBuilder(String.valueOf(valueOf).length() + 39).append(valueOf).append(" at line ").append(lineNumber).append(" column ").append(getColumnNumber()).toString();
    }
}
