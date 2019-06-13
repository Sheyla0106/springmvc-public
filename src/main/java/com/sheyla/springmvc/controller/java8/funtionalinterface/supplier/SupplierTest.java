package com.sheyla.springmvc.controller.java8.funtionalinterface.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/14 0:47
 * @Modified By：
 * Supplier接口产生一个给定类型的结果。Supplier没有输入参数。
 * <p>
 * Supplier<Person> personSupplier = Person::new;
 * <p>
 * personSupplier.get();  // new Person
 * 作用：我们可以把耗资源运算放到get方法里，在程序里，我们传递的是Supplier对象，直到调用get方法时，运算才会执行。这就是所谓的惰性求值。
 */
public class SupplierTest {
    public static void main(String[] args) {
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        cars.forEach(Car::collide);
        cars.forEach(Car::repair);

        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);

        //得到一个返回值Car
        Supplier<Car> carSupplier = Car::new;
        System.out.println(carSupplier.get());   // new Person
    }
}
