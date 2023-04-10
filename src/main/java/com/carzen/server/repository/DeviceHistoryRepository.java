package com.carzen.server.repository;

import com.carzen.server.domain.DeviceHistory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface DeviceHistoryRepository extends JpaRepository<DeviceHistory, Long> {
    @Override
    List<DeviceHistory> findAll();

    @Override
    List<DeviceHistory> findAll(Sort sort);

    @Override
    Page<DeviceHistory> findAll(Pageable pageable);

    @Override
    List<DeviceHistory> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(DeviceHistory entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends DeviceHistory> entities);

    @Override
    void deleteAll();

    @Override
    <S extends DeviceHistory> S save(S entity);

    @Override
    <S extends DeviceHistory> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<DeviceHistory> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends DeviceHistory> S saveAndFlush(S entity);

    @Override
    <S extends DeviceHistory> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<DeviceHistory> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    DeviceHistory getOne(Long aLong);

    @Override
    DeviceHistory getById(Long aLong);

    @Override
    DeviceHistory getReferenceById(Long aLong);

    @Override
    <S extends DeviceHistory> Optional<S> findOne(Example<S> example);

    @Override
    <S extends DeviceHistory> List<S> findAll(Example<S> example);

    @Override
    <S extends DeviceHistory> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends DeviceHistory> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends DeviceHistory> long count(Example<S> example);

    @Override
    <S extends DeviceHistory> boolean exists(Example<S> example);

    @Override
    <S extends DeviceHistory, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}