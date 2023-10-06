package org.example.development.and.operation.of.secure.automated.systems.business.impl.mappers;

import org.example.development.and.operation.of.secure.automated.systems.business.api.dto.security.UserDto;
import org.example.development.and.operation.of.secure.automated.systems.domain.models.security.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper {

    User toModel(UserDto dto);
    UserDto toDto(User model);
}
