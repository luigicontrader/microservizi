package it.contrader.converter;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<User, UserDTO> {


	@Autowired
	private ModelMapper modelMapper;
	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = modelMapper.map(userDTO, User.class);
		}
		return user;
	}
	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO  = modelMapper.map(user, UserDTO.class);
		}
		return userDTO;
	}
}