package com.example.food_store_cbd_be.security.userPrincipcal;

import com.example.food_store_cbd_be.model.user.User;
import com.example.food_store_cbd_be.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
        return UserPrinciple.build(user);
    }
}
