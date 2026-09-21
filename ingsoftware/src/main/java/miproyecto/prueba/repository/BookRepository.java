package miproyecto.prueba.repository;

import miproyecto.prueba.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Spring genera la consulta automáticamente a partir del nombre del método
    List<Book> findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCase(String author, String title);

    List<Book> findByIsbn(String isbn);

    @Query("SELECT b FROM Book b WHERE " +
            "(:author IS NULL OR LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%'))) AND " +
            "(:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:isbn IS NULL OR b.isbn = :isbn)")
    List<Book> searchBooks(@Param("author") String author,
                           @Param("title") String title,
                           @Param("isbn") String isbn);
}