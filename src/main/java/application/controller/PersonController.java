package application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import application.dto.request.PersonDTO;
import application.dto.response.MessagenResponseDTO;
import application.exception.PersonNotFoundException;
import application.service.PersonService;

@RestController
@RequestMapping("/api/system")
public class PersonController {
	
	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	//created
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessagenResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}

	@GetMapping
	public List<PersonDTO> listall() {
		return personService.listAll();
	}
	
	//find by Id
	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}
	
	//Update
	@PutMapping("/{id}")
	//@ResponseStatus(HttpStatus.OK)
	public MessagenResponseDTO update(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
		return personService.update(id, personDTO);
	}
	
	//Delete
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }

}
