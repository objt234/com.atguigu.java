package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 *解决线程安全问题的方式三：lock锁 ---jdk5.0新增
 *
 * 1、面试题：synchronized和lock的异同？
 * 相同点：二者都可以解决线程的安全问题
 * 不同点：synchronized机制在执行完相应的同步代码之后，自动的释放同步，Lock需要
 * 手动的启动和结束同步。
 *
 */
class Window implements Runnable{
    private int ticket = 100;
    //1、实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                //2、调用锁定方法Lock（）
                lock.lock();

                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                //3、调用解锁方法：unlock（）
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

