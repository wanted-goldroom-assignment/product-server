package wanted.goldroom.product.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // TYPE
    INVALID_TYPE("취급하지 않는 상품입니다."),

    // ITEM
    NOT_FOUND_ITEM("상품을 찾을 수 없습니다."),

    // PRICE
    NOT_FOUND_PRICE("가격정보를 찾을 수 없습니다."),

    // ORDER
    NOT_FOUND_ORDER("해당 정보를 가져올 수 없습니다.");

    private final String message;
}
