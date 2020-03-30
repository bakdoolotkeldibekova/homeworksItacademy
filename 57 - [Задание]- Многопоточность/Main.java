public class Main {
    public static void main(String[] args) {
    
        System.out.println(Result.result);
    
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();
        Thread4 thread4 = new Thread4();
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        System.out.println(Result.result);
        
     }
 }
