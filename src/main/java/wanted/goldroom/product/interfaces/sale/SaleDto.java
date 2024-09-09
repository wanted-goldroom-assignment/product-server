package wanted.goldroom.product.interfaces.sale;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SaleDto {

    public record RegisterSaleOrderRequest(
        @NotBlank
        String userToken,
        @NotNull(message = "수량을 입력해주세요.")
        double salesQuantity,
        @NotBlank(message = "판매물품을 지정해 주세요.")
        String type
    ) {

    }

    public record RegisterSaleOrderResponse(
        String orderNo
    ) {

    }
}
