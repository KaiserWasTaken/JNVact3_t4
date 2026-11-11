package com.web.jnv_act3_t4.controllers;

import com.web.jnv_act3_t4.models.vehiculo;
import com.web.jnv_act3_t4.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class vehiculoController {

    private final VehiculoService vehiculoService;

    @Autowired
    public vehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("vehiculos", vehiculoService.listarVehiculos());
        return "index";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("vehiculo", new vehiculo());
        model.addAttribute("marcas", vehiculoService.listarMarcas());
        return "form";
    }

    @PostMapping("/guardar")
    public String guardar(
            @ModelAttribute vehiculo vehiculo,
            @RequestParam Integer marcaId) {
        vehiculoService.guardar(vehiculo, marcaId);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        vehiculo vehiculo = vehiculoService.buscarPorId(id);
        model.addAttribute("vehiculo", vehiculo);
        model.addAttribute("marcas", vehiculoService.listarMarcas());
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        vehiculoService.eliminar(id);
        return "redirect:/";
    }
}
