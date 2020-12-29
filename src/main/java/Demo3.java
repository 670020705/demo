import java.util.ArrayList;
import java.util.List;
//备注1
public class Demo3 {
    volatile int count = 0;

    public void test(){
        for(int i=0;i<10000;i++){
            count++;
        }
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();

        List<Thread> threads = new ArrayList<>();

        for(int i=0;i<10;i++){
            threads.add(new Thread(demo3::test,"thread-"+i));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        System.out.println(demo3.count);
    }
}
