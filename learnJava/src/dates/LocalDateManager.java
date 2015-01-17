package dates;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class LocalDateManager {
	public static final DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	public static final List<String> NON_WRK_DAYS = new ArrayList<String>();
	static {
		NON_WRK_DAYS.add("SATURDAY");
		NON_WRK_DAYS.add("SUNDAY");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate ld = LocalDate.parse("13/02/2015", dtf);
		LocalDate ld2 = LocalDate.parse("06.03.2015", dtf2);
		LocalDate start = LocalDate.parse("27.02.2015", dtf2);
		LocalDate end = LocalDate.parse("06.03.2015", dtf2);
		ld2.plusDays(1);
		System.out.println(ld.getMonthValue() + "." + ld.getDayOfMonth() + "." + ld.getYear());
		System.out.println(ld.format(dtf2).toString());
		System.out.println(ld.getDayOfWeek().toString().equals("THURSDAY"));
		System.out.println(isWorkingDay(ld2));
		System.out.println(getNumWorkingDays(start, end)+"");
		System.out.println(getFirstMondayBefore(ld2).format(dtf2).toString());
		
		System.out.println(getWeeksInMonth(ld2)+"");
		
		

	}
	public static boolean isWorkingDay(LocalDate date) {
		if(NON_WRK_DAYS.contains(date.getDayOfWeek().toString()) && !fileContains("W"+date.format(dtf2).toString()))
			return false;
		if(fileContains(date.format(dtf2).toString()))
			return false;
		return true;
	}
	
	private static boolean fileContains(String date) {
		File file = new File("Calendar_2015.txt");
		try {
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) {
			final String lineFromFile = scanner.nextLine();
			if(lineFromFile.equals(date)) {
				scanner.close();
				return true;
			}
		}
		scanner.close();
		} catch(FileNotFoundException e) {};
		return false;
	}
	
	public static int getNumWorkingDays(LocalDate start, LocalDate end) {
		if(end.isBefore(start)) {
			LocalDate tmp = end;
			end = start;
			start = tmp;
		}
		int days = 0;
		for(LocalDate date = start; date.isBefore(end.plusDays(1)); date = date.plusDays(1))
			if(isWorkingDay(date))
				days++;
		return days;
	}
	public static LocalDate getFirstMondayBefore(LocalDate input) {
		LocalDate monday = input;
		while(!monday.getDayOfWeek().toString().equals("MONDAY"))
			monday = monday.minusDays(1);
		return monday;
	}
	public static LocalDate getFirstSundayAfter(LocalDate input) {
		LocalDate monday = input;
		while(!monday.getDayOfWeek().toString().equals("SUNDAY"))
			monday = monday.plusDays(1);
		return monday;
	}
	private static int getWeeksInMonth(LocalDate date) {
		WeekFields weekFields = WeekFields.of(Locale.getDefault());
		LocalDate last = date.with(lastDayOfMonth());
		return last.get(weekFields.weekOfMonth());
		
	}
	
	public static ArrayList<LocalDate> getDisplayDates(LocalDate today) {
		ArrayList<LocalDate> result = new ArrayList<>();
		LocalDate first = today.with(firstDayOfMonth());
		LocalDate last = today.with(lastDayOfMonth());
		LocalDate firstToDisplay = getFirstMondayBefore(first);
		LocalDate lastToDisplay = getFirstSundayAfter(last);
		
		for(LocalDate elem = firstToDisplay; elem.isBefore(lastToDisplay.plusDays(1)); elem = elem.plusDays(1)) {
			result.add(elem);
		}
		return result;
	}
}
