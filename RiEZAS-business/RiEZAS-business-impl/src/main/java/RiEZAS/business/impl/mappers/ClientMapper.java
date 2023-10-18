package RiEZAS.business.impl.mappers;

import RiEZAS.business.api.dto.ClientDto;
import RiEZAS.domain.models.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toModel(ClientDto dto);
    ClientDto toDto(Client model);
    List<Client> toModel(List<ClientDto> dtoList);
    List<ClientDto> toDto(List<Client> modelList);
}
