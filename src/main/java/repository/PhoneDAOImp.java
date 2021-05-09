package repository;

import entity.Phone;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class PhoneDAOImp implements PhoneDAO {

    @Override
    public void addNewPhone(List<Phone> phones) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            phones.forEach(session::save);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().commit();
        }
    }
}
