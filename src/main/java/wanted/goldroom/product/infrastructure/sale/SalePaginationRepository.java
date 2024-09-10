package wanted.goldroom.product.infrastructure.sale;

import static wanted.goldroom.product.domain.sale.QSale.*;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.sale.SaleInfo;
import wanted.goldroom.product.infrastructure.common.util.PaginationUtil;

@Repository
@RequiredArgsConstructor
public class SalePaginationRepository {
    private final SaleRepository saleRepository;
    private final JPAQueryFactory queryFactory;

    public Slice<SaleInfo.DetailSaleOrderList> findByUserToken(String userToken, int size, LocalDateTime cursor) {
        List<SaleInfo.DetailSaleOrderList> orders = queryFactory.select(
                Projections.constructor(SaleInfo.DetailSaleOrderList.class,
                    sale.orderNo,
                    sale.createdAt,
                    sale.seller.as("userToken"),
                    sale.status,
                    sale.item.type,
                    sale.saleQuantity,
                    sale.amount))
            .from(sale)
            .where(
                saleRepository.lessThanCreatedAt(cursor),
                saleRepository.equalUserToken(userToken))
            .orderBy(sale.createdAt.desc())
            .limit(size + 1)
            .fetch();
        return PaginationUtil.checkLastPage(size, orders);
    }
}
