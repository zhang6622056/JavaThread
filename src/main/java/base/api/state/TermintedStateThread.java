package base.api.state;

/**
 * 线程TERMINTED 状态演示
 *
 * Created by Nero on 2018-09-29.
 */
public class TermintedStateThread extends Thread{


    /****
     * 终结态
     */
    @Override
    public void run() {
        System.out.println("for terminated");
    }


    /****
     * 终结态
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread th = new TermintedStateThread();
        th.start();
        th.join();  //等待TH线程执行完毕
        System.out.println(th.getState());
    }




}
