package com.carzen.server.repository;

import com.carzen.server.domain.Customer;
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

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom{

    Optional<Customer> findBySerialNumber(String serialNumber);
//    List<Customer> findBySerialNumberAndNameAndPhoneNumberAndRole(String serialNumber, String name, String phoneNumber, CustomerRole role);
    @Override
    List<Customer> findAll();

    @Override
    List<Customer> findAll(Sort sort);

    @Override
    Page<Customer> findAll(Pageable pageable);

    @Override
    List<Customer> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Customer entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Customer> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Customer> S save(S entity);

    @Override
    <S extends Customer> List<S> saveAll(Iterable<S> entities);

    @Override
    Optional<Customer> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    boolean existsBySerialNumber(String serialNumber);

    @Override
    void flush();

    @Override
    <S extends Customer> S saveAndFlush(S entity);

    @Override
    <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    void deleteAllInBatch(Iterable<Customer> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Customer getOne(Long aLong);

    @Override
    Customer getById(Long aLong);

    @Override
    Customer getReferenceById(Long aLong);

    @Override
    <S extends Customer> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Customer> List<S> findAll(Example<S> example);

    @Override
    <S extends Customer> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Customer> long count(Example<S> example);

    @Override
    <S extends Customer> boolean exists(Example<S> example);

    @Override
    <S extends Customer, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}