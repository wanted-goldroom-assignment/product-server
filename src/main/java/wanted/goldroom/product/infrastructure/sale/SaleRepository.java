package wanted.goldroom.product.infrastructure.sale;

import static wanted.goldroom.product.domain.sale.QSale.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.querydsl.core.types.dsl.BooleanExpression;

import wanted.goldroom.product.domain.sale.Sale;

public interface SaleRepository extends JpaRepository<Sale, String> {

    Optional<Sale> findByOrderNo(String orderNo);

    default BooleanExpression lessThanCreatedAt(LocalDateTime createdAt) {
        if (createdAt == null) {
            return null;
        }

        return sale.createdAt.loe(createdAt);
    }

    default BooleanExpression equalUserToken(String userToken) {
        if (userToken == null) {
            return null;
        }
        return sale.seller.eq(userToken);
    }
}
