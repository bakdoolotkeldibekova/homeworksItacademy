package kg.db;

import kg.entity.Country;
import kg.entity.Sport;
import kg.entity.Team;
import kg.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TeamDB {
    public static List<Team> getAllOrderBySportName(List<Sport> sportList) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Team> teams =
                session.createQuery("from Team t where t.sport in (:list) order by t.sport.name", Team.class)
                        .setParameter("list", sportList).setMaxResults(10).list();
        session.close();
        return teams;
    }

}
