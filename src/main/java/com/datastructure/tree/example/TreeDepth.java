package main.java.com.datastructure.tree.example;

import main.java.com.datastructure.tree.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description: 二叉树最大深度和最小深度
 * @ClassName: TreeDepth
 * @Author: yuexx
 * @Date: 2019/4/18 16:14
 * @Version: 1.0
 */
public class TreeDepth {

    /**
     * 递归最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }

    /**
     * 非递归最大深度
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
            level ++ ;
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }

    /**
     * 递归最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        if(root.left == null && root.right != null){
            return minDepth(root.right) + 1;
        }

        if(root.left != null && root.right == null){
            return minDepth(root.left) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left,right) + 1;
    }

    /**
     * 非递归最小深度
     * @param root
     * @return
     */
    public int mixDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
            level ++ ;
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return level;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }

}
