package com.example.test.forkjion;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJionWork extends RecursiveTask<Long> {

  private Long start;
  private Long end;

  public static final Long critical=10L;


    public ForkJionWork(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        //判断是否拆分完
        Long lenth = end-start;
        if(lenth<=critical){
            //如果拆分完就相加
            Long sum = 0L;
            for(Long i=start;i<end;i++ ){
                sum += i;
            }
            return sum;
        }else {
            //没有拆分完毕就开始拆分
            Long middle = (end + start) / 2;//计算的两个值的中间值
            ForkJionWork right = new ForkJionWork(start, middle);
            right.fork();//拆分，并压入线程队列
            ForkJionWork left = new ForkJionWork(middle + 1, end);
            left.fork();//拆分，并压入线程队列
            //合并
            return right.join() + left.join();
        }
    }

    public static void main(String[] args) {

        System.out.println();
    }

}
