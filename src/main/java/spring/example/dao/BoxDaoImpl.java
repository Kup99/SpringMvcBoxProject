package spring.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.example.model.Info;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BoxDaoImpl implements BoxDao {
    public static String type = "allType";
    public static String id = "id";
    private SessionFactory sessionFactory;


    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public void add(Info info) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query insertQuery = session.createSQLQuery("" + "INSERT INTO INFO(id,name,memory,type)VALUES(?,?,?,?)");
        insertQuery.setParameter(1, info.getId());
        insertQuery.setParameter(2, info.getName());
        insertQuery.setParameter(3, info.getMemory());
        insertQuery.setParameter(4, info.getType());
        insertQuery.executeUpdate();
        session.getTransaction().commit();
    }

    @Transactional
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            String hql = "delete from Info where id=:id";
            Query query = session.createQuery(hql);
            ((org.hibernate.query.Query) query).setLong("id", id);
            System.out.println(query.executeUpdate());
            transaction.commit();
        } catch (Throwable t) {
            transaction.rollback();
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public void edit(Info info) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(info);
        session.getTransaction().commit();
    }

    public List<Info> getAllBoxInfo() {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Info> getInfoById(Long id) {
        Session session = sessionFactory.openSession();
        return session.getNamedQuery(BoxDaoImpl.id)
                .setParameter("id", id)
                .list();

    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Info> getInfoByType(String type) {
        Session session = sessionFactory.openSession();
        return session.getNamedQuery(BoxDaoImpl.type)
                .setParameter("type", type)
                .list();
    }

}




