package com.carzen.server.repository;

import com.carzen.server.domain.Company;
import com.carzen.server.domain.RsvInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface RsvInfoRepository extends JpaRepository<RsvInfo, Long>, RsvInfoRepositoryCustom {

    @Override
    List<RsvInfo> findAll();

    @Override
    List<RsvInfo> findAll(Sort sort);

    @Override
    Page<RsvInfo> findAll(Pageable pageable);

    @Override
    List<RsvInfo> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(RsvInfo entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends RsvInfo> entities);

    @Override
    void deleteAll();

    @Override
    <S extends RsvInfo> S save(S entity);

    @Override
    <S extends RsvInfo> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<RsvInfo> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends RsvInfo> S saveAndFlush(S entity);

    @Override
    <S extends RsvInfo> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<RsvInfo> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    RsvInfo getOne(Long aLong);

    @Override
    RsvInfo getById(Long aLong);

    @Override
    RsvInfo getReferenceById(Long aLong);

    @Override
    <S extends RsvInfo> Optional<S> findOne(Example<S> example);

    @Override
    <S extends RsvInfo> List<S> findAll(Example<S> example);

    @Override
    <S extends RsvInfo> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends RsvInfo> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends RsvInfo> long count(Example<S> example);

    @Override
    <S extends RsvInfo> boolean exists(Example<S> example);

    @Override
    <S extends RsvInfo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    boolean existsByCompanyAndYearDateAndInspectTime(Company company, LocalDate yearDate, Long inspectTime);
}