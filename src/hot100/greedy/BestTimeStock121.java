package hot100.greedy;

/**
 * @author WangTianze
 * @description
 * @date 2024-03-13
 */
public class BestTimeStock121 {
    public int maxProfit(int[] prices) {
        int lowPrice = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            lowPrice = Math.min(lowPrice, prices[i]);
            result = Math.max(result, prices[i] - lowPrice);
        }
        return result;
    }
}
