package base.lifecycle;

/**
 * Created by admin on 2018-09-24.
 */
public class JoinThread extends Thread{


    @Override
    public void run() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("this is join thread....");
    }
}
