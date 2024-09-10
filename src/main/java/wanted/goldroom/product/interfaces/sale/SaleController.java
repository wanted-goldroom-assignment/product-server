package wanted.goldroom.product.interfaces.sale;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.application.sale.SaleFacade;
import wanted.goldroom.product.domain.sale.SaleCommand;
import wanted.goldroom.product.domain.sale.SaleInfo;
import wanted.goldroom.product.infrastructure.common.util.CustomSlice;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales-order")
public class SaleController {
    private final SaleFacade saleFacade;
    private final SaleDtoMapper mapper;

    @PostMapping
    public ResponseEntity<SaleDto.RegisterSaleOrderResponse> registerSalesOrder(
        @RequestBody @Valid SaleDto.RegisterSaleOrderRequest request) {
        SaleCommand.RegisterSalesOrder command = mapper.of(request);
        SaleInfo.RegisterSaleInfo info = saleFacade.registerSale(command);
        SaleDto.RegisterSaleOrderResponse response = mapper.of(info);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/history")
    public ResponseEntity<CustomSlice<SaleDto.DetailsSaleOrderListResponse>> detailsSalesOrders(
        @RequestParam(name = "userToken") String userToken,
        @RequestParam(required = false, defaultValue = "10") int size,
        @RequestParam(required = false) LocalDateTime cursor) {
        SaleCommand.DetailSalesOrders command = mapper.of(userToken, size, cursor);
        CustomSlice<SaleInfo.DetailSaleOrderList> info = saleFacade.detailsSaleOrders(command);
        var response = info.map(SaleDto.DetailsSaleOrderListResponse::from);
        return ResponseEntity.ok(response);
    }
}
