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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReportRepositoryCustomImpl implements ReportRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Report> searchReport(Long id, Long inspectPaperId, LocalDate expireDate, Long fixCount, String url, Long maxFixCount, Long reportNum, LocalDate inspectDateStart, LocalDate inspectDateEnd, String carNum, Long companyId, Long carTypeId, String carName, String phoneNumber) {
        QReport qReport = QReport.report;

        QInspectPaper qInspectPaper = QInspectPaper.inspectPaper;

        return jpaQueryFactory.selectFrom(qReport)
                .join(qReport.inspectPaper, qInspectPaper)
                .where(
                        getIdExpression(qReport, id),
                        getInspectPaperIdExpression(qInspectPaper, inspectPaperId),
                        getExpireDateExpression(qReport, expireDate),
                        getFixCountExpression(qReport, fixCount),
                        getUrlExpression(qReport, url),
                        getMaxCountExpression(qReport, maxFixCount),
                        getReportNumExpression(qReport, reportNum),
                        getInspectDateExpression(qInspectPaper, inspectDateStart, inspectDateEnd),
                        getCarNumExpression(qInspectPaper, carNum),
                        getCompanyIdExpression(qInspectPaper, companyId),
                        getCarTypeIdExpression(qInspectPaper, carTypeId),
                        getCarNameExpression(qInspectPaper, carName),
                        getPhoneNumberExpression(qInspectPaper, phoneNumber)
                )
                .fetch();
    }

    @Override
    public Page<Report> searchReportWithPaging(Pageable pageable, Long id, Long inspectPaperId, LocalDate expireDate, Long fixCount, String url, Long maxFixCount, Long reportNum, LocalDate inspectDateStart, LocalDate inspectDateEnd, String carNum, Long companyId, Long carTypeId, String carName, String phoneNumber) {
        QReport qReport = QReport.report;
        QInspectPaper qInspectPaper = QInspectPaper.inspectPaper;

        JPAQuery<Report> query = jpaQueryFactory.selectFrom(qReport)
                .join(qReport.inspectPaper, qInspectPaper)
                .where(
                        getIdExpression(qReport, id),
                        getInspectPaperIdExpression(qInspectPaper, inspectPaperId),
                        getExpireDateExpression(qReport, expireDate),
                        getFixCountExpression(qReport, fixCount),
                        getUrlExpression(qReport, url),
                        getMaxCountExpression(qReport, maxFixCount),
                        getReportNumExpression(qReport, reportNum),
                        getInspectDateExpression(qInspectPaper, inspectDateStart, inspectDateEnd),
                        getCarNumExpression(qInspectPaper, carNum),
                        getCompanyIdExpression(qInspectPaper, companyId),
                        getCarTypeIdExpression(qInspectPaper, carTypeId),
                        getCarNameExpression(qInspectPaper, carName),
                        getPhoneNumberExpression(qInspectPaper, phoneNumber)
                );
        long totalCount = query.fetchCount();

        List<Report> reports = getSortedReport(query, pageable);

        return new PageImpl<>(reports, pageable, totalCount);
    }

    private static List<Report> getSortedReport(JPAQuery<Report> query, Pageable pageable) {
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
            PathBuilder<Report> entityPath = new PathBuilder<>(Report.class, "report");
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

    private BooleanExpression getIdExpression(QReport qReport, Long id) {
        if (id == null) {
            return null;
        }
        return qReport.id.eq(id);
    }

    private BooleanExpression getInspectPaperIdExpression(QInspectPaper qInspectPaper, Long inspectPaperId) {
        if (inspectPaperId == null) {
            return null;
        }
        return qInspectPaper.id.eq(inspectPaperId);
    }

    private BooleanExpression getExpireDateExpression(QReport qReport, LocalDate expireDate) {
        if (expireDate == null) {
            return null;
        }
        return qReport.expireDate.eq(expireDate);
    }

    private BooleanExpression getFixCountExpression(QReport qReport, Long fixCount) {
        if (fixCount == null) {
            return null;
        }
        return qReport.fixCount.eq(fixCount);
    }

    private BooleanExpression getUrlExpression(QReport qReport, String url) {
        if (url == null) {
            return null;
        }
        return qReport.url.eq(url);
    }

    private BooleanExpression getMaxCountExpression(QReport qReport, Long maxFixCount) {
        if (maxFixCount == null) {
            return null;
        }
        return qReport.maxFixCount.eq(maxFixCount);
    }

    private BooleanExpression getReportNumExpression(QReport qReport, Long reportNum) {
        if (reportNum == null) {
            return null;
        }
        return qReport.reportNum.eq(reportNum);
    }


    private BooleanExpression getInspectDateExpression(QInspectPaper qInspectPaper, LocalDate inspectDateStart, LocalDate inspectDateEnd) {
        BooleanExpression inspectDateExpression = null;
        if (inspectDateStart != null && inspectDateEnd != null) {
            inspectDateExpression = qInspectPaper.rsvInfo.yearDate.between(inspectDateStart, inspectDateEnd);
        } else if (inspectDateStart != null) {
            inspectDateExpression = qInspectPaper.rsvInfo.yearDate.goe(inspectDateStart);
        } else if (inspectDateEnd != null) {
            inspectDateExpression = qInspectPaper.rsvInfo.yearDate.loe(inspectDateEnd);
        }
        return inspectDateExpression;
    }

    private BooleanExpression getCarNumExpression(QInspectPaper qInspectPaper, String carNum) {
        if (carNum == null) {
            return null;
        }
        return qInspectPaper.rsvInfo.carInd.carNum.eq(carNum);
    }

    private BooleanExpression getCompanyIdExpression(QInspectPaper qInspectPaper, Long companyId) {
        if (companyId == null) {
            return null;
        }
        return qInspectPaper.rsvInfo.company.id.eq(companyId);
    }

    private BooleanExpression getCarTypeIdExpression(QInspectPaper qInspectPaper, Long carTypeId) {
        if (carTypeId == null) {
            return null;
        }
        return qInspectPaper.rsvInfo.carInd.car.carType.id.eq(carTypeId);
    }

    private BooleanExpression getCarNameExpression(QInspectPaper qInspectPaper, String carName) {
        if (carName == null) {
            return null;
        }
        return qInspectPaper.rsvInfo.carInd.car.name.eq(carName);
    }

    private BooleanExpression getPhoneNumberExpression(QInspectPaper qInspectPaper, String phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        return qInspectPaper.rsvInfo.customerPhoneNumber.eq(phoneNumber);
    }
}