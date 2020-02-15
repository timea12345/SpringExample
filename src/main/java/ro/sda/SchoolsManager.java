package ro.sda;

import org.springframework.beans.factory.annotation.Autowired;
import ro.sda.model.School;
import ro.sda.model.Student;
import ro.sda.repository.SchoolRepository;
import ro.sda.repository.StudentRepository;

public class SchoolsManager {

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
        student1.setId(2);
        student1.setCnp("1930281746374324");
        student1.setFirstName("Vasile");
        student1.setLastName("Popa");

        School school1 = new School();
        school1.setId(1);
        school1.setName("SDA");
        school1.setAddress("Cluj");

        School school2 = new School();
        school1.setId(2);
        school1.setName("UBB");
        school1.setAddress("Cluj-Napoca");

        schoolRepository.createEntity(school1);
        schoolRepository.createEntity(school2);
        studentRepository.createEntity(student1);
        studentRepository.createEntity(student2);
    }

}
