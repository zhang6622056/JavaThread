package base.lifecycle;

/**
 * Created by admin on 2018-09-24.
 */
public class Main {


    public static void main(String[] args) {
        Thread thread = new ThreadLife();
        System.out.println("new以后的状态："+thread.getState().toString());
        thread.start();


        System.out.println("start以后的状态："+thread.getState().toString());
    }




}
