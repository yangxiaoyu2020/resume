### 周赛的一次记录

* prim算法 (最小生成树)

``
非正常的prim,5513. 连接所有点的最小费用
``
![图实例](https://assets.leetcode.com/uploads/2020/08/26/c.png)
```java
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int m = points.length;
        boolean[] visited = new boolean[m];
        int[] dis = new int[m];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int u = -1;
            int minDis = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (!visited[j] && dis[j] <= minDis) {
                    minDis = dis[j];
                    u = j;
                }

            }
            res += dis[u];
            visited[u] = true;
            for (int j = 0; j < m; j++) {
                if (!visited[j]) {
                    int min = Math.abs(points[j][0]-points[u][0]) +  Math.abs(points[j][1]-points[u][1]);
                    dis[j] = Math.min(dis[j], min);
                 }
            }
        }
        return res;

    }
}
```