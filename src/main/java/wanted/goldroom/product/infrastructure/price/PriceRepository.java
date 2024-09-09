package wanted.goldroom.product.infrastructure.price;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import wanted.goldroom.product.domain.price.Price;

public interface PriceRepository extends JpaRepository<Price, Integer> {
    Optional<Price> findTopByOrderByCreatedAtDesc();
}
