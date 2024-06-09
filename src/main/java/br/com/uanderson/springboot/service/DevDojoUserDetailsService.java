package br.com.uanderson.springboot.service;

import br.com.uanderson.springboot.repository.DevDojoUserDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DevDojoUserDetailsService implements UserDetailsService {
    private final DevDojoUserDetailsRepository devDojoUserDetailsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(devDojoUserDetailsRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("DevDojo user not found"));
    }
}