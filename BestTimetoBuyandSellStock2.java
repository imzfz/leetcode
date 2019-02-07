/**
 * Created by zfz on 2019/2/6.
 */
public class BestTimetoBuyandSellStock2 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int buy = prices[0];
        int res = 0;
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] > buy) {
                res += prices[i] - buy;
            }
            buy = prices[i];
        }
        return res;
    }
}
