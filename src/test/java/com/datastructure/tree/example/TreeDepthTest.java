package test.java.com.datastructure.tree.example;

import main.java.com.datastructure.tree.base.TreeNode;
import main.java.com.datastructure.tree.example.TreeDepth;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @Description: ${description}
 * @ClassName: TreeDepthTest
 * @Author: yuexx
 * @Date: 2019/4/18 16:51
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class TreeDepthTest {
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

    TreeDepth treeDepth = new TreeDepth();

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

    @Test
    public void maxDepth() {
      int depth = treeDepth.maxDepth(A);
      assertEquals(4, depth);

    }

    @Test
    public void maxDepth2() {
        int depth = treeDepth.maxDepth2(A);
        assertEquals(4, depth);
    }

    @Test
    public void minDepth() {
        int depth = treeDepth.minDepth(A);
        assertEquals(3, depth);
    }

    @Test
    public void mixDepth2() {
        int depth = treeDepth.mixDepth2(A);
        assertEquals(3, depth);
    }
}