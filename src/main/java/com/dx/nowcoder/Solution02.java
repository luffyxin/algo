package com.dx.nowcoder;

public class Solution02 {
    public static void main(String[] args) {
        System.out.println(solution(11));
    }


    public static int solution(int n) {
        int sum = 0;
        int i = 1;
        while (true) {
            sum +=i;
            if(sum > n){
                break;
            }
            i++;
        }
        int cha = sum -n;
        sum =0;

        for(int k=1;k<=i;k++){
            sum +=Math.pow(k,2);
        }

        return sum - cha *i;
    }
}
