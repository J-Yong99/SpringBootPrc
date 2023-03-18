package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.RsvInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RsvInfoRepository extends JpaRepository<RsvInfo, Long> {
}