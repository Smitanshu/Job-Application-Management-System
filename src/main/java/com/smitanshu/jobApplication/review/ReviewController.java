package com.smitanshu.jobApplication.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {


    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }


    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,
                                            @RequestBody Review review) {

        boolean isReviewSaved = reviewService.addReview(companyId, review);

        if (isReviewSaved) {
            return new ResponseEntity<>("Review Added Successfully!!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Review Not Saved !!", HttpStatus.NOT_FOUND);

        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId) {

        Review review = reviewService.getReviewById(companyId, reviewId);


        if (review == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(review, HttpStatus.OK);
    }
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {

        boolean isReviewdeleted = reviewService.deleteReviewById(companyId, reviewId);

        if (isReviewdeleted) {
            return new ResponseEntity<>("Review Deleted SuccessFully!!", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Review Not Deleted Successfully!!", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review review) {
        boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId, review);
        if (isReviewUpdated) {
            return new ResponseEntity<>("Review Updated Successfully!!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review  Not Updated !!", HttpStatus.NOT_FOUND);
        }
    }
}
