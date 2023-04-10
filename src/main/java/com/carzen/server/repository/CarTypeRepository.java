package com.carzen.server.repository;

import com.carzen.server.domain.CarType;
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


public interface CarTypeRepository extends JpaRepository<CarType, Long> {
    @Override
    List<CarType> findAll();

    @Override
    List<CarType> findAll(Sort sort);

    @Override
    Page<CarType> findAll(Pageable pageable);

    @Override
    List<CarType> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(CarType entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends CarType> entities);

    @Override
    void deleteAll();

    @Override
    <S extends CarType> S save(S entity);

    @Override
    <S extends CarType> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<CarType> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends CarType> S saveAndFlush(S entity);

    @Override
    <S extends CarType> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<CarType> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    CarType getOne(Long aLong);

    @Override
    CarType getById(Long aLong);

    @Override
    CarType getReferenceById(Long aLong);

    @Override
    <S extends CarType> Optional<S> findOne(Example<S> example);

    @Override
    <S extends CarType> List<S> findAll(Example<S> example);

    @Override
    <S extends CarType> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends CarType> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends CarType> long count(Example<S> example);

    @Override
    <S extends CarType> boolean exists(Example<S> example);

    @Override
    <S extends CarType, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}