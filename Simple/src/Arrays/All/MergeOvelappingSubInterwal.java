package Arrays.All;

import java.util.ArrayList;
import java.util.Collections;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
public class MergeOvelappingSubInterwal {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);
        //intervals.sort(Comparator.comparing(Interval::start));
        ArrayList<Interval> ans=new ArrayList<Interval>();
        int N=intervals.size();
        int S=intervals.get(0).start;
        int E=intervals.get(0).end;
        for(int i=1;i<N;i++){
            if(intervals.get(i).start<=E)
                E=Math.max(E,intervals.get(i).end);
            else{
                ans.add(new Interval(S,E));
                S=intervals.get(i).start;
                E=intervals.get(i).end;
            }
        }
        ans.add(new Interval(S,E));
        return ans;
    }
}
//Better solution aray only
class Solution {
    public int[][] merge(int[][] intervals) {
         //sort the input on start index
        int N=intervals.length;
        List<int[]> resultList=new ArrayList<>();
        Arrays.sort(intervals,(i1,i2)->i1[0]-i2[0]);
        int lastStart=intervals[0][0];
        int lastEnd=intervals[0][1];
        for(int i=1;i<N;i++)
        {
            if(intervals[i][0]<=lastEnd)//definately an overlap start, just need to check on overlap end
            {
                lastEnd=Math.max(lastEnd,intervals[i][1]);
            }
            else
            {
                resultList.add(new int[]{lastStart,lastEnd});//add last and treat next as the first one
                lastStart=intervals[i][0];
                lastEnd=intervals[i][1];
            }
        }

        resultList.add(new int[]{lastStart,lastEnd});
        return resultList.toArray(new int[resultList.size()][]); 

    }
}
