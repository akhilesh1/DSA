/*
Problem statement
You are given an integer N.
Your task is to return a 2-D ArrayList containing the pascal’s triangle till the row N.

Solution approach
Handle corner cases separately (Boundry ones)
for in between elements just use the observation of curItem=sum of previous rows's element
 */
package ArraySimplePackage.Arrays;

import java.util.ArrayList;

public class Easy_PascalTrianglePrint {
    public static ArrayList<ArrayList<Long>> printPascal(int n) {
        // Write your code here.
        ArrayList<ArrayList<Long>> ans=new ArrayList<ArrayList<Long>>();
        for(int i=0;i<n;i++){
            ArrayList<Long> cur= new ArrayList<Long>();
            //Starting 1
            cur.add(Long.valueOf(1));
            //in between elements
            if(i>1){
                for(int j=0;j<=i-2;j++){
                    cur.add(Long.valueOf((ans.get(i-1).get(j)+ans.get(i-1).get(j+1))));
                }
            }
            //Trailing 1
            if(i>0)
                cur.add(Long.valueOf(1));
            ans.add(cur);
        }
        return ans;
    }
}
