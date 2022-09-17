package Arrays.All;

import java.util.ArrayList;

internal class Interval {
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
