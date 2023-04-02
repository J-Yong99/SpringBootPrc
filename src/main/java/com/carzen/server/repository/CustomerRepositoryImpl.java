package com.carzen.server.repository;

import com.carzen.server.domain.CustomerRole;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.carzen.server.domain.Customer;
import com.carzen.server.domain.QCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;




@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

//    public CustomerRepositoryImpl(EntityManager entityManager) {
//        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
//    }
    @Override
    public List<Customer> searchCustomers(Long id, String serialNumber, CustomerRole role) {
        QCustomer qCustomer = QCustomer.customer;

        return jpaQueryFactory.selectFrom(qCustomer)
                .where(
                        getSerialNumberExpression(qCustomer, serialNumber),
                        getRoleExpression(qCustomer, role)
                )
                .fetch();
    }

    private BooleanExpression getSerialNumberExpression(QCustomer qCustomer, String serialNumber) {
        if (serialNumber != null && !serialNumber.isEmpty()) {
            return qCustomer.serialNumber.eq(serialNumber);
        }
        return null;
    }

//    private BooleanExpression getNameExpression(QCustomer qCustomer, String name) {
//        if (name != null && !name.isEmpty()) {
//            return qCustomer.name.eq(name);
//        }
//        return null;
//    }

//    private BooleanExpression getPhoneNumberExpression(QCustomer qCustomer, String phoneNumber) {
//        if (phoneNumber != null && !phoneNumber.isEmpty()) {
//            return qCustomer.phoneNumber.eq(phoneNumber);
//        }
//        return null;
//    }

    private BooleanExpression getRoleExpression(QCustomer qCustomer, CustomerRole role) {
        if (role != null) {
            return qCustomer.role.eq(role);
        }
        return null;
    }

}

