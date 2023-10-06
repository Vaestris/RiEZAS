package org.example.development.and.operation.of.secure.automated.systems.business.impl.services;

import org.example.development.and.operation.of.secure.automated.systems.business.api.dto.security.RoleDto;
import org.example.development.and.operation.of.secure.automated.systems.business.impl.mappers.RoleMapper;
import org.example.development.and.operation.of.secure.automated.systems.domain.models.security.Role;
import org.example.development.and.operation.of.secure.automated.systems.domain.repositories.security.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleService {

    private final RoleMapper mapper;
    private final RoleRepository repository;

    public RoleService(RoleRepository repository, RoleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void create(RoleDto roleDto) {
        repository.save(mapper.toModel(roleDto));
    }

    public RoleDto findByName(String name) {
        return mapper.toDto(repository.findByName(name));
    }

    public RoleDto read(UUID id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    public void delete(UUID id) {
        Role entity = repository.findById(id).orElse(null);
        if (entity == null) {
            return;
        }
        repository.delete(entity);
    }
}
