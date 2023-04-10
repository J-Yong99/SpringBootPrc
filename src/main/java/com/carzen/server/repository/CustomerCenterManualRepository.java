package com.carzen.server.repository;

import com.carzen.server.domain.CustomerCenterManual;
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


public interface CustomerCenterManualRepository extends JpaRepository<CustomerCenterManual, Long> {
    @Override
    List<CustomerCenterManual> findAll();

    @Override
    List<CustomerCenterManual> findAll(Sort sort);

    @Override
    Page<CustomerCenterManual> findAll(Pageable pageable);

    @Override
    List<CustomerCenterManual> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(CustomerCenterManual entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends CustomerCenterManual> entities);

    @Override
    void deleteAll();

    @Override
    <S extends CustomerCenterManual> S save(S entity);

    @Override
    <S extends CustomerCenterManual> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<CustomerCenterManual> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends CustomerCenterManual> S saveAndFlush(S entity);

    @Override
    <S extends CustomerCenterManual> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<CustomerCenterManual> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    CustomerCenterManual getOne(Long aLong);

    @Override
    CustomerCenterManual getById(Long aLong);

    @Override
    CustomerCenterManual getReferenceById(Long aLong);

    @Override
    <S extends CustomerCenterManual> Optional<S> findOne(Example<S> example);

    @Override
    <S extends CustomerCenterManual> List<S> findAll(Example<S> example);

    @Override
    <S extends CustomerCenterManual> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends CustomerCenterManual> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends CustomerCenterManual> long count(Example<S> example);

    @Override
    <S extends CustomerCenterManual> boolean exists(Example<S> example);

    @Override
    <S extends CustomerCenterManual, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}