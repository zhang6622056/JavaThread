package base.doublecheck;

/**
 * 双重锁定案例......
 * <p>
 * <p>
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
     *  double check 错误理解.
     *  线程AB同时进入方法，线程A获取锁
     *
     *  一个线程争抢到锁，并且进入逻辑执行，
     *  持有锁线程执行逻辑。
     *  但最后一步   instance = new DoubleCheckExample(); 并非原子操作，并且可能进行重排序
     *  如果指令重排序，那么很有可能对象引用先于对象初始化。
     *  如此第二个线程进入判定，依然为空
     *
     *  解决方案-使得相应new对象为volatile对象，禁止重排序。插入相关内存屏障，保证原子性，可见性，执行顺序
     * @return
     */
    public static DoubleCheckExample getInstance() {
        if (instance == null) {
            //线程AB同时到此
            synchronized (DoubleCheckExample.class) {
                //一个线程持有，执行完毕。
                if (instance == null) {
                    instance = new DoubleCheckExample();
                }
            }
        }
        return instance;
    }


}
