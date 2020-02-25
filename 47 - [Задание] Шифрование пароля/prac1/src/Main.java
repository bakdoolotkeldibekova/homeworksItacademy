import db.DbWorker;
import db.UserDb;
import db.UserLogDb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserDb userDb = new UserDb();
        UserLogDb userLogDb = new UserLogDb();
        Scanner scanner = new Scanner(System.in);

        System.out.print("login: ");
        String login = scanner.nextLine();
        System.out.print("password: ");
        String password = scanner.nextLine();

        int userId = userDb.indexOfUser(login);
        boolean resultOfAuth = userDb.authorize(login, password);
        if(userId >= 0) {
            userLogDb.insertUserLog(userId, resultOfAuth);
            if(resultOfAuth) System.out.println("Вы успешно вошли!");
            else System.out.println("Неверный логин/пароль");
        }
        else System.out.println("Неверный логин/пароль");

        //userDb.registerUser("user1", "1234", "user@mail.com");
        //System.out.println(userDb.authorize("user11", "1234"));
        //userLogDb.insertUserLog(1, true);
    }
}
