package ro.sda.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sda.model.School;
import java.util.List;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {

    List<School> findByName(String name);
    List<School> findAllByAddressAndName(String address, String name);

}
