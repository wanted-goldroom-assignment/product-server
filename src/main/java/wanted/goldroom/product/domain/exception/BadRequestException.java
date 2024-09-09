package wanted.goldroom.product.domain.exception;

public class BadRequestException extends BaseException {

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}
