package com.sheyla.springmvc.controller.demo;

import java.util.concurrent.ConcurrentHashMap;

public class BitTest {
    static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash

    public static void main(String[] args) {
        System.out.println(spread(3333355));
    }

    private static int spread(int h) {
        System.out.println(h);

        binaryStr(h);
        binaryStr(h >>> 16);
        System.out.println("=================");
        binaryStr((h ^ (h >>> 16)));
        binaryStr(HASH_BITS);
        binaryStr((h ^ (h >>> 16)) & HASH_BITS);
        System.out.println("=================");

        binaryStr(1 << 30);
        return (h ^ (h >>> 16)) & HASH_BITS;

    }

    private static void binaryStr(int h) {
        String binaryStr = java.lang.Integer.toBinaryString(h);
        System.out.println("the result is : " + binaryStr);
    }


}
