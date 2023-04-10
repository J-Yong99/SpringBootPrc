package com.carzen.server.repository;

import com.carzen.server.domain.PaymentInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
    @Override
    List<PaymentInfo> findAll();

    @Override
    List<PaymentInfo> findAll(Sort sort);

    @Override
    Page<PaymentInfo> findAll(Pageable pageable);

    @Override
    List<PaymentInfo> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(PaymentInfo entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends PaymentInfo> entities);

    @Override
    void deleteAll();

    @Override
    <S extends PaymentInfo> S save(S entity);

    @Override
    <S extends PaymentInfo> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<PaymentInfo> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void flush();

    @Override
    <S extends PaymentInfo> S saveAndFlush(S entity);

    @Override
    <S extends PaymentInfo> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<PaymentInfo> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    PaymentInfo getOne(Long aLong);

    @Override
    PaymentInfo getById(Long aLong);

    @Override
    PaymentInfo getReferenceById(Long aLong);

    @Override
    <S extends PaymentInfo> Optional<S> findOne(Example<S> example);

    @Override
    <S extends PaymentInfo> List<S> findAll(Example<S> example);

    @Override
    <S extends PaymentInfo> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends PaymentInfo> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends PaymentInfo> long count(Example<S> example);

    @Override
    <S extends PaymentInfo> boolean exists(Example<S> example);

    @Override
    <S extends PaymentInfo, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    PaymentInfo findByOrderId(String orderId);
}