package org.feng.interview.blockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 通过 Lock + Condition 定制阻塞队列，实现生产者-消费者模型
 * @Author Zhu XueFeng
 * @Date 2024/8/23 11:13
 */
public class MyBlockingQueue {
    private final int maxSize; // 队列容量为 maxSize
    private final Queue<Integer> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public MyBlockingQueue(int maxSize){
        this.maxSize = maxSize;
    }

    // 生产
    private void add(int num) {
        lock.lock(); // 加锁
        try {
            while (queue.size() == maxSize) {
                try {
                    notFull.await(); // 队列满时，等待notFull条件
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(num); // 添加物品
            notEmpty.signalAll();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    // 消费
    private int take() {
        lock.lock(); // 加锁
        try {
            while (queue.isEmpty()) {
                try {
                    notEmpty.await(); // 队列空时，等待notEmpty条件
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int item = queue.poll(); // 取出物品
            notFull.signal();
            return item;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue myQueue = new MyBlockingQueue(5);
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myQueue.add(i);
                System.out.println("Produced: " + i);
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                int item = myQueue.take();
                System.out.println("Consumed: " + item);
            }
        });
        producer.start();
        consumer.start();
    }
}
