package RiEZAS.business.impl.mappers;

import RiEZAS.business.api.dto.security.UserDto;
import RiEZAS.domain.models.security.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper {

    User toModel(UserDto dto);
    UserDto toDto(User model);
}
