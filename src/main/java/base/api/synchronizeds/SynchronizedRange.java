package base.api.synchronizeds;

/**
 * synchronized锁范围案例
 *
 * -静态方法，锁class对象
 * -普通方法，锁实例对象
 * -代码块，锁相应括号内对象
 *
 * -谨记代码块案例，锁对象不能在锁内部执行写逻辑
 * Created by Nero on 2018-09-29.
 */
public class SynchronizedRange {
    static class RangeLock implements Runnable{
        public Integer forlock = 1;
        public static Integer count = 0;

        @Override
        public void run() {
            //lockOnStaticMethod();   //静态方法，锁定class对象
            lockOnNormlMethod();   //普通方法，锁定实例对象
            //lockOnBlock();          //代码块，锁定同步块内对象
        }

        private synchronized static void lockOnStaticMethod(){  //锁定class对象
            count = count + 1;
        }

        private synchronized void lockOnNormlMethod(){      //锁定实例对象
            count = count+1;
        }


        private void lockOnBlock(){     //锁定代码块括号内对象
            synchronized (forlock){
                count = count + 1;
            }
            //错误案例，代码块内不要操作锁对象，否则对象指针变动，锁提前失效
//            synchronized (count){
//                count = count + 1;
//            }
        }




    }


    /****
     * 计数器累计相加
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        RangeLock rangeLock = new RangeLock();

        for(int i = 0 ; i < 1000 ; i++){
            new Thread(rangeLock).start();
            new Thread(rangeLock).start();
            new Thread(rangeLock).start();
        }

        Thread.sleep(1000l);    //等待其他线程时间片轮转完毕
        System.out.println(rangeLock.count);
    }













}
