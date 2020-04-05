package kg.db;

import kg.entity.Championship;
import kg.entity.Country;
import kg.entity.Sport;
import kg.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ChampionshipDB {
    public static List<Sport> getSportsByCountry(Country country){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Sport> sportList = session.createQuery("select ch.sport from Championship ch where ch.country = :country")
                .setParameter("country", country).list();
        session.close();
        return sportList;
    }
}
