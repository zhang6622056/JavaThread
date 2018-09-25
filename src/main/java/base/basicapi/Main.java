package base.basicapi;

/**
 * Created by admin on 2018-09-24.
 */
public class Main {


    public static void main(String[] args) {
        for(int i = 0 ; i < 100 ;i++){
            Thread a = new Thread();
            a.start();
            System.out.println("welcome main...");
        }
        System.out.println("----------------------");
    }

}
