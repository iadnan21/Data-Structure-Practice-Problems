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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int currLevel = 0;

        if (root == null) {
            return new ArrayList<>();
        }

        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();
            al.add(new ArrayList<>());

            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                al.get(currLevel).add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            currLevel++;
        }
        return al;
    }
}