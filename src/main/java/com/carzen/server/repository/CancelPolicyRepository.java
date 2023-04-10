package com.carzen.server.repository;

import com.carzen.server.domain.CancelPolicy;
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


public interface CancelPolicyRepository extends JpaRepository<CancelPolicy, Long> {
    @Override
    List<CancelPolicy> findAll();

    @Override
    List<CancelPolicy> findAll(Sort sort);

    @Override
    Page<CancelPolicy> findAll(Pageable pageable);

    @Override
    List<CancelPolicy> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(CancelPolicy entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends CancelPolicy> entities);

    @Override
    void deleteAll();

    @Override
    <S extends CancelPolicy> S save(S entity);

    @Override
    <S extends CancelPolicy> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<CancelPolicy> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends CancelPolicy> S saveAndFlush(S entity);

    @Override
    <S extends CancelPolicy> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<CancelPolicy> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    CancelPolicy getOne(Long aLong);

    @Override
    CancelPolicy getById(Long aLong);

    @Override
    CancelPolicy getReferenceById(Long aLong);

    @Override
    <S extends CancelPolicy> Optional<S> findOne(Example<S> example);

    @Override
    <S extends CancelPolicy> List<S> findAll(Example<S> example);

    @Override
    <S extends CancelPolicy> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends CancelPolicy> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends CancelPolicy> long count(Example<S> example);

    @Override
    <S extends CancelPolicy> boolean exists(Example<S> example);

    @Override
    <S extends CancelPolicy, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}