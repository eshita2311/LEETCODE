class Solution {
    public int validParentheses(String s, int i, int curr, int open , int close, int netClose, int netOpen, int lastComplete)
    {
        //System.out.println("block 0:"+curr);
        if(curr>s.length()-1)
        {
            //System.out.println("block 1:"+curr);
            return s.length()-i;
        }
        if(s.charAt(curr)==')')
        {
            //System.out.println("block 2:"+curr);
            close++;
            if(close > netOpen)
            {
                return curr-i;
            }
        }
        else if(s.charAt(curr)=='(')
        {
            //System.out.println("block 3:"+curr);
            open++;
            if(open > netClose)
            {
                return lastComplete-i+1;
            }
        }
        if(close>open)
        {
            //System.out.println("block 4:"+curr);
            return curr-i;
        }
        if(close==open)
        {
            lastComplete=curr;
        }

        //System.out.println("block 5:"+curr);
        //System.out.println("len: "+s.length());
        return validParentheses(s, i, curr+1, open, close, netClose, netOpen,lastComplete);



    }

    public int countNetClose(String s, int start, int end)
    {
        int netClose=0;
        for(int i=start; i<end; i++)
        {
            if(s.charAt(i)==')')
            {
                netClose++;
            }
        }
        return netClose;
    }

    public int countNetOpen(String s, int start, int end)
    {
        int netOpen=0;
        for(int i=start; i<end; i++)
        {
            if(s.charAt(i)=='(')
            {
                netOpen++;
            }
        }
        return netOpen;
    }

    public int longestValidParentheses(String s) {
        int max=0;
        int netClose=0;
        int netOpen=0;
        netClose=countNetClose(s,0,s.length());
        netOpen=countNetOpen(s,0,s.length());
        if(s.length()<=1)
            return 0;
        if(netOpen==0 || netClose==0)
            return 0;

        for(int i=0; i<s.length(); i++)
        {
            max= Math.max(max,validParentheses(s, i,i,0,0, netClose-countNetClose(s,0,i), netOpen-countNetOpen(s,0,i),0));
            //System.out.println("block 6 : back to loop i:");
        }
        return max;
    }
}