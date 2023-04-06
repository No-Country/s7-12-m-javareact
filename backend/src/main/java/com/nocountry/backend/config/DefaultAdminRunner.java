package com.nocountry.backend.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.nocountry.backend.model.Customer;
import com.nocountry.backend.model.User;
import com.nocountry.backend.repository.ICustomerRepository;
import com.nocountry.backend.repository.IUserRepository;
import com.nocountry.backend.util.enums.Role;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class DefaultAdminRunner implements ApplicationRunner {

    private final IUserRepository userRepository;

    private final ICustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var admin = User.builder()
                .email("admin@movear.com")
                .password(passwordEncoder.encode("1234"))
                .role(Role.ADMIN.name())
                .build();

        var test = User.builder()
                .email("test@test.com")
                .password(passwordEncoder.encode("1234"))
                .role(Role.USER.name())
                .build();

        if (userRepository.findByEmail(admin.getUsername()).isEmpty()) {
            admin = userRepository.save(admin);
            var customer = Customer.builder()
                    .firstName("Administrador")
                    .fkUser(admin.getId())
                    .build();
            customerRepository.save(customer);
        }

        if (userRepository.findByEmail(test.getEmail()).isEmpty()) {
            test = userRepository.save(test);
            var customer = Customer.builder()
                    .firstName("User")
                    .lastName("Test")
                    .phone("434534555")
                    .birthdate(LocalDateTime.now())
                    .address("direccion")
                    .nationalIdImgUrl("http://dummyimage.com/202x100.png/ff4444/ffffff")
                    .driverLicenceImgUrl("http://dummyimage.com/202x100.png/ff4444/ffffff")
                    .fkUser(test.getId())
                    .build();
            customerRepository.save(customer);
        }


    }


}