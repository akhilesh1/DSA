package Threads;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Thread_PrintNumber_Sequence {
    //get directily from ram not from local cache value
    //volatile int n=10;
    //print 1 to 100 shared by many threads
    //sequence should be maintained
    //no two thread should print consecutive lines
    //co opeartive concurrency
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        final int maxLimit = 100;
        HashSet<String> set=new HashSet<String>();

        set.add(null);

        set.add("One");

        for(String s: set)

            System.out.println(s);

        HashMap<String, Integer> stocks = new LinkedHashMap<>(16, 0.75f, true);

        Runnable rb = new Runnable() {
            @Override
            public void run() {
                int nextValue = 0;
                synchronized (atomicInteger){// this ensures only number sequence not consecutive pickup of thread
                    while (true) {
                        nextValue = atomicInteger.getAndIncrement();
                        if (nextValue > maxLimit)
                            break;
                        System.out.println(Thread.currentThread().getName() + "@" + nextValue);
                        atomicInteger.notify();// this is next wait line force to another thread to run not current cne*/
                        try {
                            atomicInteger.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }

            }
        };

        Thread t1 = new Thread(rb);
        Thread t2 = new Thread(rb);
        Thread t3 = new Thread(rb);
        t1.start();
        t2.start();
        t3.start();
    }
    //eager concurrency
    public static void duplicateFixedmain(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        final int maxLimit = 100;
        Runnable rb = new Runnable() {
            @Override
            public void run() {
                int nextValue = 0;
                while (true) {
                    nextValue = atomicInteger.getAndIncrement();
                    if (nextValue > maxLimit)
                        break;
                    System.out.println(Thread.currentThread().getName() + "@" + nextValue);
                }
            }
        };

        Thread t1 = new Thread(rb);
        Thread t2 = new Thread(rb);
        Thread t3 = new Thread(rb);
        t1.start();
        t2.start();
        t3.start();
    }

    //two thread will pick same value at the same time ,actual lines will be greater than max limit
    public static void mainRaceCond(String[] args) {
        final int[] cur = {1};
        //int cur=0;
        int MaxLimit = 100;
        Runnable rb = new Runnable() {
            @Override
            public void run() {
                while (cur[0] <= MaxLimit) {
                    System.out.println(cur[0] + " running on Thread " + Thread.currentThread().getName());
                    cur[0]++;
                }
            }
        };

        Thread t1 = new Thread(rb);
        Thread t2 = new Thread(rb);
        Thread t3 = new Thread(rb);
        t1.start();
        t2.start();
        t3.start();
    }

    public static void Plain3main(String[] args) {
        int n=100;

        Runnable rb=()->{
            for (int i = 0; i < n; i++) {
                System.out.println(i+" running on Thread "+Thread.currentThread().getName());
            }
        };

        Thread t1=new Thread(rb);
        Thread t2=new Thread(rb);
        Thread t3=new Thread(rb);
        t1.start();
        t2.start();
        t3.start();
    }

}
