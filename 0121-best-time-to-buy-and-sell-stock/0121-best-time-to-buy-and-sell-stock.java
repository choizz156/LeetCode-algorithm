class Solution {
    public int maxProfit(int[] prices) {
        int min_price = prices[0]; //최솟값으로 둔다.
        int maxprof = 0; //이익의 최솟값

        for(int i = 0; i < prices.length ; i++){
            maxprof = Math.max(maxprof, prices[i] - min_price); //앞에 있는게 크면 음수가 나옴.  -> 최대 profit을 구한다.
            min_price = Math.min(prices[i], min_price); // minprice에 값을 저장하고 비교 -> 최소값 교체
        }

        return maxprof;
    }
}