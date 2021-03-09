package featuretask;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.*;

public class FeatureTaskTest {

    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 1;
                System.out.println(Thread.currentThread().getName() + Thread.currentThread().getState());

                for (long i = 1; i < 1000000000L; i++) {
                    sum++;
                }
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println(Thread.currentThread().getState());
                return 1;
            }
        });
        ExecutorService executor = Executors.newFixedThreadPool(6,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setDaemon(true);
                        thread.setName(thread.getName() + thread.getId());
                        return thread;
                    }
                });
        executor.submit(futureTask);
        executor.shutdown();
        try {
            System.out.println(futureTask.get(10000, TimeUnit.MILLISECONDS));
            System.out.println(executor.toString());
        } catch (Exception e) {
            boolean f = futureTask.cancel(true);
            System.out.println(f);
            System.out.println(e);
        }
    }

}
