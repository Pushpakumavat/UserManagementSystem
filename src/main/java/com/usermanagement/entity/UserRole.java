package com.usermanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User_Roles")
public class UserRole {
    @Id
    private int user_id;
    private int role_id;
}
