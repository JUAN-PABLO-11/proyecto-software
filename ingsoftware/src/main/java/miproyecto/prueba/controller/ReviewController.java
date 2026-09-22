package miproyecto.prueba.controller;


import miproyecto.prueba.model.Review;
import miproyecto.prueba.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/preview")
    public Review previewReview(@RequestBody Review review) {
        return reviewService.previewReview(review);
    }

    @PostMapping
    public Review submitReview(@RequestBody Review review) {
        return reviewService.submitReview(review);
    }

    @GetMapping("/book/{bookId}")
    public List<Review> getReviewsByBookId(@PathVariable Long bookId) {
        return reviewService.getReviewsByBookId(bookId);
    }
}