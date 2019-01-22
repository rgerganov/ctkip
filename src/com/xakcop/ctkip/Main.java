package com.xakcop.ctkip;

import java.util.Base64;
import com.rsa.ctkip.a.i;

public class Main {

    public static byte[] hex2bytes(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static String bytes2hex(byte[] arr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : arr) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }

    static final String modulus = "1np1DIf3HOHAK2ahcRzZCJsqIC1QMEqtsdanKSEn5CGtLCdLv9LbLUYo6cQxKSJtwvigpeDgBAb/UYcUNXy/7dY7rA5WpYlsaA9h5C9qzPMBHxVGSIe5k61uUbAwdFhCMfLh776wR//VZ7cuypo5d3cCbvgHGwqw4ZuECbKvONM=";

    public static void main(String args[]) {
        byte[] rsa_mod = Base64.getDecoder().decode(modulus);
        byte[] client_nonce = hex2bytes("846cd036914f3bf536e7354ece07b35a");
        byte[] server_nonce = hex2bytes("79956b2fd8502465ad5c5fe99b9e7786");
        String str = "http://www.rsasecurity.com/rsalabs/otps/schemas/2005/12/ct-kip#ct-kip-prf-aes";
        byte[] secret = i.a(client_nonce, server_nonce, rsa_mod, 16, str);
        byte[] mac = i.a(client_nonce, secret, 16, str);
        System.out.println("computed secret: " + bytes2hex(secret));
        System.out.println("computed MAC: " + bytes2hex(mac));
        System.out.println("expected MAC: eca98d8e5bf211fb5167dada9c262296");
    }

}
