package com.carzen.server.repository;

import com.carzen.server.domain.CompanyHoliday;
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


public interface CompHolidayRepository extends JpaRepository<CompanyHoliday, Long> {
    @Override
    List<CompanyHoliday> findAll();

    @Override
    List<CompanyHoliday> findAll(Sort sort);

    @Override
    Page<CompanyHoliday> findAll(Pageable pageable);

    @Override
    List<CompanyHoliday> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(CompanyHoliday entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends CompanyHoliday> entities);

    @Override
    void deleteAll();

    @Override
    <S extends CompanyHoliday> S save(S entity);

    @Override
    <S extends CompanyHoliday> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<CompanyHoliday> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends CompanyHoliday> S saveAndFlush(S entity);

    @Override
    <S extends CompanyHoliday> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<CompanyHoliday> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    CompanyHoliday getOne(Long aLong);

    @Override
    CompanyHoliday getById(Long aLong);

    @Override
    CompanyHoliday getReferenceById(Long aLong);

    @Override
    <S extends CompanyHoliday> Optional<S> findOne(Example<S> example);

    @Override
    <S extends CompanyHoliday> List<S> findAll(Example<S> example);

    @Override
    <S extends CompanyHoliday> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends CompanyHoliday> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends CompanyHoliday> long count(Example<S> example);

    @Override
    <S extends CompanyHoliday> boolean exists(Example<S> example);

    @Override
    <S extends CompanyHoliday, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}