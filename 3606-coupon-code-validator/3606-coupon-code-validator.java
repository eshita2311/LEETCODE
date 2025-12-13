class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<List<String>> lls=new ArrayList<>();
        for(int i=0;i<isActive.length;i++){
            if(isActive[i] && check(code[i]) && Arrays.asList("electronics","grocery","pharmacy","restaurant").contains(businessLine[i])){
                List<String> t=new ArrayList<>();
                t.add(code[i]);
                t.add(businessLine[i]);
                lls.add(t);
            }
        }
        Collections.sort(lls,(p,q)->p.get(1).equals(q.get(1))?p.get(0).compareTo(q.get(0)):p.get(1).compareTo(q.get(1)));
        List<String> ans=new ArrayList<>();
        for(int i=0;i<lls.size();i++){
            ans.add(lls.get(i).get(0));
        }
        return ans;
    }
    public boolean check(String s){
        if(s.length()==0)
            return false;
        for(char ch:s.toCharArray()){
            if((ch<'a'||ch>'z') && (ch<'A' || ch>'Z') && (ch<'0' || ch>'9') && (ch!='_')){
                return false;
            }
        }
        return true;
    }
}