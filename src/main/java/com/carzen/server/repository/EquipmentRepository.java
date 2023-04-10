package com.carzen.server.repository;

import com.carzen.server.domain.Equipment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    @Override
    List<Equipment> findAll();

    @Override
    List<Equipment> findAll(Sort sort);

    @Override
    Page<Equipment> findAll(Pageable pageable);

    @Override
    List<Equipment> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Equipment entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Equipment> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Equipment> S save(S entity);

    @Override
    <S extends Equipment> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Equipment> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends Equipment> S saveAndFlush(S entity);

    @Override
    <S extends Equipment> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<Equipment> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Equipment getOne(Long aLong);

    @Override
    Equipment getById(Long aLong);

    @Override
    Equipment getReferenceById(Long aLong);

    @Override
    <S extends Equipment> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Equipment> List<S> findAll(Example<S> example);

    @Override
    <S extends Equipment> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Equipment> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Equipment> long count(Example<S> example);

    @Override
    <S extends Equipment> boolean exists(Example<S> example);

    @Override
    <S extends Equipment, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}