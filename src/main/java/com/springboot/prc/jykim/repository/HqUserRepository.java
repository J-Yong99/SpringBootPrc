package com.springboot.prc.jykim.repository;

import com.springboot.prc.jykim.domain.HqUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HqUserRepository extends JpaRepository<HqUser, Long> {
    HqUser save(HqUser HQUser);
    List<HqUser> findAll();
    Optional<HqUser> findByLoginId(String loginId);
}
