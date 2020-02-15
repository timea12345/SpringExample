package ro.sda.repository;
import org.springframework.stereotype.Repository;
import ro.sda.model.Student;

@Repository
public interface StudentRepository extends BaseRepository<Student> {

    Student findByCnp(String cnp);

}
