package main.java.com.datastructure.list.linked.singly.example;

import main.java.com.datastructure.list.linked.singly.base.SinglyLinkedNode;

/**
 * @Description: 单向链表 实例操作
 * @ClassName: SinglyLinkedList
 * @Author: yuexx
 * @Date: 2019/4/4 9:31
 * @Version: 1.0
 */
public class SinglyLinkedListUtile0 {


    /**
     * 翻转链表
     * 0.  放入栈中，然后再一次弹出
     * 1.  时间复杂度： O(n)   空间复杂度O(1)
     */
    public static SinglyLinkedNode reverseList(SinglyLinkedNode head) {
        SinglyLinkedNode pre = null; //当前节点的上一个节点
        SinglyLinkedNode next = null; //当前节点的下一个节点
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 取中间节点（偶数放回取得中间节点的前面那个）
     * 两个计步器 一个加1， 一个加2  当+2到达结尾时 结束
     *
     * @param head
     * @return
     */
    public static SinglyLinkedNode getMid(SinglyLinkedNode head) {
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

    /**
     * 合并两个有序链表
     * 0 递归
     * 1.
     */
    public static SinglyLinkedNode mergeTwoList0(SinglyLinkedNode head1, SinglyLinkedNode head2){
        if(head1 == null && head2 == null){
            return null;
        }
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        SinglyLinkedNode head = null;
        if(head1.value > head2.value){
            head = head2;
            head.next = mergeTwoList0(head1, head2.next);
        } else {
            head = head1;
            head.next = mergeTwoList0(head1.next, head2);
        }
        return head;
    }


    /**
     * 合并两个有序链表
     * 0 递归
     * 1.
     */
    public static SinglyLinkedNode mergeTwoList1(SinglyLinkedNode head1, SinglyLinkedNode head2){
        if(head1 == null || head2 == null){
            return head1 !=null ? head1 : head2;
        }
        SinglyLinkedNode head = head1.value < head2.value ? head1 : head2;
        SinglyLinkedNode curl = head == head1 ? head1 : head2;
        SinglyLinkedNode cur2 = head == head1 ? head2 : head1;
        SinglyLinkedNode pre = null;//curl的前一个元素
        SinglyLinkedNode next = null;//cur2的后一个元素

        while ( curl != null && cur2 != null){
            if(curl.value <= cur2.value){
                pre = curl;
                curl = curl.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = curl;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = curl == null ? cur2 : curl;
        return head;
    }

}
