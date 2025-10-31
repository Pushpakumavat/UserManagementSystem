package com.usermanagement.dao;

import com.usermanagement.entity.Permission;
import com.usermanagement.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PermissionDAO {

    public void savePermission(Permission permission) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(permission);
            tx.commit();
            System.out.println("✅ Permission saved successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void updatePermission(Permission permission) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(permission);
            tx.commit();
            System.out.println("✅ Permission updated successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void deletePermission(int permissionId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Permission permission = session.get(Permission.class, permissionId);
            if (permission != null) {
                session.delete(permission);
                System.out.println("🗑️ Permission deleted successfully!");
            } else {
                System.out.println("⚠️ Permission not found!");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public Permission getPermissionById(int permissionId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Permission.class, permissionId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Permission> getAllPermissions() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Permission", Permission.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
