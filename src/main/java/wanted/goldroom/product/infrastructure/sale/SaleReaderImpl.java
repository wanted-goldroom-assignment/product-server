package wanted.goldroom.product.infrastructure.sale;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.sale.SaleInfo;
import wanted.goldroom.product.domain.sale.SaleReader;
import wanted.goldroom.product.infrastructure.common.util.CustomSlice;

@Component
@RequiredArgsConstructor
public class SaleReaderImpl implements SaleReader {
    private final SalePaginationRepository paginationRepository;

    @Override
    public CustomSlice<SaleInfo.DetailSaleOrders> findAllDetails(String userToken, int size,
        LocalDateTime cursor) {
        Slice<SaleInfo.DetailSaleOrders> paginationList
            = paginationRepository.findByUserToken(userToken, size, cursor);

        List<SaleInfo.DetailSaleOrders> orders = paginationList.getContent();
        LocalDateTime nextCursor = orders.isEmpty() ? null : orders.get(orders.size() - 1).getCreatedAt();

        return new CustomSlice<>(orders, nextCursor, paginationList.hasNext());

    }
}
