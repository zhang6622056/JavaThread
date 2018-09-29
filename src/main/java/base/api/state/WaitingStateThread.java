package base.api.state;

/**
 * WAITING和TIME_WAITING 状态演示
 *
 * WAITING 永久等待，直到被notify或interrupt
 * TIME_WAITING   参数指定等待时长
 *
 *
 * Created by Nero on 2018-09-29.
 */
public class WaitingStateThread extends Thread{

    @Override
    public void run() {
        try {
            synchronized (this){
                wait();         //WAITING需在monitor中进行，否则将报IllegalMonitorStateException
                //wait(500L);    //TIMEWAITING
            }
        } catch (InterruptedException e) {
            System.out.println("捕获中断异常，但我就不处理!");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        WaitingStateThread th = new WaitingStateThread();
        th.start();
        Thread.sleep(500l); //使得wait线程充分运行
        System.out.println(th.getState());
    }
}
