package wanted.goldroom.product.domain.sale;

import java.time.LocalDateTime;

import wanted.goldroom.product.domain.item.Item;

public class SaleInfo {

    public record RegisterSaleInfo(
        String orderNo
    ) {

        public static RegisterSaleInfo from(Sale sale) {
            return new RegisterSaleInfo(sale.getOrderNo());
        }
    }

    public record DetailSaleOrderList(
        String orderNo,
        LocalDateTime createdAt,
        String seller,
        Sale.Status status,
        Item.Type type,
        double saleQuantity,
        int amount
    ) {

    }
}
