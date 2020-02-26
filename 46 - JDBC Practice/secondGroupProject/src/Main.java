import db.CourseDb;
import db.DbWorker;
import db.GroupDb;
import db.StudentDb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DbWorker dbWorker = new DbWorker();
        StudentDb studentDb = new StudentDb();
        GroupDb groupDb = new GroupDb();
        Scanner scanner = new Scanner(System.in);

//        int group_id = 8;
//        if(dbWorker.getNumberOfStudent(group_id) < 15){
//            studentDb.insertStudent("Aliman", group_id);
//        }
//        else{
//            System.out.println("sorry! could not add, more than 15 students in this group");
//        }

//        CourseDb courseDb = new CourseDb();
//        courseDb.showCourses();

        //groupDb.insertGroup("JavaBE2", 1, 3, 9, 2000);

        groupDb.showTop3Groups(1);

    }
}
