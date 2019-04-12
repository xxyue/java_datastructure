package test.java.com.datastructure.stack.example;

import main.java.com.datastructure.stack.example.TwoStack4OneQueue;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @Description: ${description}
 * @ClassName: TwoStack4OneQueueTest
 * @Author: yuexx
 * @Date: 2019/4/12 10:48
 * @Version: 1.0
 */
public class TwoStack4OneQueueTest {

    TwoStack4OneQueue queue = new TwoStack4OneQueue(new Stack<Integer>(), new Stack<Integer>());

    @Before
    public void setUp() throws Exception {
        queue.add(1);
        queue.add(2);
        queue.add(3);
    }

    @Test
    public void add() {

    }

    @Test
    public void pop() {
        Integer integer = queue.pop();
        assertEquals(1, integer.intValue());
        integer = queue.pop();
        assertEquals(2, integer.intValue());
        integer = queue.pop();
        assertEquals(3, integer.intValue());
//        queue.pop();

    }

    @Test
    public void peek() {
        Integer integer = queue.peek();
        assertEquals(1, integer.intValue());
        integer = queue.peek();
        assertEquals(1, integer.intValue());
    }
}