package com.carzen.server.repository;

import com.carzen.server.domain.*;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerCenterInquiriesRepositoryCustomImpl implements CustomerCenterInquiriesRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<CustomerCenterInquiries> searchInquiries(Long id, Long hqUserId, Long rsvInfoId, Long companyId, LocalDateTime announcedDateStart, LocalDateTime announcedDateEnd, String contents, String type, String customerName, String hqPart, String solution, String answerSolution, String phoneNumber) {
        QCustomerCenterInquiries qCustomerCenterInquiries = QCustomerCenterInquiries.customerCenterInquiries;
        QHqUser qHqUser = QHqUser.hqUser;
        QRsvInfo qRsvInfo = QRsvInfo.rsvInfo;
        QCompany qCompany = QCompany.company;

        return jpaQueryFactory.selectFrom(qCustomerCenterInquiries)
                .leftJoin(qCustomerCenterInquiries.hqUser, qHqUser)
                .leftJoin(qCustomerCenterInquiries.rsvInfo, qRsvInfo)
                .where(
                        getIdExpression(qCustomerCenterInquiries, id),
                        getHqUserIdExpression(qHqUser, hqUserId),
                        getRsvInfoIdExpression(qRsvInfo, rsvInfoId),
                        getCompanyIdExpression(qCompany, companyId),
                        getAnnouncedDateExpression(qCustomerCenterInquiries, announcedDateStart, announcedDateEnd),
                        getContentExpression(qCustomerCenterInquiries, contents),
                        getTypeExpression(qCustomerCenterInquiries, type),
                        getCustomerNameExpression(qCustomerCenterInquiries, customerName),
                        getHqPartExpression(qCustomerCenterInquiries, hqPart),
                        getSolutionExpression(qCustomerCenterInquiries, solution),
                        getAnswerSolutionExpression(qCustomerCenterInquiries, answerSolution),
                        getPhoneNumberExpression(qCustomerCenterInquiries, phoneNumber)
                )
                .fetch();
    }

    @Override
    public Page<CustomerCenterInquiries> searchInquiriesWithPaging(Pageable pageable, Long id, Long hqUserId, Long rsvInfoId, Long companyId, LocalDateTime announcedDateStart, LocalDateTime announcedDateEnd, String contents, String type, String customerName, String hqPart, String solution, String answerSolution, String phoneNumber) {
        QCustomerCenterInquiries qCustomerCenterInquiries = QCustomerCenterInquiries.customerCenterInquiries;
        QHqUser qHqUser = QHqUser.hqUser;
        QRsvInfo qRsvInfo = QRsvInfo.rsvInfo;
        QCompany qCompany = QCompany.company;

        JPAQuery<CustomerCenterInquiries> query = jpaQueryFactory.selectFrom(qCustomerCenterInquiries)
                .leftJoin(qCustomerCenterInquiries.hqUser, qHqUser)
                .leftJoin(qCustomerCenterInquiries.rsvInfo, qRsvInfo)
                .where(
                        getIdExpression(qCustomerCenterInquiries, id),
                        getHqUserIdExpression(qHqUser, hqUserId),
                        getRsvInfoIdExpression(qRsvInfo, rsvInfoId),
                        getCompanyIdExpression(qCompany, companyId),
                        getAnnouncedDateExpression(qCustomerCenterInquiries, announcedDateStart, announcedDateEnd),
                        getContentExpression(qCustomerCenterInquiries, contents),
                        getTypeExpression(qCustomerCenterInquiries, type),
                        getCustomerNameExpression(qCustomerCenterInquiries, customerName),
                        getHqPartExpression(qCustomerCenterInquiries, hqPart),
                        getSolutionExpression(qCustomerCenterInquiries, solution),
                        getAnswerSolutionExpression(qCustomerCenterInquiries, answerSolution),
                        getPhoneNumberExpression(qCustomerCenterInquiries, phoneNumber)
                );
        long totalCount = query.fetchCount();

        List<CustomerCenterInquiries> inquiries = getSortedInquiries(query, pageable);

        return new PageImpl<>(inquiries, pageable, totalCount);
    }

    private List<CustomerCenterInquiries> getSortedInquiries(JPAQuery<CustomerCenterInquiries> query, Pageable pageable) {
        if(pageable.isUnpaged()){
            return query.fetch();
        }

        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());

        Sort sort = pageable.getSort();
        if (sort.isUnsorted()) {
            return query.fetch();
        }

        List<OrderSpecifier<?>> orderSpecifiers = new ArrayList<>();
        for(Sort.Order o : sort) {
            PathBuilder<CustomerCenterInquiries> entityPath = new PathBuilder<>(CustomerCenterInquiries.class, "customerCenterInquiries");
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

    private BooleanExpression getIdExpression(QCustomerCenterInquiries qCustomerCenterInquiries, Long id) {
        if(id == null) {
            return null;
        }
        return qCustomerCenterInquiries.id.eq(id);
    }

    private BooleanExpression getHqUserIdExpression(QHqUser qHqUser, Long hqUserId) {
        if(hqUserId == null) {
            return null;
        }
        return qHqUser.id.eq(hqUserId);
    }

    private BooleanExpression getRsvInfoIdExpression(QRsvInfo qRsvInfo, Long rsvInfoId) {
        if(rsvInfoId == null) {
            return null;
        }
        return qRsvInfo.id.eq(rsvInfoId);
    }

    private BooleanExpression getCompanyIdExpression(QCompany qCompany, Long companyId) {
        if(companyId == null) {
            return null;
        }
        return qCompany.id.eq(companyId);
    }

    private BooleanExpression getAnnouncedDateExpression(QCustomerCenterInquiries qCustomerCenterInquiries, LocalDateTime announcedDateStart, LocalDateTime announcedDateEnd) {
        BooleanExpression announcedDateExpression = null;
        if(announcedDateStart != null && announcedDateEnd != null) {
            announcedDateExpression = qCustomerCenterInquiries.announcedDate.between(announcedDateStart, announcedDateEnd);
        } else if(announcedDateStart != null) {
            announcedDateExpression = qCustomerCenterInquiries.announcedDate.goe(announcedDateStart);
        } else if(announcedDateEnd != null) {
            announcedDateExpression = qCustomerCenterInquiries.announcedDate.loe(announcedDateEnd);
        }
        return announcedDateExpression;

    }

    private BooleanExpression getContentExpression(QCustomerCenterInquiries qCustomerCenterInquiries, String contents) {
        if(contents == null) {
            return null;
        }
        return qCustomerCenterInquiries.contents.contains(contents);
    }

    private BooleanExpression getTypeExpression(QCustomerCenterInquiries qCustomerCenterInquiries, String type) {
        if(type == null) {
            return null;
        }
        return qCustomerCenterInquiries.type.contains(type);
    }

    private BooleanExpression getCustomerNameExpression(QCustomerCenterInquiries qCustomerCenterInquiries, String customerName) {
        if(customerName == null) {
            return null;
        }
        return qCustomerCenterInquiries.customerName.contains(customerName);
    }

    private BooleanExpression getHqPartExpression(QCustomerCenterInquiries qCustomerCenterInquiries, String hqPart) {
        if(hqPart == null) {
            return null;
        }
        return qCustomerCenterInquiries.hqPart.contains(hqPart);
    }

    private BooleanExpression getSolutionExpression(QCustomerCenterInquiries qCustomerCenterInquiries, String solution) {
        if(solution == null) {
            return null;
        }
        return qCustomerCenterInquiries.solution.contains(solution);
    }

    private BooleanExpression getAnswerSolutionExpression(QCustomerCenterInquiries qCustomerCenterInquiries, String answerSolution) {
        if(answerSolution == null) {
            return null;
        }
        return qCustomerCenterInquiries.answerSolution.contains(answerSolution);
    }

    private BooleanExpression getPhoneNumberExpression(QCustomerCenterInquiries qCustomerCenterInquiries, String phoneNumber) {
        if(phoneNumber == null) {
            return null;
        }
        return qCustomerCenterInquiries.phoneNumber.contains(phoneNumber);
    }
}
