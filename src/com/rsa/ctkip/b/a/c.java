package com.rsa.ctkip.b.a;

public final class c extends d {
    private static final byte[] a = new byte[256];
    private static final int[] b = new int[256];
    private static final int[] c = new int[256];
    private static final int[] d = new int[256];
    private static final int[] e = new int[256];
    private static final byte[] f = new byte[256];
    private static final int[] g = new int[256];
    private static final int[] h = new int[256];
    private static final int[] i = new int[256];
    private static final int[] j = new int[256];
    private static final int[] k = new int[10];
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int[] o = null;
    private int[] p = null;

    static {
        int charAt;
        int i = 1;
        for (int i2 = 0; i2 < 256; i2++) {
            charAt = "捼睻濅、末ﻗꭶ쪂쥽繁䟰귔ꊯ鲤狀럽錦㘿㒥燘ㄕӇ⏃ᢖ֚ܒ胢뉵ঃⰚ᭮媠刻횳⧣⾄发í⃼녛櫋븹䩌壏탯꫻䍍㎅䗹ɿ值龨冣䂏銝㣵벶?ჿ촌Ꮼ得䐗쒧總摝ᥳ悁俜∪邈䛮렔?௛㨊䤆⑜싓걢醕㝭跕亩汖敺금멸┮Ღ듆琟䮽變瀾땦䠃愵垹蛁ᶞ頑槙躔鬞蟩칕⣟財褍뿦䉨䆙ⴏ끔묖".charAt(i2 >>> 1);
            if ((i2 & 1) == 0) {
                charAt >>>= 8;
            }
            int i3 = ((byte) charAt) & 255;
            charAt = i3 << 1;
            int i4 = charAt >= 256 ? charAt ^ 283 : charAt;
            int i5 = i4 ^ i3;
            charAt = i2 << 1;
            int i6 = charAt >= 256 ? charAt ^ 283 : charAt;
            charAt = i6 << 1;
            int i7 = charAt >= 256 ? charAt ^ 283 : charAt;
            charAt = i7 << 1;
            if (charAt >= 256) {
                charAt ^= 283;
            }
            int i8 = charAt ^ i2;
            int i9 = i8 ^ i6;
            int i10 = i8 ^ i7;
            charAt = (charAt ^ i7) ^ i6;
            a[i2] = (byte) i3;
            i6 = (((i4 << 24) | (i3 << 16)) | (i3 << 8)) | i5;
            b[i2] = i6;
            c[i2] = (i6 >>> 8) | (i6 << 24);
            d[i2] = (i6 >>> 16) | (i6 << 16);
            e[i2] = (i6 << 8) | (i6 >>> 24);
            f[i3] = (byte) i2;
            charAt = (((charAt << 24) | (i8 << 16)) | (i10 << 8)) | i9;
            g[i3] = charAt;
            h[i3] = (charAt >>> 8) | (charAt << 24);
            i[i3] = (charAt >>> 16) | (charAt << 16);
            j[i3] = (charAt << 8) | (charAt >>> 24);
        }
        k[0] = 16777216;
        charAt = 1;
        while (i < 10) {
            charAt <<= 1;
            if (charAt >= 256) {
                charAt ^= 283;
            }
            k[i] = charAt << 24;
            i++;
        }
    }

    private final void a(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.m) {
            this.o[i3] = (((bArr[i2] << 24) | ((bArr[i2 + 1] & 255) << 16)) | ((bArr[i2 + 2] & 255) << 8)) | (bArr[i2 + 3] & 255);
            i3++;
            i2 += 4;
        }
        i2 = this.m;
        i3 = 0;
        while (i2 < this.n) {
            int i4 = this.o[i2 - 1];
            if (i == 0) {
                i = this.m;
                int i5 = (((a[(i4 >>> 16) & 255] << 24) | ((a[(i4 >>> 8) & 255] & 255) << 16)) | ((a[i4 & 255] & 255) << 8)) | (a[i4 >>> 24] & 255);
                int i6 = i3 + 1;
                i4 = k[i3] ^ i5;
                i3 = i6;
            } else if (this.m == 8 && i == 4) {
                i4 = (a[i4 & 255] & 255) | (((a[i4 >>> 24] << 24) | ((a[(i4 >>> 16) & 255] & 255) << 16)) | ((a[(i4 >>> 8) & 255] & 255) << 8));
            }
            this.o[i2] = i4 ^ this.o[i2 - this.m];
            i2++;
            i--;
        }
    }

    private final void b() {
        int i = 1;
        int i2 = this.l * 4;
        this.p[0] = this.o[i2];
        this.p[1] = this.o[i2 + 1];
        this.p[2] = this.o[i2 + 2];
        this.p[3] = this.o[i2 + 3];
        int i3 = 4;
        int i4 = i2 - 4;
        while (i < this.l) {
            i2 = this.o[i4];
            this.p[i3] = j[a[i2 & 255] & 255] ^ ((g[a[i2 >>> 24] & 255] ^ h[a[(i2 >>> 16) & 255] & 255]) ^ i[a[(i2 >>> 8) & 255] & 255]);
            i2 = this.o[i4 + 1];
            this.p[i3 + 1] = j[a[i2 & 255] & 255] ^ ((g[a[i2 >>> 24] & 255] ^ h[a[(i2 >>> 16) & 255] & 255]) ^ i[a[(i2 >>> 8) & 255] & 255]);
            i2 = this.o[i4 + 2];
            this.p[i3 + 2] = j[a[i2 & 255] & 255] ^ ((g[a[i2 >>> 24] & 255] ^ h[a[(i2 >>> 16) & 255] & 255]) ^ i[a[(i2 >>> 8) & 255] & 255]);
            i2 = this.o[i4 + 3];
            this.p[i3 + 3] = j[a[i2 & 255] & 255] ^ ((g[a[i2 >>> 24] & 255] ^ h[a[(i2 >>> 16) & 255] & 255]) ^ i[a[(i2 >>> 8) & 255] & 255]);
            i3 += 4;
            i4 -= 4;
            i++;
        }
        this.p[i3] = this.o[i4];
        this.p[i3 + 1] = this.o[i4 + 1];
        this.p[i3 + 2] = this.o[i4 + 2];
        this.p[i3 + 3] = this.o[i4 + 3];
    }

    public final int a() {
        return 16;
    }

    public final void a(byte[] bArr, int i, int i2) {
        switch (i) {
            case 16:
            case 24:
            case 32:
                i <<= 3;
                break;
            case 128:
            case 192:
            case 256:
                break;
            default:
                throw new RuntimeException();
        }
        this.m = i >>> 5;
        this.l = this.m + 6;
        this.n = (this.l + 1) * 4;
        this.o = new int[this.n];
        this.p = new int[this.n];
        if ((i2 & 3) != 0) {
            a(bArr);
            if ((i2 & 2) != 0) {
                b();
            }
        }
    }

    public final void a(byte[] bArr, byte[] bArr2) {
        int i = ((((bArr[8] << 24) | ((bArr[9] & 255) << 16)) | ((bArr[10] & 255) << 8)) | (bArr[11] & 255)) ^ this.o[2];
        int i2 = this.o[3] ^ ((((bArr[12] << 24) | ((bArr[13] & 255) << 16)) | ((bArr[14] & 255) << 8)) | (bArr[15] & 255));
        int i3 = 1;
        int i4 = ((((bArr[0] << 24) | ((bArr[1] & 255) << 16)) | ((bArr[2] & 255) << 8)) | (bArr[3] & 255)) ^ this.o[0];
        int i5 = ((((bArr[4] << 24) | ((bArr[5] & 255) << 16)) | ((bArr[6] & 255) << 8)) | (bArr[7] & 255)) ^ this.o[1];
        int i6 = 0;
        while (i3 < this.l) {
            int i7 = i6 + 4;
            int i8 = (((b[i4 >>> 24] ^ c[(i5 >>> 16) & 255]) ^ d[(i >>> 8) & 255]) ^ e[i2 & 255]) ^ this.o[i7];
            int i9 = this.o[i7 + 1] ^ (((b[i5 >>> 24] ^ c[(i >>> 16) & 255]) ^ d[(i2 >>> 8) & 255]) ^ e[i4 & 255]);
            i6 = (((b[i >>> 24] ^ c[(i2 >>> 16) & 255]) ^ d[(i4 >>> 8) & 255]) ^ e[i5 & 255]) ^ this.o[i7 + 2];
            i2 = (((b[i2 >>> 24] ^ c[(i4 >>> 16) & 255]) ^ d[(i5 >>> 8) & 255]) ^ e[i & 255]) ^ this.o[i7 + 3];
            i3++;
            i = i6;
            i5 = i9;
            i4 = i8;
            i6 = i7;
        }
        i3 = i6 + 4;
        i6 = this.o[i3];
        bArr2[0] = (byte) (a[i4 >>> 24] ^ (i6 >>> 24));
        bArr2[1] = (byte) (a[(i5 >>> 16) & 255] ^ (i6 >>> 16));
        bArr2[2] = (byte) (a[(i >>> 8) & 255] ^ (i6 >>> 8));
        bArr2[3] = (byte) (i6 ^ a[i2 & 255]);
        i6 = this.o[i3 + 1];
        bArr2[4] = (byte) (a[i5 >>> 24] ^ (i6 >>> 24));
        bArr2[5] = (byte) (a[(i >>> 16) & 255] ^ (i6 >>> 16));
        bArr2[6] = (byte) (a[(i2 >>> 8) & 255] ^ (i6 >>> 8));
        bArr2[7] = (byte) (i6 ^ a[i4 & 255]);
        i6 = this.o[i3 + 2];
        bArr2[8] = (byte) (a[i >>> 24] ^ (i6 >>> 24));
        bArr2[9] = (byte) (a[(i2 >>> 16) & 255] ^ (i6 >>> 16));
        bArr2[10] = (byte) (a[(i4 >>> 8) & 255] ^ (i6 >>> 8));
        bArr2[11] = (byte) (i6 ^ a[i5 & 255]);
        i3 = this.o[i3 + 3];
        bArr2[12] = (byte) (a[i2 >>> 24] ^ (i3 >>> 24));
        bArr2[13] = (byte) (a[(i4 >>> 16) & 255] ^ (i3 >>> 16));
        bArr2[14] = (byte) (a[(i5 >>> 8) & 255] ^ (i3 >>> 8));
        bArr2[15] = (byte) (i3 ^ a[i & 255]);
    }
}
