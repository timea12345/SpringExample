package ro.sda.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sda.model.School;
import java.util.List;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {

    @Query("SELECT u FROM School u WHERE u.name =?1")
    List<School> findByName(String name);

    @Query("SELECT u FROM School u WHERE u.address = ?1 AND u.name = ?2")
    List<School> findAllByAddressAndName(String address, String name);

}
