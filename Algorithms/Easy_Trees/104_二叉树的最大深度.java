/*
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。

思路：递归

也可以层序遍历二叉树，然后计算总层数。
这个时候要利用queue的特性, poll、 offer等方法！！！
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return left > right ? left + 1 : right + 1;
    }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            ++res;
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                TreeNode t = q.poll();   //　　poll         移除并返问队列头部的元素    如果队列为空，则返回null
                if (t.left != null) q.offer(t.left);  //　　offer       添加一个元素并返回true       如果队列已满，则返回false
                if (t.right != null) q.offer(t.right);
            }
        }
        return res;
    }
}
