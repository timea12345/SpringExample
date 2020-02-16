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
//        userInput();
        schoolsManager.saveData();
        findEntity();
    }

    private void findEntity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you need to find?");
        System.out.println("1.School");
        System.out.println("2.Student");
        int option = scanner.nextInt();

        if (option == 1) {
            System.out.println("1. by name");
            System.out.println("2. by address and name");
            int byWhat = scanner.nextInt();

            if (byWhat == 1) {
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("We have found: ");
                System.out.println(schoolRepository.findByName(name));
            } else {
                System.out.println("Enter address: ");
                String address = scanner.next();
                System.out.println("Enter name: ");
                String name = scanner.next();
                System.out.println("We have found: ");
                System.out.println(schoolRepository.findAllByAddressAndName(address, name));
            }
        } else {
            System.out.println("1. by cnp");
            System.out.println("2. by first name");
            System.out.println("3. by cnp and first name");
            int byWhat = scanner.nextInt();

            switch (byWhat) {
                case 1:
                    System.out.println("Enter cnp: ");
                    String cnp = scanner.next();
                    System.out.println("We have found: ");
                    System.out.println(studentRepository.findByCnp(cnp));
                    break;
                case 2:
                    System.out.println("Enter first name: ");
                    String firstName = scanner.next();
                    System.out.println("We have found: ");
                    System.out.println(studentRepository.findByName(firstName));
                    break;
                case 3:
                    System.out.println("Enter cnp: ");
                    String cnp2 = scanner.next();
                    System.out.println("Enter first name: ");
                    String firstName2 = scanner.next();
                    System.out.println("We have found: ");
                    System.out.println(studentRepository.findByNameAndCnp(firstName2, cnp2));
                    break;

            }
        }
    }

    private void userInput() {
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
    }


}
