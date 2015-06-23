package main;

public class babySitter {

	private static final int AFTER_MIDNIGHT_PAY = 16;
	private static final int MIDNIGHT = 24;
	private static final int START_TIME_TO_BED_TIME_PAY = 12;
	private static final int BED_TIME_TO_MIDNIGHT_PAY = 8;

	private static int convertTime(int time)
	{
		if(time < 12)
			time += 24;
		return time;
	}
	
	public static int calculatePay(int startTime, int bedTime, int endTime)
	{
		int pay = 0;
		int start, bed, end;
		
		start = convertTime(startTime);
		bed = convertTime(bedTime);
		end = convertTime(endTime);
		
		if(end>bed)
		{
			if(end<=MIDNIGHT)
				pay += (end-bed)*BED_TIME_TO_MIDNIGHT_PAY;
			else
				pay += (end-bed)*AFTER_MIDNIGHT_PAY;
		}
		
		if(bed>=start)
			pay += (bed-start)*START_TIME_TO_BED_TIME_PAY;
		
		return pay;
		
		
	}
	
}

