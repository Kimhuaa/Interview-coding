package org.feng.interview.threadprinter;

/**
 * @Description 双线程打印 1-100
 * @Author Zhu XueFeng
 * @Date 2024/8/23 11:05
 */
public class MultiThread01 {
    static volatile int max = 100; // 最大打印数字
    static int flag = 1; // 当前打印的数字
    static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> printer(0), "thread01").start();
        new Thread(() -> printer(1), "thread02").start();
    }

    private static void printer(int threadId) {
        while (flag <= max) {
            synchronized(lock) {
                while((flag - 1) % 2 != threadId) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (flag <= max) {
                    System.out.println(Thread.currentThread().getName() + " prints: " + flag);
                    flag++;
                    lock.notifyAll();
                }
            }
        }
    }
}
