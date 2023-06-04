#To count no of island 
#we need to count the disconnected parts in graphs
#To do this we consider all nodes as not visited
#normally we can count disconnected parts by doing counting no. of times we need to run DFS unitll are nodes are visited.
import sys
sys.setrecursionlimit(10**6)
class Solution:
    # @param A : list of list of integers
    # @return an integer
    def solve(self, A):
        self.N=len(A)
        self.M=len(A[0])
        #visited=new int[N][M]
        visited = [[0 for i in range(self.M)] for j in range(self.N)]
        #print("Visited length",len(visited))
        #print("Visited length M",len(visited[0]))
        ans=0
        for i in range(self.N):
            for j in range(self.M):
                if(A[i][j]==1 and visited[i][j]==0):
                    self.DFS(A,visited,i,j)
                    ans+=1
        return ans

    def DFS(self,A,visited,i,j):
        #print("IJ: ",i,j)
        if(i<0 or j<0 or i>=self.N or j>=self.M or A[i][j]==0):#avoid boundry variables and water location
            return

        if(visited[i][j]==1):
            return

        visited[i][j]=1
        directions=[[0,1],[-1,0],[0,-1],[1,0],[1,1],[1,-1],[-1,1],[-1,-1]]
        for di in directions:
                self.DFS(A,visited,i+di[0],j+di[1])
