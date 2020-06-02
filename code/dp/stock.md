* 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    
*  如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
    
*    注意：你不能在买入股票前卖出股票。
    

```java
class Solution {
    public int maxProfit(int prices[]) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i ==0) {
                dp[i][0] = 0;
//  sell dp[i][0]                
                dp[i][1] = -prices[i];
//  buy dp[i][1]

                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n - 1][0];

    }
}
```
## the key of this question is that using the dp[x][0] and dp[x][1] stand for the sell and buy,
so the function of transform is that :
> dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i])

> dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]* (k-1) - prices[i])

> k means the times u can do 

