class Solution {
    public int maxProfit(int[] prices) {
       int len = prices.length;
       int min = prices[0];
       int diff = 0;
       int total = 0;

        for(int i = 1; i < len; i++){
            int tmp = prices[i] - min;
            if(diff > tmp){
                min = prices[i];
                total += diff;
                diff = 0;
            }else{
                diff = tmp;
            }
        } 
       return total + diff;
    }
}