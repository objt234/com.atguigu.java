package com.atguigu.java;

/**
 *eg:创建三个窗口卖票，总票数为一百，使用Runnable（）方法实现
 *
 * 1、问题：卖票过程中，出现了重票、错票 --》出现了线程的安全问题
 * 2、原因：当某个线程操作车票的过程中，尚未操作完成时，其他的线程参与
 * 3、解决：一个线程再操作时，限制其他的线程，使之无法参与操作
 * 4、在java中，通过同步机制解决线程的安全问题。
 *    方式一：同步代码块(局限性：只能有一个线程参与)
 *
 *    synchronized（this同步监视器）{
 *        //需要被同步的代码
 *    }
 *    说明：1、操作共享数据的代码，即为需要被同步的代码
 *         2、同步监视器，俗称：锁。任何一个类的对象都可以充当锁
 *         //object obj（this）
 *         要求：多个线程必须用同一把锁
 *
 *    方式二：同步方法
 *    如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的
 *
 */
class windows1 implements Runnable{
    private int ticket = 100;
    //Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        windows1 windows1 = new windows1();

        Thread t1 = new Thread(windows1);
        Thread t2 = new Thread(windows1);
        Thread t3 = new Thread(windows1);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
