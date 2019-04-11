package test.java.com.datastructure.linked.singly.interview;


import main.java.com.datastructure.linked.singly.base.SinglyLinkedList0;
import main.java.com.datastructure.linked.singly.base.SinglyLinkedNode;
import main.java.com.datastructure.linked.singly.interview.Question2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @Description: ${description}
 * @ClassName: Question2Test
 * @Author: yuexx
 * @Date: 2019/4/11 14:47
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class Question2Test {
    SinglyLinkedNode node1 = new SinglyLinkedNode(8);
    SinglyLinkedNode node2 = new SinglyLinkedNode(4);
    SinglyLinkedNode node3 = new SinglyLinkedNode(5);
    SinglyLinkedNode node4 = new SinglyLinkedNode(7);
    SinglyLinkedNode node5 = new SinglyLinkedNode(1);
    SinglyLinkedNode node6 = new SinglyLinkedNode(3);
    SinglyLinkedNode node7 = new SinglyLinkedNode(6);
    SinglyLinkedNode node8 = new SinglyLinkedNode(2);
    @Before
    public void setUp() throws Exception {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
    }

    @Test
    public void sortList() {
        SinglyLinkedList0.traverse(node1);//遍历
        SinglyLinkedNode head = Question2.sortList(node1);
        SinglyLinkedList0.traverse(head);//遍历
    }
}
