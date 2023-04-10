package com.carzen.server.repository;

import com.carzen.server.domain.Career;
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


public interface CareerRepository extends JpaRepository<Career, Long> {
    @Override
    List<Career> findAll();

    @Override
    List<Career> findAll(Sort sort);

    @Override
    Page<Career> findAll(Pageable pageable);

    @Override
    List<Career> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Career entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Career> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Career> S save(S entity);

    @Override
    <S extends Career> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Career> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends Career> S saveAndFlush(S entity);

    @Override
    <S extends Career> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<Career> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Career getOne(Long aLong);

    @Override
    Career getById(Long aLong);

    @Override
    Career getReferenceById(Long aLong);

    @Override
    <S extends Career> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Career> List<S> findAll(Example<S> example);

    @Override
    <S extends Career> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Career> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Career> long count(Example<S> example);

    @Override
    <S extends Career> boolean exists(Example<S> example);

    @Override
    <S extends Career, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}