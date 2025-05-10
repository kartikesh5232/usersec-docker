package com.example.UserSecurity;

import com.example.UserSecurity.entity.User;
import com.example.UserSecurity.entity.authority;
import com.example.UserSecurity.repository.AuthorityRepository;
import com.example.UserSecurity.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;


@SpringBootApplication
@EnableDiscoveryClient
public class UserSecurityApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;


    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(UserSecurityApplication.class, args);

    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {
//        authority userAuthority = new authority("ADMIN", "Role Admin");
//        authority adminAuthority = new authority("USER", "Role User");
//
//        authorityRepository.save(userAuthority);
//        authorityRepository.save(adminAuthority);
//
//
//        User user = new User("Kartikesh", "kartikesh5232@outlook.com", passwordEncoder.encode("Admin"));
//        Set<authority> authorities = new HashSet<>();
//        authorities.add(userAuthority);
//        authorities.add(adminAuthority);
//        user.setAuthorities(authorities);
//
//
//        userRepository.save(user);
//        Optional<User> data=userRepository.findByEmail("kartikesh5232@outlook.com");
//
//       System.out.println(data.get().getAuthorities().size());
//        List<authority> authorityList = new ArrayList<>();
//
//
//        authority userAuthority = new authority("ADMIN", "Role Admin");
//        authority adminAuthority = new authority("USER", "Role User");
//
//        Set<authority> authorities = new HashSet<>();
//        authorities.add(userAuthority);
//        authorities.add(adminAuthority);
//        userRepository.save(new User().setFullName("Kartikesh")
//                .setEmail("kartikesh5232@outlook.com")
//                .setPassword(passwordEncoder.encode("Admin")).setAuthorities(authorities));
    }



//	private authority CreateAuthority(String roleCode, String roleDescription)
//	{
//		authority authority=new authority();
//		authority.setRoleCode(roleCode);
//		authority.setRoleDescription(roleDescription);
//
//		return authority;
//
//	}

}
