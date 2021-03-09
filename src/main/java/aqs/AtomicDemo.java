package aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomicDemo {


    private static Lock lock= new ReentrantLock();

    public static  int count = 0 ;

    public static void incr() {
        lock.lock();
        try {
            Thread.sleep(1);
            count++;
            decr();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void decr() {
        lock.lock();
        try {
            count--;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        for (int i = 1;i<=1000;i++){
            new Thread(()->AtomicDemo.incr()).start();
        }
        Thread.sleep(4000);
        System.out.println("rest:"+count);
    }

}
