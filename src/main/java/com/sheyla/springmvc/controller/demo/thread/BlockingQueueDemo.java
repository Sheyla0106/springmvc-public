package com.sheyla.springmvc.controller.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/2 13:39
 * @Modified By：
 *
 * ArrayBlockingQueue:数组结构组成的有界阻塞队列
 * LinkedBlockingQueue：由链表结构组成的有界（但默认Integer.MAX_VALUE）阻塞队列
 * SynchronousQueue（同步队列，专属队列）：不存储元素的阻塞队列，也即单个元素的队列
 *
 *
 * BlockingDeque-双端队列
 *
 * 1、队列
 *
 * 2、阻塞队列
 *   2.1 阻塞队列优点
 *
 *   2.2 不得不阻塞，如何管理
 *          生活实例：
 *           海底捞，满员等候区
 *           银行排队
 *
 *   定义：一个队列，FIFO
 *   当阻塞队列为空时，从队列中【获取】元素的操作会被阻塞--蛋糕店没有，不能卖
 *   当租的队列为满时，往队列中【添加】元素的操作会被阻塞--蛋糕一个没有卖出去，不用生产
 *
 *   多线程中，所谓阻塞，在某些情况下挂起线程，一旦条件满足，被挂起的线程又会自动被唤醒
 *
 *   不用关心什么时候阻塞什么时候唤醒
 *
 *   BlockingQueue 具有 4 组不同的方法用于插入、移除以及对队列中的元素进行检查：
 * 	    抛出异常	  特殊值	       阻塞	    超时
 * 插入	add(e)	    offer(e)	put(e)	offer(e, time, unit)
 * 移除	remove()	poll()	    take()	poll(time, unit)
 * 检查	element()	peek()	    不可用	不可用
 *
 * add:IllegalStateException: Queue full
 * remove:java.util.NoSuchElementException
 * element:java.util.NoSuchElementException
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception{
        group04();

    }

    private static void group04() throws InterruptedException {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);

        blockingQueue.offer("a", 2, TimeUnit.SECONDS);
        blockingQueue.offer("b", 2,TimeUnit.SECONDS);
        blockingQueue.offer("c", 2,TimeUnit.SECONDS);
        blockingQueue.offer("x", 2,TimeUnit.SECONDS);

        blockingQueue.poll(2,TimeUnit.SECONDS);
        blockingQueue.poll(2,TimeUnit.SECONDS);
        blockingQueue.poll(2,TimeUnit.SECONDS);
        blockingQueue.poll(2,TimeUnit.SECONDS);
    }

    private static void group03() throws InterruptedException {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        System.out.println("=======================================");
        //blockingQueue.put("x");

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
    }

    private static void group02() {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);


        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("x"));


        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        System.out.println(blockingQueue.poll());

        System.out.println(blockingQueue.peek());
    }

    private static void group01() {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));

        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));


        System.out.println( blockingQueue.remove());
        System.out.println( blockingQueue.remove());
        System.out.println( blockingQueue.remove());
    }
}
