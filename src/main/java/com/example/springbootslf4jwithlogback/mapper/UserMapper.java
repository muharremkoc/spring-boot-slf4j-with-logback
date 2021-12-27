package com.example.springbootslf4jwithlogback.mapper;

import com.example.springbootslf4jwithlogback.dto.UserDTO;
import com.example.springbootslf4jwithlogback.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {


        @Mappings({
                @Mapping(target = "firstName",source = "firstName"),
                @Mapping(target = "lastName",source = "lastName")
        })
    User userDTOToUser(UserDTO userDTO);

    UserDTO userToUserDTO(User user);
}
