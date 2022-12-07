package ua.vadym.people_book.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.vadym.people_book.models.Book;
import ua.vadym.people_book.services.BookService;

@Controller
@RequestMapping("/book")
public class BookController {


    private  final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public String getListBook(Model model) {
        model.addAttribute("bookList", bookService.getBookList());
        return "books/book";
    }
    @GetMapping("/{id}")
    public String getBookId(@PathVariable("id") int id, Model model) {
        model.addAttribute("bookId", bookService.getBookId(id));
        return "books/show";
    }

    @GetMapping("/add")
    public String newBook(Model model) {
    model.addAttribute("bookOBJ", new Book());
    return "books/add";
    }

    @PostMapping
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/book";
    }


}
