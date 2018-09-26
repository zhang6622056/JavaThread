package base.ch01.deadlock;

/**
 *
 * 死锁案例
 * 线程1等线程2释放A锁
 * 线程2等线程1释放B锁。
 * 互相等待，永远无法脱离block机制
 * 避免死锁的方法
 *
 * -避免一个线程同时获取多个锁，
 * -避免一个线程在锁内占用多个资源，尽量保证每个锁只占用一个资源
 * -尝试使用定时锁， lock.trylock(timeout) 来替代内部锁机制
 * -对于数据库锁，加锁和解锁必须在一个数据库连接里，否则会出现解锁失败的情况
 * Created by 止水 on 2018-09-26.
 */
public class DeadLockDemo {


    public static void main(String[] args) {
        //声明2个final对象用于锁。
        final String A = "a";
        final String B = "b";

       Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    System.out.println("threadName:"+Thread.currentThread().getName()+"__LOCK A");
                    try {
                        Thread.currentThread().sleep(2000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("threadName:"+Thread.currentThread().getName()+"__LOCK B");
                    }
                }
            }
        });


        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    System.out.println("threadName:"+Thread.currentThread().getName()+"__LOCK A");
                    try {
                        Thread.currentThread().sleep(2000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A){
                        System.out.println("threadName:"+Thread.currentThread().getName()+"__LOCK B");
                    }
                }
            }
        });

        //启动线程
        th1.start();
        th2.start();

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "线程1的状态："+th1.getState().toString());
        System.out.println( "线程2的状态："+th2.getState().toString());
    }
}
