package edu.me.test.services;

import edu.me.test.configurations.UserConfigurationToken;
import edu.me.test.models.User;
import edu.me.test.models.dtos.requests.PostUserDto;
import edu.me.test.repositories.UserRepository;
import edu.me.test.utils.GrantedAuthorities;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public User save(PostUserDto user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        return userRepository.save(User.fromPostDto(user));
    }

    public List<User> getAll() {

        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(s);

        return new UserConfigurationToken(user.getUsername(), user.getPassword(), GrantedAuthorities.getGrantedAuthority(user.getRol()));
    }

}
