package wanted.goldroom.product.domain.sale;

public interface SaleStore {
    Sale store(Sale sale);

    void delete(Sale sale, String userToken);
}
