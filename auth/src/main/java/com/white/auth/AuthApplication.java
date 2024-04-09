package com.white.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthApplication implements CommandLineRunner {
    @Autowired
    private  IUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("user", passwordEncoder.encode("1"), Role.USER);
        User admin = new User("admin", passwordEncoder.encode("1"), Role.ADMIN);
        userRepository.save(user);
        userRepository.save(admin);
    }
}
