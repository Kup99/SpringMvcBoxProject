package spring.example.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.example.model.Box;
import spring.example.model.Info;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BoxDaoImpl implements BoxDao {
    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;


    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public void add(Info info) {
        try {

            Session session = sessionFactory.getCurrentSession();
            session.save(info);
        } catch (HibernateException e) {
            Session session = sessionFactory.openSession();
            session.save(info);

        }
    }


    @SuppressWarnings("unchecked")
    public void addBox(Box box) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        long save = (Long) session.save(box);
        session.getTransaction().commit();
        System.out.println(save);
    }

    @Transactional
    @SuppressWarnings("unchecked")
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


    @SuppressWarnings("unchecked")
    @Transactional
    public List<Box> getBoxesById(Long id) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Box where id=:id");
        query.setParameter("id", id);
        return query.getResultList();

    }


    @SuppressWarnings("unchecked")
    public List<Box> getBoxInfo() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Box p");
        return query.getResultList();
    }

    public void insertBoxDefaultEntity() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query insertQuery = session.createSQLQuery("" + "INSERT INTO Box(id,name)VALUES(?,?)");
        insertQuery.setParameter(1, 1);
        insertQuery.setParameter(2, "TestBox");
        insertQuery.executeUpdate();
        session.getTransaction().commit();

    }
}




