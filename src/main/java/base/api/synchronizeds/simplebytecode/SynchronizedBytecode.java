package base.api.synchronizeds.simplebytecode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * 从最简单入手JVM指令集
 * Created by nero on 2018-09-29.
 */
public class SynchronizedBytecode implements Runnable{
    private Map map;
    private static CountDownLatch countDownLatch = new CountDownLatch(2);


    private Map getMap(){
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized(this){
            System.out.println(Thread.currentThread().getName()+","+map);
            if(map == null){
                map = new HashMap<>();
            }
        }

        return map;
    }

    @Override
    public void run() {
        getMap();
    }


    public static void main(String[] args) {
        SynchronizedBytecode synchronizedBytecode = new SynchronizedBytecode();

        Hashtable hashtable = new Hashtable();


        Thread thread1 = new Thread(synchronizedBytecode);
        Thread thread2 = new Thread(synchronizedBytecode);
        thread1.start();
        thread2.start();
        countDownLatch.countDown();
        try {
            Thread.sleep(1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }


}
