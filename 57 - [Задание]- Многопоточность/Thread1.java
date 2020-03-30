public class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("working Thread1 => * ");
        Result.result *= 2;
    }
}
