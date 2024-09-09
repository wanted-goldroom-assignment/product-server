package wanted.goldroom.product.infrastructure.item;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.exception.ErrorCode;
import wanted.goldroom.product.domain.exception.NotFoundException;
import wanted.goldroom.product.domain.item.Item;
import wanted.goldroom.product.domain.item.ItemReader;

@Component
@RequiredArgsConstructor
public class ItemReaderImpl implements ItemReader {
    private final ItemRepository itemRepository;

    @Override
    public Item findByType(Item.Type type) {
        return itemRepository.findByType(type)
            .orElseThrow(() -> new NotFoundException(ErrorCode.NOT_FOUND_ITEM));
    }
}
