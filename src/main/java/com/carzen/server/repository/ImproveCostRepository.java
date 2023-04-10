package com.carzen.server.repository;

import com.carzen.server.domain.ImproveCost;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface ImproveCostRepository extends JpaRepository<ImproveCost, Long> {
    @Override
    List<ImproveCost> findAll();

    @Override
    List<ImproveCost> findAll(Sort sort);

    @Override
    Page<ImproveCost> findAll(Pageable pageable);

    @Override
    List<ImproveCost> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(ImproveCost entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends ImproveCost> entities);

    @Override
    void deleteAll();

    @Override
    <S extends ImproveCost> S save(S entity);

    @Override
    <S extends ImproveCost> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<ImproveCost> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends ImproveCost> S saveAndFlush(S entity);

    @Override
    <S extends ImproveCost> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<ImproveCost> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    ImproveCost getOne(Long aLong);

    @Override
    ImproveCost getById(Long aLong);

    @Override
    ImproveCost getReferenceById(Long aLong);

    @Override
    <S extends ImproveCost> Optional<S> findOne(Example<S> example);

    @Override
    <S extends ImproveCost> List<S> findAll(Example<S> example);

    @Override
    <S extends ImproveCost> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends ImproveCost> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends ImproveCost> long count(Example<S> example);

    @Override
    <S extends ImproveCost> boolean exists(Example<S> example);

    @Override
    <S extends ImproveCost, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}