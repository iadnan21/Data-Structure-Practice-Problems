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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return new ArrayList<>();
        }

        boolean lefttoright = true;

        q.offer(root);

        while (!q.isEmpty()) {
            int queueSize = q.size();
            LinkedList<Integer> temp = new LinkedList<>();

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = q.poll();

                if (lefttoright) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);
                }

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            al.add(temp);
            lefttoright = !lefttoright;
        }
        return al;
    }
}