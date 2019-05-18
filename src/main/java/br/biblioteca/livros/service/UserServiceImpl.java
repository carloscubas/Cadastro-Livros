package br.biblioteca.livros.service;

import java.util.List;

import br.biblioteca.livros.entities.Role;
import br.biblioteca.livros.entities.User;
import br.biblioteca.livros.repository.RoleRepository;
import br.biblioteca.livros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
     
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role roleBasic = roleRepository.findByRole("ROLE_BASIC");
        user.getRoles().add(roleBasic);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}