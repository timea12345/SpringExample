package ro.sda.impl;
import org.springframework.stereotype.Repository;
import ro.sda.model.Student;
import ro.sda.repository.StudentRepository;

@Repository
public class DefaultStudentRepository extends GenericRepository<Student> implements StudentRepository {

    public Student findByCnp(String cnp) {
       return entityList.stream()
                .filter((s) -> s.getCnp().equals(cnp))
                .findFirst()
                .orElse(null);
    }


}
