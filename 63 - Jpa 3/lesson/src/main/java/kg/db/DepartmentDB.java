package kg.db;

import kg.entity.Department;
import kg.util.HibernateUtil;
import org.hibernate.Session;

public class DepartmentDB {
    public static Department getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Department department = session.get(Department.class, id);
        session.close();
        return department;
    }

    public static Department loadById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Department department = session.load(Department.class, id);
        session.close();
        return department;
    }
}
