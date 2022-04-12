package com.example.demo.controller;

import com.example.demo.entity.Toy;
import com.example.demo.service.ToyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToyController {

    private ToyService toyService;

    public ToyController(ToyService toyService) {
        super();
        this.toyService = toyService;
    }
    @GetMapping("/toys")
    public String listToys(Model model) {
        model.addAttribute("toys", toyService.getAllToys());
        return "toys";
    }

    @GetMapping("/toys/new")
    public String createToyForm(Model model) {
        Toy toy = new Toy();
        model.addAttribute("toy", toy);
        return "create_toy";

    }

    @PostMapping("/toys")
    public String saveToy(@ModelAttribute("toy") Toy toy) {
        toyService.saveToy(toy);
        return "redirect:/toys";
    }

    @GetMapping("/toys/edit/{id}")
    public String editToyForm(@PathVariable Long id, Model model) {
        model.addAttribute("toy", toyService.getToyById(id));
        return "edit_toy";
    }

    @PostMapping("/toys/{id}")
    public String updateToy(@PathVariable Long id,
                                 @ModelAttribute("toy") Toy toy,
                                 Model model) {
        Toy existingToy = toyService.getToyById(id);
        existingToy.setId(id);
        existingToy.setName(toy.getName());
        existingToy.setPrice(toy.getPrice());

        toyService.updateToy(existingToy);
        return "redirect:/toys";
    }

    @GetMapping("/toys/{id}")
    public String deleteToy(@PathVariable Long id) {
        toyService.deleteToyById(id);
        return "redirect:/toys";
    }

}

