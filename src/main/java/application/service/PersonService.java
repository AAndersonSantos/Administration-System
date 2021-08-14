package application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.dto.mapper.PersonMapper;
import application.dto.request.PersonDTO;
import application.dto.response.MessagenResponseDTO;
import application.entities.Person;
import application.exception.PersonNotFoundException;
import application.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public MessagenResponseDTO createPerson(PersonDTO personDTO) {
		Person personToSave = personMapper.toModel(personDTO);

		Person savedPerson = personRepository.save(personToSave);
		return MessagenResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();
	}

	public List<PersonDTO> listAll() {
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());

	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

		return personMapper.toDTO(person);
	}

	public MessagenResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

		Person personToUpdate = personMapper.toModel(personDTO);

		Person savedPerson = personRepository.save(personToUpdate);
		return MessagenResponseDTO.builder().message("Update person with ID " + savedPerson.getId()).build();
	}

	public void delete(Long id) throws PersonNotFoundException {

		personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

		personRepository.deleteById(id);

	}

}
