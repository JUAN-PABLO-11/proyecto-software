package miproyecto.prueba.controller;

import miproyecto.prueba.model.Book;
import miproyecto.prueba.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(name = "q", required = false) String query,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String isbn) {

        if (query != null && !query.isBlank()) {
            return bookService.searchBooks(query.trim());
        }

        return bookService.searchBooks(author, title, isbn);
    }
}