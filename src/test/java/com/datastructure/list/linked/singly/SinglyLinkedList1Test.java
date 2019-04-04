package test.java.com.datastructure.list.linked.singly;

import main.java.com.datastructure.list.linked.singly.base.SinglyLinkedList1;
import main.java.com.datastructure.list.linked.singly.base.SinglyLinkedNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: SinglyLinkedList1Test
 * @Author: yuexx
 * @Date: 2019/4/4 14:19
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class SinglyLinkedList1Test {
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
    public void headInsert() {
        SinglyLinkedNode node0 = new SinglyLinkedNode(0);
        singlyLinkedList1.headInsert(node0);
        singlyLinkedList1.traverse(); // 预期 0 1 2 3
    }

    @Test
    public void tailInsert() {
        SinglyLinkedNode node4 = new SinglyLinkedNode(4);
        singlyLinkedList1.tailInsert(node4);
        singlyLinkedList1.traverse(); // 预期 1 2 3 4
    }

    @Test
    public void traverse() {
        singlyLinkedList1.traverse(); // 预期 1 2 3
    }

    @Test
    public void find() {
       int index0 =  singlyLinkedList1.find(2);// 预期 1
        System.out.println("index0 : " +  index0);
        assertEquals(1 ,index0);
        int index1=  singlyLinkedList1.find(4);// 预期 -1 列表中没有
        System.out.println("index1 : " +  index1);
        assertEquals(-1 ,index1);

    }

    @Test
    public void inster() {
        SinglyLinkedNode head0 = new SinglyLinkedNode(10);
        singlyLinkedList1.inster(head1,head0);
        singlyLinkedList1.traverse();//预期 1 10 2 3
    }

    @Test
    public void delete0() {
        //预期 1 3 　实际 1 3 　
        singlyLinkedList1.delete0(node2);
        singlyLinkedList1.traverse();
        System.out.println("**********");
        //预期 1 　实际 1 3 　　其实删除的是他的下一个节点指针， 并且把下一节点值赋值到当前节点 故预期删除下一节点是失效
        singlyLinkedList1.delete0(node3);
        singlyLinkedList1.traverse();
        System.out.println("**********");
        //预期 1 3  　实际 1 其实删除的是他的下一个节点指针， 并且把下一节点值赋值到当前节点 故预期删除当前节点重复删除失效，其实删除了下一个节点
        singlyLinkedList1.delete0(node2);
        singlyLinkedList1.traverse();
    }

    @Test
    public void delete1() {
        //预期 1 3  　实际 1 3 　
        singlyLinkedList1.delete1(node2);
        singlyLinkedList1.traverse();
        System.out.println("**********");
        //预期 1 3  　实际 1 3 　
        singlyLinkedList1.delete1(node2);
        singlyLinkedList1.traverse();
        System.out.println("**********");
        //预期 1 　实际 1
        singlyLinkedList1.delete1(node3);
        singlyLinkedList1.traverse();
    }
}
