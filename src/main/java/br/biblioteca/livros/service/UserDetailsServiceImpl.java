package br.biblioteca.livros.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.entities.Login;
import br.biblioteca.livros.entities.Role;
import br.biblioteca.livros.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		logger.info("m=UserDetailsServiceImpl.loadUserByUsername. User: " + username);

		Login user = userRepository.findByUsername(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : user.getRoles()) {
			logger.info("m=UserDetailsServiceImpl.loadUserByUsername.roles Role: " + role.getRole());

			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				grantedAuthorities);
	}

}
