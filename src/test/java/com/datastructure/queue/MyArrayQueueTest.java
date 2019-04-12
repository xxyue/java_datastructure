package test.java.com.datastructure.queue;


import main.java.com.datastructure.queue.base.MyArrayQueue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: MyArrayQueueTest
 * @Author: yuexx
 * @Date: 2019/4/11 18:01
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class MyArrayQueueTest {

    MyArrayQueue myArrayQueue = null;

    @Before
    public void setUp() throws Exception {
        myArrayQueue = new MyArrayQueue(new int[6],0,0);
    }

    @Test
    public void isEmpty() {
        boolean flage = MyArrayQueue.isEmpty(myArrayQueue);
        assertTrue(flage);
    }
    @Test
    public void isFull() {
        boolean flage = MyArrayQueue.isFull(myArrayQueue);
        assertFalse(flage);
    }



    @Test
    public void enQueue() {
        MyArrayQueue.enQueue(myArrayQueue,1);
        MyArrayQueue.enQueue(myArrayQueue,2);
        MyArrayQueue.enQueue(myArrayQueue,3);
        MyArrayQueue.enQueue(myArrayQueue,4);
        MyArrayQueue.enQueue(myArrayQueue,5);
        boolean flage = MyArrayQueue.isFull(myArrayQueue);//浪费了一位
        assertTrue(flage);
        MyArrayQueue.traverse(myArrayQueue);//预期 1 2 3 4 5

    }

    @Test
    public void traverse() {
        MyArrayQueue.enQueue(myArrayQueue,1);
        MyArrayQueue.enQueue(myArrayQueue,2);
        MyArrayQueue.enQueue(myArrayQueue,3);

        MyArrayQueue.traverse(myArrayQueue);//预期 1 2 3
    }

    @Test
    public void outQueue() {
        Integer integer = MyArrayQueue.outQueue(myArrayQueue);
        assertNull(integer);//为空时返回null
        MyArrayQueue.enQueue(myArrayQueue,1);
        MyArrayQueue.enQueue(myArrayQueue,2);
        MyArrayQueue.enQueue(myArrayQueue,3);
        MyArrayQueue.enQueue(myArrayQueue,4);
        MyArrayQueue.enQueue(myArrayQueue,5);
        MyArrayQueue.traverse(myArrayQueue);//预期 1 2 3 4 5
        integer = MyArrayQueue.outQueue(myArrayQueue);//先出先进
        assertEquals(1,integer.intValue() );
    }
}
