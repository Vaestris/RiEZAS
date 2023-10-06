package org.example.development.and.operation.of.secure.automated.systems.business.api.dto.security;

import java.util.UUID;

public class RoleDto {

    private UUID id;

    private String name;

    public RoleDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
    public RoleDto() {}

    public void setId(UUID id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
