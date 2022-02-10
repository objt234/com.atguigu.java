package com.atguigu.java2;

/**
 *线程通信的例子：使用两个线程打印1-100.线程1，线程2交替打印
 *
 * 涉及到的三个方法：
 * wait（）：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify（）：一旦执行此方法，就会唤醒wait的一个线程，如果有多个线程，就会唤醒优先级高的
 * notifyAll（）：一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * 三个方法在java.lang.Object类中
 *
 * 面试题：sleep（）和wait（）的异同？
 * 1、相同点：一旦执行此方法，都可以使当前线程进入阻塞状态。
 * 2、不同点：1）两个方法声明的位置不同：Thread类中声明sleep（）；Object类中声明wait（）
 *          2）调用的要求不同：sleep（）在任何场景都能使用。wait（）必须在同步代码块使用
 *          3）对于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep（）
 *            不会释放锁，wait会释放。
 *
 */
class Number implements Runnable{
    private int num = 1;
    @Override
    public void run() {
        synchronized (this){
            //
            notify();
            while(true){
                if(num <= 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                }else{
                    break;
                }
            }
            //
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number n1 = new Number();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
