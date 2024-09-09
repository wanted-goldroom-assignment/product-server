package wanted.goldroom.product.infrastructure.sale;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.sale.Sale;
import wanted.goldroom.product.domain.sale.SaleStore;

@Component
@RequiredArgsConstructor
public class SaleStoreImpl implements SaleStore {
    private final SaleRepository saleRepository;

    @Override
    public Sale store(Sale sale) {
        return saleRepository.save(sale);
    }
}
