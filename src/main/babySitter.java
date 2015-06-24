package main;

import java.util.HashMap;
import java.util.Map;

public class babySitter {
	
	private static final int MIDNIGHT = 24;
	private static final int AFTER_MIDNIGHT_PAY = 16;
	private static final int START_TIME_TO_BED_TIME_PAY = 12;
	private static final int BED_TIME_TO_MIDNIGHT_PAY = 8;
	
	public static int calculatePay(int startTime, int bedTime, int endTime)
	{
		int pay = 0;
		
		Map<Integer, Integer> mapA = new HashMap<Integer, Integer>();
		
		mapA.put(1, 25);
		mapA.put(2, 26);
		mapA.put(3, 27);
		mapA.put(4, 28);
		
		int start = (mapA.get(startTime) == null) ? startTime : mapA.get(startTime);
		int bed = (mapA.get(bedTime) == null) ? bedTime : mapA.get(bedTime);
		int end = (mapA.get(endTime) == null) ? endTime : mapA.get(endTime);
		
		pay += calcStartToBedPay(start, bed, end);
		pay += calcBedToMidnightPay(start, bed, end);
		pay += calcMidnightToEndPay(start, bed, end);
		
		return pay;
		
	}

	private static int calcStartToBedPay(int start, int bed, int end)
	{
		if((start <= bed) && (start <= MIDNIGHT))
				return (Math.min(Math.min(bed, MIDNIGHT),end)-start)*START_TIME_TO_BED_TIME_PAY;
		
		return 0;
	}
	
	private static int calcBedToMidnightPay(int start, int bed, int end)
	{
		if((MIDNIGHT >= bed && (end >= bed)))
			return (Math.min(MIDNIGHT,end) - Math.max(start,bed))*BED_TIME_TO_MIDNIGHT_PAY;

		return 0;
	}
	
	private static int calcMidnightToEndPay(int start, int bed, int end)
	{
		if((end >= MIDNIGHT))
			return (end-Math.max(start, MIDNIGHT))*AFTER_MIDNIGHT_PAY;

		return 0;
	}
}

