package org.example.development.and.operation.of.secure.automated.systems.rest.controllers.security;

import org.example.development.and.operation.of.secure.automated.systems.business.api.dto.security.RoleDto;
import org.example.development.and.operation.of.secure.automated.systems.business.impl.services.RoleService;
import org.example.development.and.operation.of.secure.automated.systems.rest.respons.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public void create(@RequestBody RoleDto roleDto) {
        service.create(roleDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        RoleDto roleDto = service.read(id);
        if (roleDto == null) {
            return new ResponseEntity<>(new ErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Role with id " + id + " not found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleDto, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
