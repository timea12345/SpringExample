package ro.sda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.sda.repository.SchoolRepository;
import ro.sda.repository.StudentRepository;

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
//        schoolsManager.userInput();
        schoolsManager.saveData();
        schoolsManager.findEntity();
    }
}
