package com.sheyla.springmvc.controller.demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/10/15 23:30
 * @Modified By：
 * @Description:
 *
 *
 * 字节码重组
 *
 * 通过本文可以知道 JDK 原生动态代理是使用反射实现的，
 * 但动态代理的实现方式不止有反射，还可以是 ASM（一个短小精悍的字节码操作框架）、
 * cglib（基于 ASM）等。其中 JDK 原生的动态代理是通过接口实现的，
 * 而 cglib 是通过子类实现的，因此 cglib 不能代理最终类（final）。
 * 而反射不但可以反射调用静态方法，还可以反射调用普通方法和私有方法，
 * 其中调用私有方法时要设置 setAccessible 为 true。
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.sheyla.springmvc.controller.demo.reflect.Demo");
        Method method = aClass.getMethod("getName");
        System.out.println(aClass);
        System.out.println(method);

        //反射调用静态方法,静态方法可以直接类名.方法名
        Method methodStaticMd = aClass.getMethod("staticMd");
        methodStaticMd.invoke(aClass);

        //反射调用公共方法，需要一个实例对象
        // 创建实例对象（相当于 new ）
        Object instance = aClass.newInstance();
        Method methodPublicMd = aClass.getMethod("publicMd");
        methodPublicMd.invoke(instance);

        //反射调用私有方法 ，需要实例对象，还需要设置访问权限
        //私有方法通过getDeclaredMethod
        Method methodprivateMd = aClass.getDeclaredMethod("privateMd");
        methodprivateMd.setAccessible(true);
        methodprivateMd.invoke(instance);
        //获取属性
        //私有属性使用getDeclaredField  这个方法也能拿到共有属性
        Field field = aClass.getDeclaredField("name");
        System.out.println(field);

        Field fieldcity = aClass.getDeclaredField("city");
        System.out.println(fieldcity);

        //私有属性不能直接通过getField
        /*Field fieldname = aClass.getField("name");
        System.out.println(fieldname);*/

        //获取所有属性 1
        Field[] fields = aClass.getFields();
        System.out.println(fields.length);
        //获取所有属性 3
        Field[] fields1 = aClass.getDeclaredFields();
        System.out.println(fields1.length);

    }
}
