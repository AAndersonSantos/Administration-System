package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
