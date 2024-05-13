package org.example.maria1.Controller;



import jakarta.persistence.EntityNotFoundException;
import org.example.maria1.model.Auto;
import org.example.maria1.services.AutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


import java.util.Optional;

@Controller
@RequestMapping("/auto")
public class AutoController {

    private final AutoService autoService;



    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @GetMapping("/lista")
    public String listar(Model model) {
        Iterable<Auto> auto = autoService.listarAuto();
        model.addAttribute("autos", auto);
        return "ListaVehiculo";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        Iterable<Auto> autoss = autoService.listarAuto();
        model.addAttribute("auto1", autoss);
        return "registro-vehiculos";
    }



    @PostMapping("/crear")
    public RedirectView crearauto(@ModelAttribute Auto auto, RedirectAttributes redirectAttributes) {
        autoService.crear(auto);
        redirectAttributes.addFlashAttribute("mensaje", "Curso creado correctamente");
        return new RedirectView("/auto/lista");
    }

    @GetMapping("/editar/{id}")
    public String Editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Auto> cursoOptional = autoService.obtenerPorId(id);

        if (cursoOptional.isPresent()) {
            model.addAttribute("cursoeditar", cursoOptional.get());
            return "Administrador/html/Curso/ModificarCurso";
        } else {
            redirectAttributes.addFlashAttribute("error", "El curso con ID " + id + " no existe.");
            return "redirect:/cursos/lista";
        }
    }

    @PostMapping("/actualizar/{id}")
    public RedirectView actualizar(@PathVariable Long id, @ModelAttribute Auto autoactua, RedirectAttributes redirectAttributes) {
        try {
            autoService.actualizar(id, autoactua);
            redirectAttributes.addFlashAttribute("mensaje", "Curso actualizado correctamente");
        } catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el curso: Curso no encontrado");
        }
        return new RedirectView("/cursos/lista");
    }

    @GetMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            autoService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Curso eliminado correctamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el curso");
        }
        return new RedirectView("/cursos/lista");
    }
}