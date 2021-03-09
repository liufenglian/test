package aqs;

public class MutextDemo {

    private static Mutex mutex = new Mutex();

    public    static void main(String[] args) {
        for(int i=0;i<100;i++){
            Thread thread =  new Thread(()->{
                mutex.lock();
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    mutex.unlock();
                }
            });
            thread.start();
        }

    }
}
