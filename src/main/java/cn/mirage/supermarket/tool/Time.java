package cn.mirage.supermarket.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    public static String currentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

}
