package com.smitanshu.jobApplication.review.impl;


import com.smitanshu.jobApplication.company.Company;
import com.smitanshu.jobApplication.company.CompanyService;
import com.smitanshu.jobApplication.review.Review;
import com.smitanshu.jobApplication.review.ReviewRepository;
import com.smitanshu.jobApplication.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);

            return true;
        } else {

            return false;
        }

    }

    @Override
    public Review getReviewById(Long companyId, Long reviewId) {

        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteReviewById(Long companyId, Long reviewId) {

        if (companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {


            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            //Due to the Bidirectional Mapping
            review.setCompany(null);
            companyService.updateCompany(company, reviewId);
            reviewRepository.deleteById(reviewId);
            return true;


        } else {
            return false;
        }

    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {

        if (companyService.getCompanyById(companyId) != null) {
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        } else {
            return false;
        }

    }
}
