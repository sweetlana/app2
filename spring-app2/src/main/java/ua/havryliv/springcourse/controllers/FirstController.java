package ua.havryliv.springcourse.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

	/*
	 * @GetMapping("/hello") public String helloPage(HttpServletRequest request) {
	 * String name = request.getParameter("name"); 
	 * String surname = request.getParameter("surname");
	 * 
	 * System.out.println("Hello," + name + " " + surname); return "first/hello"; }
	 */

	/*
	 * @GetMapping("/hello") public String helloPage(@RequestParam("name") String name, //expect that we populate params in url, if not - status 400
	 * 												 @RequestParam("surname") String surname) {
	 * 
	 * System.out.println("Hello," + name + " " + surname); return "first/hello"; }
	 */

	@GetMapping("/hello") 
	public String helloPage(@RequestParam(value = "name", required = false) String name,
												  @RequestParam(value = "surname", required = false) String surname,
												  Model model) {
			
		//System.out.println("Hello," + name + " " + surname); 
		model.addAttribute("message", "Hello," + name + " " + surname);
		
		return "first/hello"; }
	

	@GetMapping("/goodbye")
	public String goodByePage() {
		return "first/goodbye";
	}
	
	@GetMapping("/calculator")
	public String calculator(@RequestParam("a") int a, 
							 @RequestParam("b") int b,
							 @RequestParam("action") String action,
							 Model model) {
		String resultString = "Invalid parameters";
		
		if(action != null) {
			switch(action) {
			case "multiplication":
				resultString =  a + " * " + b + " = " +  a*b;
				break;
			case "addition":
				resultString = a + " + " + b + " = " +  (a+b);
				break;
			case "subtraction":
				resultString = a + " - " + b + " = " + (a-b);
				break;
			case "division":
				if(b != 0) {
					resultString = a + " / " + b + " = " +  a/(double)b;
				} else resultString = "Division by zero is deprecated";
				break;
			}
		}
		
		model.addAttribute("result", resultString);
		
		return "first/calculator";
		
	}
}
