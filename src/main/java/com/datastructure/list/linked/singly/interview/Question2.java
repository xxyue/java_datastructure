package main.java.com.datastructure.list.linked.singly.interview;

import main.java.com.datastructure.list.linked.singly.base.SinglyLinkedNode;

/**
 * @Description: 面试真题  单链表归并排序
 *          8 4 5 7 1 3 6 2
 *          先拆分 然后再治理
 *    过程：
 *          84571362
 *          8457 1362
 *          84 57 13 62
 *          8 4 5 7 1 3 6 2
 *          48 57 13 26
 *          4578 1236
 *          123456789
 * 时间复杂度 log2n
 */
public class Question2 {
    /**
     * 分成四部
     *  1.将待排序的数组（链表）去重点并一份为二（使用快慢指针 快指针一次两步，满指针一次走一步，快指针在链表末尾，慢指针敲好在链表中点）
     *  2.递归的对左半部分进行递归排序
     *  3.递归的对右半部分进行递归排序
     *  4.将两个半部分进行合并（merge）
     */
    public static SinglyLinkedNode sortList(SinglyLinkedNode head){
        if(head == null || head.next == null){//0或1 个就不用做排序了
            return head;
        }
        SinglyLinkedNode mid = getMid(head);
        SinglyLinkedNode right = mid.next;
        mid.next = null;//咬断链表
        SinglyLinkedNode node = mergeTwoList1(sortList(head),sortList(right));
        return node;
    }


    /**
     * 1.1取中间节点（偶数放回取得中间节点的前面那个）
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
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    /**
     * 4.将两个半部分进行合并（merge）
     * @param head1
     * @param head2
     * @return
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
