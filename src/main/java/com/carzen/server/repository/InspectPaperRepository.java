package com.carzen.server.repository;

import com.carzen.server.domain.InspectPaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectPaperRepository extends JpaRepository<InspectPaper, Long> {
}