public class Thread3 extends Thread {
    @Override
    public void run() {
        System.out.println("working Thread3 => + ");
        Result.result += 2;
    }
}
