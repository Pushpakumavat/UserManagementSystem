package com.usermanagement.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Permissions")

public class Permission {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionId;

    @Column(unique = true)
    private String permissionName;

    private String description;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles;

    // Getters and Setters
}

