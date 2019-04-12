package main.java.com.datastructure.queue.base;

/**
 * @Description: ${description}
 * @ClassName: MyArrayQueue
 * @Author: yuexx
 * @Date: 2019/4/11 17:41
 * @Version: 1.0
 */
public class MyArrayQueue {
    public int[] array;
    public int front;//指向第一个有效元素
    public int rear;//指向最后一个有效元素的下一个元素（无效元素）

    public MyArrayQueue(int[] array, int front, int rear) {
        this.array = array;
        this.front = front;
        this.rear = rear;
    }

    /**
     * 判断是否已满
     * @param myArrayQueue
     * @return
     */
    public static boolean isFull(MyArrayQueue myArrayQueue){
        if((myArrayQueue.rear + 1) % myArrayQueue.array.length == myArrayQueue.front){
            return true;
        }
        return  false;

    }

    /**
     * 判断是否空
     * @param myArrayQueue
     * @return
     */
    public static boolean isEmpty(MyArrayQueue myArrayQueue){
        if(myArrayQueue.rear == myArrayQueue.front){
            return true;
        }
        return  false;
    }

    /**
     * 入队
     * @param myArrayQueue
     * @param value
     * @return
     */
    public static boolean enQueue(MyArrayQueue myArrayQueue, int value){
        if(!isFull(myArrayQueue)){
            myArrayQueue.array[myArrayQueue.rear] = value;
            myArrayQueue.rear = (myArrayQueue.rear +1) % myArrayQueue.array.length;
            return true;
        }
        return false;
    }

    /**
     * 遍历
     * @param myArrayQueue
     * @return
     */
    public static void traverse(MyArrayQueue myArrayQueue){
       int i = myArrayQueue.front;
       while (i != myArrayQueue.rear){
           System.out.print(myArrayQueue.array[i] + " ");
           i = (i + 1) % myArrayQueue.array.length;
       }
       System.out.println();
    }

    /**
     * 出队
     * @param myArrayQueue
     * @return
     */
    public static Integer outQueue(MyArrayQueue myArrayQueue){
        if(!isEmpty(myArrayQueue)){
            int value = myArrayQueue.array[myArrayQueue.front];
            myArrayQueue.front = (myArrayQueue.front + 1) % myArrayQueue.array.length;
            return value;
        }
        return null;
    }

}
