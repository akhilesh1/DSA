package Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JavaLock {
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter(0);
        Lock lck=new ReentrantLock();

        Thread t1=new Thread(new AdderRunnable(counter,lck));
        Thread t2=new Thread(new SubstracterRunnable(counter,lck));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getVal());
    }
}
