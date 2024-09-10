package wanted.goldroom.product.application.sale;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.item.Item;
import wanted.goldroom.product.domain.item.ItemService;
import wanted.goldroom.product.domain.price.Price;
import wanted.goldroom.product.domain.price.PriceService;
import wanted.goldroom.product.domain.sale.SaleCommand;
import wanted.goldroom.product.domain.sale.SaleInfo;
import wanted.goldroom.product.domain.sale.SaleService;
import wanted.goldroom.product.infrastructure.common.util.CustomSlice;

@Service
@RequiredArgsConstructor
public class SaleFacade {
    private final SaleService saleService;
    private final ItemService itemService;
    private final PriceService priceService;

    public SaleInfo.RegisterSaleInfo registerSale(SaleCommand.RegisterSalesOrder command) {
        Item.Type type = Item.Type.from(command.type());
        Item item = itemService.findByType(type);
        Price price = priceService.findLatestPrice();
        return saleService.registerSale(command, item, price);
    }

    public CustomSlice<SaleInfo.DetailSaleOrders> detailsSaleOrderList(SaleCommand.DetailSalesOrderList command) {
        return saleService.detailsSaleList(command);
    }
}
