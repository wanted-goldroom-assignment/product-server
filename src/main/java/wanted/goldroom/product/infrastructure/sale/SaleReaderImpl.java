package wanted.goldroom.product.infrastructure.sale;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.exception.ErrorCode;
import wanted.goldroom.product.domain.exception.NotFoundException;
import wanted.goldroom.product.domain.sale.Sale;
import wanted.goldroom.product.domain.sale.SaleInfo;
import wanted.goldroom.product.domain.sale.SaleReader;
import wanted.goldroom.product.infrastructure.common.util.CustomSlice;

@Component
@RequiredArgsConstructor
public class SaleReaderImpl implements SaleReader {
    private final SalePaginationRepository paginationRepository;
    private final SaleRepository saleRepository;

    @Override
    public CustomSlice<SaleInfo.DetailSaleOrderList> findAllDetails(String userToken, int size,
        LocalDateTime cursor) {
        Slice<SaleInfo.DetailSaleOrderList> paginationList
            = paginationRepository.findByUserToken(userToken, size, cursor);

        List<SaleInfo.DetailSaleOrderList> orders = paginationList.getContent();
        LocalDateTime nextCursor = orders.isEmpty() ? null : orders.get(orders.size() - 1).getCreatedAt();

        return new CustomSlice<>(orders, nextCursor, paginationList.hasNext());
    }

    @Override
    public SaleInfo.DetailSaleOrder findSaleDetails(String orderNo) {
        Sale sale = saleRepository.findByOrderNo(orderNo)
            .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_ORDER));
        return new SaleInfo.DetailSaleOrder(sale);
    }
}
