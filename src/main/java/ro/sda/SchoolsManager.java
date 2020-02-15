package ro.sda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ro.sda.model.School;
import ro.sda.model.Student;
import ro.sda.repository.SchoolRepository;
import ro.sda.repository.StudentRepository;

@Component
public class SchoolsManager {

    @Qualifier("defaultSchoolRepository")
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

//    @Autowired
//    public SchoolsManager(SchoolRepository schoolRepository, StudentRepository studentRepository) {
//        this.schoolRepository = schoolRepository;
//        this.studentRepository = studentRepository;
//    }

    public void saveData() {
        Student student1 = new Student();
        student1.setId(1);
        student1.setCnp("2930281746374324");
        student1.setFirstName("Timea");
        student1.setLastName("Balogh");

        Student student2 = new Student();
        student2.setId(2);
        student2.setCnp("1930281746374324");
        student2.setFirstName("Vasile");
        student2.setLastName("Popa");

        School school1 = new School();
        school1.setId(1);
        school1.setName("SDA");
        school1.setAddress("Cluj");

        School school2 = new School();
        school2.setId(2);
        school2.setName("UBB");
        school2.setAddress("Cluj-Napoca");

        schoolRepository.createEntity(school1);
        schoolRepository.createEntity(school2);
        studentRepository.createEntity(student1);
        studentRepository.createEntity(student2);
    }

}
