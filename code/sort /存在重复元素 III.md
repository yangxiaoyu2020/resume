### 解题思路
使用TreeSet 来处理,
ceiling(n) 返回大于 n 的最小
floor(n) 返回小于 n 的最大

### 代码

```java
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> map = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            Integer c = map.ceiling(nums[i]);
            if (c != null && c <= nums[i] + t) return true;
            Integer f = map.floor(nums[i]);
            if (f != null &&  nums[i] <= t + f) return true;
            map.add(nums[i]);
            if (map.size() > k) {
                map.remove(nums[i-k]);
            }
        }
        return false;

    }
}
```