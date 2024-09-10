package wanted.goldroom.product.domain.sale;

import java.time.LocalDateTime;

import wanted.goldroom.product.domain.item.Item;

public class SaleCommand {

    public record RegisterSalesOrder(
        String userToken,
        String type,
        double salesQuantity
    ) {

        public Sale toEntity(Item item, int salePrice) {
            return Sale.builder()
                .seller(userToken)
                .saleQuantity(salesQuantity)
                .item(item)
                .salePrice(salePrice)
                .build();
        }
    }

    public record DetailSalesOrderList(
        String userToken,
        int size,
        LocalDateTime cursor
    ) {

    }
}
