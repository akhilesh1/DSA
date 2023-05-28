
/*
Problem Description
You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.

NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.



Problem Constraints
1 <= N <= 100000



Input Format
First argument is vector A

Second argument is integer B

Third argument is integer C



Output Format
Return 1 if reachable, 0 otherwise.



Example Input
Input 1:

 A = [1, 1, 2]
 B = 1
 C = 2
Input 2:

 A = [1, 1, 2]
 B = 2
 C = 1


Example Output
Output 1:

 0
Output 2:

 1
*/
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(ArrayList<Integer> A, final int B, final int C) {
        //First create Adjacency list by given Array
        HashMap<Integer,List<Integer>> hm=new HashMap<Integer,List<Integer>>();
        for(int i=1;i<A.size();i++)
        {
            List<Integer> lst;
            if(hm.containsKey(A.get(i)))
                lst=hm.get(A.get(i));
            else{
                lst=new ArrayList<Integer>();
            }      
            lst.add(i+1);
            hm.put(A.get(i),lst);
            //System.out.println("Key: "+A.get(i)+" Items :"+lst.size());
            
        }
        if (DFS(C,B,hm))
            return 1;

        return 0;
        //Initilze visited array -- No need since no cycles are present and we are doing DFS here not BFS
        //Create a query put source in it
        //while queue not empty
            //remove items
            //If not visited Explore neighbours
            //mark visted with appropriate distance
            //Add neighbours to queue
    }

    public boolean DFS(int src,int dest,HashMap<Integer,List<Integer>> graph)
    {
        //System.out.println("SRC: "+src+" DEST :"+dest);
        if(src==dest)
            return true;
        int out=0;
        List<Integer> childList=graph.get(src);

        if(childList!=null)
        for(int i=0;i<childList.size();i++)
        {
            if(DFS(childList.get(i),dest,graph))//can not afford to return false here if not found.
                return true;
        }
        return false;
    }
}
