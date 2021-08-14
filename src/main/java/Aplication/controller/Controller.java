package Aplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/system")
public class Controller {
	
	@GetMapping
	public String getBook() {
		return"Anderson Ok";
	}

}
