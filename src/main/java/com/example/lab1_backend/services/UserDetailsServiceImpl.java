package com.example.lab1_backend.services;


import com.example.lab1_backend.entities.UserRole;
import com.example.lab1_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String username) {

        com.example.lab1_backend.entities.User user = userRepository.findUserByEmail(username);
        Set<String> roles = new HashSet<>();
        roles.add(user.getRoles());
        List<GrantedAuthority> authorities =
                buildUserAuthority(roles);

        return buildUserForAuthentication(user, authorities);

    }

    private User buildUserForAuthentication(com.example.lab1_backend.entities.User user,
                                            List<GrantedAuthority> authorities) {
        return new User(user.getEmail(), user.getPassword(),
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<String> roles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        // Build user's authorities
        for (String role : roles) {
            setAuths.add(new SimpleGrantedAuthority(role));
        }

        return new ArrayList<>(setAuths);
    }
}

