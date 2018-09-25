package base.lifecycle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by admin on 2018-09-24.
 */
public class ThreadLife extends Thread{

    @Override
    public void run() {

        System.out.println("run方法内的线程状态："+Thread.currentThread().getState().toString());
        File f = new File("D://book/JAVAJDKAPI17.zip");

        JoinThread b = new JoinThread();
        try {
            b.join();
            System.out.println("join后状态："+Thread.currentThread().getState().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
