package miu.edu.lab5.springsecurity.service.impl;

import miu.edu.lab5.springsecurity.repository.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Service("userDetailsService")
@Transactional
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepo userRepo;

    public UserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    @Override
//    public UserDetails loadUserByUserid(Long userid) throws UsernameNotFoundException {
//        var user = userRepo.findById(userid);
//        var userDetails = new AwesomeUserDetails(user);
//        return userDetails;
//    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findByUsername(username);
        var userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return null;
            }

            @Override
            public String getUsername() {
                return null;
            }

            @Override
            public boolean isAccountNonExpired() {
                return false;
            }

            @Override
            public boolean isAccountNonLocked() {
                return false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }
        };
        return userDetails;
    }


}
