package Recursion;

import java.util.ArrayList;

public class SubSetList {
    ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    //[1,2,3]
    //Process will be to pick item one by one
    //
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        getSubset(A,new ArrayList<Integer>(),0);
        return result;
    }

    void getSubset(ArrayList<Integer> al,ArrayList<Integer> consider,int idx)
    {
        if(idx==al.size()){
            result.add(consider);
            return;
        }
        consider.add(al.get(idx));
        getSubset(al,consider,idx+1);
        consider.remove(al.get(idx));
        getSubset(al,consider,idx+1);
    }
}
