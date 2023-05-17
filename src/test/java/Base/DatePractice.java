package Base;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;

public class DatePractice {

    public static void main(String[] args) {

        String date = "April 2024";
        String day = "15";
        LocalDateTime d = LocalDateTime.now();
        System.out.println(d);

        GregorianCalendar g = new GregorianCalendar();
        System.out.println(g.get(Calendar.MONTH)+" "+g.get(Calendar.YEAR));

        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM yyyy");

        String p =f.format(d.plusYears(1));

        System.out.println(date.contains(p));

        System.out.println(p);
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd");
        String  p1 = f1.format(d);
        System.out.println(p1);

        System.out.println(Integer.parseInt(day)>Integer.parseInt(p1)-2);


    }
}
