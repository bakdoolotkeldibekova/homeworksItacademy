package kg.db;

import kg.entity.Post;
import kg.entity.User;
import kg.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class PostDB {
    public  static Integer getIdMaxLike(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer id = (Integer) session.createQuery("select Post.id from Post order by postLikes.size desc ").getSingleResult();
        session.close();
        return id;
    }

    public static List<Post> getAllOrderByDate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Post> posts = session.createQuery("FROM Post order by nick DESC ", User.class).list(); //HQL
        session.close();
        return users;
    }
}
