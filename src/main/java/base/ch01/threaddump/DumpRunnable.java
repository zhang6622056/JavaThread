package base.ch01.threaddump;

/**
 * Created by admin on 2018-09-26.
 */
public class DumpRunnable implements Runnable{

    private Integer a = 0;


    /***
     * 锁住共享实例对象.每个线程执行+1
     * 休眠2s，查看其它线程的状态
     */
    @Override
    public void run() {
        synchronized (this){
            a = a+1;
            try {
                Thread.currentThread().sleep(2000L);
                System.out.println("thread name:"+Thread.currentThread().getName()+",a的值："+a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
