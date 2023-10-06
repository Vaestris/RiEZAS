package org.example.development.and.operation.of.secure.automated.systems.domain.repositories.security;

import org.example.development.and.operation.of.secure.automated.systems.domain.models.security.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends CrudRepository<Role,UUID> {

    Role findByName(@Param("name")String name);
}
