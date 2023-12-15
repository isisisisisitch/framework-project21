package ca.bytetube.util;

public class Strings {
    public static String underlineCased(String str) {
        if (str == null) return null;
        int len = str.length();
        if (len == 0) return str;

        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(str.charAt(0)));
        for (int i = 1; i < len; i++) {
            char c = str.charAt(i);

            if (Character.isUpperCase(c)) {
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String bigCamelCase(String str) {
        return camelCase(str, true);
    }

    public static String smallCamelCase(String str) {
        return camelCase(str, false);
    }

    private static String camelCase(String str, boolean big) {
        if (str == null) return null;
        int len = str.length();
        if (len == 0) return str;

        StringBuilder sb = new StringBuilder();
        char first = str.charAt(0);
        if (big) {
            first = Character.toUpperCase(first);
        } else {
            first = Character.toLowerCase(first);
        }
        sb.append(first);

        boolean upper = false;
        for (int i = 1; i < len; i++) {
            char c = str.charAt(i);
            if (c == '_') {
                upper = true;
                continue;
            }

            if (upper) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }
            upper = false;
        }
        return sb.toString();
    }
}
