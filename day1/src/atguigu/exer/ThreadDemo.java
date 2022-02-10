package atguigu.exer;

/**
 * eg：创建两个线程：一个遍历100以内的偶数，一个遍历100以内奇数；
 */
class Thread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(i+"**");
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        t1.start();
        Thread2 t2 = new Thread2();
        t2.start();
    }
}
