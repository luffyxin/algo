package com.dx;

public class main03 {


    public static void main(String[] args) {

        int num=-4566;
        test(num);

    }

    public static  void test(int num){
        if(num<0){
            System.out.print("-");
            num = num * -1;
        }

        while (num > 1){
            System.out.print(num%10);
            num /=10;
        }

    }
}
