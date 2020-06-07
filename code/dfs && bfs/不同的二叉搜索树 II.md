```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList();
        if (n <= 0) return res;
        return dfs(1, n);
        
    }

    private List<TreeNode> dfs(int left, int right) {
        List<TreeNode> res = new ArrayList();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode>  leftNode = dfs(left, i-1);
            List<TreeNode>  rightNode = dfs(i+1, right);
            for (TreeNode l: leftNode) {
                for (TreeNode r: rightNode) {
                    TreeNode tmp = new TreeNode(i, l, r);
                    res.add(tmp);

                }
            }


        }
        return res;

        

    }
}
```