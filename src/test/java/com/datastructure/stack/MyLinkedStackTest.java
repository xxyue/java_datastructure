package test.java.com.datastructure.stack;


import main.java.com.datastructure.linked.singly.base.SinglyLinkedNode;
import main.java.com.datastructure.stack.base.MyLinkedStack;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @Description: ${description}
 * @ClassName: MyLinkedStackTest
 * @Author: yuexx
 * @Date: 2019/4/11 15:54
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class MyLinkedStackTest {
    MyLinkedStack myLinkedStack = new MyLinkedStack(new SinglyLinkedNode(0),new SinglyLinkedNode(0));

    @Before
    public void setUp() throws Exception {
        myLinkedStack.stackBottom = myLinkedStack.stackTop;
    }

    @Test
    public void isEmpty() {
        boolean falg = MyLinkedStack.isEmpty(myLinkedStack);
        assertTrue(falg);
        System.out.println("falg : " + falg);
    }

    @Test
    public void pushStack() {
        MyLinkedStack.pushStack(myLinkedStack, 1);
        boolean falg = MyLinkedStack.isEmpty(myLinkedStack);
        assertFalse(falg);
        System.out.println("falg : " + falg);
        MyLinkedStack.pushStack(myLinkedStack, 2);
        MyLinkedStack.pushStack(myLinkedStack, 3);
        MyLinkedStack.traverse(myLinkedStack);//预期结果 3 2 1
        falg = MyLinkedStack.isEmpty(myLinkedStack);
        assertFalse(falg);
        System.out.println("falg : " + falg);
    }

    @Test
    public void traverse() {
        MyLinkedStack.pushStack(myLinkedStack, 1);
        MyLinkedStack.pushStack(myLinkedStack, 2);
        MyLinkedStack.pushStack(myLinkedStack, 3);
        MyLinkedStack.traverse(myLinkedStack);//预期结果 3 2 1
    }



    @Test
    public void popStack() {
        MyLinkedStack.pushStack(myLinkedStack, 1);
        MyLinkedStack.pushStack(myLinkedStack, 2);
        MyLinkedStack.pushStack(myLinkedStack, 3);
        MyLinkedStack.traverse(myLinkedStack);//预期结果 3 2 1
        SinglyLinkedNode stackTop1 = MyLinkedStack.popStack(myLinkedStack);//预期结果 3 2 1
        assertEquals(3, stackTop1.value);
        MyLinkedStack.traverse(myLinkedStack);//预期结果 2 1

    }

    @Test
    public void cleatStack() {
        MyLinkedStack.pushStack(myLinkedStack, 1);
        MyLinkedStack.pushStack(myLinkedStack, 2);
        MyLinkedStack.pushStack(myLinkedStack, 3);
        boolean falg = MyLinkedStack.isEmpty(myLinkedStack);
        assertFalse(falg);
        MyLinkedStack.cleatStack(myLinkedStack);
        falg = MyLinkedStack.isEmpty(myLinkedStack);
        assertTrue(falg);
    }
}
