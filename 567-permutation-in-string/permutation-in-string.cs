public class Solution {
    public bool CheckInclusion(string s1, string s2) {
        //create freq map from s1=> which
        //create fn which will check if complete map is zero
        //iterate the window and check for match if true return true
        //    else  on every i remove from freq map , add new char in map
        int N=s1.Length;
        int M=s2.Length;
        if (N > M) return false;
        int[] freq=new int[26];
        for(int i=0;i<N;i++)
        {
            freq[s1[i]-'a']++;
            freq[s2[i]-'a']--;
        }
        
        
        if (checkIfZero(freq)) return true;
        for(int i=N;i<M;i++)
        {
            freq[s2[i]-'a']--;
            freq[s2[i-N]-'a']++;
            if(checkIfZero(freq)) return true;
            
        }
        return false;
    }
    bool checkIfZero(int[] freq)
    {
        int N=freq.Length;
        for(int i=0;i<N;i++)
        {
            if(freq[i]!=0) return false;
        }
        return true;
    }
}