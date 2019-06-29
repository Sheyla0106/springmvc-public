package com.sheyla.springmvc.controller.java8.repeatingannotations;

import com.sheyla.springmvc.controller.java8.repeatingannotations.bean.Book;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/29 16:07
 * @Modified By：
 */
public class AnnotatioonTest {
    public static void main(String[] args) {
        Book book = new Book();
        String sql = assembleSqlFromObj(book);
        System.out.println(sql);
    }

    private static String assembleSqlFromObj(Object obj) {
        //Category category = obj.getClass().getAnnotation(Category.class);
        StringBuffer sb = new StringBuffer();
        Field[] fileds = obj.getClass().getDeclaredFields();
        for (Field f : fileds) {
            String fieldName = f.getName();
            sb.append(fieldName);
            try {
                //使用getAnnotationsByType把注解所有的值拿到
                Category[] category1 = f.getAnnotationsByType(Category.class);
                for (int i = 0; i < category1.length; i++) {
                    sb.append(category1[i].role());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
