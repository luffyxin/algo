package com.dx.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintDemo{

    private int num = 0;
    private Lock lock =new ReentrantLock();
    private Condition a = lock.newCondition();
    private Condition b = lock.newCondition();
    private Condition c = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
            while ( num !=0){
                a.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            num =1;
            b.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10(){
        lock.lock();
        try {
            while ( num !=1){
                b.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            num =2;
            c.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            while ( num !=2){
                c.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            num =0;
            a.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }




}


/**
 * @author dx
 */
public class ThreadOrderPrint {

    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {

                printDemo.print5();
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {

                printDemo.print10();
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {

                printDemo.print15();
            }
        },"CC").start();



    }


}
