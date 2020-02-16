package ro.sda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.sda.model.School;
import ro.sda.model.Student;
import ro.sda.repository.SchoolRepository;
import ro.sda.repository.StudentRepository;

@Component
public class SchoolsManager {
    private SchoolRepository schoolRepository;
    private StudentRepository studentRepository;

    @Autowired
    public SchoolsManager(SchoolRepository schoolRepository, StudentRepository studentRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }

    public void saveData() {
        Student student1 = new Student();
        student1.setId(1);
        student1.setCnp("2930281746374324");
        student1.setFirstName("Timea");
        student1.setLastName("Balogh");
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setId(2);
        student2.setCnp("1930281746374324");
        student2.setFirstName("Vasile");
        student2.setLastName("Popa");
        studentRepository.save(student2);

        School school1 = new School();
        school1.setId(1);
        school1.setName("SDA");
        school1.setAddress("Cluj");
        schoolRepository.save(school1);

        School school2 = new School();
        school2.setId(2);
        school2.setName("UBB");
        school2.setAddress("Cluj-Napoca");
        schoolRepository.save(school2);

    }

}
