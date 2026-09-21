package miproyecto.prueba.service;

import miproyecto.prueba.model.Rating;
import miproyecto.prueba.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Rating rating) {
        if (rating.getScore() < 1 || rating.getScore() > 5) {
            throw new IllegalArgumentException("La puntuacion debe ser entre 1 a 5");
        }
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsByBookId(Long bookId) {
        return ratingRepository.findByBookId(bookId);
    }
}