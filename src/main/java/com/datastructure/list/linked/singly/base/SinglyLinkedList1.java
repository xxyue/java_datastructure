package main.java.com.datastructure.list.linked.singly.base;

/**
 * @Description: 单向链表   (只研究数据结构，不考虑类型 安全等其他问题，  以int为例）
 * @ClassName: SinglyLinkedList
 * @Author: yuexx
 * @Date: 2019/4/4 9:31
 * @Version: 1.0
 */
public class SinglyLinkedList1 {
    //单向链表的头
    private SinglyLinkedNode head;
    //单向链表的尾
    private SinglyLinkedNode tail;

    /**
     * 头节点的插入
     *
     * @param newHead 新增的头节点
     */
    public void headInsert(SinglyLinkedNode newHead) {
        if(head == null){
            head = newHead;
            tail = newHead;
            return;
        }
        SinglyLinkedNode oldhead = head;
        head = newHead;
        head.next = oldhead;
    }

    /**
     * 尾节点插入
     *
     * @param newTail 新追加的尾节点
     */
    public void tailInsert( SinglyLinkedNode newTail) {
        if(tail == null){
            head = newTail;
            tail = newTail;
            return;
        }
        SinglyLinkedNode oldTail = tail;
        tail = newTail;
        newTail.next = null;
        oldTail.next = newTail;
    }

    /**
     * 遍历
     *
     */
    public void traverse() {
        SinglyLinkedNode node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 查找
     *
     * @param vlue 要查找的值
     * @return 角标
     */
    public int find(int vlue) {
        int index = -1; //默认未找到为-1
        int count = 0;
        while (head != null) {
            if (head.value == vlue) {
                index = count;
                return index;
            }
            count++;
            head = head.next;
        }
        return index;
    }

    /**
     * 指定插入某个节点之后
     *
     * @param p 要插入节点的上一个节点
     * @param s 要插入的节点
     */
    public static void inster(SinglyLinkedNode p, SinglyLinkedNode s) {
        SinglyLinkedNode nodeNext = p.next;
        p.next = s;
        s.next = nodeNext;
    }

    /**
     * 删除节点
     * @param q    要删除的节点
     */
    public void delete0(SinglyLinkedNode q) {
        //单向链表的上一个节点不容易找到 故把要删除的节点的下一节点放到当前节点，这样当前节点原有的数据都删除了
        //这样删除速度快 但是删除 只能一次，多次 对象与初始有差异 再删除其他元素时，可能与预想不太一样
        if (q != null && q.next != null) {
            SinglyLinkedNode p = q.next;
//            q = p;
            q.value = p.value;
            q.next = p.next;
            return;
        }

        //删除最后一个节点的情况
        SinglyLinkedNode node = head;
        if (q.next == null) {
            while (node != null) {
                if (node.next != null && node.next == q) {
                    node.next = null;
                    break;
                }
                node = node.next;
            }
        }
    }

    /**
     * 删除节点
     * 其实删除的是他的下一个节点指针， 并且把下一节点值赋值到当前节点
     * 故会出现该节点能够一直删除的，缩减列表的假象
     *
     * @param q    要删除的节点
     */
    public void delete1(SinglyLinkedNode q) {
        if (q == null) {
            return;
        }
        if(head == q){
            head = head.next;
            return;
        }

        SinglyLinkedNode node = head;
        while (node != null) {
            if (node.next != null && node.next == q) {
                node.next = q.next;
                if(tail == q){
                    tail = node;
                }
                break;
            }
            node = node.next;
        }
    }

    public SinglyLinkedNode getHead() {
        return head;
    }

    public void setHead(SinglyLinkedNode head) {
        this.head = head;
    }

    public SinglyLinkedNode getTail() {
        return tail;
    }

    public void setTail(SinglyLinkedNode tail) {
        this.tail = tail;
    }
}
