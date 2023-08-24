class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0]; //최솟값으로 둔다.
        int diff = 0; //이익의 최솟값

        for(int i = 0; i < prices.length ; i++){
            diff = Math.max(diff, prices[i] - min); //앞에 있는게 크면 음수가 나옴.  -> 최대 profit을 구한다.
            min = Math.min(prices[i], min); // minprice에 값을 저장하고 비교 -> 최소값 교체
        }

        return diff;
    }
}
