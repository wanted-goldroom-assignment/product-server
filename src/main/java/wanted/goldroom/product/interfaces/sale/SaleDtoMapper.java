package wanted.goldroom.product.interfaces.sale;

import java.time.LocalDateTime;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import wanted.goldroom.product.domain.sale.SaleCommand;
import wanted.goldroom.product.domain.sale.SaleInfo;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface SaleDtoMapper {
    SaleCommand.RegisterSalesOrder of(SaleDto.RegisterSaleOrderRequest request);

    SaleDto.RegisterSaleOrderResponse of(SaleInfo.RegisterSaleInfo info);

    SaleCommand.DetailSalesOrderList of(String userToken, int size, LocalDateTime cursor);

    SaleCommand.DetailSalesOrder of(String orderNo);

    SaleDto.DetailsSaleOrderResponse of(SaleInfo.DetailSaleOrder info);

    SaleCommand.DeleteSalesOrder of(SaleDto.DeleteSaleOrderRequest request);
}
