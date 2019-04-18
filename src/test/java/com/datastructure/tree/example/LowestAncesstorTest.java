package test.java.com.datastructure.tree.example;

import main.java.com.datastructure.tree.base.TreeNode;
import main.java.com.datastructure.tree.example.LowestAncesstor;
import main.java.com.datastructure.tree.example.TreeDepth;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: LowestAncesstorTest
 * @Author: yuexx
 * @Date: 2019/4/18 17:03
 * @Version: 1.0
 */
public class LowestAncesstorTest {

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

    LowestAncesstor lowestAncesstor = new LowestAncesstor();

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
    public void lowestCommonAcvestor() {
       TreeNode node0 = lowestAncesstor.lowestCommonAcvestor(A,B, F);
       assertEquals("A",node0.value);

        TreeNode node1 = lowestAncesstor.lowestCommonAcvestor(A,K, G);
        assertEquals("C",node1.value);

        TreeNode node2 = lowestAncesstor.lowestCommonAcvestor(A,H, J);
        assertEquals("B",node2.value);
    }
}