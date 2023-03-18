package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}