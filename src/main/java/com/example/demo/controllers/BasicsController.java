package com.example.demo.controllers;

import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class BasicsController {

    @Resource
    PersonRepository personRepo;

    @RequestMapping("/")
    public String goHome(Model model) {
        model.addAttribute("allPeople", personRepo.findAll());
        return "home";
    }

    @RequestMapping("/home")
    public String goHomeAgain(Model model) {
        model.addAttribute("allPeople", personRepo.findAll());
        return "home";
    }

    @RequestMapping("/random-page")
    public String randomPage() {
        return "randomPage";
    }


    @RequestMapping("/enter-person")
    public String enterPerson() {
        return "enterPerson";
    }

    @PostMapping("/add-person")
    public String addPerson(@RequestParam String firstName, String lastName) {
        Person personToAdd = new Person(firstName, lastName);
        personRepo.save(personToAdd);
        return "redirect:home";
    }

//    @PostMapping("/add-pet")
//    public String addPet(@RequestParam String petName, String petType, int petAge, String petDesc, int petTemperament, String petNeeds, Boolean goodWithKids, Boolean hypoallergenic, String petImageUrl) {
//        Pet petToAdd = new Pet(petName, petType, petAge, petDesc, petTemperament, petNeeds, goodWithKids, hypoallergenic, petImageUrl);
//        petRepo.save(petToAdd);
//        return "redirect:pets";
//    }


}
