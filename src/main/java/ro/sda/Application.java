package ro.sda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SchoolsManager schoolsManager;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        schoolsManager.saveData();
    }


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
