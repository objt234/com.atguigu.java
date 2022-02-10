package atguigu.java;

/**
 *测试Thread中的常用方法：
 * 1、start（）：
 * 2、run（）：
 * 3、currentThread（）：返回 当前代码执行的线程
 * 4、getName（）：获取当前线程是名字
 * 5、setName（）：设置当前线程的名字
 *   也可以通过构造器构造给线程设置名字
 * 6、yield（）：释放当前cpu的执行权（有可能释放之后又是执行它）
 * 7、join（）：在线程a中调用线程b的join方法，此时线程a阻塞，直到线程b结束，结束阻塞状态
 * 8、stop（）：线程强制结束（过时，不建议使用）
 * 9、sleep（Long millitime）：让当前线程睡眠millitime毫秒，在millitime时间内，线程阻塞
 * 10、isAlive（）：判断当前线程是否存活
 *
 *
 * 线程的优先级
 * MAX_PRIORITY:10
 * MIN_PRIORITY:1
 * NORM_PRIORITY:5->默认的优先级
 * 2、如何获取和设置当前线程的优先级
 * getPriority（）：获取当前线程的优先级
 * setPriority（int p）：设置线程的优先级
 *说明：高优先级的线程要抢占低优先线程cpu的执行权，但是只是从概率上讲，
 * 高优先级的线程高概率的情况下被执行，并不意味着只有当高优先级线程执行
 * 完之后，低优先级的线程才能执行
 *
 */
class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
//                try {
//                    sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(getName() + ":"+Thread.currentThread().getPriority() + ":" + i);
            }
            if(i % 20 == 0){
                yield();
            }
        }
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        helloThread.setName("线程1");
        //设置分线程的优先级
        helloThread.setPriority(Thread.MAX_PRIORITY);

        helloThread.start();
        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ";" +Thread.currentThread().getPriority()+":"+ i);
            }
            if(i == 20){
                try {
                    helloThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(helloThread.isAlive());
    }
}
