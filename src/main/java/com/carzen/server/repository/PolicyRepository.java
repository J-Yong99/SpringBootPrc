package com.carzen.server.repository;

import com.carzen.server.domain.Policy;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    @Override
    List<Policy> findAll();

    @Override
    List<Policy> findAll(Sort sort);

    @Override
    Page<Policy> findAll(Pageable pageable);

    @Override
    List<Policy> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Policy entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Policy> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Policy> S save(S entity);

    @Override
    <S extends Policy> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Policy> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends Policy> S saveAndFlush(S entity);

    @Override
    <S extends Policy> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<Policy> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Policy getOne(Long aLong);

    @Override
    Policy getById(Long aLong);

    @Override
    Policy getReferenceById(Long aLong);

    @Override
    <S extends Policy> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Policy> List<S> findAll(Example<S> example);

    @Override
    <S extends Policy> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Policy> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Policy> long count(Example<S> example);

    @Override
    <S extends Policy> boolean exists(Example<S> example);

    @Override
    <S extends Policy, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}