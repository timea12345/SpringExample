import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.sda.SchoolsManager;
import ro.sda.config.ApplicationConfiguration;
import ro.sda.model.School;
import ro.sda.model.Student;
import ro.sda.repository.SchoolRepository;
import ro.sda.repository.StudentRepository;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ApplicationConfiguration.class);
        applicationContext.refresh();

        StudentRepository studentRepo = (StudentRepository) applicationContext.getBean("defaultStudentRepository");
        SchoolRepository schoolRepo = (SchoolRepository) applicationContext.getBean("defaultSchoolRepository");

        SchoolsManager manager = (SchoolsManager) applicationContext.getBean("schoolsManager");
        manager.saveData();
    }

}
