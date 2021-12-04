package ru.mephi.homeworks.hw5;

//Задание 1
// 1 Abe Lincoln's Birthday: February 12, 1809, died April 15, 1855
//   How old when he died?
//   How many days did he live?


// 2  Bennedict Cumberbatch, July 19, 1976
//   Born in a leap year?
//   How many days in the year he was born?
//   How many decades old is he?
//   What was the day of the week on his 21st birthday?


// 3 Train departs Boston at 1:45PM and arrives New York 7:25PM
//   How many minutes long is the train ride?
//   If the train was delayed 1 hour 19 minutes, what is the actual arrival time?


// 4  Flight: Boston to Miami, leaves March 24th 9:15PM. Flight time is 4 hours 15 minutes
//   When does it arrive in Miami?
//   When does it arrive if the flight is delays 4 hours 27 minutes?


// 5 School semester starts the second Tuesday of September of this year.
//   Hint: Look at the TemporalAdjusters class
//   What is the date?
//   School summer vacation starts June 25th
//   Assuming:
//     *  Two weeks off in December
//     *  Two other vacation weeks
//     *  School is taught Monday - Friday
//   How many days of school are there?
//   Hint: keep track of the short weeks also


//  6 A meeting is schedule for 1:30 PM next Tuesday. If today is Tuesday, assume it is today.
//   What is the time of the week's meetings?

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.next;

public class FirstTask {

    public  static  long getDaysLived(LocalDate birth, LocalDate death){
        long result = 0;
        var copyBirth = birth;
        var copyDeath = death;
        result = (copyBirth.getMonth().maxLength()-copyBirth.getDayOfMonth() )+ copyDeath.getDayOfMonth() -2;
        while(copyBirth.getMonth().getValue() != 12)
        {
            copyBirth = copyBirth.plusMonths(1);
            result+= copyBirth.getMonth().maxLength();
        }
        while (copyDeath.getMonth().getValue() != 1)
        {
            copyDeath = copyDeath.minusMonths(1);
            result+= copyDeath.getMonth().maxLength();
        }
        copyBirth = copyBirth.plusYears(1);
        while(copyBirth.getYear() != copyDeath.getYear()){
            result += copyBirth.lengthOfYear();
            copyBirth = copyBirth.plusYears(1);
        }
        return  result;
    }


    public static void main(String[] args) {
        //1
        System.out.println("----> 1\nAbe Lincoln's Birthday: February 12, 1809, died April 15, 1855");
        LocalDate linBirthday = LocalDate.of(1809, 2, 12);
        LocalDate linDeath = LocalDate.of(1855,4,15);
        //int d = linDeath.getMonthValue()>linBirthday.getMonthValue()
                //?1: (linDeath.getMonth()==linBirthday.getMonth() && linDeath.getDayOfMonth()>=linBirthday.getDayOfMonth())
              //  ?1:0;
       // int d2 = linDeath.minusYears(linDeath.getYear() - linBirthday.getYear()).isAfter(linBirthday)?1:0;
        System.out.println("How old when he died?");
        System.out.println("He was " + (Period.between(linBirthday,linDeath)).getYears() +" years old");

        System.out.println("How many days did he live?");
        System.out.println("1) He  lived "+ getDaysLived(linBirthday,linDeath)+ " days");
        System.out.println("2) He  lived "+ Duration.between(linBirthday.atStartOfDay(),linDeath.atStartOfDay()).toDays()+ " days");

        //2
        System.out.println("----> 2\nBennedict Cumberbatch, July 19, 1976");
        LocalDate bendikit = LocalDate.of(1976, Month.JULY.getValue(),19);
        System.out.println("Born in a leap year?");
        System.out.println(bendikit.isLeapYear()?"Yes is a leap year":"No , this is not a leap year");
        System.out.println("How many days in the year he was born?");
        System.out.println("This year there were " + bendikit.lengthOfYear()+ " days");
        System.out.println("How many decades old is he?");
        System.out.println("It is " + (LocalDate.now().getYear() - bendikit.getYear() )/10+ " decades old");
        System.out.println("What was the day of the week on his 21st birthday?");
        System.out.println("It was " + bendikit.plusYears(21).getDayOfWeek());

        //3
        System.out.println("----> 3\nTrain departs Boston at 1:45PM and arrives New York 7:25PM");
        LocalTime departureTime = LocalTime.of(13,45);
        LocalTime arrivalTime = LocalTime.of(19,25);
        System.out.println("How many minutes long is the train ride?");
        System.out.println("Answer: " + departureTime.until(arrivalTime, ChronoUnit.MINUTES)+ " Another" +
                arrivalTime.minusHours(departureTime.getHour()).minusMinutes(departureTime.getMinute())
        );
        System.out.println("If the train was delayed 1 hour 19 minutes, what is the actual arrival time?");
        System.out.println("Answer: " + arrivalTime
                .plusHours(1).plusMinutes(19));

        // 4
        System.out.println("----> 4\nFlight: Boston to Miami, leaves March 24th 9:15PM. Flight time is 4 hours 15 minutes");
        LocalDateTime departDT = LocalDateTime.of(LocalDate.now().getYear(),Month.MARCH,24,9+12,15);
        LocalTime flight = LocalTime.of(4,15);
        System.out.println("When does it arrive in Miami?");
        System.out.println("Answer: " + departDT.plusHours(flight.getHour()).plusMinutes(flight.getMinute()));
        System.out.println("When does it arrive if the flight is delays 4 hours 27 minutes?");
        System.out.println("Answer: " + departDT.plusHours(flight.getHour()).plusMinutes(flight.getMinute())
                .plusHours(4).plusMinutes(27));

        // 5
        System.out.println("----> 5\nSchool semester starts the second Tuesday of September of this year.");
        LocalDate startSchoolCourse = LocalDate.of(LocalDate.now().getYear(),Month.SEPTEMBER,1);
        LocalDate vacation = LocalDate.of(LocalDate.now().getYear()+1,Month.JUNE,25);
        //Находим первый второй вторник
        startSchoolCourse  = startSchoolCourse.with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY)).with(next(DayOfWeek.TUESDAY));
        double countOfDays = Duration.between(startSchoolCourse.atStartOfDay(),vacation.atStartOfDay()).toDays();
        System.out.println("This the date: "+ startSchoolCourse );
        System.out.println("How many days of school are there?\n"+ (long)(((countOfDays  / 7) - 4) * 5) );

        //  6
        System.out.println("----> 6\nA meeting is schedule for 1:30 PM next Tuesday. If today is Tuesday, assume it is today.");
        System.out.println("What is the time of the week's meetings?");
        TemporalAdjuster adjuster = next(DayOfWeek.TUESDAY);
        LocalDateTime meetings = LocalDateTime.of(LocalDate.now(),LocalTime.of(13,30)).with(adjuster);
        DayOfWeek endWeek = DayOfWeek.of(7);
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.nextOrSame(endWeek)).isAfter(meetings)?"the meetings on ths week":"The meetings on next week");
    }
}
