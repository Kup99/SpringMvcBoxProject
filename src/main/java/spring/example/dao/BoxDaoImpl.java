package spring.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    public void add(Info info) {
        Session session = sessionFactory.getCurrentSession();
        long save = (Long) session.save(info);
        System.out.println(save);
    }

    public void addBox(Box box) {
        Session session = sessionFactory.getCurrentSession();
        long save = (Long) session.save(box);
        System.out.println(save);
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "delete from Info where id=:id";
        Query query = session.createQuery(hql);
        ((org.hibernate.query.Query) query).setLong("id", id);
        System.out.println(query.executeUpdate());
    }

    public void edit(Info info) {
        Session session = sessionFactory.getCurrentSession();
        session.update(info);
    }

    public Box getBoxesById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Box.class, id);
    }

    public List<Box> getBoxInfo() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Box p");
        return query.getResultList();
    }

    public void insertBoxDefaultEntity() {
        Session session = sessionFactory.getCurrentSession();
        Query insertQuery = session.createSQLQuery("" + "INSERT INTO Box(id,name)VALUES(?,?)");
        insertQuery.setParameter(1, 1);
        insertQuery.setParameter(2, "TestBox");
        insertQuery.executeUpdate();
    }
}




