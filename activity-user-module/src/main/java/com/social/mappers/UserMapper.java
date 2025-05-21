package com.social.mappers;

import com.social.model.User;
import com.social.model.dto.UserRequestDto;
import com.social.model.dto.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "active", source = "active")
    User userRequestToUserEntity(UserRequestDto dto);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "active", source = "active")
    UserResponseDto userEntityToResponse(User user);
}
