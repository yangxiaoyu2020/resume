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

### for example 
#### 309. 最佳买卖股票时机含冷冻期
```text
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
```


```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
        {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            if (i == 1){
                dp[i][0] = Math.max(dp[i-1][1]+prices[i], dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);
            }
            // 第一天要特殊处理
            else{
                dp[i][0] = Math.max(dp[i-1][1]+prices[i], dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-2][0]-prices[i], dp[i-1][1]);
            }
        }
        return Math.max(dp[n-1][1], dp[n-1][0]);
        
    }
}
```