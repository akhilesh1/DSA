/*

***Used in Single source shortest path SSSP***
Where need to find the distance from single source to all nodes.



Problem Description
Given a directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:

There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A

Solution Approach
Create the adjancy list

take a queue and a visited array
perform breadh first search on this using the graph
 */
package Graph;

import java.util.*;

public class PathExistsDirected {
    public int solve(int A, int[][] B)
    {
        ArrayList<HashSet<Integer>> g=new ArrayList<HashSet<Integer>>();
        // //prepare empty graph
        for(int i=0;i<=A;i++)
        {
            g.add(new HashSet<Integer>());
        }
        //Create adjacant list
        int edges=B.length;
        for(int i=0;i<edges;i++)
        {
            g.get(B[i][0]).add(B[i][1]);
            //g.get(B[i][1]).add(B[i][0]);// this is directed not undirected graph
        }
        //Queue and visted array
        Queue<Integer> q=new LinkedList<>();;
        int[] visited=new int[A+1];
        q.add(1);
        visited[1]=1;
        int i=0;
        while(!q.isEmpty())
        {
            int leftMost=q.remove();
            HashSet<Integer> hs=g.get(leftMost);
            //System.out.println("leftMost "+leftMost+" : Size"+hs.size());
            Iterator itr = hs.iterator();
            while(itr.hasNext())
            {
                int cur=(int)itr.next();
                //System.out.println("\t content "+cur);
                if(cur==A)
                    return 1;
                if(visited[cur]!=1)
                {
                    q.add(cur);
                    visited[cur]=1;
                }
            }
        }
        return 0;//return visited[A]
    }
}
