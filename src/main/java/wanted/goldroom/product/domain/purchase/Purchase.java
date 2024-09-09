package wanted.goldroom.product.domain.purchase;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import wanted.goldroom.product.domain.item.Item;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "purchase_order")
public class Purchase {

    @Id
    private String orderNo;
    private String buyer;
    private Status status;
    private double saleQuantity;
    private String receiverZipCode;
    private String receiverAddress;
    private String receiverDetailAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ORDER_COMPLETE("주문 완료"),
        REMITTANCE_COMPLETE("입금 완료"),
        RECEIVE_COMPLETE("수령 완료");

        private final String description;
    }
}
