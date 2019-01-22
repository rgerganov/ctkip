package com.rsa.ctkip.b.a;

public final class a {
    private d a;
    private int b;
    private byte[] c;
    private byte[] d;
    private int e;
    private int f;
    private int g;

    public a(d dVar) {
        this.a = dVar;
        int a = dVar.a();
        this.b = a;
        this.e = a;
        if (this.b == 16 || this.b == 8) {
            this.f = this.b == 16 ? 135 : 27;
            this.c = new byte[this.b];
            a(this.c, (byte) 0);
            this.d = new byte[this.b];
            a(this.d, (byte) 0);
            this.g = -1;
            return;
        }
        throw new RuntimeException("Block size not supported");
    }

    private void a(byte[] bArr, byte b) {
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = b;
        }
    }

    public void a() {
        a(this.c, (byte) 0);
        this.a.a(this.c, this.c);
        int i = this.c[0] & 128;
        for (int i2 = 0; i2 < this.b - 1; i2++) {
            this.c[i2] = (byte) ((this.c[i2] << 1) | ((this.c[i2 + 1] & 255) >>> 7));
        }
        this.c[this.b - 1] = (byte) ((i != 0 ? this.f : 0) ^ (this.c[this.b - 1] << 1));
        a(this.d, (byte) 0);
        this.e = this.b;
        this.g = 0;
    }

    public void a(byte[] bArr, int i) {
        int i2 = 0;
        if (this.g != 0) {
            throw new RuntimeException("OMAC computation not initialized");
        }
        int i3 = this.b - this.e;
        int i4 = 0;
        while (i > this.e) {
            for (int i5 = 0; i5 < this.e; i5++) {
                byte[] bArr2 = this.d;
                int i6 = i3 + i5;
                bArr2[i6] = (byte) (bArr2[i6] ^ bArr[i4 + i5]);
            }
            this.a.a(this.d, this.d);
            i -= this.e;
            i4 += this.e;
            this.e = this.b;
            i3 = 0;
        }
        while (i2 < i) {
            byte[] bArr3 = this.d;
            int i7 = i3 + i2;
            bArr3[i7] = (byte) (bArr3[i7] ^ bArr[i4 + i2]);
            i2++;
        }
        this.e -= i;
    }

    public void b() {
        int i = 0;
        if (this.g != 0) {
            throw new RuntimeException("OMAC computation not initialized");
        }
        byte[] bArr;
        if (this.e > 0) {
            int i2 = this.c[0] & 128;
            for (int i3 = 0; i3 < this.b - 1; i3++) {
                this.c[i3] = (byte) ((this.c[i3] << 1) | ((this.c[i3 + 1] & 255) >>> 7));
            }
            this.c[this.b - 1] = (byte) ((i2 != 0 ? this.f : 0) ^ (this.c[this.b - 1] << 1));
            bArr = this.d;
            i2 = this.b - this.e;
            bArr[i2] = (byte) (bArr[i2] ^ 128);
            this.e = 0;
        }
        while (i < this.b) {
            bArr = this.d;
            bArr[i] = (byte) (bArr[i] ^ this.c[i]);
            i++;
        }
        this.a.a(this.d, this.d);
        this.g = 1;
    }

    public byte[] c() {
        if (this.g == 0) {
            b();
        } else if (this.g != 1) {
            throw new RuntimeException("OMAC computation not initialized");
        }
        return this.d;
    }
}
