package com.sheyla.springmvc.controller.demo.datatype;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/8/26 23:40
 * @Modified By：
 * @Description: 各包装类高频区域的取值范围：
 * <p>
 * Boolean：使用静态 final 定义，就会返回静态值
 * Byte：缓存区 -128~127
 * Short：缓存区 -128~127
 * Character：缓存区 0~127
 * Long：缓存区 -128~127
 * Integer：缓存区 -128~127
 * <p>
 * Integer 是唯一一个可以修改缓存范围的包装类，在 VM optons 加入参数：
 * -XX:AutoBoxCacheMax=666 即修改缓存最大值为 666 。
 */
public class IntegerTest {
    public static void main(String[] args) {

        Integer a = new Integer(1);
        Integer b = new Integer(1);
        System.out.println(a == b);
        /**
         * valueOf 使用了高頻緩存
         */
        Integer c = Integer.valueOf(1);
        Integer d = Integer.valueOf(1);
        System.out.println(c == d);

        /**
         *自动装箱调用valueOf方法
         */
        Integer e = 1;
        Integer f = 1;
        System.out.println(e == f);

        /**
         * 自动拆箱调用intValue方法
         */
        int i1 = new Integer(1);
        int i2 = new Integer(1);
        System.out.println(i1 == i2);


        float f1 = new Integer(1);
        float f2 = new Integer(1);
        System.out.println(f1 == f2);

        System.out.println("===============int和Integer比较 自动拆箱 数值的比较============================");
        int i = 100;
        Integer j = new Integer(100);
        System.out.println(i == j);
        System.out.println(j.equals(i));

        System.out.println("===============Short 类型 -1 之后转换成了 Int 类型，remove() 的时候在集合中找不到 Int 类型的数据，所以就没有删除任何元素============================");

        Set<Short> set = new HashSet<>();
        for (short ii = 0; ii < 5; ii++) {
            set.add(ii);
            set.remove(ii - 1);
        }

        System.out.println(set.size());
        System.out.println(3 * 0.1);
        //float ff1=3.4;
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
