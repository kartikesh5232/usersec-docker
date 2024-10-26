package com.example.UserSecurity.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;



@Table(name = "AUTH_AUTHORITY")
@Entity
public class authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="ROLE_CODE")
    private String roleCode;
    @Column(name="ROLE_DESCRIPTION")
    private String roleDescription;

    @Override
    public String getAuthority() {
        return roleCode;
    }

    public Long getId() {
        return id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
