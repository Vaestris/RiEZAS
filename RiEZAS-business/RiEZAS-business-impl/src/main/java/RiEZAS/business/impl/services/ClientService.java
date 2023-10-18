package RiEZAS.business.impl.services;

import RiEZAS.business.api.dto.ClientDto;
import RiEZAS.business.impl.mappers.ClientMapper;
import RiEZAS.domain.models.Client;
import RiEZAS.domain.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public void create(ClientDto dto) {
        repository.save(mapper.toModel(dto));
    }
    public void delete(UUID id) {
        Client entity = repository.findById(id).orElse(null);
        if (entity == null) {
            return;
        }
        repository.delete(entity);
    }
    public void update(ClientDto client) {
        Client entity = repository.findById(client.getId()).orElse(null);
        if(entity != null) {
            entity.setName(client.getName());
            entity.setSurname(client.getSurname());
            entity.setPatronymic(client.getPatronymic());
            entity.setBirthday(client.getBirthday());
            entity.setRegistrationDate(client.getRegistrationDate());
            repository.save(entity);
        }
    }
    public ClientDto get(UUID id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }
    public List<ClientDto> getPage(String name, int offset) {
        return mapper.toDto(repository.findAllByName(name, PageRequest.of(offset,10) ));
    }
}
