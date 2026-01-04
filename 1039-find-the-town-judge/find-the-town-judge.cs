public class Solution {
    public int FindJudge(int n, int[][] trust) {
        //3->1,2// this can tell if a candidate is reachable via all other nodes
        //1->3  // how to check if any node pointing to that node??

        //use array
        int[] iTrust=new int[n+1];
        int[] theyTrust=new int[n+1];
        foreach(int[] direction in trust)
        {
            iTrust[direction[0]]++;
            theyTrust[direction[1]]++;
        }

        for(int i=1;i<n+1;i++)
        {
            if(iTrust[i]==0 && theyTrust[i]==n-1)
                return i;
        }

        return -1;
    }
}