package ua.vadym.people_book.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.vadym.people_book.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
