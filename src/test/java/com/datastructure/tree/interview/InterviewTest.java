package test.java.com.datastructure.tree.interview;

import main.java.com.datastructure.tree.base.MyTree;
import main.java.com.datastructure.tree.base.TreeNode;
import main.java.com.datastructure.tree.interview.Interview;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: InterviewTest
 * @Author: yuexx
 * @Date: 2019/4/18 17:41
 * @Version: 1.0
 */
public class InterviewTest {

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
    @Test
    public void buildTree() {
        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode node = new Interview().buildTree(preOrder, inOrder);
        MyTree.preTraverse(node);//3 9 20 15 7
        System.out.println();
        MyTree.inTraverse(node);//9 3 15 20 7
        System.out.println();
        MyTree.postTraverse(node);//9 15 7 20 3
        System.out.println();
        MyTree.levelTraverse(node);//3 9 20 15 7


    }
}