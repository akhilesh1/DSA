/*
Problem Description
Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
*/
from collections import deque
class Solution:
    # @param A : list of list of integers
    # @return an integer
    def __init__(self):
        self.directions=[[0,1],[1,0],[0,-1],[-1,0]]
    
    def solve(self, A):
        self.N=len(A)
        self.M=len(A[0])
        # To Run BFS from multiple sources
        # First get multiple sources (cordinates of all 2)
        currentQ,rottenDays=self.getInitialData(A)
        self.BFS(A,currentQ,rottenDays)
        ans = 0
        for i in range(self.N):
            for j in range(self.M):
                if(A[i][j] == 1):
                    ans = max(ans, rottenDays[i][j])
        if(ans == 10**6):
            return -1
        return ans


    def BFS(self,A,currentQ,rottenDays):# the fire is spreading
        # for every item if its a wroten orange traverse
        #initialize the queue 
        
        while(len(currentQ)!=0):
            i,j=currentQ.popleft()
            #if(A[i][j]==2):
            #rottenDays[i][j]=0
            for d in self.directions:
                x=i+d[0]
                y=j+d[1]
                
                if(x>self.N-1 or y>self.M-1 or x<0 or y<0):
                    continue
                #print("Coordinates",x,y)
                #print("range",self.N+1,self.M+1)
                if(A[x][y]==0):#out side grid or no orange present
                    continue
                if(A[x][y]==1 and rottenDays[i][j]+1<rottenDays[x][y]):#Next element can be infected and not rot already
                    rottenDays[x][y]=rottenDays[i][j]+1
                    currentQ.append((x,y))
                



    # create queue with  i,j indexes 
     # Create RottenDays (calculated distance) matrix
    def getInitialData(self,A):
        Q=deque()
        rottenDays=[]
        for r,row in enumerate(A):
            rottenRow=[]
            for c,cell in enumerate(row):          
                rottenRow.append(10**6 if (cell==1 or cell==0) else 0)#if not present no distance other wise take very long time
                if(cell==2):
                    Q.append((r,c)) 
            rottenDays.append(rottenRow)
                    
        
        return Q,rottenDays