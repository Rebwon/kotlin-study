package com.rebwon.kotlinstudy;

import java.util.List;

public final class CollectionUtils {

    public static List<String> uppercaseAll(List<String> strings) {
        strings.replaceAll(String::toUpperCase);
        return strings;
    }
}
