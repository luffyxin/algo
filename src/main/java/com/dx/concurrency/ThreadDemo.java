package com.dx.concurrency;

import lombok.Data;

@Data
class Punishment {
    private int leftCopyCount;
    private String wordToCopy;
}
//1、继承Thread类
class Student implements Runnable{
    private String name;
    private Punishment punishment;

    public Student(String name, Punishment punishment) {
        //2、调用Thread构造方法，设置threadName
        this.name=name;
        this.punishment = punishment;
    }

    public void copyWord() {
        int count = 0;
        String threadName = Thread.currentThread().getName();
        while (true) {
            if (punishment.getLeftCopyCount() > 0) {
                int leftCopyCount = punishment.getLeftCopyCount();
                System.out.println(threadName+"线程-"+name + "抄写" + punishment.getWordToCopy() + "。还要抄写" + --leftCopyCount + "次");
                punishment.setLeftCopyCount(leftCopyCount);
                count++;
            } else {
                break;
            }
        }
        System.out.println(threadName+"线程-"+name + "一共抄写了" + count + "次！");
    }
    //3、重写run方法，调用copyWord完成任务
    @Override
    public void run(){
        copyWord();
    }
}


public class ThreadDemo {

    public static void main(String[] args) {
        Punishment p = new Punishment();
        p.setLeftCopyCount(100);
        p.setWordToCopy("好好学习天天向上");
        Student s = new Student("张三",p);
        Thread thread = new Thread(s);
        thread.start();

    }
}
