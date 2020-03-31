public class Main {
    public static void main(String[] args) {

        Thread team1 = new Thread(new Match(), "Team1");
        Thread team2 = new Thread(new Match(), "Team2");

        team1.start();
        team2.start();

        if (Scoring.goalTeam1 > Scoring.goalTeam2)
            System.out.println("выиграла команда:" + team1.getName());
        else if(Scoring.goalTeam1 < Scoring.goalTeam2)
            System.out.println("выиграла команда:" + team2.getName());
        else
            System.out.println("ничья!");

    }
}
