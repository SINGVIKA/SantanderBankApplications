package com.santander.test.automation.util;

import com.santander.test.automation.config.TestConfig;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public final class Utility {
    private Utility() {
    }

    public static <T extends Comparable<? super T>> boolean isSorted(List<T> items, SortType sortType) {
        List<T> sorted = new ArrayList<>(items);
        if (sortType == SortType.DESC) {
            sorted.sort(Comparator.reverseOrder());
        }
        if (sortType == SortType.ASC) {
            sorted.sort(Comparator.naturalOrder());
        }
        return sorted.equals(items);
    }

    public static String getScreenshotFileName() {
        return "Screenshot_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".PNG";
    }

    public static int parseIntTestConfig(String intString) {
        return Integer.parseInt(TestConfig.getConfig(intString.trim()));
    }

    public static short parseShortTestConfig(String intString) {
        return Short.parseShort(TestConfig.getConfig(intString.trim()));
    }


}
