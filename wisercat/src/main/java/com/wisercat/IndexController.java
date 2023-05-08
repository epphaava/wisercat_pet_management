package com.wisercat;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {

    @Autowired
    PetService petService;

    @Autowired
    PetRepository petRepository;

    @GetMapping("add")
    public String add() {
        return "add";
    }

    @GetMapping("table")
    public String table() {
        return "table";
    }

    @PostMapping("add")
    public String addPet(@ModelAttribute Pet pet, Model model) {

        System.out.println(pet.toString());

        petRepository.save(pet);

        return "table";
    }


    @RequestMapping("add")
    public String editPetById(org.springframework.ui.Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException, ChangeSetPersister.NotFoundException {
        if (id.isPresent()) {
            Pet entity = petService.getPetById(id.get());
            model.addAttribute("pet", entity);
        } else model.addAttribute("pet", new Pet());
        return "table";
    }
}