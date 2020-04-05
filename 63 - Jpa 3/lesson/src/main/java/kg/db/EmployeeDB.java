package kg.db;

import kg.entity.Country;
import kg.entity.Department;
import kg.entity.Employee;
import kg.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import java.util.List;

public class EmployeeDB {
   public static List<Employee> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list(); //HQL
        session.close();
        return employees;
    }

    public static Employee update(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee e = session.load(Employee.class, employee.getId());
        e.setId(employee.getId());
        e.setName(employee.getName());
        e.setAge(employee.getAge());
        session.getTransaction().commit();
        session.close();
        return e;
    }

    public static Employee findById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = session.get(Employee.class, id);
        session.close();
        return employee;
    }

    public static Employee getById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee = (Employee) session.createQuery("from Employee where id = :id")
                .setParameter("id", id).getSingleResult();
        session.close();
        return employee;
    }

    public static Employee getByNameAndAge(String string, Integer age) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee employee;
        try {
            employee =  session.createQuery("from Employee where name like :name and age > :age", Employee.class)
                    .setParameter("name", "%" + string + "%").setParameter("age", age)
                    .getSingleResult();
        } catch (NoResultException e) {
            employee = null;
            System.out.println(e.getMessage());
        }

        return employee;
    }

    public static void deleteById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Employee employee = findById(id);
        session.delete(employee);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Employee> getByDepartName(String departName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees =
                session.createQuery("from Employee e where e.department.name = :depName", Employee.class)
                .setParameter("depName", departName).list();
        session.close();
        return employees;
    }

    public static List<Employee> getAllByDepartmentAndCountry(Department department, Country country) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees =
                session.createQuery(
                        "from Employee e where e.department = :department and e.country = :country", Employee.class)
                        .setParameter("department", department).setParameter("country", country).list();
        session.close();
        return employees;
    }

    public static List<Employee> getAllOrderByNameASC() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees =
                session.createQuery("from Employee e order by e.name ASC", Employee.class).list();
        session.close();
        return employees;
    }

    public static List<Employee> getAllOrderByCountryName() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees =
                session.createQuery("from Employee e order by e.country.name", Employee.class).list();
        session.close();
        return employees;
    }

    public static List<Employee> getAllOrderByDepartmentName() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees =
                session.createQuery("from Employee e order by e.department.name", Employee.class).list();
        session.close();
        return employees;
    }
}
