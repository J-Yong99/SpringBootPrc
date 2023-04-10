package com.carzen.server.repository;

import com.carzen.server.domain.AnnounceHistory;
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


public interface AnnounceHistoryRepository extends JpaRepository<AnnounceHistory, Long> {
    @Override
    List<AnnounceHistory> findAll();

    @Override
    List<AnnounceHistory> findAll(Sort sort);

    @Override
    Page<AnnounceHistory> findAll(Pageable pageable);

    @Override
    List<AnnounceHistory> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(AnnounceHistory entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends AnnounceHistory> entities);

    @Override
    void deleteAll();

    @Override
    <S extends AnnounceHistory> S save(S entity);

    @Override
    <S extends AnnounceHistory> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<AnnounceHistory> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends AnnounceHistory> S saveAndFlush(S entity);

    @Override
    <S extends AnnounceHistory> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<AnnounceHistory> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    AnnounceHistory getOne(Long aLong);

    @Override
    AnnounceHistory getById(Long aLong);

    @Override
    AnnounceHistory getReferenceById(Long aLong);

    @Override
    <S extends AnnounceHistory> Optional<S> findOne(Example<S> example);

    @Override
    <S extends AnnounceHistory> List<S> findAll(Example<S> example);

    @Override
    <S extends AnnounceHistory> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends AnnounceHistory> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends AnnounceHistory> long count(Example<S> example);

    @Override
    <S extends AnnounceHistory> boolean exists(Example<S> example);

    @Override
    <S extends AnnounceHistory, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}