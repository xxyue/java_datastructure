package main.java.com.datastructure.linked.singly.example;

import main.java.com.datastructure.linked.singly.base.SinglyLinkedList1;
import main.java.com.datastructure.linked.singly.base.SinglyLinkedNode;

/**
 * @Description: 单向链表 实例操作
 * @ClassName: SinglyLinkedList
 * @Author: yuexx
 * @Date: 2019/4/4 9:31
 * @Version: 1.0
 */
public class SinglyLinkedListUtile1 {


    /**
     *     * 翻转链表
     *      * 0.  放入栈中，然后再一次弹出
     *      * 1.  时间复杂度： O(n)   空间复杂度O(1)
     * @param list 要反转的链表
     */
    public static void reverseList(SinglyLinkedList1 list) {
        SinglyLinkedNode node = list.getHead();
        SinglyLinkedNode pre = null; //当前节点的上一个节点
        SinglyLinkedNode next = null; //当前节点的下一个节点
        SinglyLinkedNode headNode = list.getHead();
        while (node != null) {
            next = node.next;
            if(next == null){
                list.setHead(node);
            }
            node.next = pre;
            pre = node;
            node = next;

        }
        headNode.next = null;
        list.setTail(headNode);
    }


    /**
     *   取中间节点（偶数放回取得中间节点的前面那个）
     *   两个计步器 一个加1， 一个加2  当+2到达结尾时 结束
     * @param list
     * @return
     */
    public static SinglyLinkedNode getMid(SinglyLinkedList1 list) {
        if(list == null ){
            return null;
        }
        SinglyLinkedNode head = list.getHead();
        if (head == null) {
            return head;
        }
        SinglyLinkedNode fast = head;
        SinglyLinkedNode slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
