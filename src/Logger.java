package src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public void logServerStart() {
        System.out.println("Server start -- " + getDateTime());
    }

    public String getDateTime() {
		LocalDateTime dateTime = LocalDateTime.now();
        return String.valueOf(dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss d-MM-uuuu")));
    }

    public String getTime() {
        return String.valueOf(LocalTime.now());
    }

    public String getDate() {
        return String.valueOf(LocalDate.now());
    }
}
