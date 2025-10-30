package com.usermanagement.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Roles")

public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;

    @Column(unique = true)
    private String roleName;

    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany
    @JoinTable(
        name = "Role_Permissions",
        joinColumns = @JoinColumn(name = "role_id"),
        inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<Permission> permissions;

    // Getters and Setters

}
