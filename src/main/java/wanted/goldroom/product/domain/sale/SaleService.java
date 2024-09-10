package wanted.goldroom.product.domain.sale;

import wanted.goldroom.product.domain.item.Item;
import wanted.goldroom.product.domain.price.Price;
import wanted.goldroom.product.infrastructure.common.util.CustomSlice;

public interface SaleService {

    SaleInfo.RegisterSaleInfo registerSale(SaleCommand.RegisterSalesOrder command, Item item, Price price);

    CustomSlice<SaleInfo.DetailSaleOrderList> detailsSaleList(SaleCommand.DetailSalesOrderList command);
}
