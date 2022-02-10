package atguigu.java;

/**
 *eg:创建三个窗口卖票，总票数为一百，使用Runnable（）方法实现
 */
class windows1 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket--;
            }else{
                break;
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
