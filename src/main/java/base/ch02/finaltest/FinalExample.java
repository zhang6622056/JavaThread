package base.ch02.finaltest;

/**
 * -禁止把final域的写重排序到构造函数之外   finalField = 1;不能在构造函数之外。
 * (就是说，你在对象外面读取到这个对象时，final域已经完成赋值)
 *
 * -在一个线程中，初次读对象引用于初次读该对象包含final属性引用。不可重排序
 * -final域读案例存在依赖关系，但某些CPU还是不会遵守，所以
 *
 * Created by Nero on 2018-09-27.
 */
public class FinalExample {

    int norml;
    final int finalField;    //final 变量
    static FinalExample obj;

    public FinalExample(){
        norml = 2;      //写普通域
        finalField = 1;          //final域变量写入
        //storestore屏障
        //return
    }


    public static void writer(){        //写线程A执行
        obj = new FinalExample();
    }


    public static void reader(){        //读线程B执行
        FinalExample object = obj;  //读对象引用
        int a = object.norml;       //读普通域
        //readread
        int b = object.finalField;  //读final域
    }







}
