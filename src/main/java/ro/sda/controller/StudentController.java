package ro.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.model.Student;
import ro.sda.repository.StudentRepository;
import java.util.Optional;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping("/add/")
    public String getAddStudentView(Student student) {
        return "addStudents.html";
    }

    @PostMapping("/add/")
    public String processAddStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable long id, Model model) {
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            return "redirect:/";
        }
        model.addAttribute("student", student);
        return "editStudent.html";
    }

    @PostMapping("/edit/")
    public String processEditStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/";
    }


}
