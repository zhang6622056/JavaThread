package base.ch02.finaltest;

/**
 * final域为引用类型的内存语义
 * 构造函数内对final域的写入，与构造函数外，把构造出来的对象赋值给某个引用变量，这两个操作不可以重排序，即1和3不可以重排序
 *
 *
 *
 * Created by 止水 on 2018-09-27.
 */
public class FinalReferenceExample {

    final int[] finalRefer;
    static FinalReferenceExample obj;

    public FinalReferenceExample(){
        finalRefer = new int[1];        //1...引用成员final域写入
        finalRefer[0] = 1;              // 2....final域引用的成员域的写入
        //storestore
        //return
    }


    public static void writerOne(){     //写线程A
        obj = new FinalReferenceExample();  // 3 构造函数外，引用赋值给某个对象
    }

    public static void writerTwo(){     //写线程B
        obj.finalRefer[0] = 2;
    }

    public static void reader(){        //读线程C
        if (null != obj){
            int temp = obj.finalRefer[0];
        }
    }
















}
