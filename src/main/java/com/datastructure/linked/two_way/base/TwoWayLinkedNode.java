package main.java.com.datastructure.linked.two_way.base;

import java.util.Objects;

/**
 * @Description: 双向链表节点类
 * @ClassName: Node
 * @Author: yuexx
 * @Date: 2019/4/4 11:04
 * @Version: 1.0
 */
public class TwoWayLinkedNode {
    //实际值
    public int value;
    //下一节点
    public TwoWayLinkedNode next;
    //上一节点
    public TwoWayLinkedNode prev;

    public TwoWayLinkedNode(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TwoWayLinkedNode)) return false;
        TwoWayLinkedNode that = (TwoWayLinkedNode) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
