package com.example.newsshow.utils;

import com.socks.library.KLog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Created by Administrator on 2017/11/22.
 */

public class DateUtil {

    /**
     * from yyyy-MM-dd HH:mm:ss to MM-dd HH:mm
     * @param before
     * @return
     * @throws ParseException
     */
    public static String formatDate(String before) throws ParseException {
        String after;
        try {
            Date data = new SimpleDateFormat("yyyy-MM-HH dd:mm:ss", Locale.getDefault()).parse(before);
            after = new SimpleDateFormat("yyyy-MM-HH dd:mm:ss", Locale.getDefault()).format(data);
        } catch (ParseException e) {
            KLog.e("转换新闻日期格式异常：" + e.toString());
            e.printStackTrace();
            return before;
        }

        return after;
    }

    /**
     * 将秒转换成分钟
     * @param length
     * @return
     */
    public static String getLengthStr(long length) {
        int hour = (int) (length / (60 * 60));
        int hourLast = (int) (length % (60 * 60));
        int minute = hourLast / 60;
        int second = hourLast % 60;
        StringBuffer sb = new StringBuffer();
        if(hour != 0){
            sb.append(zeroize(hour));
            sb.append(":");
        }

        if(minute != 0){
            sb.append(zeroize(minute));
            sb.append(":");
        }else{
            sb.append("00:");
        }

        if(second != 0){
            sb.append(zeroize(second));
        }else{
            sb.append("00");
        }

        return sb.toString();
    }

    public static String zeroize(int time){
        if(time < 10){
            return "0" + time ;
        }
        return String.valueOf(time);
    }
}
