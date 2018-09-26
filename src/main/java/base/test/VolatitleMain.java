package base.test;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2018-09-21.
 */
public class VolatitleMain {





    public static void main(String[] args) throws InterruptedException {
        VolatileRunnale volatileRunnale = new VolatileRunnale();
        for (int i = 0 ; i < 1000; i++){
            new Thread(volatileRunnale).start();
            new Thread(volatileRunnale).start();
            new Thread(volatileRunnale).start();
        }

        Thread.sleep(3000L);
        System.out.println("int 型变量："+volatileRunnale.getA());
    }



}
