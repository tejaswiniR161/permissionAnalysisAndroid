package com.applovin.impl.sdk;

/* renamed from: com.applovin.impl.sdk.by */
public class C0345by implements Comparable {

    /* renamed from: a */
    private static int f569a = 0;

    /* renamed from: b */
    private final int f570b;

    /* renamed from: c */
    private final String f571c;

    /* renamed from: d */
    private final Object f572d;

    private C0345by(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (obj == null) {
            throw new IllegalArgumentException("No default value specified");
        } else {
            this.f571c = str;
            this.f572d = obj;
            this.f570b = f569a;
            f569a++;
        }
    }

    /* renamed from: a */
    public int mo5539a() {
        return this.f570b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo5540a(Object obj) {
        return this.f572d.getClass().cast(obj);
    }

    /* renamed from: b */
    public String mo5541b() {
        return this.f571c;
    }

    /* renamed from: c */
    public Object mo5542c() {
        return this.f572d;
    }

    public int compareTo(Object obj) {
        if (obj == null || !(obj instanceof C0345by)) {
            return 0;
        }
        return this.f571c.compareTo(((C0345by) obj).mo5541b());
    }
}
