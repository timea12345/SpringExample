package ro.sda.impl;
import org.springframework.stereotype.Repository;
import ro.sda.model.Student;
import ro.sda.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DefaultStudentRepository implements StudentRepository {
    private List<Student> studentList = new ArrayList<Student>();

    public Student findByCnp(String cnp) {
       return studentList.stream()
                .filter((s) -> s.getCnp().equals(cnp))
                .findFirst()
                .orElse(null);
    }

    public Student findById(int id) {
        return studentList.stream()
                .filter((s) -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void createEntity(Student entity) {
        studentList.add(entity);
    }

    public void updateEntity(Student entity) {

    }

    public void deleteEntity(Student entity) {
        for (Student s: studentList) {
            if (s.equals(entity)) {
                studentList.remove(entity);
            }
        }
    }
}
