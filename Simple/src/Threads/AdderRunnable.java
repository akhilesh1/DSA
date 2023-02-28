package Threads;

import java.util.concurrent.locks.Lock;

public class AdderRunnable implements Runnable{

    Counter _cnt;
    Lock _lck;
    AdderRunnable(Counter cnt, Lock lock)
    {
        this._cnt = cnt;
        this._lck=lock;
    }

    @Override
    public void run() {
//        _lck.lock(); // lock will protect every thing inside lock
        //syncronized will only protect that variable on object level
        // so used when only single syncronized object
        //every class in java works on object leval
        //and object have inbuilt locking mechanism

        //synchronized (_cnt) {
            for (int i = 0; i < 10000; i++) {
                _cnt.addVal(i);
            }
        //}
//        _lck.unlock();
    }
}
