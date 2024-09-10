package wanted.goldroom.product.domain.sale;

import java.time.LocalDateTime;

import wanted.goldroom.product.infrastructure.common.util.CustomSlice;

public interface SaleReader {

    CustomSlice<SaleInfo.DetailSaleOrderList> findAllDetails(String userToken, int size, LocalDateTime cursor);

    SaleInfo.DetailSaleOrder findSaleDetails(String orderNo);
}
