package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class TextGenerator {
    private TextGenerator() {
    }

    private static final int TEXT_COUNT = 7;
    private static final int LONG_TEXT_COUNT = 1000;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";

    private static final String POST_TEXT = RandomStringUtils.randomAlphabetic(TEXT_COUNT);

    public static String generateText() {
        return POST_TEXT;
    }

    public static String randomText() {
        return RandomStringUtils.randomAlphabetic(TEXT_COUNT);
    }

    public static String randomSpecialCharacters() {
        return RandomStringUtils.random(TEXT_COUNT, SPECIAL_CHARACTERS);
    }

    public static String randomLongText() {
        return RandomStringUtils.randomAlphabetic(LONG_TEXT_COUNT);
    }
}


