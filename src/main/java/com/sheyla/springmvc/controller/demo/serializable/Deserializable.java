package com.sheyla.springmvc.controller.demo.serializable;

import com.sheyla.springmvc.controller.demo.serializable.bean.Car;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/6/29 17:52
 * @Modified By：
 * @Description: *
 * 1、transient 不参与序列化
 * 2、final修饰为值引用，在序列化的文件中
 * 3、static 不参与序列化
 */
public class Deserializable {
    public static final String fileName = "car.ser";

    public static void main(String[] args) {


        FileInputStream fis = null;
        ObjectInput input = null;
        try {

            fis = new FileInputStream(fileName);
            input = new ObjectInputStream(fis);
            Car car = (Car) input.readObject();

            System.out.println(car);
            System.out.println("反序列化完成");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
