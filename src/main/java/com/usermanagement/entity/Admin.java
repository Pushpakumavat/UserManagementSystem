package com.usermanagement.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Admin")


public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    // One Admin can create many Users
    @OneToMany(mappedBy = "createdBy")
    private List<User> users;

    // Getters and Setters
    public int getAdminId() { return adminId; }
    public void setAdminId(int adminId) { this.adminId = adminId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<User> getUsers() { return users; }
    public void setUsers(List<User> users) { this.users = users; }

}
