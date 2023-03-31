package com.carzen.server.repository;

import com.carzen.server.domain.InspectQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectQuestionRepository extends JpaRepository<InspectQuestion, Long> {
}