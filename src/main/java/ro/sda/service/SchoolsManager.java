package ro.sda.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.sda.model.School;
import ro.sda.model.Student;
import ro.sda.repository.SchoolRepository;
import ro.sda.repository.StudentRepository;

import java.util.Scanner;

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
        student1.setCnp("2930286374324");
        student1.setFirstName("Timea");
        student1.setLastName("Balogh");
        student1.setAge(24);
        student1.setEmail("Balogh@ffd");
        student1.setGender("female");
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setId(2);
        student2.setCnp("1930281746324");
        student2.setFirstName("Alin");
        student2.setLastName("Popa");
        student2.setAge(24);
        student2.setEmail("popa@ffd");
        student2.setGender("male");
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

        School school3 = new School();
        school3.setId(3);
        school3.setName("UBB");
        school3.setAddress("Cluj");
        schoolRepository.save(school3);

        School school4 = new School();
        school4.setId(4);
        school4.setName("UBB");
        school4.setAddress("Cluj");
        schoolRepository.save(school4);

    }

    public void findEntity() {
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
                    System.out.println(studentRepository.findByFirstName(firstName));
                    break;
                case 3:
                    System.out.println("Enter cnp: ");
                    String cnp2 = scanner.next();
                    System.out.println("Enter first name: ");
                    String firstName2 = scanner.next();
                    System.out.println("We have found: ");
                    System.out.println(studentRepository.findByFirstNameAndCnp(firstName2, cnp2));
                    break;

            }
        }
    }

    public void userInput() {
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
