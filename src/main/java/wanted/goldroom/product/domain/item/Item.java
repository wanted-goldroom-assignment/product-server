package wanted.goldroom.product.domain.item;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.exception.BadRequestException;
import wanted.goldroom.product.domain.exception.ErrorCode;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Getter
    @RequiredArgsConstructor
    public enum Type {
        GOLD_99_9_PERCENT("금 99.9%"),
        GOLD_99_99_PERCENT("금 99.99%");

        private final String product;

        public static Type from(String type) {
            return Arrays.stream(Type.values())
                .filter(itemType -> itemType.getProduct().equals(type))
                .findFirst()
                .orElseThrow(() -> new BadRequestException(ErrorCode.INVALID_TYPE));
        }
    }
}
