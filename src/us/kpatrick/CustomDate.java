package us.kpatrick;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * CUSTOM DATE CLASS USED TO CALCULATE THE DIFFERENT BETWEEN MINUTES
 * @author kpatr
 * @version 1.0.0
 */
public class CustomDate {

    /**
     * CALCULATE THE MINUTES BETWEEN TWO TIMES
     * @param time1 EARLIEST TIME IN LocalDateTime FORMAT
     * @param time2 LATEST TIME IN LocalDateTime FORMAT
     * @return long RETURNS THE MINUTES BETWEEN TWO TIMES
     */
    public static long minuteDifference1(String time1, String time2) {
        if (!time2.equals("null")) {
            String t1 = LocalDateTime.parse(time1).toLocalTime().toString();
            String t2 = LocalDateTime.parse(time2).toLocalTime().toString();

            long diff = 0;
            try {
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                Date date1 = format.parse(t1);
                Date date2 = format.parse(t2);
                diff = date2.getTime() - date1.getTime();
                //System.out.println(diff/1000);
            } catch (Exception e) {
                diff = 0;
            }

            return (diff / 1000 / 60);
        } else {
            return 0;
        }

    }
}