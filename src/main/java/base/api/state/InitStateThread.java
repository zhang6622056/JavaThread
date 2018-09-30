package base.api.state;

/**
 * 演示以下3种状态
 * NEW
 * RUNNABLE
 * BLOCK
 * Created by admin on 2018-09-29.
 */
public class InitStateThread extends Thread{

    @Override
    public void run() {
        synchronized (InitStateThread.class){
            while(true){        //永不释放锁

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InitStateThread firstStateThread = new InitStateThread();
        System.out.println(firstStateThread.getState());
        firstStateThread.start();
        System.out.println(firstStateThread.getState());

        //开启第二个线程争抢锁，但肯定争抢不到，于是进入BLOCK
        InitStateThread blockStateThread = new InitStateThread();
        blockStateThread.start();
        Thread.sleep(2000l);    //使得blockStateThread充分运行，争抢锁
        System.out.println(blockStateThread.getState());
    }














}
