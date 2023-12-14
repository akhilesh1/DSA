class Solution {
    public String reverseWords(String s) {
        
        //StringBuilder source=new StringBuilder(s.trim());
        s=s.trim();
        int N=s.length();
        String reversedString=reverseString(s,0,N-1);
        int startIndex=0;
        int endIndex=-1;    
        int i=0;
        StringBuilder ans=new StringBuilder();
        while(i<N)
        {
            if(reversedString.charAt(i)!=' ' && startIndex==-1)
                startIndex=i;
            if(reversedString.charAt(i)==' ')//word ends  || elpmaxe   doog a
            {
                if(startIndex>-1)
                {
                    ans.append(reverseString(reversedString,startIndex,i-1));
                    ans.append(" ");
                    startIndex=-1;
                }
            }
            else if(i==N-1)
            {
                ans.append(reverseString(reversedString,startIndex,i));
            }
            i++;
        }
        return ans.toString();
    }
    
    public String reverseString(String sb,int start,int end)
    {
        int s=start,e=end;
        StringBuilder sbr=new StringBuilder(sb);
        int N=sb.length();
        while(start<end)
        {
            char startChar=sbr.charAt(start);
            char endChar=sbr.charAt(end);
            sbr.setCharAt(start,endChar);
            sbr.setCharAt(end,startChar);
            start++;
            end--;
        }
        return sbr.substring(s,e+1);
    }
}
