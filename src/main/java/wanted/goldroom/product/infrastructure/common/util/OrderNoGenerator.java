package wanted.goldroom.product.infrastructure.common.util;

import org.apache.commons.lang3.RandomStringUtils;

public class OrderNoGenerator {
    private static final int TOKEN_LENGTH = 25;

    private static String randomCharacter(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String randomCharacterWithPrefix(String prefix) {
        return prefix + randomCharacter(TOKEN_LENGTH - prefix.length());
    }
}
