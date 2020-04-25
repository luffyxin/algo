package com.dx;

public class main03 {


    public static void main(String[] args) {
        int i = 0;
        i = i++ + i;
        System.out.println("I =" +i);

    }

    public static void test(int num) {
        if (num < 0) {
            System.out.print("-");
            num = num * -1;
        }

        while (num > 1) {
            int temp = num % 10;
            if (temp != 0) {
                System.out.print(temp);
            }
            num /= 10;
        }

    }
}
