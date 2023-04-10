package com.carzen.server.repository;

import com.carzen.server.domain.Report;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface ReportRepository extends JpaRepository<Report, Long>, ReportRepositoryCustom {
    @Override
    List<Report> findAll();

    @Override
    List<Report> findAll(Sort sort);

    @Override
    Page<Report> findAll(Pageable pageable);

    @Override
    List<Report> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Report entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Report> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Report> S save(S entity);

    @Override
    <S extends Report> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Report> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends Report> S saveAndFlush(S entity);

    @Override
    <S extends Report> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<Report> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Report getOne(Long aLong);

    @Override
    Report getById(Long aLong);

    @Override
    Report getReferenceById(Long aLong);

    @Override
    <S extends Report> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Report> List<S> findAll(Example<S> example);

    @Override
    <S extends Report> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Report> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Report> long count(Example<S> example);

    @Override
    <S extends Report> boolean exists(Example<S> example);

    @Override
    <S extends Report, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}