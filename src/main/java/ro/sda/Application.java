package ro.sda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.sda.service.SchoolsManager;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SchoolsManager schoolsManager;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        schoolsManager.userInput();
//        schoolsManager.saveData();
//        schoolsManager.findEntity();
    }
}
