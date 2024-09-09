package wanted.goldroom.product.infrastructure.item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import wanted.goldroom.product.domain.item.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByType(Item.Type type);
}
