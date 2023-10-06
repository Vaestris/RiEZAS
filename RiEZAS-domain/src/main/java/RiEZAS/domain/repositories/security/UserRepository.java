package RiEZAS.domain.repositories.security;

import RiEZAS.domain.models.security.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User,UUID> {

    User findByName(@Param("name")String name);
}
