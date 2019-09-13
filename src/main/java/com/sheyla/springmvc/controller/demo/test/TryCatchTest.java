package com.sheyla.springmvc.controller.demo.test;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/8/11 15:00
 * @Modified By：
 * @Description:
 */
public class TryCatchTest {
    public static void main(String[] args) {
        //System.out.println(retrunVal());

        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b);

        Integer c = Integer.valueOf(1);
        Integer d = Integer.valueOf(1);
        System.out.println(c == d);

        Integer e = 1;
        Integer f = 1;
        System.out.println(e == f);

    }

    private static int retrunVal() {
        int a = 1;
        try {
            a = 2;
            return 8;
        } catch (Exception e) {
            a = 3;
            return a;
        } finally {
            a = 4;
            return a;
        }
    }
}
