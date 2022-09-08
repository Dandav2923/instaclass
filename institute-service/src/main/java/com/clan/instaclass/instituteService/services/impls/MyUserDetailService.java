package com.clan.instaclass.instituteService.services.impls;

import com.clan.instaclass.instituteService.entities.InstituteEnt;
import com.clan.instaclass.instituteService.repositories.InstituteRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@Service
public class MyUserDetailService implements UserDetailsService {

    private InstituteRepository instituteRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        InstituteEnt instituteEnt = instituteRepository.findByUsername(username);
        if (instituteEnt == null) {
            throw new UsernameNotFoundException(username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new User(instituteEnt.getUsername(),instituteEnt.getPassword(),new ArrayList<>());
    }
}
