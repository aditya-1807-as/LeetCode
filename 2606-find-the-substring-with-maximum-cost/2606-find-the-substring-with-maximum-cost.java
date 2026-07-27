class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] cost=new int[26];

        for(int i=0;i<26;i++){
            cost[i]=i+1;
        }

        for(int i=0;i<chars.length();i++){
            cost[chars.charAt(i)-'a']=vals[i];
        }
        int maxSum=0;
        int currSum=0;

        for(char ch: s.toCharArray()){

            currSum += cost[ch-'a'];

            if(currSum<0){
                currSum=0;
            }
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}