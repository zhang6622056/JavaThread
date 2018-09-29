package base.api.interrupt;

/**
 * 什么是中断?
 *
 *
 *
 *
 *
 * Created by Nero on 2018-09-29.
 */
public class InterruptExample {



    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(),"sleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(),"busyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();
        Thread.sleep(5000L);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("sleep Thread interrupt state:"+sleepThread.isInterrupted());
        System.out.println("busy Thread interrupt state:"+busyThread.isInterrupted());

        Thread.sleep(5000000L);

    }








    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while(true){
                try {
                    Thread.currentThread().sleep(3000l);
                    System.out.println("name:"+Thread.currentThread().getName()+"................");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while(true){
                if(Thread.currentThread().isInterrupted()){
                    try {
                        System.out.println("我中断了，但是我要继续执行！！");
                        Thread.sleep(200l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }













}
