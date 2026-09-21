package miproyecto.prueba.controller;

import miproyecto.prueba.model.Rating;
import miproyecto.prueba.service.RatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public Rating addRating(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }

    @GetMapping("/book/{bookId}")
    public List<Rating> getRatingsByBookId(@PathVariable Long bookId) {
        return ratingService.getRatingsByBookId(bookId);
    }
}