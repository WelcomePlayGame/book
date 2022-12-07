package ua.vadym.people_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.vadym.people_book.models.Person;
import ua.vadym.people_book.services.PersonService;

@Controller
@RequestMapping("/people")
public class PersonControler {


    private final PersonService personService;

    @Autowired
    public PersonControler(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String getListPerson (Model model){
        model.addAttribute("personList", personService.getListPeople());
        return "people/people";
    }

    @GetMapping("/{id}")
    public String getPersonId(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("personId", personService.getPersonId(id));
        return "people/show";
    }

    @GetMapping("/add")
    public String newPerson(Model model) {
        model.addAttribute("personOBJ", new Person());
        return "people/add";
    }

    @PostMapping
    public String addPerson(@ModelAttribute("person") Person person) {
        personService.savePerson(person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id ) {
        personService.deletePerson(id);
        return "redirect:/people";
    }
}
