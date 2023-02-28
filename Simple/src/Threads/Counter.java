package Threads;

public class Counter {
    private int value=0;

    // this syn key word make sure that no other thread would dare touching same method of that instance while one thead is using method below
    // eg while c1.addVal in pregress by T1 c1.addValue not allowed by T2
    // eg while c1.addVal in pregress by T1 c1.getValue is allowed by T2 // as getValue is not busy can be used

    // eg while c1.addVal in pregress by T1 c1.getValue is allowed by T2 // as getValue is not busy can be used
    // eg while c1.addVal in pregress by T1 c2.getValue is allowed by T2 // as completely seperate instance
    public synchronized void addVal(int offset)
    {
        value+=offset;
    }
    public  int getVal()
    {
        return value;
    }
    Counter(int val)
    {
        this.value=val;
    }
}
