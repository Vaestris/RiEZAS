package RiEZAS.business.api.dto.security;

import java.util.List;
import java.util.UUID;

public class UserDto {

    private UUID id;

    private String name;

    private String password;

    private List<RoleDto> roles;

    public UserDto(UUID id, String name, String password, List<RoleDto> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }
    public UserDto() {}

    public void setId(UUID id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRoles(List<RoleDto> roles) {
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public List<RoleDto> getRoles() {
        return roles;
    }
}
