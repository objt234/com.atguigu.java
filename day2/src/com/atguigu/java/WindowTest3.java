package com.atguigu.java;

/**
 *eg:创建三个窗口卖票，总票数为一百，使用Runnable（）方法实现
 *
 * 同步方法解决Runnable的线程安全问题
 */
class Window3 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            show();
        }
    }
    private synchronized void show(){
        if (ticket > 0){
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
            ticket--;
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 window3 = new Window3();
        Thread thread1 = new Thread(window3);
        Thread thread2 = new Thread(window3);
        Thread thread3 = new Thread(window3);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
