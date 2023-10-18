package RiEZAS.rest.controllers;

import RiEZAS.business.api.dto.ClientDto;
import RiEZAS.business.impl.services.ClientService;
import RiEZAS.rest.respons.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    final ClientService service;

    @PostMapping("/create")
    public void create(@RequestBody ClientDto client) {
        service.create(client);
    }
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
    @PostMapping("/update")
    public void update(@RequestBody ClientDto client) {
        service.update(client);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable UUID id) {
        ClientDto client = service.get(id);
        if (client == null) {
            return new ResponseEntity<>(new ErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Client with id " + id + " not found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }
    @PostMapping("/getPage")
    public ResponseEntity<?> getPage(@RequestParam String name, @RequestParam int pageNumber) {
        List<ClientDto> clients = service.getPage(name, pageNumber);
        if (clients == null) {
            return new ResponseEntity<>(new ErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Clients with name " + name + " not found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
