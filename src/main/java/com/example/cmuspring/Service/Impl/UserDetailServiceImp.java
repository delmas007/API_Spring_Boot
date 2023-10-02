package com.example.cmuspring.Service.Impl;

import com.example.cmuspring.Model.Utilisateur;
import com.example.cmuspring.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    public UserDetailServiceImp(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    UtilisateurService utilisateurService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurService.loadUserById(username);
        if(username==null) throw new UsernameNotFoundException("pas D'utilisateur");

        UserDetails userDetails = User
                .withUsername(utilisateur.getId())
                .password(utilisateur.getPassword())
                .authorities((GrantedAuthority) utilisateur.getRole())
                .build();
        return userDetails;
    }
}