package com.sheyla.springmvc.controller.demo.control;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/10/15 21:38
 * @Modified By：控制流程
 * @Description:
 */
public class ControlTest {
    public static void main(String[] args) {
        turnMark();
        returnflag();
    }

    /**
     * 外部加标记，跳出循环加校验
     */
    private static void returnflag() {
        boolean flag = true;
        for (int i = 0; i < 100 && flag; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.println("J:" + j);
                if (j == 10) {
                    // 跳出多重循环
                    flag = false;
                    break;
                }
            }
        }
    }

    /**
     * 回到标识位
     */
    private static void turnMark() {
        myfor:
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.println("J:" + j);
                if (j == 10) {
                    // 跳出多重循环
                    break myfor;
                }
            }
        }
    }
}
