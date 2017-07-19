import java.io.File;

/**
 * Created by Demi on 2017/4/28.
 */
public class myThread1 implements Runnable{
    private  int books = 5;

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            if(this.books > 0){
                System.out.println("thread " + Thread.currentThread().getName() + " Sell : Left " + (--this.books));
            }
        }
    }

    public static void main(String[] args){
        myThread1 t = new myThread1();
        new Thread(t,"A").start();
        new Thread(t,"B").start();
        new Thread( () -> System.out.println("Java8")).start();
    }

}
