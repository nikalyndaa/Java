package org.example.task6;

public class Array implements IMath, ISort{

    private int[] arr;

    public Array(int[] arr){
        this.arr = arr;
    }
    @Override
    public int Max() {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    @Override
    public int Min() {
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    @Override
    public float Avg() {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum +=arr[i];
        }
        return (float)sum / arr.length;
    }

    public void showArray() {
        System.out.print("Array: ");

        for (int number : arr) {
            System.out.print(number + " ");
        }

        System.out.println();
    }


    @Override
    public void SortAsc() {
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                boolean needSwap = false;

                if(arr[j] > arr[j+1]){
                    needSwap = true;
                }

                if(needSwap){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    @Override
    public void SortDesc() {
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                boolean needSwap = false;

                if(arr[j] < arr[j+1]){
                    needSwap = true;
                }

                if(needSwap){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
