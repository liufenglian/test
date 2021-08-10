package ThreadPool;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int RUNNING    = -1 << COUNT_BITS;
    public static void main(String[] args) {


        System.out.println( new AtomicInteger(ctlOf(RUNNING, 0)));
    }

    private static int ctlOf(int rs, int wc) { return rs | wc; }
}
