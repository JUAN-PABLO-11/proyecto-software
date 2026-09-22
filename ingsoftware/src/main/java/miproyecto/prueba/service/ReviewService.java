package miproyecto.prueba.service;

import miproyecto.prueba.model.Review;
import miproyecto.prueba.repository.BookRepository;
import miproyecto.prueba.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private static final int MAX_CONTENT_LENGTH = 2000;

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;

    public ReviewService(ReviewRepository reviewRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.bookRepository = bookRepository;
    }

    public Review previewReview(Review review) {
        validateReview(review);
        // No se persiste: se devuelve el mismo objeto ya validado/normalizado
        return review;
    }

    public Review submitReview(Review review) {
        validateReview(review);
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    private void validateReview(Review review) {
        if (review.getBookId() == null) {
            throw new IllegalArgumentException("Debe indicar el libro que se está reseñando");
        }

        if (!bookRepository.existsById(review.getBookId())) {
            throw new IllegalArgumentException("El libro indicado no existe en el catálogo");
        }

        if (review.getUsername() == null || review.getUsername().isBlank()) {
            throw new IllegalArgumentException("El nombre de usuario es obligatorio");
        }

        if (review.getContent() == null || review.getContent().isBlank()) {
            throw new IllegalArgumentException("La reseña no puede estar vacía");
        }

        if (review.getContent().length() > MAX_CONTENT_LENGTH) {
            throw new IllegalArgumentException(
                    "La reseña no puede superar los " + MAX_CONTENT_LENGTH + " caracteres");
        }
    }
}
