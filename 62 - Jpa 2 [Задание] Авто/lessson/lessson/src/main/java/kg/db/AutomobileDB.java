package kg.db;

import kg.entities.Automobile;
import kg.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class AutomobileDB {
    public static Automobile create(Automobile automobile){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(automobile);
        session.getTransaction().commit();
        session.close();
        return automobile;
    }
    public static List<Automobile> getAll(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Automobile> automobileList = session.createQuery("FROM kg.entities.Automobile").list();
        session.close();
        return automobileList;
    }
    public static Automobile update(Automobile automobile){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Automobile car = session.load(Automobile.class, automobile.getId());
        car.setId(automobile.getId());
        car.setModel(automobile.getModel());
        car.setYear(automobile.getYear());
        session.getTransaction().commit();
        session.close();
        return car;
    }
    public static Automobile findById(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Automobile automobile = session.load(Automobile.class, id);
        session.close();
        return automobile;
    }
    public static void deleteById(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Automobile automobile = findById(id);
        session.delete(automobile);
        session.getTransaction().commit();
        session.close();
        System.out.println("deleted automobile by id = " + id);
    }
}
