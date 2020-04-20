import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
	import java.time.LocalTime;
	import java.time.LocalDateTime;
	import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DateTime {


	   public static void main(String args[]) {
		   DateTime dateTime = new DateTime();
		   dateTime.testLocalDateTime();
		   dateTime.testPeriod();
		   dateTime.testDuration();
		   dateTime.testAdjusters();
		   
	   }
	   public void testAdjusters() {
		      LocalDate date1 = LocalDate.now();
		      System.out.println("Current date: " + date1);
				
		      LocalDate nextTuesday = date1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		      System.out.println("Next Tuesday on : " + nextTuesday);
				
		      LocalDate firstInYear = LocalDate.of(date1.getYear(),date1.getMonth(), 1);
		      LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(
		         DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		      System.out.println("Second Saturday on : " + secondSaturday);
		   }
	   public void testPeriod() {
		      LocalDate date1 = LocalDate.now();
		      System.out.println("Current date: " + date1);
				
		      LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
		      System.out.println("Next month: " + date2);
		      
		      Period period = Period.between(date2, date1);
		      System.out.println("Period: " + period);
		   }
			
		   public void testDuration() {
		      LocalTime time1 = LocalTime.now();
		      Duration twoHours = Duration.ofHours(2);
				
		      LocalTime time2 = time1.plus(twoHours);
		      Duration duration = Duration.between(time1, time2);
				
		      System.out.println("Duration: " + duration);
		   }
	   public void testLocalDateTime() {
	      LocalDateTime currentTime = LocalDateTime.now();
	      System.out.println("Current DateTime: " + currentTime);
			
	      LocalDate date1 = currentTime.toLocalDate();
	      System.out.println("date1: " + date1);
			
	      Month month = currentTime.getMonth();
	      int day = currentTime.getDayOfMonth();
	      int seconds = currentTime.getSecond();
			
	      System.out.println("Month: " + month + " "+"day: " + day +" "+"seconds: " + seconds);
			
	      LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
	      System.out.println("date2: " + date2);
			
	      LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
	      System.out.println("date3: " + date3);
			
	      LocalTime date4 = LocalTime.of(22, 15);
	      System.out.println("date4: " + date4);
			
	      LocalTime date5 = LocalTime.parse("20:15:30");
	      System.out.println("date5: " + date5);
	   }
	}

