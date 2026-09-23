package miproyecto.prueba.service;

import miproyecto.prueba.model.Book;
import miproyecto.prueba.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> searchBooks(String query) {
        return bookRepository.findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCase(query, query);
    }

    public List<Book> searchBooks(String author, String title, String isbn) {
        return bookRepository.searchBooks(author, title, isbn);
    }
}