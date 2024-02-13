package ca.bytetube.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uris {
    private static final Pattern lastPathReg = Pattern.compile("([^/]+)/*$");
    private static final Pattern last2PathsReg = Pattern.compile("([^/]+)/+([^/]+)/*$");

    public static String lastPath(String uri) {
        if (uri == null) return null;
        Matcher matcher = lastPathReg.matcher(uri);
        if (!matcher.find()) return null;
        return matcher.group(1);
    }

    public static String[] last2Paths(String uri) {
        if (uri == null) return null;
        Matcher matcher = last2PathsReg.matcher(uri);
        if (!matcher.find()) return null;
        return new String[]{matcher.group(1), matcher.group(2)};
    }
}
