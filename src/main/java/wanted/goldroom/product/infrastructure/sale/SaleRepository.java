package wanted.goldroom.product.infrastructure.sale;

import org.springframework.data.jpa.repository.JpaRepository;

import wanted.goldroom.product.domain.sale.Sale;

public interface SaleRepository extends JpaRepository<Sale, String> {
}
