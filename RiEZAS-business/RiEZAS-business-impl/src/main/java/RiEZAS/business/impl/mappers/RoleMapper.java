package RiEZAS.business.impl.mappers;

import RiEZAS.business.api.dto.security.RoleDto;
import RiEZAS.domain.models.security.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toModel(RoleDto dto);
    RoleDto toDto(Role model);
    List<Role> toModel(List<RoleDto> dtoList);
    List<RoleDto> toDto(List<Role> modelList);

}
