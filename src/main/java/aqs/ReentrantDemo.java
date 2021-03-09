package aqs;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo  extends Thread{

    private ReentrantLock reentrantLock;

        public ReentrantDemo (ReentrantLock lock){
            this.reentrantLock = lock;
        }

    @Override
    public void run() {
        reentrantLock.lock();
        try {
            System.out.println(this.getName());
        }catch (Exception  e){
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        ReentrantDemo thread1 = new ReentrantDemo(lock);
        ReentrantDemo thread2 = new ReentrantDemo(lock);
        ReentrantDemo thread3 = new ReentrantDemo(lock);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
