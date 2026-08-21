package org.example;

import java.util.function.Predicate;

public class Task4 {
    public void lambdaRun(){
        int[] arr = {-1,5,9,6,3,12,-99,-4,0};
        System.out.println(sumCondition(arr, n->n==12));
        // діапазон [-5;5] , число не входить в цей діапазон
        System.out.println(sumCondition(arr, n -> n <-5 || n>5));
        System.out.println(sumCondition(arr, n -> n >0));
        System.out.println(sumCondition(arr, n -> n <0));

    }

    private int sumCondition(int[] arr, Predicate<Integer> condition){
        int sum = 0;
        for(int item: arr){
            if(condition.test(item)){
                sum += item;
            }
        }
        return sum;
    }
}
