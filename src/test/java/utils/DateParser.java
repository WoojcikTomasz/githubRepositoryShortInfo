package utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateParser {
    public static LocalDate parseDateToLocalDate(String date) {
        Instant instant = Instant.parse(date);
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
