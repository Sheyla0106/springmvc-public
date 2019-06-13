package com.sheyla.springmvc.bean.interfacetest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test<A,B> implements MyInterfaceC<A,B>,MyInterfaceA,MyInterfaceB{

    private A a;

    private B b;

    //MyInterfaceC

    public A getA() {

        return a;

    }

    public B getB() {

        return b;

    }

    //MyInterfaceA

    public void sayHello() {

    }

    //MyInterfaceB

    public String print() {

        return "";

    }



    public static void main(String args[]) throws Exception{

        Type[] ts = Test.class.getGenericInterfaces();



        System.out.println("======getGenericInterfaces======:");

        for (Type t:ts) {

            System.out.println(t);



            if (ParameterizedType.class.isAssignableFrom(t.getClass())) {

                System.out.print("----------->getActualTypeArguments:");

                for (Type t1:((ParameterizedType)t).getActualTypeArguments()) {

                    System.out.print(t1 + ",");

                }

                System.out.println();

            }

        }



        System.out.println();

        System.out.println("======getInterfaces======:");

        for (Class c:Test.class.getInterfaces()) {

            System.out.println(c.getName());

        }

    }

}
