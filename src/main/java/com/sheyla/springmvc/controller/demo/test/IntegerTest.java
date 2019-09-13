package com.sheyla.springmvc.controller.demo.test;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/8/26 23:40
 * @Modified By：
 * @Description:
 */
public class IntegerTest {
    public static void main(String[] args) {

        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b);

        Integer c = Integer.valueOf(1);
        Integer d = Integer.valueOf(1);
        System.out.println(c == d);

        Integer e = 1;
        Integer f = 1;
        System.out.println(e == f);

       /* String aa = "123";
        String bb = "123";
        System.out.println(aa == bb);
        String cc = new String("123");
        String dd = new String("123");
        System.out.println(cc == dd);

        System.out.println(aa == dd);

        String ee = new String("123").intern();
        System.out.println(aa == ee);


        Boolean aaa = new Boolean(true);
        Boolean bbb = new Boolean("true");
        System.out.println(aaa == bbb);*/



    }
}
