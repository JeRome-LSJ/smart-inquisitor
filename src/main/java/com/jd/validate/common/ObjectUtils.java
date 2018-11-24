package com.jd.validate.common;


public class ObjectUtils {
    public static boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    public static boolean isNotNull(Object obj) {
        if (obj != null) {
            return true;
        }
        return false;
    }

    public static boolean NotNull(Object obj) {
        if (obj != null && obj != "") {
            return true;
        }
        return false;
    }

    public static String[] parseStringArray(Object bean) {
        if (bean instanceof String[]) {
            return (String[]) bean;
        }
        return emptyStringArray();
    }

    private static String[] emptyStringArray() {
        return new String[]{};
    }

    public static long parseLong(Object bean) {
        if (bean instanceof Long) {
            return ((Long) bean).longValue();
        }
        return 0;
    }

    public static boolean parseBoolean(Object bean) {
        if (bean instanceof Boolean) {
            return ((Boolean) bean).booleanValue();
        }
        return true;
    }

}
