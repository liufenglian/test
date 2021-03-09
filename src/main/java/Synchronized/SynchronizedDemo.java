package Synchronized;

public class SynchronizedDemo {

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class){

        }
        method();
    }
    public static void method(){
        System.out.println("-------");
    }
}
