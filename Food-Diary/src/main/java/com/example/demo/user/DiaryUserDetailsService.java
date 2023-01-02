package com.example.demo.user;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DiaryUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public DiaryUserDetailsService(){}
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(username)
                .orElseThrow(()-> new UsernameNotFoundException("no user with this username"));

        return new DiaryUserPrincipal(user);
    }
}
