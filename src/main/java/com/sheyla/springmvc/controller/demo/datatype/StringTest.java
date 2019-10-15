package com.sheyla.springmvc.controller.demo.datatype;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/10/15 22:23
 * @Modified By：String 的了理解
 * @Description: 转换符    说明
 * %s	字符串类型
 * %d	整数类型（十进制）
 * %c	字符类型
 * %b	布尔类型
 * %x	整数类型（十六进制）
 * %o	整数类型（八进制）
 * %f	浮点类型
 * %a	浮点类型（十六进制）
 * %e	指数类型
 * %%	百分比类型
 * %n	换行符
 * <p>
 * <p>
 * 字符串相关类型主要有这三种：String、StringBuffer、StringBuilder，
 * 其中 StringBuffer、StringBuilder 都是可以变的字符串类型，
 * StringBuffer 在字符串拼接时使用 synchronized 来保障线程安全，因此在多线程字符串拼接中推荐使用 StringBuffer
 * <p>
 * <p>
 * <p>
 * String 为不可变类型，在方法内对 String 修改的时候，相当修改传递过来的是一个 String 副本，
 * 所以 String 本身的值是不会被修改的，
 * 而 StringBuffer 为可变类型，参数传递过来的是对象的引用，对其修改它本身就会发生改变
 * <p>
 * <p>
 * 什么是字符串常量池？
 * 字符串常量池是存储在 Java 堆内存中的字符串池，
 * 是为防止每次新建字符串带的时间和空间消耗的一种解决方案。
 * 在创建字符串时 JVM 会首先检查字符串常量池，
 * 如果字符串已经存在池中，就返回池中的实例引用，
 * 如果字符串不在池中，就会实例化一个字符串放到池中并把当前引用指向该字符串。
 * <p>
 * <p>
 * String 不可变性都有哪些好处？
 * 答：不可变的好处如下。
 * <p>
 * 1、只有当字符串是不可变的，字符串常量池才能实现，字符串池的实现可以在运行时节约很多堆空间，
 * 因为不同的字符串变量都指向池中的同一个字符串；
 * <p>
 * 2、可以避免一些安全漏洞，比如在 Socket 编程中，主机名和端口都是以字符串的形式传入，
 * 因为字符串是不可变的，所以它的值是不可改变的，否则黑客们可以钻到空子，改变字符串指向的对象的值，造成安全漏洞；
 * <p>
 * 3、多线程安全，因为字符串是不可变的，所以同一个字符串实例可以被多个线程共享，
 * 保证了多线程的安全性；
 * <p>
 * 4、适合做缓存的 key，因为字符串是不可变的，所以在它创建的时候哈希值就被缓存了，
 * 不需要重新计算速度更快，所以字符串很适合作缓存的中的 key。
 */
public class StringTest {
    public static void main(String[] args) {
        String aa = "123";
        String bb = "123";
        System.out.println(aa == bb);
        String cc = new String("123");
        String dd = new String("123");
        System.out.println(cc == dd);

        System.out.println(aa == dd);

        //强制使用缓存池中拿，如果不存在，则在缓存池中增加一个，再从缓存池中拿
        String ee = new String("123").intern();
        System.out.println(aa == ee);


        Boolean aaa = new Boolean(true);
        Boolean bbb = new Boolean("true");
        System.out.println(aaa == bbb);

        System.out.println("===============但 JVM 也会对 String 进行特殊处理，以此来提供程序的运行效率============================");
        String str = "hi," + "lao" + "wang";
        String str2 = "hi,laowang";
        //返回为true
        System.out.println(str == str2);

        System.out.println("===============字符串格式化============================");

        String strformat = String.format("我叫%s，今年%d岁，喜欢%s", "老王", 30, "读书");
        System.out.println(strformat);

        StringBuffer sf = new StringBuffer("lao");
        // 添加字符串到尾部 append方法增加了synchronized
        sf.append("wang"); // 执行结果：laowang
        // 插入字符串到到当前字符串下标的位置 insert方法增加了synchronized
        sf.insert(0, "hi,"); // 执行结果：hi,laowang
        // 修改字符中某个下标的值 setCharAt 增加了synchronized
        sf.setCharAt(0, 'H'); // 执行结果：Hi,laowang

        //substring返回值为new String()的值，不会影响原来的值
        String str6 = "laowang";
        str.substring(0, 1);
        System.out.println(str6);
    }
}
