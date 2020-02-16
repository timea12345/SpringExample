package ro.sda.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.sda.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findByCnp(String cnp);

    @Query("SELECT u FROM Student u WHERE u.firstName = ?1")
    List<Student> findByName(String name);

    @Query("SELECT u FROM Student u WHERE u.firstName = ?1 AND u.cnp = ?2")
    List<Student> findByNameAndCnp(String name, String cnp);

}
