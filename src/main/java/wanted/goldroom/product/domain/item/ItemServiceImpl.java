package wanted.goldroom.product.domain.item;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemReader itemReader;

    @Override
    @Transactional(readOnly = true)
    public Item findByType(Item.Type type) {
        return itemReader.findByType(type);
    }
}
