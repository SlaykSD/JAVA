package ru.mephi.homeworks.hw5;
// Задание 2
// 1 Using the following information:
//   * Use America/New_York as the time zone for Boston Logan Airport(BOS).
//   * Use America/Los_Angeles as the time zone for San Francisco Airport (SFO).
//   * Use Asia/Calcutta as the time zone for Bangalore's Bengaluru International Airport (BLR)


// 2 Flight 123, San Francisco to  Boston, leaves SFO at 10:30 PM June 13, 2014
// The flight is 5 hours 30 minutes
//   What is the local time in Boston when the flight takes off?
//   What is the local time at Boston Logan airport when the flight arrives?
//   What is the local time in San Francisco when the flight arrives?


// 3 Flight 456, San Francisco to Bangalore, India, leaves SFO at Saturday, 10:30 PM June 28, 2014
// The flight time is 22 hours
//   Will the traveler make a meeting in Bangalore Monday at 9 AM local time?
//   Can the traveler call her husband at a reasonable time when she arrives?


// 4 Flight 123, San Francisco to Boston, leaves SFO at 10:30 PM Saturday, November 1st, 2014
// Flight time is 5 hours 30 minutes.
//   What day and time does the flight arrive in Boston?
//   What happened?

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class SecondTask {
    public static void main(String[] args) {
        // 1
    //   * Use America/New_York as the time zone for Boston Logan Airport(BOS).
    //   * Use America/Los_Angeles as the time zone for San Francisco Airport (SFO).
    //   * Use Asia/Calcutta as the time zone for Bangalore's Bengaluru International Airport ()
        ZoneId BOS = ZoneId.of("America/New_York");
        ZoneId SFO = ZoneId.of("America/Los_Angeles");
        ZoneId BLR = ZoneId.of("Asia/Calcutta");


        // 2
        System.out.println("\nFlight 123, San Francisco to  Boston, leaves SFO at 10:30 PM June 13, 2014");
        System.out.println("The flight is 5 hours 30 minutes");
        LocalTime durationFlight = LocalTime.of(5,30);
        ZonedDateTime startFlight = ZonedDateTime.of(LocalDate.of(2014, Month.JUNE,13),LocalTime.of(22,30),SFO);
        System.out.println("What is the local time in Boston when the flight takes off?");
        System.out.println("Answer: "+ startFlight.withZoneSameInstant(BOS).toLocalTime());
        System.out.println("What is the local time at Boston Logan airport when the flight arrives?");
        System.out.println("Answer: "+ startFlight
                .plusHours(durationFlight.getHour())
                .plusMinutes(durationFlight.getMinute())
                .withZoneSameInstant(BOS).toLocalTime());
        System.out.println("What is the local time in San Francisco when the flight arrives?");
        System.out.println("Answer: "+ startFlight
                .plusHours(durationFlight.getHour())
                .plusMinutes(durationFlight.getMinute()).toLocalTime());

        // 3 Flight 456, San Francisco to Bangalore, India, leaves SFO at Saturday, 10:30 PM June 28, 2014
        System.out.println("\nFlight 456, San Francisco to Bangalore, India, leaves SFO at Saturday, 10:30 PM June 28, 2014");
        System.out.println("The flight time is 22 hours");
        startFlight = ZonedDateTime.of(LocalDate.of(2014, Month.JUNE,28),LocalTime.of(22,30),SFO);
        durationFlight = LocalTime.of(22,0);
        var timeArrive = startFlight.plusHours(durationFlight.getHour()).withZoneSameInstant(BLR);
        var meeting = startFlight.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)).with(LocalTime.of(9,0));
        System.out.println("Will the traveler make a meeting in Bangalore Monday at 9 AM local time?");
        System.out.println("Answer: "+((meeting.toLocalDate().isEqual(timeArrive.toLocalDate()) &&
                (meeting.toLocalTime().isAfter(timeArrive.toLocalTime()) || meeting.toLocalTime().equals(timeArrive.toLocalTime())))?"yes":"no"));
        System.out.println("Can the traveler call her husband at a reasonable time when she arrives?");
        System.out.println("Answer: "+(( timeArrive.toLocalTime().isAfter(LocalTime.of(8,0)) &&
                timeArrive.toLocalTime().isBefore(LocalTime.of(23,0))  )?"yes":"no"));

        // 4 Flight 123, San Francisco to Boston, leaves SFO at 10:30 PM Saturday, November 1st, 2014
        System.out.println("\nFlight 123, San Francisco to Boston, leaves SFO at 10:30 PM Saturday, November 1st, 2014");
        System.out.println("Flight time is 5 hours 30 minutes.");
        durationFlight = LocalTime.of(5,30);
        startFlight = ZonedDateTime.of(LocalDateTime.of(2014,Month.NOVEMBER,1,22,30),SFO);
        System.out.println("What day and time does the flight arrive in Boston?");
        System.out.println("Answer: "+ startFlight
                .plusHours(durationFlight.getHour())
                .plusMinutes(durationFlight.getMinute())
                .withZoneSameInstant(BOS)
                .toLocalDateTime());
        //   What happened? -I don't know
    }
}
