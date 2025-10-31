package com.usermanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Role_Permissions")
public class RolePermission {
    @Id
    private int role_id;
    private int permission_id;
}
