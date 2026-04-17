package home.spring_ecommerce.webapi.auth;

import home.spring_ecommerce.application.dtos.user.CustomUserDetails;
import home.spring_ecommerce.domain.entities.emp.UserEntity;
import home.spring_ecommerce.infrastructure.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new CustomUserDetails(user);
        /*return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();*/
    }
}
