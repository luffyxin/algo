package com.dx.sync;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    private volatile boolean FALG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void myProd() throws Exception {
        String data = null;
        while (FALG) {
            data = atomicInteger.incrementAndGet() + "";
            boolean retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");

            }
//            TimeUnit.SECONDS.sleep(1);

        }
        System.out.println(Thread.currentThread().getName() + "FLAG =false， 生产结束");
    }

    public void myConsumer() throws Exception{

        while (FALG){

            String result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(StringUtils.isEmpty(result)){
                FALG = false;
                System.out.println(Thread.currentThread().getName()+"超过两秒没消费到蛋糕，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t消费队列"+result+"成功");
//            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void stop()throws Exception{
        this.FALG = false;
    }
}

public class ProdConsumerQueue {
    public static void main(String[] args) {
        MyResource resource = new MyResource(new ArrayBlockingQueue<String>(10));
        for (int i = 0; i < 1000000; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 生产者线程启动");
                try {
                    resource.myProd();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }, "生产者").start();
        }

        for (int i = 0; i < 1000000; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 消费者线程启动");
                try {
                    resource.myConsumer();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },"消费者").start();
        }



//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("大老板喊停！");
//
//        try {
//            resource.stop();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
