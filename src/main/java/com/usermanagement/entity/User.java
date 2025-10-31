package com.usermanagement.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone;
    private String status;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp created_at;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Admin createdBy;

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }
    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }
    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Timestamp getCreated_at() { return created_at; }
    public void setCreated_at(Timestamp created_at) { this.created_at = created_at; }
    public Admin getCreatedBy() { return createdBy; }
    public void setCreatedBy(Admin createdBy) { this.createdBy = createdBy; }
}
