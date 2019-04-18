package test.java.com.datastructure.tree;

import main.java.com.datastructure.tree.base.MyTree;
import main.java.com.datastructure.tree.base.TreeNode;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description: ${description}
 * @ClassName: MyTreeTest
 * @Author: yuexx
 * @Date: 2019/4/18 16:02
 * @Version: 1.0
 */
public class MyTreeTest {

    TreeNode A = new TreeNode("A");
    TreeNode B = new TreeNode("B");
    TreeNode C = new TreeNode("C");
    TreeNode D = new TreeNode("D");
    TreeNode E = new TreeNode("E");
    TreeNode F = new TreeNode("F");
    TreeNode G = new TreeNode("G");
    TreeNode H = new TreeNode("H");
    TreeNode I = new TreeNode("I");
    TreeNode J = new TreeNode("J");
    TreeNode K = new TreeNode("K");


    @Before
    public void setUp() throws Exception {
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        D.right = I;
        E.right = J;
        F.right = K;
        //树的结构图形
        // https://www.processon.com/diagraming/5cb82250e4b0841b84352c75
    }

    /**
     * 非递归前序遍历
     *  前序遍历：先访问根结点，然后遍历左子树，最后遍历右子树。
     *   例：
     *      树的结构为： https://www.processon.com/diagraming/5cb82250e4b0841b84352c75
     *      遍历结果：(A B D H I E J C F K G)
     *
     */
    @Test
    public void preTraverse() {
        MyTree.preTraverse(A);

    }

    /**
     * 非递归中序遍历
     *  中序遍历：先遍历左子树，然后遍历根结点，最后遍历右子树。
     *   例：
     *      树的结构为： https://www.processon.com/diagraming/5cb82250e4b0841b84352c75
     *      遍历结果：(H D I B E J A F K C G)
     *
     */
    @Test
    public void inTraverse() {
        MyTree.inTraverse(A);
    }


    /**
     * 非递归后序遍历
     *  后序遍历：先遍历左子树，然后遍历右子树，最后遍历根结点。
     *   例：
     *      树的结构为： https://www.processon.com/diagraming/5cb82250e4b0841b84352c75
     *      遍历结果：(H I D J E B K F G C A)
     *
     */
    @Test
    public void postTraverse() {
        MyTree.postTraverse(A);
    }

    /**
     * 非递归层次遍历
     *  层次遍历：从上到下逐层遍历，在同一层中，按从左到右的顺序遍历。
     *   例：
     *      树的结构为： https://www.processon.com/diagraming/5cb82250e4b0841b84352c75
     *      遍历结果：(A B C D E F G H I J K)
     *
     */
    @Test
    public void levelTraverse() {
        MyTree.levelTraverse(A);
    }
}