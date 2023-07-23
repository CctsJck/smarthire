package com.smarthire.project.security;

import com.smarthire.project.exception.EmailNotCheckedException;
import com.smarthire.project.model.entity.Recruiter;
import com.smarthire.project.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Recruiter recruiter = recruiterRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El email del usuario no fue encontrado"));

       if (recruiter.isEnabled()){
           return new UserDetailsImpl(recruiter);
       }else {
           throw new EmailNotCheckedException("El email no fue verificado");
       }

    }
}
