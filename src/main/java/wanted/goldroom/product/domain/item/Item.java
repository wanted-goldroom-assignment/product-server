package wanted.goldroom.product.domain.item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Type type;
    private int salePrice;
    private int buyPrice;

    @Getter
    @RequiredArgsConstructor
    public enum Type {
        GOLD_99_9_PERCENT("금 99.9%"),
        GOLD_99_99_PERCENT("금 99.99%");

        private final String product;
    }
}
