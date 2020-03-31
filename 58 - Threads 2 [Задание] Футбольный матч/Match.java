import java.util.Random;

public class Match implements Runnable {
    Random rand = new Random();
    @Override
    public void run(){
        if (Thread.currentThread().getName().equals("Team1")){
            Scoring.goalTeam1 = rand.nextInt(15);
            Scoring.yellowCardTeam1 = rand.nextInt(15);
            Scoring.offsideTeam1 = rand.nextInt(15);

            System.out.println("команда:" + Thread.currentThread().getName() + " забила гол = " + Scoring.goalTeam1);
            System.out.println("игрок " + Scoring.yellowCardTeam1 + " команды:" + Thread.currentThread().getName() + " полчает желтую карточку.");
            System.out.println("команда:" + Thread.currentThread().getName() + " оффсайд = " + Scoring.offsideTeam1);
        }else if(Thread.currentThread().getName().equals("Team2")){
            Scoring.goalTeam2 = rand.nextInt(15);
            Scoring.yellowCardTeam2 = rand.nextInt(15);
            Scoring.offsideTeam2 = rand.nextInt(15);

            System.out.println("команда:" + Thread.currentThread().getName() + " забила гол = " + Scoring.goalTeam2);
            System.out.println("игрок " + Scoring.yellowCardTeam2 + " команды:" + Thread.currentThread().getName() + " полчает желтую карточку.");
            System.out.println("команда:" + Thread.currentThread().getName() + " оффсайд = " + Scoring.offsideTeam2);
        }else{
            System.out.println("такая команда не зарегистрирована!");
        }

    }
}
