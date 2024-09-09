package wanted.goldroom.product.domain.exception;

public record ErrorResponse(
    int statusCode,
    String message) {

}
