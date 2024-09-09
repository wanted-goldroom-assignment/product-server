package wanted.goldroom.product.domain.sale;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.item.Item;
import wanted.goldroom.product.domain.price.Price;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleStore saleStore;

    @Override
    @Transactional
    public SaleInfo.RegisterSaleInfo registerSale(SaleCommand.RegisterSalesOrder command,
        Item item, Price price) {
        Sale sale = saleStore.store(command.toEntity(item, price.getSalePrice()));
        return SaleInfo.RegisterSaleInfo.from(sale);
    }
}
