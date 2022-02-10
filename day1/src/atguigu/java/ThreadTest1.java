package atguigu.java;

/**
 *创建多线程的方式二：实现Runnable接口（共享数据）
 *
 * 比较两种方式：（继承和接口）
 *   开发中优先选择实现Runnable接口的方式
 *   原因：实现的方式没有类的单继承性的局限性
 *       实现的方式更适合来处理多个线程有共享数据的情况
 *
 */
//1、创建一个实现了Runnable接口的类
class MThread implements Runnable{
//实现类去实现Runnable中的抽线方法Run（）
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 ==0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        //3、创建实现类的参数
        MThread mThread = new MThread();
        //4、将此对象作为参数传递到Thread类的构造器中，创建Thread的类的对象
        Thread thread = new Thread(mThread);
        thread.setName("线程1");
        //5、通过Thread类的对象调用start（）：启动线程；调用当前线程的run（）。
        thread.start();
        //再创建一个线程
        Thread thread1 = new Thread(mThread);
        thread1.setName("线程2");
        thread1.start();
    }
}
