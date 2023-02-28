package Threads;

import java.util.concurrent.locks.Lock;

public class SubstracterRunnable implements Runnable{

    Counter _cnt;
    Lock _lck;
    SubstracterRunnable(Counter cnt, Lock lock)
    {
        this._cnt = cnt;
        this._lck=lock;
    }

    @Override
    public void run() {
        //synchronized (_cnt) {
            for (int i = 0; i < 10000; i++) {
                _cnt.addVal(-i);
            }
        //}
    }
}
