package src;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public void logAnnouncement(String announcement) {
        System.out.println(announcement + getDateTime());
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
