package test.java.com.datastructure.linked.singly;


import main.java.com.datastructure.linked.singly.base.SinglyLinkedList0;
import main.java.com.datastructure.linked.singly.base.SinglyLinkedNode;
import main.java.com.datastructure.linked.singly.example.SinglyLinkedListUtile0;
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
public class SinglyLinkedListUtile0Test {

    SinglyLinkedNode head1 = new SinglyLinkedNode(1);
    SinglyLinkedNode node2 = new SinglyLinkedNode(2);
    SinglyLinkedNode node3 = new SinglyLinkedNode(3);

    SinglyLinkedNode head0 = new SinglyLinkedNode(0);
    SinglyLinkedNode node8 = new SinglyLinkedNode(8);
    SinglyLinkedNode node9 = new SinglyLinkedNode(9);
    @Before
    public void setUp() throws Exception {
        //第一个链表 头是head1
        head1.next= node2;
        node2.next=node3;
        node3.next= null;
        //第二个链表 头是head0
        head0.next= node8;
        node8.next= node9;
        node9.next= null;
    }

    @Test
    public void reverseList() {
        SinglyLinkedNode newHead = SinglyLinkedListUtile0.reverseList(head1);
        SinglyLinkedList0.traverse(newHead);//翻转后遍历预期 3 2 1
    }

    @Test
    public void getMid() {
        SinglyLinkedNode midNode = SinglyLinkedListUtile0.getMid(head1);
        System.out.println(midNode.value);
        assertEquals(2 ,midNode.value);

    }
    @Test
    public void mergeTwoList0() {
        SinglyLinkedNode head = SinglyLinkedListUtile0.mergeTwoList0(head1, head0);
        SinglyLinkedList0.traverse(head);// 预期 0 1 2 3 8 9
    }

    @Test
    public void mergeTwoList1() {
        SinglyLinkedNode head = SinglyLinkedListUtile0.mergeTwoList1(head1, head0);
        SinglyLinkedList0.traverse(head);// 预期 0 1 2 3 8 9

    }

}
