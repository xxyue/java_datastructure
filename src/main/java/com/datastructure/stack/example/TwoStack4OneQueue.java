package main.java.com.datastructure.stack.example;

import java.util.Stack;

/**
 * @Description: 两个栈实现一个队列  （ 直接使用jdk 中的stack ）
 *      必须实现两个点：
 *      1.如果stackPush 要往stackPop中压数据，必须一次性把stackPush 中的数据全部要入
 *      2.如果stackPop不为空，stackPush绝不能想stackPop中压入数据
 * @ClassName: TwoStack4OneQueue
 * @Author: yuexx
 * @Date: 2019/4/11 18:17
 * @Version: 1.0
 */
public class TwoStack4OneQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStack4OneQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    /**
     * 队列添加
     * @param value
     * @return
     */
    public Integer add(Integer value){
        stackPush.push(value);
        return value;

    }

    /**
     * 获取队列数据
     * 拿到元素，并弹出改元素
     * @return
     */
    public Integer pop(){
        if (stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("Queue is empty");
        } else if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();//拿到元素，并弹出改元素
    }

    /**
     * 获取队列数据
     * 不弹出该元素
     * @return
     */
    public Integer peek(){
        if (stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("Queue is empty");
        } else if(stackPop.isEmpty()){//只有stackPop 为空在一次性压入
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }


}
