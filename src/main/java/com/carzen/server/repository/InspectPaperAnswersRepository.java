package com.carzen.server.repository;

import com.carzen.server.domain.InspectPaperAnswers;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface InspectPaperAnswersRepository extends JpaRepository<InspectPaperAnswers, Long> {
    @Override
    List<InspectPaperAnswers> findAll();

    @Override
    List<InspectPaperAnswers> findAll(Sort sort);

    @Override
    Page<InspectPaperAnswers> findAll(Pageable pageable);

    @Override
    List<InspectPaperAnswers> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(InspectPaperAnswers entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends InspectPaperAnswers> entities);

    @Override
    void deleteAll();

    @Override
    <S extends InspectPaperAnswers> S save(S entity);

    @Override
    <S extends InspectPaperAnswers> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<InspectPaperAnswers> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends InspectPaperAnswers> S saveAndFlush(S entity);

    @Override
    <S extends InspectPaperAnswers> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<InspectPaperAnswers> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    InspectPaperAnswers getOne(Long aLong);

    @Override
    InspectPaperAnswers getById(Long aLong);

    @Override
    InspectPaperAnswers getReferenceById(Long aLong);

    @Override
    <S extends InspectPaperAnswers> Optional<S> findOne(Example<S> example);

    @Override
    <S extends InspectPaperAnswers> List<S> findAll(Example<S> example);

    @Override
    <S extends InspectPaperAnswers> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends InspectPaperAnswers> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends InspectPaperAnswers> long count(Example<S> example);

    @Override
    <S extends InspectPaperAnswers> boolean exists(Example<S> example);

    @Override
    <S extends InspectPaperAnswers, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}