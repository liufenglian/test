package com.example.test;

import com.example.test.forkjion.ForkJionWork;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class ForkJoinWorkTest {

    @Test
    public void test() {
        //ForkJoin实现
        long l = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();//实现ForkJoin 就必须有ForkJoinPool的支持
        ForkJoinTask<Long> task = new ForkJionWork(0L, 10000000000L);//参数为起始值与结束值
        Long invoke = forkJoinPool.invoke(task);
        long l1 = System.currentTimeMillis();
        System.out.println("invoke = " + invoke + "  time: " + (l1 - l));
        //invoke = -5340232216128654848  time: 56418
        //ForkJoinWork forkJoinWork = new ForkJoinWork(0L, 10000000000L);
    }

    @Test
    public void test2() {
        //普通线程实现
        Long x = 0L;
        Long y = 10000000000L;
        long l = System.currentTimeMillis();
        for (Long i = 0L; i <= y; i++) {
            x += i;
        }
        long l1 = System.currentTimeMillis();
        System.out.println("invoke = " + x + "  time: " + (l1 - l));
        //invoke = -5340232216128654848  time: 64069
    }

    @Test
    public void test3() {
        //Java 8 并行流的实现
        long l = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(0, 10000000000L).parallel().reduce(0, Long::sum);
        //long reduce = LongStream.rangeClosed(0, 10000000000L).parallel().reduce(0, (a, b) -> a+b);
        long l1 = System.currentTimeMillis();
        System.out.println("invoke = " + reduce + "  time: " + (l1 - l));

        //invoke = -5340232216128654848  time: 2152
    }
}
