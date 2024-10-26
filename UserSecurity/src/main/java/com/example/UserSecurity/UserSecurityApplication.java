package com.example.UserSecurity;

import com.example.UserSecurity.entity.User;
import com.example.UserSecurity.entity.authority;
import com.example.UserSecurity.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class UserSecurityApplication {
@Autowired
UserRepository userRepository;

  @Autowired
	BCryptPasswordEncoder  passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(UserSecurityApplication.class, args);

	}
//	@PostConstruct
//	protected void init(){
//	 List<authority> authorityList =new ArrayList<>();
//
//	 authorityList.add(CreateAuthority("ADMIN", "Role Admin"));
//	 authorityList.add(CreateAuthority("USER", "Role User"));
//
//
//     userRepository.save(new User().setFullName("Kartikesh")
//			 .setEmail("kartikesh5232@outlook.com")
//			 .setPassword(passwordEncoder.encode("Admin")).setAuthorities(authorityList));
//
//	}
//
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
