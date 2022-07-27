package ua.havryliv.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.havryliv.springcourse.dao.PersonDAO;

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

}
