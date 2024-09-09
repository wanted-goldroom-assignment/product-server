package wanted.goldroom.product.interfaces.sale;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SaleDto {

    public record RegisterSaleOrderRequest(
        @NotBlank
        String userToken,
        @NotNull
        double salesQuantity,
        @NotNull
        String type
    ) {

    }

    public record RegisterSaleOrderResponse(
        String orderNo
    ) {

    }
}
