/**
 * Created by zfz on 2019/2/1.
 */
public class LowestCommonAncestorofaBinaryTree {
    TreeNode tn = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        return search(root, p, q);
    }

    public TreeNode search(TreeNode root, TreeNode p, TreeNode q){

        if(root.left != null){
            if(root.left.val == p.val && root.right != null && search(root.right, p, q).val == q.val){
                return root;
            }
            else if(root.left.val == q.val && root.right != null && search(root.right, p, q).val == p.val){
                return root;
            }
            else if(root.left.val == p.val && root.left.left != null && search(root.left.left, p, q).val == q.val){
                return root.left;
            }
            else if(root.left.val == q.val && root.left.right != null && search(root.left.right, p, q).val == p.val){
                return root.left;
            }
        }
        if(root.right != null){
            if(root.right.val == p.val && root.left != null && search(root.left, p, q).val == q.val){
                return root;
            }
            else if(root.right.val == q.val && root.left != null && search(root.left, p, q).val == p.val){
                return root;
            }
            else if(root.right.val == p.val && root.right.left != null && search(root.right.left, p, q).val == q.val){
                return root.right;
            }
            else if(root.right.val == q.val && root.right.right != null && search(root.right.right, p, q).val == p.val){
                return root.right;
            }
        }

        TreeNode tn = root;
        if(root.left != null){
            tn = search(root.left, p, q);
            if(tn != root){
                return tn;
            }
        }
        if(root.right != null){
            tn = search(root.right, p, q);
            if(tn != root){
                return tn;
            }
        }
        return root;
    }

    public TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        TreeNode res = null;

        if(root == null){
            return null;
        }

        if(root.left == null){
            return root;
        }

        if(root.left.val == p.val){
            if(tn != null){
                return p;
            }
            tn = root.left;
            if(root.left.left != null){
                if(find(root.left.left, p, q).val == q.val){
                    return root.left;
                }
            }
            if(root.left.right != null){
                if(find(root.left.right, p, q).val == q.val){
                    return root.left;
                }
            }
//            return root;
        }
        else if(root.left.val == q.val){
            if(tn != null){
                return q;
            }
            tn = root.left;

            if(root.left.left != null){
                if(find(root.left.left, p, q).val == p.val){
                    return root.left;
                }
            }
            if(root.left.right != null){
                if(find(root.left.right, p, q).val == p.val){
                    return root.left;
                }
            }
//            return root;
        }
        else {
            return find(root.left,p, q);
        }

        if(root.right == null){
            return root;
        }
        if(root.right.val == p.val){
            if(tn != null){
                return p;
            }
            tn = root.right;

            if(root.right.left != null){
                if(find(root.right.left, p, q).val == q.val){
                    return root.right;
                }
            }
            if(root.right.right != null){
                if(find(root.right.right, p, q).val == q.val){
                    return root.right;
                }
            }
//            return root;
        }
        else if(root.right.val == q.val){
            if(tn != null){
                return q;
            }
            tn = root.right;

            if(root.right.left != null){
                if(find(root.right.left, p, q).val == p.val){
                    return root.right;
                }
            }
            if(root.right.right != null){
                if(find(root.right.right, p, q).val == p.val){
                    return root.right;
                }
            }
//            return root;
        }
        else {
            return find(root.right, p, q);
        }
//        tn = null;
        find(root.left, p, q);
        find(root.right, p, q);
        /*if(root.left != null){
            if(tn != null){
                return q;
            }
//            tn = root.right;

            if(root.left.left != null){
                if(find(root.right.left, p, q).val == p.val){
                    return root.right;
                }
            }
            if(root.right.right != null){
                if(find(root.right.right, p, q).val == p.val){
                    return root.right;
                }
            }
        }

        find(root.right, p, q);*/
        return root;
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
