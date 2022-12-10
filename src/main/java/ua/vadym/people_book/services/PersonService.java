package ua.vadym.people_book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.vadym.people_book.models.Book;
import ua.vadym.people_book.models.Person;
import ua.vadym.people_book.repositories.BookRepository;
import ua.vadym.people_book.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;
    private final BookRepository bookRepository;

    @Autowired
    public PersonService(PersonRepository personRepository, BookRepository bookRepository) {
        this.personRepository = personRepository;

        this.bookRepository = bookRepository;
    }

    public List<Person> getListPeople() {
      return   personRepository.findAll();
    }

    public Person getPersonId(int id) {
        Optional<Person> foundPerson = personRepository.findById(id);
        return foundPerson.orElse(null);
    }


    @Transactional
    public void  savePerson(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }


    @Transactional
    public void editPersonage(int id, Person person) {
        person.setId(id);
        personRepository.save(person);
    }


}
