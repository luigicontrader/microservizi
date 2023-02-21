package it.contrader.service;


import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.mapper.UtenzaMapper;
import it.contrader.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private UtenzaMapper converter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException  {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException( "User not found with username:" + username );
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }

    public User save (UserDTO userDTO) {
        User newUser = converter.toUser(userDTO);
        newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
        return userRepository.save(newUser);
    }
}
