package base.ch01.threaddump;

/**
 * jstack dump线程进行分析的测试类
 *
 *
 * Created by admin on 2018-09-26.
 */
public class DumpMain {







    /****
     * -查看进程号：ps -ef | grep java
     * -导出线程dump：jstack 4276 > /threaddump1      4276 为对应的java进程
     * -grep java.lang.Thread.State threaddump1 | awk '{print $2$3$4%5}' | sort | uniq -c    grep   awk    sort    uniq 统计相关线程状态
     *
     *
     * 主线程建立3000个子线程，依次锁在对象锁之外。
     * 通过jstack dump查看相关信息
     * web容器类似于 jboss或tomcat也可以用jstack的分析工具
     * @param args
     */
    public static void main(String[] args) {
        DumpRunnable dumpRunnable =  new DumpRunnable();
        for(int i = 0 ; i < 3000; i++){
            new Thread(dumpRunnable).start();
        }
    }



}
