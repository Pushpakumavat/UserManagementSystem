package com.usermanagement.dao;

import com.usermanagement.entity.Role;
import com.usermanagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class RoleDAO {

    public void saveRole(Role role) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(role);
            tx.commit();
            System.out.println("✅ Role saved successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void updateRole(Role role) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(role);
            tx.commit();
            System.out.println("✅ Role updated successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void deleteRole(int roleId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Role role = session.get(Role.class, roleId);
            if (role != null) {
                session.delete(role);
                System.out.println("🗑️ Role deleted successfully!");
            } else {
                System.out.println("⚠️ Role not found!");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Role getRoleById(int roleId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Role.class, roleId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Role> getAllRoles() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Role", Role.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
