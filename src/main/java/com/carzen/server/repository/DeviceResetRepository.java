package com.carzen.server.repository;

import com.carzen.server.domain.DeviceReset;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface DeviceResetRepository extends JpaRepository<DeviceReset, Long> {
    @Override
    List<DeviceReset> findAll();

    @Override
    List<DeviceReset> findAll(Sort sort);

    @Override
    Page<DeviceReset> findAll(Pageable pageable);

    @Override
    List<DeviceReset> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(DeviceReset entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends DeviceReset> entities);

    @Override
    void deleteAll();

    @Override
    <S extends DeviceReset> S save(S entity);

    @Override
    <S extends DeviceReset> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<DeviceReset> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends DeviceReset> S saveAndFlush(S entity);

    @Override
    <S extends DeviceReset> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<DeviceReset> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    DeviceReset getOne(Long aLong);

    @Override
    DeviceReset getById(Long aLong);

    @Override
    DeviceReset getReferenceById(Long aLong);

    @Override
    <S extends DeviceReset> Optional<S> findOne(Example<S> example);

    @Override
    <S extends DeviceReset> List<S> findAll(Example<S> example);

    @Override
    <S extends DeviceReset> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends DeviceReset> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends DeviceReset> long count(Example<S> example);

    @Override
    <S extends DeviceReset> boolean exists(Example<S> example);

    @Override
    <S extends DeviceReset, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}