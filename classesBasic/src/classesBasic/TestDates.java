package classesBasic;
import java.util.*;
public class TestDates
{  
   public static void main(String args[])
   {
      // GregorianCalendar date below correspond to 15th March 2007, 1.30 pm 
      GregorianCalendar dateTime1 = new GregorianCalendar(2007,2,15,13,30);
	  
	  // advancing month to April
      dateTime1.add(Calendar.MONTH,1); 
	  
	  // setting day to 10 = 15 - 5
      dateTime1.add(Calendar.DAY_OF_MONTH,-5); 

     System.out.println("Year = " + dateTime1.get(Calendar.YEAR));
     System.out.println("Month = " + dateTime1.get(Calendar.MONTH));
     System.out.println("Day = " + dateTime1.get(Calendar.DAY_OF_MONTH));
     System.out.println("Hour = " + dateTime1.get(Calendar.HOUR_OF_DAY));
     System.out.println("Min = " + dateTime1.get(Calendar.MINUTE));
     System.out.println("Year = " + dateTime1.get(Calendar.YEAR));

     // Defaults constructor sets it to current  date and time  
     GregorianCalendar dateTime2 = new GregorianCalendar();
	 
     // Finding the difference in dates in millseconds  
     long diff = dateTime1.getTimeInMillis() - dateTime2.getTimeInMillis();
	 
     // converting difference to days 
     int diffDays = (int)(diff / (1000 * 60 * 60 * 24));
	 
     System.out.println("Difference in days = " + diffDays);  
   }
}
