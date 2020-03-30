public class Thread4 extends Thread {
    @Override
    public void run() {
        System.out.println("working Thread4 => - ");
        Result.result -= 2;
    }
}
