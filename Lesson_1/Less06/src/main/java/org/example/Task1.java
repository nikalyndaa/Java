package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task1 {

    public void lambdaRun(){
        Predicate<LocalDate> isLeapYear = date -> Year.isLeap(date.getYear());
        BiFunction<LocalDate, LocalDate, Long> daysBetween =
                (d1,d2) -> ChronoUnit.DAYS.between(d1,d2);
        BiFunction<LocalDate, LocalDate, Long>  weeksBetween  =
                (w1, w2) -> ChronoUnit.WEEKS.between(w1,w2);
        Function<LocalDate, DayOfWeek> getDayOfWeek = date -> date.getDayOfWeek();


        System.out.println(isLeapYear.test(LocalDate.of(2023,1,1)));
        System.out.println(daysBetween.apply(LocalDate.of(2026,2,3), LocalDate.of(2026,6,15)));
        System.out.println(weeksBetween.apply(LocalDate.of(2026,2,6), LocalDate.of(2026,3,5)));
        System.out.println(getDayOfWeek.apply(LocalDate.of(1969,7,20)));
    }
}
