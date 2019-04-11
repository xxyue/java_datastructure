package main.java.com.datastructure.linked.singly.base;

/**
 * @Description: 单向链表   (只研究数据结构，不考虑类型 安全等其他问题，  以int为例）
 * @ClassName: SinglyLinkedList
 * @Author: yuexx
 * @Date: 2019/4/4 9:31
 * @Version: 1.0
 */
public class SinglyLinkedList0 {

    /**
     * 头节点的插入
     *
     * @param head    原来的头节点
     * @param newHead 新增的头节点
     */
    public static void headInsert(SinglyLinkedNode head, SinglyLinkedNode newHead) {
        SinglyLinkedNode oldhead = head;
        head = newHead;
        head.next = oldhead;
    }

    /**
     * 尾节点插入
     *
     * @param tail    原尾尾节点
     * @param newTail 新追加的尾节点
     */
    public static void tailInsert(SinglyLinkedNode tail, SinglyLinkedNode newTail) {
        SinglyLinkedNode oldTail = tail;
        tail = newTail;
        newTail.next = null;
        oldTail.next = newTail;
    }

    /**
     * 遍历
     *
     * @param head 现在的头结点
     */
    public static void traverse(SinglyLinkedNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 查找
     *
     * @param head 现在的头结点
     * @param vlue 要查找的值
     * @return
     */
    public static int find(SinglyLinkedNode head, int vlue) {
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
     *
     * @param head 头结点
     * @param q    要删除的节点
     */
    public static void delete0(SinglyLinkedNode head, SinglyLinkedNode q) {
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
        if (q.next == null) {
            while (head != null) {
                if (head.next != null && head.next == q) {
                    head.next = null;
                    break;
                }
                head = head.next;
            }
        }
    }

    /**
     * 删除节点
     * 其实删除的是他的下一个节点指针， 并且把下一节点值赋值到当前节点
     * 故会出现该节点能够一直删除的，缩减列表的假象
     *
     * @param head 头结点
     * @param q    要删除的节点
     */
    public static void delete1(SinglyLinkedNode head, SinglyLinkedNode q) {
        if (q == null) {
            return;
        }
        while (head != null) {
            if (head.next != null && head.next == q) {
                head.next = q.next;
                break;
            }
            head = head.next;
        }
    }
}
