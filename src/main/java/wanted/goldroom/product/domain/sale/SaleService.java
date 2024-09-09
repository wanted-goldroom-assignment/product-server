package wanted.goldroom.product.domain.sale;

import wanted.goldroom.product.domain.item.Item;
import wanted.goldroom.product.domain.price.Price;

public interface SaleService {

    SaleInfo.RegisterSaleInfo registerSale(SaleCommand.RegisterSalesOrder command, Item item, Price price);
}
