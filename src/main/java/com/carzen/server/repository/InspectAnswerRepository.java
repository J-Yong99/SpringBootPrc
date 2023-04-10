package com.carzen.server.repository;

import com.carzen.server.domain.InspectAnswer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface InspectAnswerRepository extends JpaRepository<InspectAnswer, Long> {
    @Override
    List<InspectAnswer> findAll();

    @Override
    List<InspectAnswer> findAll(Sort sort);

    @Override
    Page<InspectAnswer> findAll(Pageable pageable);

    @Override
    List<InspectAnswer> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(InspectAnswer entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends InspectAnswer> entities);

    @Override
    void deleteAll();

    @Override
    <S extends InspectAnswer> S save(S entity);

    @Override
    <S extends InspectAnswer> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<InspectAnswer> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends InspectAnswer> S saveAndFlush(S entity);

    @Override
    <S extends InspectAnswer> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<InspectAnswer> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    InspectAnswer getOne(Long aLong);

    @Override
    InspectAnswer getById(Long aLong);

    @Override
    InspectAnswer getReferenceById(Long aLong);

    @Override
    <S extends InspectAnswer> Optional<S> findOne(Example<S> example);

    @Override
    <S extends InspectAnswer> List<S> findAll(Example<S> example);

    @Override
    <S extends InspectAnswer> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends InspectAnswer> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends InspectAnswer> long count(Example<S> example);

    @Override
    <S extends InspectAnswer> boolean exists(Example<S> example);

    @Override
    <S extends InspectAnswer, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}