package spring.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.example.model.Box;
import spring.example.model.Info;

import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BoxDaoImpl implements BoxDao {
    public static String type = "allType";
    public static String id = "ido";
    public static String allInfo = "allInfo";


    public SessionFactory sessionFactory;


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


    @SuppressWarnings("unchecked")
    @Transactional
    public void addBox(Box box) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query insertQuery = session.createSQLQuery("" + "INSERT INTO Box(id,name,weight,colour)VALUES(?,?,?,?)");
        insertQuery.setParameter(1, box.getId());
        insertQuery.setParameter(2, box.getName());
        insertQuery.setParameter(3, box.getWeight());
        insertQuery.setParameter(4, box.getColour());
        insertQuery.executeUpdate();
        session.getTransaction().commit();
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


    @SuppressWarnings("unchecked")
    @Transactional
    public List<Box> getBoxesById(Long id) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Box where id=:id");
        query.setParameter("id",id);
        return query.getResultList();

    }


    @SuppressWarnings("unchecked")
    public List<Box> getBoxInfo() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Box p");
        return query.getResultList();

//        return session.getNamedQuery(BoxDaoImpl.id)
//                .list();
    }
}




