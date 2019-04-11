package test.java.com.datastructure.linked.singly;



import main.java.com.datastructure.linked.singly.base.SinglyLinkedList1;
import main.java.com.datastructure.linked.singly.base.SinglyLinkedNode;
import main.java.com.datastructure.linked.singly.example.SinglyLinkedListUtile1;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * @Description: ${description}
 * @ClassName: SinglyLinkedListUtile0Test
 * @Author: yuexx
 * @Date: 2019/4/4 15:59
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class SinglyLinkedListUtile1Test {

    SinglyLinkedList1 singlyLinkedList1 = new SinglyLinkedList1();
    SinglyLinkedNode head1 = new SinglyLinkedNode(1);
    SinglyLinkedNode node2 = new SinglyLinkedNode(2);
    SinglyLinkedNode node3 = new SinglyLinkedNode(3);
    @Before
    public void setUp() throws Exception {
        singlyLinkedList1.tailInsert(head1);
        singlyLinkedList1.tailInsert(node2);
        singlyLinkedList1.tailInsert(node3);
    }

    @Test
    public void reverseList() {
        SinglyLinkedListUtile1.reverseList(singlyLinkedList1);
        singlyLinkedList1.traverse();//翻转后遍历预期 3 2 1
    }

    @Test
    public void getMid() {
        SinglyLinkedNode midNode = SinglyLinkedListUtile1.getMid(singlyLinkedList1);
        System.out.println(midNode.value);
        assertEquals(2 ,midNode.value);

    }
}
