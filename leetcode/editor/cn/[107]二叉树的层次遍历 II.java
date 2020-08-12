//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 280 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
//跟前序遍历的区别 1这里是queue，2这里是先左后右
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> listInner = new LinkedList<Integer>();
            while (size > 0) {
                TreeNode node = queue.poll();
                listInner.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            list.add(0, listInner);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
