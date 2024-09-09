package wanted.goldroom.product.domain.sale;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.item.Item;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "sales_order")
public class Sale {

    @Id
    private String orderNo;
    private String seller;
    private Status status;
    private double saleQuantity;
    private int price;

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
}
