package ro.sda.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sda.model.LocalUser;

import java.util.Optional;

@Repository
public interface LocalUserRepository extends CrudRepository<LocalUser, Long> {

    Optional<LocalUser> findByEmailIgnoreCase(String email);
}
