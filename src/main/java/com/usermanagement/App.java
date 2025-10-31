package com.usermanagement;

import com.usermanagement.dao.AdminDAO;
import com.usermanagement.entity.Admin;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdminDAO adminDAO = new AdminDAO();
        int choice;

        do {
            System.out.println("\n=== USER MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Admin");
            System.out.println("2. View All Admins");
            System.out.println("3. Update Admin");
            System.out.println("4. Delete Admin");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    Admin a = new Admin();
                    System.out.print("Enter Name: ");
                    a.setName(sc.nextLine());
                    System.out.print("Enter Email: ");
                    a.setEmail(sc.nextLine());
                    System.out.print("Enter Password: ");
                    a.setPassword(sc.nextLine());
                    adminDAO.saveAdmin(a);
                    System.out.println("✅ Admin Added!");
                    break;

                case 2:
                    List<Admin> admins = adminDAO.getAllAdmins();
                    admins.forEach(ad -> System.out.println(ad.getAdmin_id() + " - " + ad.getName() + " (" + ad.getEmail() + ")"));
                    break;

                case 3:
                    System.out.print("Enter Admin ID to Update: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    Admin adminToUpdate = new Admin();
                    adminToUpdate.setAdmin_id(uid);
                    System.out.print("New Name: ");
                    adminToUpdate.setName(sc.nextLine());
                    System.out.print("New Email: ");
                    adminToUpdate.setEmail(sc.nextLine());
                    System.out.print("New Password: ");
                    adminToUpdate.setPassword(sc.nextLine());
                    adminDAO.updateAdmin(adminToUpdate);
                    System.out.println("✅ Admin Updated!");
                    break;

                case 4:
                    System.out.print("Enter Admin ID to Delete: ");
                    int did = sc.nextInt();
                    adminDAO.deleteAdmin(did);
                    System.out.println("✅ Admin Deleted!");
                    break;

                case 5:
                    System.out.println("👋 Exiting...");
                    break;

                default:
                    System.out.println("❌ Invalid Choice!");
            }
        } while (choice != 5);
    }
}
