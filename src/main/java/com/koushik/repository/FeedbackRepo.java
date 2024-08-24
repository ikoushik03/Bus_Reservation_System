package com.koushik.repository;

import com.koushik.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback,Integer> {
}
