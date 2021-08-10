package tree;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashSet;

public class SortMethod {

    public static void main(String[] args) {
        //bubble();
        //bigAdd("1900","111");

        //快排
       /* int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
        String a[]={"1","3","5","5","7","8","5","4","3","a"}, b[]={"1","2","3","4","8","66","6","5","5","10","a"};
        HashSet<String> sa=new HashSet<String>(Arrays.asList(a));
        sa.retainAll(Arrays.asList(b));
        System.out.println(sa);

    }


    //冒泡
    public static void bubble() {
        int arr[] = {8, 5, 3, 2, 4};

        //冒泡
        for (int i = 0; i < arr.length; i++) {
            //外层循环，遍历次数
            for (int j = 0; j < arr.length - i - 1; j++) {
                //内层循环，升序（如果前一个值比后一个值大，则交换）
                //内层循环一次，获取一个最大值
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(JSON.toJSON(arr));
    }

    //大数相加
    public static String bigAdd(String a, String b) {
        char[] charsA = new StringBuilder(a).reverse().toString().toCharArray();
        char[] charsB = new StringBuilder(b).reverse().toString().toCharArray();

        int maxLength = Math.max(charsA.length, charsB.length);

        int[] result = new int[maxLength + 1];

        int temp = 0;
        for (int i = 0; i <= maxLength; i++) {
            temp = result[i];

            if (i < charsA.length) {
                temp += charsA[i] - '0';
            }

            if (i < charsB.length) {
                temp += charsB[i] - '0';
            }

            if (temp >= 10) {
                temp -= 10;
                result[i + 1] = 1;
            }

            result[i] = temp;

        }

        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        for (int i = maxLength; i >= 0; i--) {
            if (result[i] == 0 && flag) {
                continue;
            }

            flag = false;
             sb.append(result[i]);
        }
        System.out.println(sb.toString());
        return sb.toString();

    }

    //快排
    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }


}
