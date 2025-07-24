package com.notionconcept.notionconcept.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.notionconcept.notionconcept.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServicesImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return userRepository.getAllUsers().stream().filter(user -> user.getUsername().equals(username)).findFirst().orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }
}
