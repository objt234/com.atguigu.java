package atguigu.java;

/**
 *多线程的创建方法：继承-》重写run-》创建对象-》start
 * 1、继承于Thread类
 * eg：遍历100以内的偶数
 * 注意：不能通过调用run方法来启动线程，只能用start。
 */
//创建一个继承于Thread的子内
class MyThread extends Thread{
    //重写Thread中的run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //创建Thread子类的对象
        MyThread t1 = new MyThread();
        //通过对象调用start（）；
        t1.start();//使线程开始执行（启动当前线程；调用当前线程的run方法）

        //如下的方法任然在主线程执行main；
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i + "**");
            }
        }
    }
}
