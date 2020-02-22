package ro.sda.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sda.model.Student;
import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findByCnp(String cnp);
    List<Student> findByFirstName(String name);
    List<Student> findByFirstNameAndCnp(String name, String cnp);

}
