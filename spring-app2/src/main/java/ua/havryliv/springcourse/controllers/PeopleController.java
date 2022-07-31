package ua.havryliv.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.havryliv.springcourse.dao.PersonDAO;
import ua.havryliv.springcourse.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {
	
//	@Autowired
//	private PersonDAO personDAO;
	
	private final PersonDAO personDAO;
	
	@Autowired // its possible not to write this annotation
	public PeopleController(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	@GetMapping()
	public String index(Model model) {
		//get all people from DAO and transfer it to model and return View
		model.addAttribute("people", personDAO.index());
		return "/people/index";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		//get one person by id from DAO and transfer it to model and return view
		model.addAttribute("person", personDAO.show(id));
		return "/people/show";
	}

	/*
	 * @GetMapping("/new") 
	 * public String newPerson(Model model) {
	 * model.addAttribute("person", new Person());
	 * return "people/new"; }
	 */
	
	@GetMapping("/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "people/new";
	}
	
	@PostMapping
	public String create(@ModelAttribute("person") Person person) {
		personDAO.save(person);
		return "redirect:/people";
	}
	
	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") int id) {
		model.addAttribute("person", personDAO.show(id));
		return "people/edit";
	}
	
	@PatchMapping("/{id}")
	public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
		personDAO.update(id, person);
		return "redirect:/people";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		personDAO.delete(id);
		return "redirect:/people";
	}
}
