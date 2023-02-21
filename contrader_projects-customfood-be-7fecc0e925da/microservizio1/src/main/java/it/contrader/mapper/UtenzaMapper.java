package it.contrader.mapper;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UtenzaMapper {
    UtenzaMapper INSTANCE = Mappers.getMapper(UtenzaMapper.class);

    User toUser (UserDTO utenza);
    UserDTO toUser (User utenza);

}

