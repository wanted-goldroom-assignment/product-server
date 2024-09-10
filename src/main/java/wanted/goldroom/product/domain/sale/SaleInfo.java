package wanted.goldroom.product.domain.sale;

import java.time.LocalDateTime;

import lombok.Getter;
import wanted.goldroom.product.domain.item.Item;

public class SaleInfo {

    public record RegisterSaleInfo(
        String orderNo
    ) {

        public static RegisterSaleInfo from(Sale sale) {
            return new RegisterSaleInfo(sale.getOrderNo());
        }
    }

    @Getter
    public static class DetailSaleOrderList {
        private String orderNo;
        private LocalDateTime createdAt;
        private String seller;
        private Sale.Status status;
        private Item.Type type;
        private double saleQuantity;
        private int amount;
    }
}
