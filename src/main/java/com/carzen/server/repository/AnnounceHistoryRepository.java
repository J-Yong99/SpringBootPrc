package com.carzen.server.repository;

import com.carzen.server.domain.AnnounceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnounceHistoryRepository extends JpaRepository<AnnounceHistory, Long> {
}