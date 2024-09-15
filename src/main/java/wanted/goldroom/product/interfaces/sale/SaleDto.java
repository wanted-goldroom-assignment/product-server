package wanted.goldroom.product.interfaces.sale;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import wanted.goldroom.product.domain.sale.SaleInfo;

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

    public record DetailsSaleOrderListResponse(
        String orderNo,
        LocalDateTime createdAt,
        String seller,
        String status,
        String type,
        double saleQuantity,
        int amount
    ) {

        public static DetailsSaleOrderListResponse from(SaleInfo.DetailSaleOrderList list) {
            return new DetailsSaleOrderListResponse(
                list.orderNo(),
                list.createdAt(),
                list.seller(),
                list.status().getDescription(),
                list.type().getProduct(),
                list.saleQuantity(),
                list.amount());
        }
    }

    public record DetailsSaleOrderResponse(
        String orderNo,
        LocalDateTime createdAt,
        String seller,
        String status,
        String type,
        double saleQuantity,
        int amount
    ) {

    }

    public record DeleteSaleOrderRequest(
        String orderNo,
        String userToken
    ) {

    }
}
