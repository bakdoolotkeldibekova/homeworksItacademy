package kg.db;

import kg.util.HibernateUtil;
import org.hibernate.Session;

public class GenericsDB<T> {
    public T create(T object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
        return object;
    }
}
