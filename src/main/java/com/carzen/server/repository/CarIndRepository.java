package com.carzen.server.repository;

import com.carzen.server.domain.CarInd;
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


public interface CarIndRepository extends JpaRepository<CarInd, Long> {
    @Override
    List<CarInd> findAll();

    @Override
    List<CarInd> findAll(Sort sort);

    @Override
    Page<CarInd> findAll(Pageable pageable);

    @Override
    List<CarInd> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(CarInd entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends CarInd> entities);

    @Override
    void deleteAll();

    @Override
    <S extends CarInd> S save(S entity);

    @Override
    <S extends CarInd> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<CarInd> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends CarInd> S saveAndFlush(S entity);

    @Override
    <S extends CarInd> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<CarInd> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    CarInd getOne(Long aLong);

    @Override
    CarInd getById(Long aLong);

    @Override
    CarInd getReferenceById(Long aLong);

    @Override
    <S extends CarInd> Optional<S> findOne(Example<S> example);

    @Override
    <S extends CarInd> List<S> findAll(Example<S> example);

    @Override
    <S extends CarInd> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends CarInd> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends CarInd> long count(Example<S> example);

    @Override
    <S extends CarInd> boolean exists(Example<S> example);

    @Override
    <S extends CarInd, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}