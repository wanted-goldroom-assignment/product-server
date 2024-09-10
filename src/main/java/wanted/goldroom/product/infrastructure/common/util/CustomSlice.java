package wanted.goldroom.product.infrastructure.common.util;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;

@Getter
public class CustomSlice<T> {
    private final static boolean IS_EMPTY = false;
    private final static boolean IS_NOT_EMPTY = true;

    private final boolean success;
    private final String message;
    private final List<T> data;
    private final Paging links;

    public CustomSlice(List<T> data, LocalDateTime nextCursor, boolean hasNext) {
        this.success = data.isEmpty() ? IS_EMPTY : IS_NOT_EMPTY;
        this.message = data.isEmpty() ? "Empty to search invoices" : "Success to search invoices";
        this.data = data;
        this.links = new Paging(nextCursor, hasNext);
    }

    public record Paging(LocalDateTime nextCursor, boolean hasNext) {

    }
}
