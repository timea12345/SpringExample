package ro.sda.repository;
import org.springframework.stereotype.Repository;
import ro.sda.model.School;
import java.util.List;

@Repository
public interface SchoolRepository extends BaseRepository<School> {

    List<School> findByName(String name);

}
