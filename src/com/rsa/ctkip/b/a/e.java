package com.rsa.ctkip.b.a;

import java.io.UnsupportedEncodingException;

public class e {

    public static final byte eF = (byte) 51; //com.rsa.jcm.c.cm.eF
    public static final byte dhfI = (byte) 52; // com.rsa.jcm.c.dh.fI
    public static final byte emfI = (byte) 53; // com.rsa.jcm.c.em.fI
    public static final byte dqfI = (byte) 54; // com.rsa.jcm.c.dq.fI
    public static final byte fvfI = (byte) 56; // com.rsa.jcm.c.fv.fI

    private static final byte[] a;
    private static final byte[] bb = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 62, (byte) -9, (byte) -9, (byte) -9, (byte) 63, dhfI, emfI, dqfI, (byte) 55, fvfI, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, eF, (byte) -9, (byte) -9, (byte) -9, (byte) -9};

    static {
        try {
            a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Base64 not supported");
        }
    }

    private static int a(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3;
        if (bArr[i + 2] == (byte) 61) {
            bArr2[i2] = (byte) ((((bb[bArr[i]] & 255) << 18) | ((bb[bArr[i + 1]] & 255) << 12)) >>> 16);
            return 1;
        } else if (bArr[i + 3] == (byte) 61) {
            i3 = (((bb[bArr[i]] & 255) << 18) | ((bb[bArr[i + 1]] & 255) << 12)) | ((bb[bArr[i + 2]] & 255) << 6);
            bArr2[i2] = (byte) (i3 >>> 16);
            bArr2[i2 + 1] = (byte) (i3 >>> 8);
            return 2;
        } else {
            try {
                i3 = ((((bb[bArr[i]] & 255) << 18) | ((bb[bArr[i + 1]] & 255) << 12)) | ((bb[bArr[i + 2]] & 255) << 6)) | (bb[bArr[i + 3]] & 255);
                bArr2[i2] = (byte) (i3 >> 16);
                bArr2[i2 + 1] = (byte) (i3 >> 8);
                bArr2[i2 + 2] = (byte) i3;
                return 3;
            } catch (Exception e) {
                return -1;
            }
        }
    }

    public static String a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    public static String a(byte[] bArr, int i, int i2, int i3) {
        int i4 = i3 & 2;
        int i5 = (i3 & 8) == 0 ? 1 : 0;
        int i6 = (i2 * 4) / 3;
        byte[] bArr2 = new byte[((i5 != 0 ? i6 / 76 : 0) + (i6 + (i2 % 3 > 0 ? 4 : 0)))];
        int i7 = i2 - 2;
        i4 = 0;
        i6 = 0;
        int i8 = 0;
        while (i8 < i7) {
            a(bArr, i8 + i, 3, bArr2, i6);
            i4 += 4;
            if (i5 != 0 && i4 == 76) {
                bArr2[i6 + 4] = (byte) 10;
                i6++;
                i4 = 0;
            }
            i8 += 3;
            i6 += 4;
        }
        if (i8 < i2) {
            a(bArr, i8 + i, i2 - i8, bArr2, i6);
            i6 += 4;
        }
        try {
            return new String(bArr2, 0, i6, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bArr2, 0, i6);
        }
    }

    public static byte[] a(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            bytes = str.getBytes();
        }
        return a(bytes, 0, bytes.length);
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        int i3;
        byte[] bArr2 = new byte[((i2 * 3) / 4)];
        byte[] bArr3 = new byte[4];
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        while (i4 < i + i2) {
            byte b = (byte) (bArr[i4] & 127);
            byte b2 = bb[b];
            if (b2 >= (byte) -5) {
                if (b2 >= (byte) -1) {
                    i3 = i5 + 1;
                    bArr3[i5] = b;
                    if (i3 > 3) {
                        i3 = a(bArr3, 0, bArr2, i6) + i6;
                        if (b == (byte) 61) {
                            break;
                        }
                        i5 = i3;
                        i3 = 0;
                    } else {
                        i5 = i6;
                    }
                } else {
                    i3 = i5;
                    i5 = i6;
                }
                i4++;
                i6 = i5;
                i5 = i3;
            } else {
                System.err.println("Bad Base64 input character at " + i4 + ": " + bArr[i4] + "(decimal)");
                return null;
            }
        }
        i3 = i6;
        byte obj[] = new byte[i3];
        System.arraycopy(bArr2, 0, obj, 0, i3);
        return obj;
    }

    private static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        int i5 = (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0);
        if (i2 > 2) {
            i4 = (bArr[i + 2] << 24) >>> 24;
        }
        i4 |= i5;
        switch (i2) {
            case 1:
                bArr2[i3] = a[i4 >>> 18];
                bArr2[i3 + 1] = a[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = (byte) 61;
                bArr2[i3 + 3] = (byte) 61;
                break;
            case 2:
                bArr2[i3] = a[i4 >>> 18];
                bArr2[i3 + 1] = a[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = a[(i4 >>> 6) & 63];
                bArr2[i3 + 3] = (byte) 61;
                break;
            case 3:
                bArr2[i3] = a[i4 >>> 18];
                bArr2[i3 + 1] = a[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = a[(i4 >>> 6) & 63];
                bArr2[i3 + 3] = a[i4 & 63];
                break;
        }
        return bArr2;
    }
}
