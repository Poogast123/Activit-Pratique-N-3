package org.example.activite_pratique_n_3;

import jakarta.validation.Valid;
import org.example.activite_pratique_n_3.PatientRepository;
import org.example.activite_pratique_n_3.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/")
    public String listPatients(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "5") int size,
                               @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Patient> patients = (Page<Patient>) patientRepository.findByNameContaining(keyword, PageRequest.of(page, size));
        model.addAttribute("patients", patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/delete")
    public String deletePatient(@RequestParam Long id, @RequestParam int page, @RequestParam String keyword) {
        patientRepository.deleteById(id);
        return "redirect:/?page=" + page + "&keyword=" + keyword;
    }

    @PostMapping("/save")
    public String savePatient(@Valid @ModelAttribute Patient patient, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        patientRepository.save(patient);
        return "redirect:/patients";
    }
}
