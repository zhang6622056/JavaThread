package base.ch03lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable{

    private static final Lock lock = new ReentrantLock();
    private int count;


    public void run() {
        try{
            lock.lock();    //独占获取锁
            count = count+1;
            System.out.println("thread name:"+Thread.currentThread().getName()+",Count:"+count);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        LockTest lockRunnable = new LockTest();

        for (int i = 0 ; i < 10000 ; i++){
            new Thread(lockRunnable).start();
            new Thread(lockRunnable).start();
            new Thread(lockRunnable).start();
            new Thread(lockRunnable).start();
            new Thread(lockRunnable).start();
            new Thread(lockRunnable).start();
            new Thread(lockRunnable).start();
            new Thread(lockRunnable).start();
            new Thread(lockRunnable).start();
            new Thread(lockRunnable).start();
        }
    }


}
