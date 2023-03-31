package com.carzen.server.repository;

import com.carzen.server.domain.Device;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    Optional<Device> findBySerialNumber(String serialNumber);
    @Override
    List<Device> findAll();

    @Override
    List<Device> findAll(Sort sort);

    @Override
    Page<Device> findAll(Pageable pageable);

    @Override
    List<Device> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Device entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Device> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Device> S save(S entity);

    @Override
    <S extends Device> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Device> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends Device> S saveAndFlush(S entity);

    @Override
    <S extends Device> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<Device> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Device getOne(Long aLong);

    @Override
    Device getById(Long aLong);

    @Override
    Device getReferenceById(Long aLong);

    @Override
    <S extends Device> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Device> List<S> findAll(Example<S> example);

    @Override
    <S extends Device> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Device> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Device> long count(Example<S> example);

    @Override
    <S extends Device> boolean exists(Example<S> example);

    @Override
    <S extends Device, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}