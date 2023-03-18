package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.InspectPaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectPaperRepository extends JpaRepository<InspectPaper, Long> {
}