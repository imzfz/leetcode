/**
 * Created by zfz on 2019/2/1.
 */
public class LowestCommonAncestorofaBinaryTree {
    TreeNode tn = null;
    TreeNode tn1 = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode leftRoot = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRoot = lowestCommonAncestor(root.right, p , q);

        if(leftRoot != null && rightRoot != null){
            return root;
        }

        return leftRoot == null ? rightRoot : leftRoot;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
