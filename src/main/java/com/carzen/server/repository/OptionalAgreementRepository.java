package com.carzen.server.repository;

import com.carzen.server.domain.OptionalAgreement;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface OptionalAgreementRepository extends JpaRepository<OptionalAgreement, Long> {
    @Override
    List<OptionalAgreement> findAll();

    @Override
    List<OptionalAgreement> findAll(Sort sort);

    @Override
    Page<OptionalAgreement> findAll(Pageable pageable);

    @Override
    List<OptionalAgreement> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(OptionalAgreement entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends OptionalAgreement> entities);

    @Override
    void deleteAll();

    @Override
    <S extends OptionalAgreement> S save(S entity);

    @Override
    <S extends OptionalAgreement> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<OptionalAgreement> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends OptionalAgreement> S saveAndFlush(S entity);

    @Override
    <S extends OptionalAgreement> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<OptionalAgreement> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    OptionalAgreement getOne(Long aLong);

    @Override
    OptionalAgreement getById(Long aLong);

    @Override
    OptionalAgreement getReferenceById(Long aLong);

    @Override
    <S extends OptionalAgreement> Optional<S> findOne(Example<S> example);

    @Override
    <S extends OptionalAgreement> List<S> findAll(Example<S> example);

    @Override
    <S extends OptionalAgreement> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends OptionalAgreement> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends OptionalAgreement> long count(Example<S> example);

    @Override
    <S extends OptionalAgreement> boolean exists(Example<S> example);

    @Override
    <S extends OptionalAgreement, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}