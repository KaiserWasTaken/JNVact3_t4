package com.web.jnv_act3_t4.controllers;

import com.web.jnv_act3_t4.models.vehiculo;
import com.web.jnv_act3_t4.repository.vehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class vehiculoController {

    @Autowired
    private vehiculoRepository repo;

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("vehiculos", repo.findAll());
        return "index";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("vehiculo", new vehiculo());
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute vehiculo vehiculo) {
        repo.save(vehiculo);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        vehiculo vehiculo = repo.findById(id).orElseThrow();
        model.addAttribute("vehiculo", vehiculo);
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
