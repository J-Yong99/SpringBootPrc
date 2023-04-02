package com.carzen.server.repository;

import com.carzen.server.domain.RsvInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RsvInfoRepository extends JpaRepository<RsvInfo, Long>, RsvInfoRepositoryCustom {
}