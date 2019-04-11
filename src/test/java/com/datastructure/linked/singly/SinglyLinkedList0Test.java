package test.java.com.datastructure.linked.singly;


import main.java.com.datastructure.linked.singly.base.SinglyLinkedList0;
import main.java.com.datastructure.linked.singly.base.SinglyLinkedNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: SinglyLinkedList0Test
 * @Author: yuexx
 * @Date: 2019/4/4 11:07
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class SinglyLinkedList0Test {

    SinglyLinkedNode head1 = new SinglyLinkedNode(1);
    SinglyLinkedNode node2 = new SinglyLinkedNode(2);
    SinglyLinkedNode node3 = new SinglyLinkedNode(3);

    @Before
    public void setUp() throws Exception {
        head1.next= node2;
        node2.next=node3;
        node3.next= null;
    }

    @Test
    public void headInsert() {
        SinglyLinkedNode head0 = new SinglyLinkedNode(0);
        SinglyLinkedList0.headInsert(head1,head0);
        SinglyLinkedList0.traverse(head0);//预期0 1 2 3
    }

    @Test
    public void tailInsert() {
        SinglyLinkedNode head4 = new SinglyLinkedNode(4);
        SinglyLinkedList0.tailInsert(node3,head4);
        SinglyLinkedList0.traverse(head1);//预期1 2 3 4

    }

    @Test
    public void traverse() {
        SinglyLinkedList0.traverse(head1);//预期 1 2 3
    }

    @Test
    public void find() {
       int index2 =  SinglyLinkedList0.find(head1, 2);
       System.out.println();
        assertEquals(1 ,index2);
        int index5 =  SinglyLinkedList0.find(head1, 5);
        System.out.println(index5);
        assertEquals(-1 ,index5);
    }

    @Test
    public void inster() {
        SinglyLinkedNode head0 = new SinglyLinkedNode(10);
        SinglyLinkedList0.inster(head1,head0);
        SinglyLinkedList0.traverse(head1);//预期 1 10 2 3
    }

    @Test
    public void delete0() {
        //预期 1 3  　实际 1 3 　
        SinglyLinkedList0.delete0(head1,node2);
        SinglyLinkedList0.traverse(head1);
        System.out.println("**********");
        //预期 1  　实际 1 3 　其实删除的是他的下一个节点指针， 并且把下一节点值赋值到当前节点 故预期删除下一节点是失效
        SinglyLinkedList0.delete0(head1,node3);
        SinglyLinkedList0.traverse(head1);
        System.out.println("**********");
        //预期 1 3   　实际 1 其实删除的是他的下一个节点指针， 并且把下一节点值赋值到当前节点 故预期删除当前节点重复删除失效，其实删除了下一个节点
        SinglyLinkedList0.delete0(head1,node2);
        SinglyLinkedList0.traverse(head1);
    }

    @Test
    public void delete1() {
        //预期 1 3
        SinglyLinkedList0.delete1(head1,node2);
        SinglyLinkedList0.traverse(head1);
        System.out.println("**********");
        //预期 1 3
        SinglyLinkedList0.delete1(head1,node2);
        SinglyLinkedList0.traverse(head1);
        System.out.println("**********");
        //预期 1
        SinglyLinkedList0.delete1(head1,node3);
        SinglyLinkedList0.traverse(head1);
    }
}
