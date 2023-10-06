package RiEZAS.business.impl.services;

import RiEZAS.business.api.dto.security.RoleDto;
import RiEZAS.business.api.dto.security.UserDto;
import RiEZAS.business.impl.mappers.UserMapper;
import RiEZAS.domain.models.security.User;
import RiEZAS.domain.repositories.security.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final RoleService roleService;
    private final UserMapper mapper;
    private final UserRepository repository;

    public UserService(UserRepository repository, RoleService roleService, UserMapper mapper) {
        this.repository = repository;
        this.roleService = roleService;
        this.mapper = mapper;
    }

    public boolean checkUser(String name, String password) {
        UserDto user = findByName(name);
        if (user != null) {
            //return Arrays.equals(user.getPassword(), calculateHash(password.getBytes(StandardCharsets.UTF_8), user.getSalt()));
        return false;
        }
        return false;
    }

    public void create(UserDto user) {
        repository.save(mapper.toModel(user));
    }
    public UserDto findByName(String name) {
        return mapper.toDto(repository.findByName(name));
    }

    public UserDto read(UUID id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    public void delete(UUID id) {
        User entity = repository.findById(id).orElse(null);
        if (entity == null) {
            return;
        }
        repository.delete(entity);
    }

    public void registration(String name, String password) {
        if(findByName(name) == null)
        {
            List<RoleDto> roles = new ArrayList<RoleDto>();
            roles.add(roleService.findByName("ROLE_USER"));
            UserDto user = new UserDto(
                    null,
                    name,
                    password,
                    roles
            );
            User _user = mapper.toModel(user);
            repository.save(mapper.toModel(user));
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = findByName(username);
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }
}
