package main.java.com.datastructure.list.linked.singly.interview;

import main.java.com.datastructure.list.linked.singly.base.SinglyLinkedNode;

/**
 * @Description: 面试真题 ： 奇数位升序，偶数位降序链表排序
 *          1 8 3 6 5 4 7 2 9
 * 奇数位 1 3 5 7 9
 * 偶数位 8 6 4 2
 * 结果 1 2 3 4 5 6 7 8 9
 * 时间复杂度O（n）
 * @ClassName: Question1
 * @Author: yuexx
 * @Date: 2019/4/8 15:14
 * @Version: 1.0
 */
public class Question1 {
    /**
     * 分成三部
     *  1.按照奇数位和偶数位拆成两个链表
     *  2.对偶数位链表进行翻转
     *  3.将两个有序链表合并
     */
    public static SinglyLinkedNode question1(SinglyLinkedNode head){
        SinglyLinkedNode[] arr = getLists(head);//1.按照奇数位和偶数位拆成两个链表
        SinglyLinkedNode head1 = arr[0];
        SinglyLinkedNode head2 = arr[1];
        head2 = reverseList(arr[1]);//2.对偶数位链表进行翻转
        SinglyLinkedNode head3 = mergeTwoList(head1,head2);//3.将两个有序链表合并
        return head3;
    }
    
    //第一步
    public  static SinglyLinkedNode[] getLists(SinglyLinkedNode head){
        SinglyLinkedNode head1 = null;
        SinglyLinkedNode head2 = null;

        SinglyLinkedNode cur1 = null;
        SinglyLinkedNode cur2 = null;
        int count = 1;//计数器
        while ( head !=null){
            if(count % 2 == 1){//奇数节点
                if(cur1 != null){
                    cur1.next = head;
                    cur1 = cur1.next;
                } else {
                    cur1 = head;
                    head1 = cur1;
                }
            } else {//偶数
                if(cur2 != null){
                    cur2.next = head;
                    cur2 = cur2.next;
                } else {
                    cur2 = head;
                    head2 = cur2;
                }

            }
            head = head.next;
            count++;
        }
        cur1.next = null;
        cur2.next = null;

        SinglyLinkedNode[] nodes = new SinglyLinkedNode[]{head1,head2};
        return nodes;
    }

    //翻转
    public static SinglyLinkedNode reverseList(SinglyLinkedNode head){
        SinglyLinkedNode pre = null;
        SinglyLinkedNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //合并
    public static SinglyLinkedNode mergeTwoList(SinglyLinkedNode head1, SinglyLinkedNode head2){
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
            head.next = mergeTwoList(head1, head2.next);
        } else {
            head = head1;
            head.next = mergeTwoList(head1.next, head2);
        }
        return head;
    }
}
