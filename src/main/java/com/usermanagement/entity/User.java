package com.usermanagement.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "Users")

public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Status status = Status.Active;

    private Timestamp createdAt;

    // Many Users created by one Admin
    @ManyToOne
    @JoinColumn(name = "created_by")
    private Admin createdBy;

    // Many-to-Many with Role
    @ManyToMany
    @JoinTable(
        name = "User_Roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    // Enum for status
    public enum Status {
        Active, Inactive, Suspended
    }

    // Getters and Setters
    // (Add standard getters/setters)

}
