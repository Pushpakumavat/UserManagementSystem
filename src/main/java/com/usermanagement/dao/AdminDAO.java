package com.usermanagement.dao;

import com.usermanagement.entity.Admin;
import com.usermanagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class AdminDAO {

    public void saveAdmin(Admin admin) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(admin);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Admin> getAllAdmins() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Admin", Admin.class).list();
        }
    }

    public void updateAdmin(Admin admin) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(admin);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void deleteAdmin(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Admin admin = session.get(Admin.class, id);
            if (admin != null) session.remove(admin);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
