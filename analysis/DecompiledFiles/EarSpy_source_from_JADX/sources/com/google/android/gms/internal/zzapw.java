package com.google.android.gms.internal;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

public final class zzapw {
    public static final zzaot<Class> bmS = new zzaot<Class>() {
        public void zza(zzaqa zzaqa, Class cls) throws IOException {
            if (cls == null) {
                zzaqa.mo8990bx();
            } else {
                String valueOf = String.valueOf(cls.getName());
                throw new UnsupportedOperationException(new StringBuilder(String.valueOf(valueOf).length() + 76).append("Attempted to serialize java.lang.Class: ").append(valueOf).append(". Forgot to register a type adapter?").toString());
            }
        }

        /* renamed from: zzo */
        public Class zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    };
    public static final zzaou bmT = zza(Class.class, bmS);
    public static final zzaot<BitSet> bmU = new zzaot<BitSet>() {
        public void zza(zzaqa zzaqa, BitSet bitSet) throws IOException {
            if (bitSet == null) {
                zzaqa.mo8990bx();
                return;
            }
            zzaqa.mo8986bt();
            for (int i = 0; i < bitSet.length(); i++) {
                zzaqa.zzcu((long) (bitSet.get(i) ? 1 : 0));
            }
            zzaqa.mo8987bu();
        }

        /* renamed from: zzx */
        public BitSet zzb(zzapy zzapy) throws IOException {
            boolean z;
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            BitSet bitSet = new BitSet();
            zzapy.beginArray();
            zzapz bn = zzapy.mo8968bn();
            int i = 0;
            while (bn != zzapz.END_ARRAY) {
                switch (C080926.bmF[bn.ordinal()]) {
                    case 1:
                        if (zzapy.nextInt() == 0) {
                            z = false;
                            break;
                        } else {
                            z = true;
                            break;
                        }
                    case 2:
                        z = zzapy.nextBoolean();
                        break;
                    case 3:
                        String nextString = zzapy.nextString();
                        try {
                            if (Integer.parseInt(nextString) == 0) {
                                z = false;
                                break;
                            } else {
                                z = true;
                                break;
                            }
                        } catch (NumberFormatException e) {
                            String valueOf = String.valueOf(nextString);
                            throw new zzaoq(valueOf.length() != 0 ? "Error: Expecting: bitset number value (1, 0), Found: ".concat(valueOf) : new String("Error: Expecting: bitset number value (1, 0), Found: "));
                        }
                    default:
                        String valueOf2 = String.valueOf(bn);
                        throw new zzaoq(new StringBuilder(String.valueOf(valueOf2).length() + 27).append("Invalid bitset value type: ").append(valueOf2).toString());
                }
                if (z) {
                    bitSet.set(i);
                }
                i++;
                bn = zzapy.mo8968bn();
            }
            zzapy.endArray();
            return bitSet;
        }
    };
    public static final zzaou bmV = zza(BitSet.class, bmU);
    public static final zzaot<Boolean> bmW = new zzaot<Boolean>() {
        public void zza(zzaqa zzaqa, Boolean bool) throws IOException {
            if (bool == null) {
                zzaqa.mo8990bx();
            } else {
                zzaqa.zzdf(bool.booleanValue());
            }
        }

        /* renamed from: zzae */
        public Boolean zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() != zzapz.NULL) {
                return zzapy.mo8968bn() == zzapz.STRING ? Boolean.valueOf(Boolean.parseBoolean(zzapy.nextString())) : Boolean.valueOf(zzapy.nextBoolean());
            }
            zzapy.nextNull();
            return null;
        }
    };
    public static final zzaot<Boolean> bmX = new zzaot<Boolean>() {
        public void zza(zzaqa zzaqa, Boolean bool) throws IOException {
            zzaqa.zzut(bool == null ? "null" : bool.toString());
        }

        /* renamed from: zzae */
        public Boolean zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() != zzapz.NULL) {
                return Boolean.valueOf(zzapy.nextString());
            }
            zzapy.nextNull();
            return null;
        }
    };
    public static final zzaou bmY = zza(Boolean.TYPE, Boolean.class, bmW);
    public static final zzaot<Number> bmZ = new zzaot<Number>() {
        public void zza(zzaqa zzaqa, Number number) throws IOException {
            zzaqa.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) zzapy.nextInt());
            } catch (NumberFormatException e) {
                throw new zzaoq((Throwable) e);
            }
        }
    };
    public static final zzaot<UUID> bnA = new zzaot<UUID>() {
        public void zza(zzaqa zzaqa, UUID uuid) throws IOException {
            zzaqa.zzut(uuid == null ? null : uuid.toString());
        }

        /* renamed from: zzz */
        public UUID zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() != zzapz.NULL) {
                return UUID.fromString(zzapy.nextString());
            }
            zzapy.nextNull();
            return null;
        }
    };
    public static final zzaou bnB = zza(UUID.class, bnA);
    public static final zzaou bnC = new zzaou() {
        public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
            if (zzapx.mo9067by() != Timestamp.class) {
                return null;
            }
            final zzaot<Date> zzk = zzaob.zzk(Date.class);
            return new zzaot<Timestamp>() {
                public void zza(zzaqa zzaqa, Timestamp timestamp) throws IOException {
                    zzk.zza(zzaqa, timestamp);
                }

                /* renamed from: zzaa */
                public Timestamp zzb(zzapy zzapy) throws IOException {
                    Date date = (Date) zzk.zzb(zzapy);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }
            };
        }
    };
    public static final zzaot<Calendar> bnD = new zzaot<Calendar>() {
        public void zza(zzaqa zzaqa, Calendar calendar) throws IOException {
            if (calendar == null) {
                zzaqa.mo8990bx();
                return;
            }
            zzaqa.mo8988bv();
            zzaqa.zzus("year");
            zzaqa.zzcu((long) calendar.get(1));
            zzaqa.zzus("month");
            zzaqa.zzcu((long) calendar.get(2));
            zzaqa.zzus("dayOfMonth");
            zzaqa.zzcu((long) calendar.get(5));
            zzaqa.zzus("hourOfDay");
            zzaqa.zzcu((long) calendar.get(11));
            zzaqa.zzus("minute");
            zzaqa.zzcu((long) calendar.get(12));
            zzaqa.zzus("second");
            zzaqa.zzcu((long) calendar.get(13));
            zzaqa.mo8989bw();
        }

        /* renamed from: zzab */
        public Calendar zzb(zzapy zzapy) throws IOException {
            int i = 0;
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            zzapy.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (zzapy.mo8968bn() != zzapz.END_OBJECT) {
                String nextName = zzapy.nextName();
                int nextInt = zzapy.nextInt();
                if ("year".equals(nextName)) {
                    i6 = nextInt;
                } else if ("month".equals(nextName)) {
                    i5 = nextInt;
                } else if ("dayOfMonth".equals(nextName)) {
                    i4 = nextInt;
                } else if ("hourOfDay".equals(nextName)) {
                    i3 = nextInt;
                } else if ("minute".equals(nextName)) {
                    i2 = nextInt;
                } else if ("second".equals(nextName)) {
                    i = nextInt;
                }
            }
            zzapy.endObject();
            return new GregorianCalendar(i6, i5, i4, i3, i2, i);
        }
    };
    public static final zzaou bnE = zzb(Calendar.class, GregorianCalendar.class, bnD);
    public static final zzaot<Locale> bnF = new zzaot<Locale>() {
        public void zza(zzaqa zzaqa, Locale locale) throws IOException {
            zzaqa.zzut(locale == null ? null : locale.toString());
        }

        /* renamed from: zzac */
        public Locale zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(zzapy.nextString(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }
    };
    public static final zzaou bnG = zza(Locale.class, bnF);
    public static final zzaot<zzaoh> bnH = new zzaot<zzaoh>() {
        public void zza(zzaqa zzaqa, zzaoh zzaoh) throws IOException {
            if (zzaoh == null || zzaoh.mo8851aV()) {
                zzaqa.mo8990bx();
            } else if (zzaoh.mo8850aU()) {
                zzaon aY = zzaoh.mo8854aY();
                if (aY.mo8872bb()) {
                    zzaqa.zza(aY.mo8836aQ());
                } else if (aY.mo8871ba()) {
                    zzaqa.zzdf(aY.getAsBoolean());
                } else {
                    zzaqa.zzut(aY.mo8837aR());
                }
            } else if (zzaoh.mo8848aS()) {
                zzaqa.mo8986bt();
                Iterator<zzaoh> it = zzaoh.mo8853aX().iterator();
                while (it.hasNext()) {
                    zza(zzaqa, it.next());
                }
                zzaqa.mo8987bu();
            } else if (zzaoh.mo8849aT()) {
                zzaqa.mo8988bv();
                for (Map.Entry next : zzaoh.mo8852aW().entrySet()) {
                    zzaqa.zzus((String) next.getKey());
                    zza(zzaqa, (zzaoh) next.getValue());
                }
                zzaqa.mo8989bw();
            } else {
                String valueOf = String.valueOf(zzaoh.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 15).append("Couldn't write ").append(valueOf).toString());
            }
        }

        /* renamed from: zzad */
        public zzaoh zzb(zzapy zzapy) throws IOException {
            switch (C080926.bmF[zzapy.mo8968bn().ordinal()]) {
                case 1:
                    return new zzaon((Number) new zzape(zzapy.nextString()));
                case 2:
                    return new zzaon(Boolean.valueOf(zzapy.nextBoolean()));
                case 3:
                    return new zzaon(zzapy.nextString());
                case 4:
                    zzapy.nextNull();
                    return zzaoj.bld;
                case 5:
                    zzaoe zzaoe = new zzaoe();
                    zzapy.beginArray();
                    while (zzapy.hasNext()) {
                        zzaoe.zzc((zzaoh) zzb(zzapy));
                    }
                    zzapy.endArray();
                    return zzaoe;
                case 6:
                    zzaok zzaok = new zzaok();
                    zzapy.beginObject();
                    while (zzapy.hasNext()) {
                        zzaok.zza(zzapy.nextName(), (zzaoh) zzb(zzapy));
                    }
                    zzapy.endObject();
                    return zzaok;
                default:
                    throw new IllegalArgumentException();
            }
        }
    };
    public static final zzaou bnI = zzb(zzaoh.class, bnH);
    public static final zzaou bnJ = new zzaou() {
        /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.zzapx<T>, com.google.android.gms.internal.zzapx] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> com.google.android.gms.internal.zzaot<T> zza(com.google.android.gms.internal.zzaob r3, com.google.android.gms.internal.zzapx<T> r4) {
            /*
                r2 = this;
                java.lang.Class r0 = r4.mo9067by()
                java.lang.Class<java.lang.Enum> r1 = java.lang.Enum.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x0010
                java.lang.Class<java.lang.Enum> r1 = java.lang.Enum.class
                if (r0 != r1) goto L_0x0012
            L_0x0010:
                r0 = 0
            L_0x0011:
                return r0
            L_0x0012:
                boolean r1 = r0.isEnum()
                if (r1 != 0) goto L_0x001c
                java.lang.Class r0 = r0.getSuperclass()
            L_0x001c:
                com.google.android.gms.internal.zzapw$zza r1 = new com.google.android.gms.internal.zzapw$zza
                r1.<init>(r0)
                r0 = r1
                goto L_0x0011
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzapw.C080119.zza(com.google.android.gms.internal.zzaob, com.google.android.gms.internal.zzapx):com.google.android.gms.internal.zzaot");
        }
    };
    public static final zzaou bna = zza(Byte.TYPE, Byte.class, bmZ);
    public static final zzaot<Number> bnb = new zzaot<Number>() {
        public void zza(zzaqa zzaqa, Number number) throws IOException {
            zzaqa.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) zzapy.nextInt());
            } catch (NumberFormatException e) {
                throw new zzaoq((Throwable) e);
            }
        }
    };
    public static final zzaou bnc = zza(Short.TYPE, Short.class, bnb);
    public static final zzaot<Number> bnd = new zzaot<Number>() {
        public void zza(zzaqa zzaqa, Number number) throws IOException {
            zzaqa.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(zzapy.nextInt());
            } catch (NumberFormatException e) {
                throw new zzaoq((Throwable) e);
            }
        }
    };
    public static final zzaou bne = zza(Integer.TYPE, Integer.class, bnd);
    public static final zzaot<Number> bnf = new zzaot<Number>() {
        public void zza(zzaqa zzaqa, Number number) throws IOException {
            zzaqa.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            try {
                return Long.valueOf(zzapy.nextLong());
            } catch (NumberFormatException e) {
                throw new zzaoq((Throwable) e);
            }
        }
    };
    public static final zzaot<Number> bng = new zzaot<Number>() {
        public void zza(zzaqa zzaqa, Number number) throws IOException {
            zzaqa.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() != zzapz.NULL) {
                return Float.valueOf((float) zzapy.nextDouble());
            }
            zzapy.nextNull();
            return null;
        }
    };
    public static final zzaot<Number> bnh = new zzaot<Number>() {
        public void zza(zzaqa zzaqa, Number number) throws IOException {
            zzaqa.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() != zzapz.NULL) {
                return Double.valueOf(zzapy.nextDouble());
            }
            zzapy.nextNull();
            return null;
        }
    };
    public static final zzaot<Number> bni = new zzaot<Number>() {
        public void zza(zzaqa zzaqa, Number number) throws IOException {
            zzaqa.zza(number);
        }

        /* renamed from: zzg */
        public Number zzb(zzapy zzapy) throws IOException {
            zzapz bn = zzapy.mo8968bn();
            switch (bn) {
                case NUMBER:
                    return new zzape(zzapy.nextString());
                case NULL:
                    zzapy.nextNull();
                    return null;
                default:
                    String valueOf = String.valueOf(bn);
                    throw new zzaoq(new StringBuilder(String.valueOf(valueOf).length() + 23).append("Expecting number, got: ").append(valueOf).toString());
            }
        }
    };
    public static final zzaou bnj = zza(Number.class, bni);
    public static final zzaot<Character> bnk = new zzaot<Character>() {
        public void zza(zzaqa zzaqa, Character ch) throws IOException {
            zzaqa.zzut(ch == null ? null : String.valueOf(ch));
        }

        /* renamed from: zzp */
        public Character zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            String nextString = zzapy.nextString();
            if (nextString.length() == 1) {
                return Character.valueOf(nextString.charAt(0));
            }
            String valueOf = String.valueOf(nextString);
            throw new zzaoq(valueOf.length() != 0 ? "Expecting character, got: ".concat(valueOf) : new String("Expecting character, got: "));
        }
    };
    public static final zzaou bnl = zza(Character.TYPE, Character.class, bnk);
    public static final zzaot<String> bnm = new zzaot<String>() {
        public void zza(zzaqa zzaqa, String str) throws IOException {
            zzaqa.zzut(str);
        }

        /* renamed from: zzq */
        public String zzb(zzapy zzapy) throws IOException {
            zzapz bn = zzapy.mo8968bn();
            if (bn != zzapz.NULL) {
                return bn == zzapz.BOOLEAN ? Boolean.toString(zzapy.nextBoolean()) : zzapy.nextString();
            }
            zzapy.nextNull();
            return null;
        }
    };
    public static final zzaot<BigDecimal> bnn = new zzaot<BigDecimal>() {
        public void zza(zzaqa zzaqa, BigDecimal bigDecimal) throws IOException {
            zzaqa.zza(bigDecimal);
        }

        /* renamed from: zzr */
        public BigDecimal zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            try {
                return new BigDecimal(zzapy.nextString());
            } catch (NumberFormatException e) {
                throw new zzaoq((Throwable) e);
            }
        }
    };
    public static final zzaot<BigInteger> bno = new zzaot<BigInteger>() {
        public void zza(zzaqa zzaqa, BigInteger bigInteger) throws IOException {
            zzaqa.zza(bigInteger);
        }

        /* renamed from: zzs */
        public BigInteger zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            try {
                return new BigInteger(zzapy.nextString());
            } catch (NumberFormatException e) {
                throw new zzaoq((Throwable) e);
            }
        }
    };
    public static final zzaou bnp = zza(String.class, bnm);
    public static final zzaot<StringBuilder> bnq = new zzaot<StringBuilder>() {
        public void zza(zzaqa zzaqa, StringBuilder sb) throws IOException {
            zzaqa.zzut(sb == null ? null : sb.toString());
        }

        /* renamed from: zzt */
        public StringBuilder zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() != zzapz.NULL) {
                return new StringBuilder(zzapy.nextString());
            }
            zzapy.nextNull();
            return null;
        }
    };
    public static final zzaou bnr = zza(StringBuilder.class, bnq);
    public static final zzaot<StringBuffer> bns = new zzaot<StringBuffer>() {
        public void zza(zzaqa zzaqa, StringBuffer stringBuffer) throws IOException {
            zzaqa.zzut(stringBuffer == null ? null : stringBuffer.toString());
        }

        /* renamed from: zzu */
        public StringBuffer zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() != zzapz.NULL) {
                return new StringBuffer(zzapy.nextString());
            }
            zzapy.nextNull();
            return null;
        }
    };
    public static final zzaou bnt = zza(StringBuffer.class, bns);
    public static final zzaot<URL> bnu = new zzaot<URL>() {
        public void zza(zzaqa zzaqa, URL url) throws IOException {
            zzaqa.zzut(url == null ? null : url.toExternalForm());
        }

        /* renamed from: zzv */
        public URL zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            String nextString = zzapy.nextString();
            if (!"null".equals(nextString)) {
                return new URL(nextString);
            }
            return null;
        }
    };
    public static final zzaou bnv = zza(URL.class, bnu);
    public static final zzaot<URI> bnw = new zzaot<URI>() {
        public void zza(zzaqa zzaqa, URI uri) throws IOException {
            zzaqa.zzut(uri == null ? null : uri.toASCIIString());
        }

        /* renamed from: zzw */
        public URI zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            try {
                String nextString = zzapy.nextString();
                if (!"null".equals(nextString)) {
                    return new URI(nextString);
                }
                return null;
            } catch (URISyntaxException e) {
                throw new zzaoi((Throwable) e);
            }
        }
    };
    public static final zzaou bnx = zza(URI.class, bnw);
    public static final zzaot<InetAddress> bny = new zzaot<InetAddress>() {
        public void zza(zzaqa zzaqa, InetAddress inetAddress) throws IOException {
            zzaqa.zzut(inetAddress == null ? null : inetAddress.getHostAddress());
        }

        /* renamed from: zzy */
        public InetAddress zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() != zzapz.NULL) {
                return InetAddress.getByName(zzapy.nextString());
            }
            zzapy.nextNull();
            return null;
        }
    };
    public static final zzaou bnz = zzb(InetAddress.class, bny);

    private static final class zza<T extends Enum<T>> extends zzaot<T> {
        private final Map<String, T> bnT = new HashMap();
        private final Map<T, String> bnU = new HashMap();

        public zza(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    zzaow zzaow = (zzaow) cls.getField(name).getAnnotation(zzaow.class);
                    if (zzaow != null) {
                        name = zzaow.value();
                        for (String put : zzaow.mo8880be()) {
                            this.bnT.put(put, enumR);
                        }
                    }
                    String str = name;
                    this.bnT.put(str, enumR);
                    this.bnU.put(enumR, str);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        public void zza(zzaqa zzaqa, T t) throws IOException {
            zzaqa.zzut(t == null ? null : this.bnU.get(t));
        }

        /* renamed from: zzaf */
        public T zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() != zzapz.NULL) {
                return (Enum) this.bnT.get(zzapy.nextString());
            }
            zzapy.nextNull();
            return null;
        }
    }

    public static <TT> zzaou zza(final zzapx<TT> zzapx, final zzaot<TT> zzaot) {
        return new zzaou() {
            public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
                if (zzapx.equals(zzapx)) {
                    return zzaot;
                }
                return null;
            }
        };
    }

    public static <TT> zzaou zza(final Class<TT> cls, final zzaot<TT> zzaot) {
        return new zzaou() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(zzaot);
                return new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append("Factory[type=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
            }

            public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
                if (zzapx.mo9067by() == cls) {
                    return zzaot;
                }
                return null;
            }
        };
    }

    public static <TT> zzaou zza(final Class<TT> cls, final Class<TT> cls2, final zzaot<? super TT> zzaot) {
        return new zzaou() {
            public String toString() {
                String valueOf = String.valueOf(cls2.getName());
                String valueOf2 = String.valueOf(cls.getName());
                String valueOf3 = String.valueOf(zzaot);
                return new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
            }

            public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
                Class<? super T> by = zzapx.mo9067by();
                if (by == cls || by == cls2) {
                    return zzaot;
                }
                return null;
            }
        };
    }

    public static <TT> zzaou zzb(final Class<TT> cls, final zzaot<TT> zzaot) {
        return new zzaou() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(zzaot);
                return new StringBuilder(String.valueOf(valueOf).length() + 32 + String.valueOf(valueOf2).length()).append("Factory[typeHierarchy=").append(valueOf).append(",adapter=").append(valueOf2).append("]").toString();
            }

            public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
                if (cls.isAssignableFrom(zzapx.mo9067by())) {
                    return zzaot;
                }
                return null;
            }
        };
    }

    public static <TT> zzaou zzb(final Class<TT> cls, final Class<? extends TT> cls2, final zzaot<? super TT> zzaot) {
        return new zzaou() {
            public String toString() {
                String valueOf = String.valueOf(cls.getName());
                String valueOf2 = String.valueOf(cls2.getName());
                String valueOf3 = String.valueOf(zzaot);
                return new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("Factory[type=").append(valueOf).append("+").append(valueOf2).append(",adapter=").append(valueOf3).append("]").toString();
            }

            public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
                Class<? super T> by = zzapx.mo9067by();
                if (by == cls || by == cls2) {
                    return zzaot;
                }
                return null;
            }
        };
    }
}
