package wanted.goldroom.product.domain.sale;

public class SaleInfo {

    public record RegisterSaleInfo(
        String orderNo
    ) {

        public static RegisterSaleInfo from(Sale sale) {
            return new RegisterSaleInfo(sale.getOrderNo());
        }
    }
}
