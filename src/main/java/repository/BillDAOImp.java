package repository;

import entity.BillEntity;
import org.hibernate.Session;
import util.CollectionUtil;
import util.HibernateUtil;

import java.util.List;

public class BillDAOImp implements BillDAO {

    @Override
    public void addNewBill(List<BillEntity> bills) {
        if (CollectionUtil.isEmpty(bills)) {
            return;
        }
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            bills.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

}
