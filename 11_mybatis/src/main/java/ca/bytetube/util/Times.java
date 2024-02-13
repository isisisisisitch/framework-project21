package ca.bytetube.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Times {
    private static final SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(Date date) {
        return date == null ? null : dateFmt.format(date);
    }

    public static String formatTime(Date date) {
        return date == null ? null : timeFmt.format(date);
    }

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }
}
