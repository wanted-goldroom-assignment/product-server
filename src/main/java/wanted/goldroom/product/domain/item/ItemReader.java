package wanted.goldroom.product.domain.item;

public interface ItemReader {

    Item findByType(Item.Type type);
}
