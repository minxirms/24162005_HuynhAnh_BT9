package vn.minxi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import vn.minxi.entity.Role;
import vn.minxi.entity.User;
import vn.minxi.repository.RoleRepository;
import vn.minxi.repository.UserRepository;

@SpringBootApplication
public class SpringbootVd2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootVd2Application.class, args);
	}

	@Bean
	CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository,
			PasswordEncoder passwordEncoder) {
		return args -> {
			Role userRole = roleRepository.findByNameIgnoreCase("ROLE_USER").orElseGet(() -> {
				Role role = new Role();
				role.setName("ROLE_USER");
				return roleRepository.save(role);
			});

			String defaultEmail = "user01@gmail.com";
			if (!userRepository.existsByEmailIgnoreCase(defaultEmail)) {
				User user = new User();
				user.setUsername("user01"); //
				user.setEmail(defaultEmail);
				user.setPassword(passwordEncoder.encode("123456"));
				user.setFullName("Nguyễn Hữu Trung");
				user.setRole(userRole);
				user.setEnabled(true);

				userRepository.save(user);
			}
		};
	}
}