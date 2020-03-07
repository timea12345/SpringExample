package ro.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.model.School;
import ro.sda.model.Student;
import ro.sda.repository.SchoolRepository;
import ro.sda.repository.StudentRepository;

@org.springframework.stereotype.Controller
public class Controller {

    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public Controller(SchoolRepository schoolRepository, StudentRepository studentRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        Iterable<School> schools = schoolRepository.findAll();
        model.addAttribute("schools", schools);
        Iterable<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "index";
    }
}
