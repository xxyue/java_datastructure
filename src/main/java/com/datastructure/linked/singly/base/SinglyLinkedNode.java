package main.java.com.datastructure.linked.singly.base;

import java.util.Objects;

/**
 * @Description: 单向链表节点类
 * @ClassName: Node
 * @Author: yuexx
 * @Date: 2019/4/4 11:04
 * @Version: 1.0
 */
public class SinglyLinkedNode {
    public int value;
    public SinglyLinkedNode next;

    public SinglyLinkedNode(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinglyLinkedNode)) return false;
        SinglyLinkedNode that = (SinglyLinkedNode) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
