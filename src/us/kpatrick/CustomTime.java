package us.kpatrick;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

/**
 * RANDOM TIME GENERATOR
 * @author kpatr
 * @version 1.0.0
 */
public class CustomTime {
    /**
     *  GET RANDOM TIME BETWEEN 7AM AND 11AM
     * @return String of Time
     */

    public static String MorningTime()  { //RETURNS RANDOM CANNOT TEST
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Calendar cal=Calendar.getInstance();
        try {
            String str_date1="07:00:00";
            String str_date2="11:00:00";

            cal.setTime(formatter.parse(str_date1));
            Long value1 = cal.getTimeInMillis();

            cal.setTime(formatter.parse(str_date2));
            Long value2 = cal.getTimeInMillis();

            long value3 = (long)(value1 + Math.random()*(value2 - value1));
            cal.setTimeInMillis(value3);

        } catch (Exception e) {
            System.out.println("Error Getting Random Morning Time");
        }
        return LocalDateTime.of(LocalDate.now(), LocalTime.of(cal.getTime().getHours(),cal.getTime().getMinutes(), cal.getTime().getSeconds())).toString();
        // return(formatter.format(cal.getTime()));
    }

    /**
     *  GET RANDOM TIME BETWEEN 1PM AND 11PM
     * @return string of time
     */
    public static String EveningTime() { //RETURNS RANDOM CANNOT TEST
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Calendar cal=Calendar.getInstance();
        try {
            String str_date1="13:00:00";
            String str_date2="23:00:00";

            cal.setTime(formatter.parse(str_date1));
            Long value1 = cal.getTimeInMillis();

            cal.setTime(formatter.parse(str_date2));
            Long value2 = cal.getTimeInMillis();

            long value3 = (long)(value1 + Math.random()*(value2 - value1));
            cal.setTimeInMillis(value3);

        } catch (Exception e) {
            System.out.println("Error Getting Random Evening Time");
        }
        return LocalDateTime.of(LocalDate.now(), LocalTime.of(cal.getTime().getHours(),cal.getTime().getMinutes(), cal.getTime().getSeconds())).toString();
        //return(formatter.format(cal.getTime()));
    }

}
