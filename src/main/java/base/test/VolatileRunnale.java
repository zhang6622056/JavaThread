package base.test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 止水 on 2018-09-21.
 */
public class VolatileRunnale implements Runnable{

    //volatile
    Integer a = 0;
    Integer b = 1;
    static final Random random = new Random();


    /****
     * 注意synchronized的范围，这里加在方法上肯定没有问题。
     * TODO-ZL 但是单个变量锁会有问题，目前还没有理解好synchronized范围。
     *
     */
//    @Override
//    public synchronized void run() {
//            //ticket = ticket + 1;
//            System.out.println("before add:"+a);
//            a = a + 1;
//            System.out.println("after add:"+a);
//    }


    @Override
    public void run() {
        /****
         *  同步this和同步方法是一样的效果
         */
        synchronized(this){
            System.out.println("before add:"+a);
            a = a + 1;
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("after add:"+a);
        }
    }


    /****
     * 错误示范案例
     * 锁定A对象有可能失败
     *
     */
//    @Override
//    public void run() {
//        /****
//         *  同步this和同步方法是一样的效果
//         *  更改完值之后，对象发生改变，锁被提前释放。所以锁不住
//         */
//        synchronized(a){
//            //更改完值之后，对象发生改变，锁被提前释放。所以锁不住
//            System.out.println("ThreadName:"+Thread.currentThread().getName()+"______________before add:"+System.identityHashCode(a));
//            a = a + 1;
//            try {
//                Thread.currentThread().sleep(2000l);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("ThreadName:"+Thread.currentThread().getName()+"______________after add:"+System.identityHashCode(a));
//        }
//    }




    private Long randomSleep(){
        return Long.valueOf(random.nextInt(1000));
    }

    public int getA(){
        System.out.println("线程名："+Thread.currentThread().getName());
        return a;
    }

}
