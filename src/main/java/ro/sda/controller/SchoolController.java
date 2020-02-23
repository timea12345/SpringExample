package ro.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.model.School;
import ro.sda.model.Student;
import ro.sda.repository.SchoolRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SchoolController {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

//    @GetMapping("/")
//    public String getIndex(Model model) {
//        Iterable<School> schools = schoolRepository.findAll();
//        model.addAttribute("schools", schools);
//        return "index";
//    }

    @GetMapping("/addSchool/")
    public String addSSchool(School school) {
        return "addSchool.html";
    }

    @PostMapping("/addSchool/")
    public String processAddSchool(@Valid School school, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addSchool";
        }
        schoolRepository.save(school);
        return "redirect:/";
    }

    @GetMapping("/deleteSchool/{id}")
    public String deleteSchool(@PathVariable long id) {
        schoolRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/editSchool/{id}")
    public String editSchool(@PathVariable long id, Model model) {
        Optional<School> school = schoolRepository.findById(id);
        if (!school.isPresent()) {
            return "redirect:/";
        }
        model.addAttribute("school", school);
        return "editSchool.html";
    }

    @PostMapping("/editSchool/")
    public String processEditSchool(@Valid School school, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editSchool";
        }
        schoolRepository.save(school);
        return "redirect:/";
    }
}
