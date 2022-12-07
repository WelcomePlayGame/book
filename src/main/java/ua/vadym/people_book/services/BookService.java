package ua.vadym.people_book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.vadym.people_book.models.Book;
import ua.vadym.people_book.models.Person;
import ua.vadym.people_book.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBookList() {
     return    bookRepository.findAll();
    }

    public Book getBookId(int id) {
        Optional<Book> foundBook = bookRepository.findById(id);
        return foundBook.orElse(null);
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }
}
