package kg.db;

import kg.entity.User;
import kg.util.HibernateUtil;
import org.graalvm.compiler.lir.LIRInstruction;
import org.hibernate.Session;

import java.util.List;

public class UserDB {
    public static List<User> getAllOrderByName() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("FROM kg.entity.User order by nick DESC ", User.class).list(); //HQL
        session.close();
        return users;
    }

    public static Integer getIdMaxPost() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer id = (Integer) session.createQuery("select User.id from User order by postList.size desc ").getSingleResult();
        session.close();
        return id;
    }

    public  static Integer getIdMaxLikedNum(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer id = (Integer) session.createQuery("select User.id from User order by likedNumber desc ").getSingleResult();
        session.close();
        return id;
    }



}
