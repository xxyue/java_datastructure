package main.java.com.datastructure.tree.interview;

import main.java.com.datastructure.tree.base.TreeNode;

import java.util.HashMap;

/**
 * @Description: 先序数组 中序数组 结合重构二叉树
 * @ClassName: Interview
 * @Author: yuexx
 * @Date: 2019/4/18 17:13
 * @Version: 1.0
 */
public class Interview {


    /**
     * leetcode　　105
     * 给定一颗树的前序遍历与中序遍历，依据此构造二叉树
     * 注意：
     * 你可以假设树种没有重复的元素
     *例如，给出
     *
     * 前序遍历 = [3,9,20,15,7]
     * 中序遍历 = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     *    思路：
     *      先通过前序遍历的到第一个元素确定根元素，然后找到钙元素的中序遍历中的位置，采取递归实现
     */
    public TreeNode buildTree(int[] preOrder,int[] inOrder){
        if(preOrder == null || inOrder == null){
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return buildTree(preOrder,0,preOrder.length-1,
                        inOrder, 0 , inOrder.length -1,
                map);
    }



    private TreeNode buildTree(int[] preOrder, int pstart, int pend,
                              int[] inOrder, int istart, int iend,
                              HashMap<Integer, Integer> map){

        if(pstart > pend || istart > iend){
            return null;
        }

        TreeNode head = new TreeNode(preOrder[pstart] + "");
        int index = map.get(preOrder[pstart]);
        head.left = buildTree(preOrder, pstart + 1, pstart + index - istart,
                                inOrder ,istart, index -1,
                                 map);

        head.right = buildTree(preOrder, pstart + index - istart + 1, pend,
                                inOrder,index + 1, iend,
                                 map);
         return head;
    }
}
