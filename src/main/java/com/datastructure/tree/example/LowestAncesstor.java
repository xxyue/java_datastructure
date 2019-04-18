package main.java.com.datastructure.tree.example;

import main.java.com.datastructure.tree.base.TreeNode;

/**
 * @Description: 查找两个节点的最近公共祖先
 * @ClassName: LowestAncesstor
 * @Author: yuexx
 * @Date: 2019/4/18 16:58
 * @Version: 1.0
 */
public class LowestAncesstor {

    /**
     * 查找两个节点的最近公共祖先
     * @param root 根节点
     * @param p
     * @param q
     * @return  公共节点
     */
    public TreeNode lowestCommonAcvestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAcvestor(root.left,p,q);
        TreeNode right = lowestCommonAcvestor(root.right,p,q);
        if(left != null && right != null){
            return root;
        }
        return left != null? left : right;
    }
}
