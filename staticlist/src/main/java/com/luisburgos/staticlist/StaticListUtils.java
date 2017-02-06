package com.luisburgos.staticlist;

/**
 * Helper methods
 */
public class StaticListUtils {

    /**
     * Helper method to determine if a object is null.
     * This class throws a {@link NullPointerException} whether the object is null.
     *
     * @param reference object to test
     * @param <T> concrete class of the object to test.
     * @return The {@code reference} if not null.
     */
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

}