/*
Problem Description
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.

Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.



Problem Constraints
1 <= N <= 2000
0 <= A[i], B[i] <= 109

Solution approach
21  22
11  12

consider above rectange on x-y plane

if we are given two cordinates 11 and 22 then we can predict remaining cordinate which are 21 and 12
so to generalize if we are given A[i],B[i] and A[j],B[j] as coordinates

then we can predict and look for remaining cordinate A[i],B[j] and A[j],B[i]
also few edge case
1)Two cordinates should not be equal
2)avoid counting 11 -- 22 and 22--11 twice
 */

package Hashing;

class Coordinate
{
    public int X;
    public int Y;
    Coordinate(int x,int y){
        this.X=x;
        this.Y=y;
    }
    @Override
    public boolean equals(Object x){
        Coordinate p = (Coordinate)x;
        return p.X==this.X && p.Y==this.Y;
    }
    @Override
    public int hashCode(){
        return this.X*100000+this.Y;
    }
}
public class CountRectangles {
    public int solve(int[] A, int[] B)
    {
        int ans=0;
        int N=A.length;
        HashSet<Coordinate> hs=new HashSet<Coordinate>();
        for(int i=0;i<N;i++)
        {
            hs.add(new Coordinate(A[i],B[i]));
        }

        for(int i=0;i<N;i++)
        {
            for(int j=i+1;j<N;j++)
            {
                if(A[i]!=A[j] && B[i]!=B[j]){
                    Coordinate b = new Coordinate(A[i],B[j]);
                    Coordinate d = new Coordinate(A[j],B[i]);

                    if(hs.contains(b) && hs.contains(d))
                        ans++;
                }

            }
        }
        return ans/2;
    }
}

