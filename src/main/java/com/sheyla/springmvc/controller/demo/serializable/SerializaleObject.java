package com.sheyla.springmvc.controller.demo.serializable;

import com.sheyla.springmvc.controller.demo.serializable.bean.Car;
import com.sheyla.springmvc.controller.demo.serializable.bean.Tyre;

import java.io.*;
import java.util.Date;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/29 17:35
 * @Modified By：
 */
public class SerializaleObject {
    public static final String fileName = "car.ser";

    public static void main(String[] args) {
        //设置对象
        Car car = new Car();
        Tyre tyre = new Tyre();
        tyre.setTyreName("tyre-P");
        car.setTyre(tyre);

        car.setName("BMW");
        car.setBirthDay(new Date());

        car.setMaster("sheyla");
        //序列化对象
        FileOutputStream fos = null;
        ObjectOutput output = null;
        try {

            fos = new FileOutputStream(fileName);
            output = new ObjectOutputStream(fos);
            output.writeObject(car);
            System.out.println(car);

            System.out.println("序列化完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
