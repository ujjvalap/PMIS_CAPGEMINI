
class Test implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {

        Test obj = new Test();

        Thread t1 = new Thread(obj);
        t1.start();
    }
}
