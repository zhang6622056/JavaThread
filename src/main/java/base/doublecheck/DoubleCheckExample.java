package base.doublecheck;

/**
 * 双重锁定案例......
 *
 *
 * Created by admin on 2018-09-28.
 */
public class DoubleCheckExample {

    private static DoubleCheckExample instance;


    /****
     * 此案例，在多线程的情况下将可能被多次初始化。
     * 线程A判断instance为空，进行初始化， 线程B同样进行如下操作。
     * 那么instance被new多次对象，指向内存地址不一定
     *
     * @return
     */
/*    public static DoubleCheckExample getInstance(){
        if(instance == null){
            instance = new DoubleCheckExample();
        }
        return instance;
    }*/


    /***
     *
     * @return
     */
    public static DoubleCheckExample getInstance(){
        if(instance == null){
            //为了保证尽可能小的锁力度，我们将锁代码块加到如下位置

            synchronized (DoubleCheckExample.class){
                instance = new DoubleCheckExample();
            }

        }
        return instance;
    }






}
