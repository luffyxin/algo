package com.dx.sync;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Resource {
    Byte[] b = new Byte[0];
    static AtomicInteger  count = new AtomicInteger(0);

    public void pvProducer() throws InterruptedException {
        synchronized (b) {
            int i = count.incrementAndGet();
            while (i >= 1) {
                System.out.println(Thread.currentThread().getName() + "：产品已满 ");
                b.wait();
            }
            System.out.println(Thread.currentThread().getName()+"产品送往Buffer");
            b.notify();
        }
    }

    public void pvConsumer() throws InterruptedException {
        synchronized (b) {
            int i = count.decrementAndGet();
            while (i <=0 ) {
                System.out.println(Thread.currentThread().getName() + "：缺货 ");
                b.wait();
            }
            System.out.println(Thread.currentThread().getName() + "消费该产品");
            b.notify();
        }
    }


}

public class ProSum {

    public static void main(String[] args)  {
        Resource resource = new Resource();

        for (int i = 0; i < 100000; i++) {

        new Thread(()->{

            try {
                resource.pvProducer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"生产者").start();
        }

        for (int i =0;i< 100000;i++){

            new Thread(() -> {
                    try {
                        resource.pvConsumer();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }, "消费者").start();
        }



    }
}
