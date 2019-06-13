package com.sheyla.springmvc.controller.demo.thread;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/1 21:21
 * @Modified By：
 * 集合类不安全问题
 * ArrayList
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
        //notSafeList();

        //Map<String, String> map = new HashMap<>();

        //Map<String, String> map= Collections.synchronizedMap(new HashMap<>());

        // 分段锁
        Map<String, String> map= new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println("map:"+map);
            }, String.valueOf(i)).start();
        }


    }

    private static void notSafeList() {
        //new ArrayList<Integer>().add(1);
        /*List<String> list= Arrays.asList("a","b","c");
        list.forEach(System.out::println);*/
        //JDK1.2
        //List<String> list=new ArrayList<>();
        // JDK1.0
        //List<String> list=new Vector<>();

        //List<String> list=Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException 并发修改异常

        /**
         * new ArrayList<>() 并发报错
         * 1、故障现象
         *     java.util.ConcurrentModificationException
         * 2、分析原因
         *    并发争抢修改导致
         *      一个人正在写，另外一个人过来抢夺，导致数据不一致。并发修改异常
         *
         * 3、解决方案
         *  3.1 new Vector()
         *  3.2 Collections.synchronizedList(new ArrayList<>())
         *  3.3 new CopyOnWriteArrayList<>() 写时复制，读写分离 空间换时间
         *     public boolean add(E e) {
         *         //写时加锁
         *         final ReentrantLock lock = this.lock;
         *         lock.lock();
         *         try {
         *             Object[] elements = getArray();
         *             int len = elements.length;
         *             //负责拷贝
         *             Object[] newElements = Arrays.copyOf(elements, len + 1);
         *             newElements[len] = e;
         *             //列表重新赋值
         *             setArray(newElements);
         *             return true;
         *         } finally {
         *             //写完释放锁
         *             lock.unlock();
         *         }
         *     }
         * 4、优化建议（同样的错误不犯第2次）
         *
         */}
}
