package wanted.goldroom.product.domain.sale;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.exception.ErrorCode;
import wanted.goldroom.product.domain.exception.ForbiddenException;
import wanted.goldroom.product.domain.item.Item;
import wanted.goldroom.product.domain.price.Price;
import wanted.goldroom.product.infrastructure.common.util.CustomSlice;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SaleServiceImpl implements SaleService {
    private final SaleStore saleStore;
    private final SaleReader saleReader;

    @Override
    @Transactional
    public SaleInfo.RegisterSaleInfo registerSale(SaleCommand.RegisterSalesOrder command,
        Item item, Price price) {
        Sale sale = saleStore.store(command.toEntity(item, price.getSalePrice()));
        return SaleInfo.RegisterSaleInfo.from(sale);
    }

    @Override
    public CustomSlice<SaleInfo.DetailSaleOrderList> detailsSaleList(SaleCommand.DetailSalesOrderList command) {
        return saleReader.findAllDetails(command.userToken(), command.size(), command.cursor());
    }

    @Override
    public SaleInfo.DetailSaleOrder detailsSale(SaleCommand.DetailSalesOrder command) {
        return saleReader.findSaleDetails(command.orderNo());
    }

    @Override
    public void deleteSale(SaleCommand.DeleteSalesOrder command) {
        Sale sale = saleReader.findByOrderNo(command.orderNo());
        if (sale.validateSeller(command.userToken())) {
            saleStore.delete(sale, command.userToken());
        } else {
            throw new ForbiddenException(ErrorCode.ITEM_FORBIDDEN);
        }
    }
}
