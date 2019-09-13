package com.sheyla.springmvc.controller.demo.file;

import java.io.*;
import java.util.*;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/9/13 13:45
 * @Modified By：
 * @Description:
 */
public class ReadText {
    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
        try {
            String str;
            fis = new FileInputStream("C:\\Users\\User\\Desktop\\1.txt");// FileInputStream
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);// InputStreamReader 是字节流通向字符流的桥梁,
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
            Map<String, Integer> stringIntegerMap = new HashMap<>();
            while ((str = br.readLine()) != null) {
                String key = subString(str, ":", "-").trim();

                if (stringIntegerMap.containsKey(key)) {
                    stringIntegerMap.put(key, stringIntegerMap.get(key) + 1);
                } else {
                    stringIntegerMap.put(key, 1);
                }

            }
            // 当读取的一行不为空时,把读到的str的值赋给str1
            //System.out.println(str1);// 打印出str1
            for (Map.Entry<String, Integer> stringIntegerEntry : stringIntegerMap.entrySet()) {
                System.out.println(stringIntegerEntry.getKey() + " \t" + stringIntegerEntry.getValue());

            }

            //排序
            System.out.println("================================排序之后======================================");
            List<Map.Entry<String, Integer>> list = new ArrayList<>(stringIntegerMap.entrySet());

            Collections.sort(list, (Map.Entry<String, Integer> o1,
                                    Map.Entry<String, Integer> o2) ->
                    o2.getValue().compareTo(o1.getValue())
            );

            for (Map.Entry<String, Integer> mapping : list) {
                System.out.println(mapping.getKey() +
                        "\t " + mapping.getValue());
            }

        } catch (
                FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (
                IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 截取字符串str中指定字符 strStart、strEnd之间的字符串
     *
     * @param str
     * @param strStart
     * @param strEnd
     * @return
     */
    public static String subString(String str, String strStart, String strEnd) {

        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex = str.indexOf(strStart);
        int strEndIndex = str.indexOf(strEnd);

        /* index 为负数 即表示该字符串中 没有该字符 */
        if (strStartIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
        }
        if (strEndIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
        }
        /* 开始截取 */
        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
        return result;
    }


}


