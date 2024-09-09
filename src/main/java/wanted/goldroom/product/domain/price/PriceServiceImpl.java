package wanted.goldroom.product.domain.price;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceReader priceReader;

    @Override
    public Price findLatestPrice() {
        return priceReader.findLatestPrice();
    }
}
