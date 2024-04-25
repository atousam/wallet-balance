package org.example.wallet.balance.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
public class DateUtil {
    public static LocalDate getPreviousDate() {
        return LocalDate.now().minusDays(1);
    }

    public static Long getStartTimestampOfDay(LocalDate localDate) {
        LocalDateTime startDate = localDate.atStartOfDay();
        ZonedDateTime zdt = startDate.atZone(ZoneId.systemDefault());
        return Date.from(zdt.toInstant()).getTime();
    }

    public static Long getEndTimestampOfDay(Long startTimestamp) {
        return startTimestamp + (24*60*60*1000);
    }
}
