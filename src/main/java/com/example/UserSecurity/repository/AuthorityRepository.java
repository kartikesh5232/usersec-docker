package com.example.UserSecurity.repository;


import com.example.UserSecurity.entity.authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<authority, Long> {
    // You can define custom query methods here if needed
    authority findByRoleCode(String roleCode);
}