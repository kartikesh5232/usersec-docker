package com.example.UserSecurity.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
@Accessors(chain = true)
public class LoginResponse {
    private String token;

    private long expiresIn;

}
