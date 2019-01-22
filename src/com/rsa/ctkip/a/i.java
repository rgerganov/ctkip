package com.rsa.ctkip.a;

import com.rsa.ctkip.b.a.a;
import com.rsa.ctkip.b.a.b;
import com.rsa.ctkip.b.a.c;
import com.rsa.ctkip.b.a.d;

class i {
    private static byte[] a(byte[] bArr, byte[] bArr2, int i) {
        return b(bArr, bArr2, 1);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, int i, String str) {
        if (str.equals(b.b)) {
            String str2 = "MAC 2 Computation";
            Object obj = new byte[(str2.length() + bArr.length)];
            System.arraycopy(str2.getBytes(), 0, obj, 0, str2.length());
            System.arraycopy(bArr, 0, obj, str2.length() + 0, bArr.length);
            return a(bArr2, obj, i);
        }
        throw new RuntimeException("unhandled PRF");
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, String str) {
        if (str.indexOf("ct-kip-prf-aes") != -1) {
            String str2 = "Key generation";
            Object obj = new byte[((bArr3.length + str2.length()) + bArr2.length)];
            System.arraycopy(bArr3, 0, obj, 0, bArr3.length);
            Object bytes = str2.getBytes();
            System.arraycopy(bytes, 0, obj, bArr3.length, bytes.length);
            System.arraycopy(bArr2, 0, obj, str2.length() + bArr3.length, bArr2.length);
            return a(bArr, obj, i);
        }
        throw new RuntimeException("unhandled PRF");
    }

    private static byte[] b(byte[] bArr, byte[] bArr2, int i) {
        d cVar = new c();
        cVar.a(bArr, 128, 1);
        a aVar = new a(cVar);
        aVar.a();
        byte[] bArr3 = new byte[(bArr2.length + 4)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        bArr3[bArr3.length - 1] = (byte) i;
        int i2 = i / 256;
        bArr3[bArr3.length - 2] = (byte) i2;
        i2 /= 256;
        bArr3[bArr3.length - 3] = (byte) i2;
        bArr3[bArr3.length - 4] = (byte) (i2 / 256);
        aVar.a(bArr3, bArr3.length);
        bArr3 = new byte[16];
        return aVar.c();
    }

    public static byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, String str) {
        if (str.equals(b.b)) {
            byte[] bArr4;
            String str2 = "MAC 1 Computation";
            if (bArr != null) {
                bArr4 = new byte[((bArr.length + str2.length()) + bArr2.length)];
                System.arraycopy(str2.getBytes(), 0, bArr4, 0, str2.length());
                int length = str2.length() + 0;
                System.arraycopy(bArr, 0, bArr4, length, bArr.length);
                System.arraycopy(bArr2, 0, bArr4, length + bArr.length, bArr2.length);
            } else {
                bArr4 = new byte[(str2.length() + bArr2.length)];
                System.arraycopy(str2, 0, bArr4, 0, str2.length());
                System.arraycopy(bArr2, 0, bArr4, str2.length() + 0, bArr2.length);
            }
            return a(bArr3, bArr4, i);
        }
        throw new RuntimeException("unhandled PRF");
    }
}
