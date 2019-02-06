/**
 * Created by zfz on 2019/2/6.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int res = 0;
        int buy = Integer.MAX_VALUE;
        for(int price : prices){
            buy = Integer.min(buy, price);
            res = Integer.max(res, price - buy);
        }

        return res;
    }
}
