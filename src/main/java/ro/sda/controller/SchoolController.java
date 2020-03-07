package ro.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.model.School;
import ro.sda.repository.SchoolRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/school")
public class SchoolController {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @GetMapping("/add/")
    public String addSSchool(School school) {
        return "addSchool.html";
    }

    @PostMapping("/add/")
    public String processAddSchool(@Valid School school, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addSchool";
        }
        schoolRepository.save(school);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    @Secured("ADMIN")
    public String deleteSchool(@PathVariable long id) {
        schoolRepository.deleteById(id);
        return "redirect:/";
    }

    @Secured("ADMIN")
    @GetMapping("/edit/{id}")
    public String editSchool(@PathVariable long id, Model model) {
        Optional<School> school = schoolRepository.findById(id);
        if (!school.isPresent()) {
            return "redirect:/";
        }
        model.addAttribute("school", school);
        return "editSchool.html";
    }

    @PostMapping("/edit/")
    public String processEditSchool(@Valid School school, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editSchool";
        }
        schoolRepository.save(school);
        return "redirect:/";
    }
}
