package com.carzen.server.repository;

import com.carzen.server.domain.Announcement;
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


public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    @Override
    List<Announcement> findAll();

    @Override
    List<Announcement> findAll(Sort sort);

    @Override
    Page<Announcement> findAll(Pageable pageable);

    @Override
    List<Announcement> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Announcement entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Announcement> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Announcement> S save(S entity);

    @Override
    <S extends Announcement> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Announcement> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends Announcement> S saveAndFlush(S entity);

    @Override
    <S extends Announcement> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<Announcement> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Announcement getOne(Long aLong);

    @Override
    Announcement getById(Long aLong);

    @Override
    Announcement getReferenceById(Long aLong);

    @Override
    <S extends Announcement> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Announcement> List<S> findAll(Example<S> example);

    @Override
    <S extends Announcement> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Announcement> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Announcement> long count(Example<S> example);

    @Override
    <S extends Announcement> boolean exists(Example<S> example);

    @Override
    <S extends Announcement, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}