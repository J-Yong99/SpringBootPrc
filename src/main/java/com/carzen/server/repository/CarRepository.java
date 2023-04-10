package com.carzen.server.repository;

import com.carzen.server.domain.Car;
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


public interface CarRepository extends JpaRepository<Car, Long> {
    @Override
    List<Car> findAll();

    @Override
    List<Car> findAll(Sort sort);

    @Override
    Page<Car> findAll(Pageable pageable);

    @Override
    List<Car> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Car entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Car> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Car> S save(S entity);

    @Override
    <S extends Car> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Car> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends Car> S saveAndFlush(S entity);

    @Override
    <S extends Car> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<Car> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Car getOne(Long aLong);

    @Override
    Car getById(Long aLong);

    @Override
    Car getReferenceById(Long aLong);

    @Override
    <S extends Car> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Car> List<S> findAll(Example<S> example);

    @Override
    <S extends Car> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Car> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Car> long count(Example<S> example);

    @Override
    <S extends Car> boolean exists(Example<S> example);

    @Override
    <S extends Car, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}