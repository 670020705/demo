import java.util.concurrent.TimeUnit;

public class Demo1 {

    String s1 = "hello";
    String s2 = "hello";

    public void test1(){
        synchronized (s1){
            System.out.println("t1 start...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end...");
        }
    }

    public void test2(){
        synchronized (s2){
            System.out.println("t2 start...");
        }
    }

    public static void main(String[] args) {

        Demo1 demo1 = new Demo1();
        new Thread(demo1::test1,"test1").start();
        new Thread(demo1::test2,"test2").start();

    }
}
