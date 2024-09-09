package wanted.goldroom.product.infrastructure.price;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.exception.ErrorCode;
import wanted.goldroom.product.domain.exception.NotFoundException;
import wanted.goldroom.product.domain.price.Price;
import wanted.goldroom.product.domain.price.PriceReader;

@Component
@RequiredArgsConstructor
public class PriceReaderImpl implements PriceReader {
    private final PriceRepository priceRepository;

    @Override
    public Price findLatestPrice() {
        return priceRepository.findTopByOrderByCreatedAtDesc()
            .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_PRICE));
    }
}
