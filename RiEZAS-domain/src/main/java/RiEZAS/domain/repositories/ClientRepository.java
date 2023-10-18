package RiEZAS.domain.repositories;

import RiEZAS.domain.models.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, UUID> {

    List<Client> findAllByName(String name, Pageable pageable);
}
