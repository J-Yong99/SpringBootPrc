package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.AnnounceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnounceHistoryRepository extends JpaRepository<AnnounceHistory, Long> {
}