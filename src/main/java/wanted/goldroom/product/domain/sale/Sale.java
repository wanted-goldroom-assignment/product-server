package wanted.goldroom.product.domain.sale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.item.Item;
import wanted.goldroom.product.infrastructure.common.util.OrderNoGenerator;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sales_order")
public class Sale {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final String PREFIX_ORDER_NUM = FORMATTER.format(LocalDateTime.now()) + "_";

    @Id
    private String orderNo;
    private String seller;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double saleQuantity;
    private int amount;

    @CreatedDate
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ORDER_COMPLETE("주문 완료"),
        PAYMENT_COMPLETE("입금 완료"),
        SEND_COMPLETE("발송 완료");

        private final String description;
    }

    @Builder
    public Sale(String seller, double saleQuantity, Item item, int salePrice) {
        this.orderNo = OrderNoGenerator.randomCharacterWithPrefix(PREFIX_ORDER_NUM);
        this.seller = seller;
        this.status = Status.ORDER_COMPLETE;
        this.saleQuantity = saleQuantity;
        this.amount = (int)(salePrice * saleQuantity);
        this.createdAt = LocalDateTime.now();
        this.item = item;
    }
}
