package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.InspectQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectQuestionRepository extends JpaRepository<InspectQuestion, Long> {
}