package main.java.com.datastructure.stack;

import main.java.com.datastructure.linked.singly.base.SinglyLinkedNode;

/**
 * @Description: 动态栈（链表）
 * @ClassName: MyLinkedStack
 * @Author: yuexx
 * @Date: 2019/4/11 15:28
 * @Version: 1.0
 */
public class MyLinkedStack {
    public SinglyLinkedNode stackTop;
    public SinglyLinkedNode stackBottom;

    public MyLinkedStack(SinglyLinkedNode stackTop, SinglyLinkedNode stackBottom) {
        this.stackTop = stackTop;
        this.stackBottom = stackBottom;
    }

    /**
     * 进栈
     * @param myLinkedStack
     * @param value
     */
    public static void pushStack(MyLinkedStack myLinkedStack, int value){
        SinglyLinkedNode node = new SinglyLinkedNode(value);
        node.next = myLinkedStack.stackTop;
        myLinkedStack.stackTop = node;
    }

    /**
     * 遍历
     * @param myLinkedStack
     */
    public static void traverse(MyLinkedStack myLinkedStack){
        SinglyLinkedNode stackTop1 = myLinkedStack.stackTop;
        while ( stackTop1 != myLinkedStack.stackBottom){
            System.out.print(stackTop1.value + " ");
            stackTop1 = stackTop1.next;
        }
        System.out.println();
    }

    /**
     * 判断这个栈是否为空
     * @param myLinkedStack
     * @return
     */
    public static boolean isEmpty(MyLinkedStack myLinkedStack){
      if(myLinkedStack.stackTop == myLinkedStack.stackBottom){ return true;}
      return false;
    }

    /**
     * 出栈
     * @param myLinkedStack
     * @return
     */
    public static SinglyLinkedNode popStack(MyLinkedStack myLinkedStack){
        //栈不能为空
        if(!isEmpty(myLinkedStack)){
            SinglyLinkedNode stackTop1 = myLinkedStack.stackTop;
            myLinkedStack.stackTop = stackTop1.next;
//            System.out.println(stackTop1.value);
            return stackTop1;
        }
        return null;
    }

    /**
     * 清空栈
     * @param myLinkedStack
     * @return
     */
    public static void cleatStack(MyLinkedStack myLinkedStack){
        myLinkedStack.stackTop = null;
        myLinkedStack.stackBottom = null;
    }




}
