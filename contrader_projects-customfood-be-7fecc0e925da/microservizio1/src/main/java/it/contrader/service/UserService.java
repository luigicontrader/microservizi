package it.contrader.service;

import it.contrader.config.JwtTokenUtil;
import it.contrader.dto.JwtResponseDTO;
import it.contrader.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.mapper.UtenzaMapper;

@Service
public class UserService {
	
	 UtenzaMapper utenzaMapper = UtenzaMapper.INSTANCE;
	 @Autowired
	 UserRepository userRepository;
	 @Autowired
	 private AuthenticationManager authenticationManager;
	 @Autowired
	 private JwtUserDetailsService jwtUserDetailsService;
	 @Autowired
	 private JwtTokenUtil jwtTokenUtil;
	
	//LOGIN method
	public UserDTO findByUsernameAndPassword(String username, String password) {
		return utenzaMapper.toUser((userRepository).findByUsernameAndPassword(username, password));
	}

	public  UserDTO findByUsername(String username){
		return utenzaMapper.toUser((userRepository).findByUsername(username));
	}
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		} catch (DisabledException e) {
			throw new DisabledException("Errore disabled Expection");
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Credenziali sbagliate");
		}
	}
	public ResponseEntity<?> login(LoginDTO loginDTO) throws Exception {

		authenticate(loginDTO.getUsername(), loginDTO.getPassword());
		UserDTO user = findByUsername(loginDTO.getUsername());

		final UserDetails userDetails = jwtUserDetailsService
				.loadUserByUsername(loginDTO.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails,user.getUsertype());


		return ResponseEntity.ok(new JwtResponseDTO(token, user));
	}

}
