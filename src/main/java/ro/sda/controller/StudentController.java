package ro.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.model.Student;
import ro.sda.repository.StudentRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/add/")
    public String getAddStudentView(Student student) {
        return "addStudents.html";
    }

    @PostMapping("/add/")
    public String processAddStudent(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addStudents";
        }
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
    public String processEditStudent(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editStudent";
        }
        studentRepository.save(student);
        return "redirect:/";
    }


}
