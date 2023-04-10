package com.carzen.server.repository;

import com.carzen.server.domain.CompanyHoliRules;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public interface CompHoliRulesRepository extends JpaRepository<CompanyHoliRules, Long> {
    @Override
    List<CompanyHoliRules> findAll();

    @Override
    List<CompanyHoliRules> findAll(Sort sort);

    @Override
    Page<CompanyHoliRules> findAll(Pageable pageable);

    @Override
    List<CompanyHoliRules> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(CompanyHoliRules entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends CompanyHoliRules> entities);

    @Override
    void deleteAll();

    @Override
    <S extends CompanyHoliRules> S save(S entity);

    @Override
    <S extends CompanyHoliRules> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<CompanyHoliRules> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends CompanyHoliRules> S saveAndFlush(S entity);

    @Override
    <S extends CompanyHoliRules> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<CompanyHoliRules> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    CompanyHoliRules getOne(Long aLong);

    @Override
    CompanyHoliRules getById(Long aLong);

    @Override
    CompanyHoliRules getReferenceById(Long aLong);

    @Override
    <S extends CompanyHoliRules> Optional<S> findOne(Example<S> example);

    @Override
    <S extends CompanyHoliRules> List<S> findAll(Example<S> example);

    @Override
    <S extends CompanyHoliRules> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends CompanyHoliRules> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends CompanyHoliRules> long count(Example<S> example);

    @Override
    <S extends CompanyHoliRules> boolean exists(Example<S> example);

    @Override
    <S extends CompanyHoliRules, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}