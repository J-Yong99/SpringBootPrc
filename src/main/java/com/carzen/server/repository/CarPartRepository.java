package com.carzen.server.repository;

import com.carzen.server.domain.CarPart;
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


public interface CarPartRepository extends JpaRepository<CarPart, Long> {
    @Override
    List<CarPart> findAll();

    @Override
    List<CarPart> findAll(Sort sort);

    @Override
    Page<CarPart> findAll(Pageable pageable);

    @Override
    List<CarPart> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(CarPart entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends CarPart> entities);

    @Override
    void deleteAll();

    @Override
    <S extends CarPart> S save(S entity);

    @Override
    <S extends CarPart> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<CarPart> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends CarPart> S saveAndFlush(S entity);

    @Override
    <S extends CarPart> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<CarPart> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    CarPart getOne(Long aLong);

    @Override
    CarPart getById(Long aLong);

    @Override
    CarPart getReferenceById(Long aLong);

    @Override
    <S extends CarPart> Optional<S> findOne(Example<S> example);

    @Override
    <S extends CarPart> List<S> findAll(Example<S> example);

    @Override
    <S extends CarPart> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends CarPart> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends CarPart> long count(Example<S> example);

    @Override
    <S extends CarPart> boolean exists(Example<S> example);

    @Override
    <S extends CarPart, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}