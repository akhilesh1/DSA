
/*

Problem Description
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Problem Constraints
0 <= |intervals| <= 105



Input Format
First argument is the vector of intervals

second argument is the new interval to be merged



Output Format
Return the vector of intervals after merging


Solution approach
Need to solve this in three steps
A)If overlap happended
    1)Before overlap
    2)Overlapped interval
    3)After overlap
B)If no overlap
   1)Keep printing ranges and print new pair also where its suits
*
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
package Arrays.All;

public class InsertNewInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans=new ArrayList<Interval>();
        int N=intervals.size();
        //indexes of intervals
        int overlapS=-1,overlapE=-1;
        //1)check if new interval is overlapping with existing interval
        for(int i=0;i<N;i++){
            Interval cur=intervals.get(i);
            //if they are not distance apart they must to overlapping
            //----      -------     ---       ------
            //  -----     ---     --------   -----
            // consider above 4 cases of overlap
            if((newInterval.start<=cur.end && newInterval.end>=cur.start))
            {
                if(overlapS==-1)
                    overlapS=i;
                overlapE=i;
            }
        }

        if(overlapS>-1)//there is a overlap
        {
            //print elements before overlap point
            for(int i=0;i<overlapS;i++){
                ans.add(intervals.get(i));
            }
            //print overlap range
            int start=Math.min(intervals.get(overlapS).start,newInterval.start);
            int end=Math.max(intervals.get(overlapE).end,newInterval.end);
            ans.add(new Interval(start,end));
            //print elements after overlap point
            for(int i=overlapE+1;i<N;i++){
                ans.add(intervals.get(i));
            }
        }
        else         //if no overlap found
        {
            boolean done=false;
            for(int i=0;i<N;i++){
                if(intervals.get(i).start>newInterval.end && !done){
                    ans.add(newInterval);
                    done=true;
                }
                ans.add(intervals.get(i));
            }
            if(!done)
                ans.add(newInterval);
        }
        return ans;


    }
}
