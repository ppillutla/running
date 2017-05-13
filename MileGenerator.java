package running;

import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;

public class MileGenerator {

	private static final Map<Integer, Integer> milesPerDay = new HashMap<>();

	public static void main(String[] args) {
		int min = 1;
		int max = 3;

		try {
			min = Integer.parseInt(args[0]);
			max = Integer.parseInt(args[1]);
		} catch (Exception e) {
			System.out
					.println("Inputs were invalid. Continuing with default range of 1-3 miles.");
		}

		final int milesForToday = getMilesInRange(min, max);
		
		updateMilesMap(milesForToday);
	}

	private static void updateMilesMap(final int milesForToday) {
		final Calendar calendar = Calendar.getInstance();
		final int day = calendar.get(Calendar.DAY_OF_WEEK);

		switch (day) {
		case Calendar.SUNDAY:
			milesPerDay.put(0, milesForToday);
			break;
		case Calendar.MONDAY:
			milesPerDay.put(1, milesForToday);
			break;
		case Calendar.TUESDAY:
			milesPerDay.put(2, milesForToday);
			break;
		case Calendar.WEDNESDAY:
			milesPerDay.put(3, milesForToday);
			break;
		case Calendar.THURSDAY:
			milesPerDay.put(4, milesForToday);
			break;
		case Calendar.FRIDAY:
			milesPerDay.put(5, milesForToday);
			break;
		case Calendar.SATURDAY:
			milesPerDay.put(6, milesForToday);
		default:
			break;
		}

	}

	private static int getMilesInRange(int min, int max) {
		final int range = Math.abs(max - min) + 1; // safe guard against min
													// input val > max input val
		return (int) (Math.random() * range) + (min <= max ? min : max);
	}

}
