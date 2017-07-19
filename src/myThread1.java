import java.io.*;

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

    public static int fibonacci(int index){
        if(index == 0) {
            return 0;
        }else if(index == 1){
            return 1;
        }else{
            return fibonacci(index-1) + fibonacci(index-2);
        }
    }

    public static void writeToFile(){
        FileWriter fw = null;
        try{
            try{
                fw = new FileWriter("demo.txt");
                fw.write("HelloWorld");
            }finally {
                fw.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void readFromFile(){
        FileReader fr = null;
        try {
            fr = new FileReader("demo.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int ch = 0;
        try {
            while((ch = fr.read()) != -1){
                System.out.println((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        writeToFile();
        readFromFile();
        myThread1 t = new myThread1();
        new Thread(t,"A").start();
        new Thread(t,"B").start();
        new Thread( () -> System.out.println("Java8")).start();
    }

}
