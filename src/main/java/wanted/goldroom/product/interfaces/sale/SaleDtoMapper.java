package wanted.goldroom.product.interfaces.sale;

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
}
