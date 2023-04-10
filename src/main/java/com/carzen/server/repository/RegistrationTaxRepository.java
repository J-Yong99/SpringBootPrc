package com.carzen.server.repository;

import com.carzen.server.domain.RegistrationTax;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface RegistrationTaxRepository extends JpaRepository<RegistrationTax, Long> {
    @Override
    List<RegistrationTax> findAll();

    @Override
    List<RegistrationTax> findAll(Sort sort);

    @Override
    Page<RegistrationTax> findAll(Pageable pageable);

    @Override
    List<RegistrationTax> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(RegistrationTax entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends RegistrationTax> entities);

    @Override
    void deleteAll();

    @Override
    <S extends RegistrationTax> S save(S entity);

    @Override
    <S extends RegistrationTax> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<RegistrationTax> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends RegistrationTax> S saveAndFlush(S entity);

    @Override
    <S extends RegistrationTax> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<RegistrationTax> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    RegistrationTax getOne(Long aLong);

    @Override
    RegistrationTax getById(Long aLong);

    @Override
    RegistrationTax getReferenceById(Long aLong);

    @Override
    <S extends RegistrationTax> Optional<S> findOne(Example<S> example);

    @Override
    <S extends RegistrationTax> List<S> findAll(Example<S> example);

    @Override
    <S extends RegistrationTax> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends RegistrationTax> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends RegistrationTax> long count(Example<S> example);

    @Override
    <S extends RegistrationTax> boolean exists(Example<S> example);

    @Override
    <S extends RegistrationTax, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}