package ro.sda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.sda.model.School;
import ro.sda.model.Student;
import ro.sda.repository.SchoolRepository;
import ro.sda.repository.StudentRepository;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SchoolsManager schoolsManager;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1.Student");
        System.out.println("2.School");
        int option = scanner.nextInt();

        if (option == 1) {
            System.out.println("How many students?");
            int userCount = scanner.nextInt();
            for (int i = 0; i < userCount; i++) {
                System.out.println("Enter firstName: ");
                String firstName = scanner.next();
                System.out.println("Enter lastName: ");
                String lastName = scanner.next();
                System.out.println("Enter cnp: ");
                String cnp = scanner.next();

                Student student = new Student();
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setCnp(cnp);

                studentRepository.save(student);
            }
        } else {
            System.out.println("How many schools?");
            int userCount = scanner.nextInt();
            for (int i = 0; i<userCount; i++) {
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("Enter address: ");
                String address = scanner.next();

                School school = new School();
                school.setName(name);
                school.setAddress(address);

                schoolRepository.save(school);
            }
        }
        schoolsManager.saveData();
    }

    //findByNameAndCnp metoda pentru student todo



//    public static void main(String[] args) {
//
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        applicationContext.register(ApplicationConfiguration.class);
//        applicationContext.refresh();
//
//        StudentRepository studentRepo = (StudentRepository) applicationContext.getBean("defaultStudentRepository");
//        SchoolRepository schoolRepo = (SchoolRepository) applicationContext.getBean("defaultSchoolRepository");
//
//        SchoolsManager manager = (SchoolsManager) applicationContext.getBean("schoolsManager");
//        manager.saveData();
//    }

}
