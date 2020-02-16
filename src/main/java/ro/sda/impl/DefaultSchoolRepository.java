package ro.sda.impl;
import org.springframework.stereotype.Repository;
import ro.sda.model.School;
import ro.sda.repository.SchoolRepository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DefaultSchoolRepository extends GenericRepository<School> implements SchoolRepository {


    public List<School> findByName(String name) {
        return entityList.stream()
                .filter((s) -> s.getName().equals(name))
                .collect(Collectors.toList());
    }
}
