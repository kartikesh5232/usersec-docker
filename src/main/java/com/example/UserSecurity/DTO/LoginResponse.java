package com.example.UserSecurity.DTO;


import com.example.UserSecurity.entity.authority;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Component
@Accessors(chain = true)
public class LoginResponse {
    private String token;

    private long expiresIn;

    private Set<authority> authorities ;
}
