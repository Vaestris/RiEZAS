package org.example.development.and.operation.of.secure.automated.systems.business.impl.mappers;

import org.example.development.and.operation.of.secure.automated.systems.business.api.dto.security.RoleDto;
import org.example.development.and.operation.of.secure.automated.systems.domain.models.security.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toModel(RoleDto dto);
    RoleDto toDto(Role model);
    List<Role> toModel(List<RoleDto> dtoList);
    List<RoleDto> toDto(List<Role> modelList);

}
