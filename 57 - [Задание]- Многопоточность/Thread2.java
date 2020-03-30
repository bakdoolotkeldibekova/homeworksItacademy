public class Thread2 extends Thread {
    @Override
    public void run() {
        System.out.println("working Thread2 => / ");
        Result.result /= 2;
    }
}
