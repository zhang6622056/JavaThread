package base.contextswitching;

/**
 * 测试串行和并行的性能开销,主要为上下文数据指标
 *
 * Created by 止水 on 2018-09-26.
 */
public class CurrencyTest {

    private static final long count = 10001;

    public static void main(String[] args) {
        try {
            concurrency();
            serial();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /****
     * 并行执行
     * @throws InterruptedException
     */
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for(long i = 0 ; i < count ; i++){
                    a += 5;
                }
            }
        });
        thread.start();

        int b = 0;
        for(long i = 0 ; i < count; i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;


        //使得主线程等待子线程执行完毕再继续执行
        thread.join();
        System.out.println("concurrency:"+time+"ms,b="+b);
    }



    private static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;

        for(long i = 0 ; i < count ; i++){
            a += 5;
        }

        int b = 0;
        for(long i = 0 ; i < count ; i++){
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:"+time+"ms,b:"+b);
    }













}
