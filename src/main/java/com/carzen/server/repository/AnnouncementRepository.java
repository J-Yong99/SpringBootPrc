package com.carzen.server.repository;

import com.carzen.server.domain.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}