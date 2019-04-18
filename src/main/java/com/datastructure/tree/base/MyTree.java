package main.java.com.datastructure.tree.base;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: 树的遍历
 * @ClassName: MyTree
 * @Author: yuexx
 * @Date: 2019/4/18 14:54
 * @Version: 1.0
 */
public class MyTree {
    /**
     * 非递归前序遍历
     *  前序遍历：先访问根结点，然后遍历左子树，最后遍历右子树。
     *   例：
     *      树的结构为： https://www.processon.com/diagraming/5cb82250e4b0841b84352c75
     *      遍历结果：(ABDHIEJCFKG)
     *
     */
    public static void preTraverse(TreeNode node){
        if(node != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(node);
            while (!stack.isEmpty()){
                TreeNode pop = stack.pop();
                System.out.print(pop.value + " ");
                if(pop.right != null){
                    stack.push(pop.right);
                }
                if(pop.left != null){
                    stack.push(pop.left);
                }
            }
        }
    }

    /**
     * 非递归中序遍历
     *  中序遍历：先遍历左子树，然后遍历根结点，最后遍历右子树。
     *   例：
     *      树的结构为： https://www.processon.com/diagraming/5cb82250e4b0841b84352c75
     *      遍历结果：(HDIBEJAFKCG)
     *
     */
    public static void inTraverse(TreeNode node){
        if(node != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (!stack.isEmpty() || node != null){
                if(node != null){
                    stack.push(node);
                    node = node.left;
                }else {
                    node = stack.pop();
                    System.out.print(node.value + " ");
                    node = node.right;
                }
            }
        }
    }

    /**
     * 非递归后序遍历
     *  后序遍历：先遍历左子树，然后遍历右子树，最后遍历根结点。
     *   例：
     *      树的结构为： https://www.processon.com/diagraming/5cb82250e4b0841b84352c75
     *      遍历结果：(HIDJEBKFGCA)
     *
     */
    public static void postTraverse(TreeNode node){
        if(node != null){
            Stack<TreeNode> stack1 = new Stack<TreeNode>();
            Stack<TreeNode> stack2 = new Stack<TreeNode>();
            stack1.push(node);
            while (!stack1.isEmpty()){
                TreeNode pop = stack1.pop();
                stack2.push(pop);
                if(pop.left != null){
                    stack1.push(pop.left);
                }

                if(pop.right != null){
                    stack1.push(pop.right);
                }
            }

            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().value  + " ");
            }
        }
    }

    /**
     * 非递归层次遍历
     *  层次遍历：从上到下逐层遍历，在同一层中，按从左到右的顺序遍历。
     *   例：
     *      树的结构为： https://www.processon.com/diagraming/5cb82250e4b0841b84352c75
     *      遍历结果：(ABCDEFGHIJK)
     *
     */
    public static void levelTraverse(TreeNode node){
        if(node != null){
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(node);
          while (!queue.isEmpty()){
              //获取获当前层的节点数
              int levelNum = queue.size();
              for (int i = 0; i < levelNum ; i++) {
                  TreeNode poll = queue.poll();
                  System.out.print(poll.value + " ");
                  if (poll.left != null){
                      queue.offer(poll.left);
                  }
                  if (poll.right != null){
                      queue.offer(poll.right);
                  }
              }
          }
        }
    }
}




