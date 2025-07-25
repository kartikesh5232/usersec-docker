package com.example.UserSecurity.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor

@Accessors(chain = true)
public class User implements UserDetails {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(nullable = false)
        private Long id;

        @Column(nullable = false)
        private String fullName;

        @Column(unique = true, length = 100, nullable = false)
        private String email;

        @Column(nullable = false)
        private String password;

        @CreationTimestamp
        @Column(updatable = false, name = "created_at")
        private Date createdAt;

        @UpdateTimestamp
        @Column(name = "updated_at")
        private Date updatedAt;

        @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
        @JoinTable(name = "AUTH_USER_AUTHORITY",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<authority> authorities = new HashSet<>();


        public User(String fullName, String email, String password) {
                this.fullName = fullName;
                this.email = email;
                this.password = password;
        }


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return authorities;
        }
        public String getPassword() {
                return password;
        }

        @Override
        public String getUsername() {
                return email;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }

}

