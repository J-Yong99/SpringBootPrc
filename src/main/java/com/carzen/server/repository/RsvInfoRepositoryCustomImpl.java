package com.carzen.server.repository;

import com.carzen.server.domain.*;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RsvInfoRepositoryCustomImpl implements RsvInfoRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<RsvInfo> searchRsv(Long id, Long carIndId, Long companyId, Long customerId, Long paymentInfoId, String rsvStatus, String insStatus, LocalDate yearDate, Long inspectTime, String customerName, String customerPhoneNumber) {
        QRsvInfo qRsvInfo = QRsvInfo.rsvInfo;
        QCarInd qCarInd = QCarInd.carInd;
        QCompany qCompany = QCompany.company;
        QCustomer qCustomer = QCustomer.customer;
        QPaymentInfo qPaymentInfo = QPaymentInfo.paymentInfo;

        return jpaQueryFactory.selectFrom(qRsvInfo)
                .leftJoin(qRsvInfo.carInd, qCarInd)
                .leftJoin(qRsvInfo.company, qCompany)
                .leftJoin(qRsvInfo.customer, qCustomer)
                .leftJoin(qRsvInfo.paymentInfo, qPaymentInfo)
                .where(
                        getIdExpression(qRsvInfo, id),
                        getCarIndIdExpression(qCarInd, carIndId),
                        getCompanyIdExpression(qCompany, companyId),
                        getCustomerIdExpression(qCustomer, customerId),
                        getPaymentInfoIdExpression(qPaymentInfo, paymentInfoId),
                        getRsvStatusExpression(qRsvInfo, rsvStatus),
                        getInsStatusExpression(qRsvInfo, insStatus),
                        getYearDateExpression(qRsvInfo, yearDate),
                        getInspectTimeExpression(qRsvInfo, inspectTime),
                        getCustomerNameExpression(qRsvInfo, customerName),
                        getCustomerPhoneNumberExpression(qRsvInfo, customerPhoneNumber)
                )
                .fetch();
    }
    @Override
    public Page<RsvInfo> searchRsvWithPaging(Pageable pageable, Long id, Long carIndId, Long companyId, Long customerId, Long paymentInfoId, String rsvStatus, String insStatus, LocalDate yearDate, Long inspectTime, String customerName, String customerPhoneNumber) {
        QRsvInfo qRsvInfo = QRsvInfo.rsvInfo;
        QCarInd qCarInd = QCarInd.carInd;
        QCompany qCompany = QCompany.company;
        QCustomer qCustomer = QCustomer.customer;
        QPaymentInfo qPaymentInfo = QPaymentInfo.paymentInfo;

        JPAQuery<RsvInfo> query = jpaQueryFactory.selectFrom(qRsvInfo)
                .leftJoin(qRsvInfo.carInd, qCarInd)
                .leftJoin(qRsvInfo.company, qCompany)
                .leftJoin(qRsvInfo.customer, qCustomer)
                .leftJoin(qRsvInfo.paymentInfo, qPaymentInfo)
                .where(
                        getIdExpression(qRsvInfo, id),
                        getCarIndIdExpression(qCarInd, carIndId),
                        getCompanyIdExpression(qCompany, companyId),
                        getCustomerIdExpression(qCustomer, customerId),
                        getPaymentInfoIdExpression(qPaymentInfo, paymentInfoId),
                        getRsvStatusExpression(qRsvInfo, rsvStatus),
                        getInsStatusExpression(qRsvInfo, insStatus),
                        getYearDateExpression(qRsvInfo, yearDate),
                        getInspectTimeExpression(qRsvInfo, inspectTime),
                        getCustomerNameExpression(qRsvInfo, customerName),
                        getCustomerPhoneNumberExpression(qRsvInfo, customerPhoneNumber)
                );

        long totalCount = query.fetchCount();

        List<RsvInfo> rsvInfos = getSortedRsvInfos(query, pageable);

        return new PageImpl<>(rsvInfos, pageable, totalCount);
    }
    private static List<RsvInfo> getSortedRsvInfos(JPAQuery<RsvInfo> query, Pageable pageable) {
        if (pageable.isUnpaged()) {
            return query.fetch();
        }

        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());

        Sort sort = pageable.getSort();
        if (sort.isUnsorted()) {
            return query.fetch();
        }

        List<OrderSpecifier<?>> orderSpecifiers = new ArrayList<>();
        for (Sort.Order o : sort) {
            PathBuilder<RsvInfo> entityPath = new PathBuilder<>(RsvInfo.class, "rsvInfo");
            Path<?> property = entityPath.get(o.getProperty());
            if (o.isAscending()) {
                orderSpecifiers.add(new OrderSpecifier(Order.ASC, property));
            } else {
                orderSpecifiers.add(new OrderSpecifier(Order.DESC, property));
            }
        }
        query.orderBy(orderSpecifiers.toArray(new OrderSpecifier[0]));


        return query.fetch();
    }

    private BooleanExpression getIdExpression(QRsvInfo qRsvInfo, Long id) {
        return id != null ? qRsvInfo.id.eq(id) : null;
    }

    private BooleanExpression getCarIndIdExpression(QCarInd qCarInd, Long carIndId) {
        return carIndId != null ? qCarInd.id.eq(carIndId) : null;
    }

    private BooleanExpression getCompanyIdExpression(QCompany qCompany, Long companyId) {
        return companyId != null ? qCompany.id.eq(companyId) : null;
    }

    private BooleanExpression getCustomerIdExpression(QCustomer qCustomer, Long customerId) {
        return customerId != null ? qCustomer.id.eq(customerId) : null;
    }

    private BooleanExpression getPaymentInfoIdExpression(QPaymentInfo qPaymentInfo, Long paymentInfoId) {
        return paymentInfoId != null ? qPaymentInfo.id.eq(paymentInfoId) : null;
    }

    private BooleanExpression getRsvStatusExpression(QRsvInfo qRsvInfo, String rsvStatus) {
        return rsvStatus != null ? qRsvInfo.rsvStatus.eq(rsvStatus) : null;
    }

    private BooleanExpression getInsStatusExpression(QRsvInfo qRsvInfo, String insStatus) {
        return insStatus != null ? qRsvInfo.insStatus.eq(insStatus) : null;
    }



    private BooleanExpression getYearDateExpression(QRsvInfo qRsvInfo, LocalDate yearDate) {
        if (yearDate != null) {
            return qRsvInfo.yearDate.eq(yearDate);
        }
        return null;
    }

    private BooleanExpression getInspectTimeExpression(QRsvInfo qRsvInfo, Long inspectTime) {
        if (inspectTime != null) {
            return qRsvInfo.inpectTime.eq(inspectTime);
        }
        return null;
    }

    private BooleanExpression getCustomerNameExpression(QRsvInfo qRsvInfo, String customerName) {
        if (customerName != null) {
            return qRsvInfo.customerName.eq(customerName);
        }
        return null;
    }

    private BooleanExpression getCustomerPhoneNumberExpression(QRsvInfo qRsvInfo, String customerPhoneNumber) {
        if (customerPhoneNumber != null) {
            return qRsvInfo.customerPhoneNumber.eq(customerPhoneNumber);
        }
        return null;
    }
}


