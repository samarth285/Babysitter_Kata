package main;

public class babySitter {
	
	private static final int MIDNIGHT = 24;
	private static final int AFTER_MIDNIGHT_PAY = 16;
	private static final int START_TIME_TO_BED_TIME_PAY = 12;
	private static final int BED_TIME_TO_MIDNIGHT_PAY = 8;
	
	private static int convertTime(int time)
	{
		if(time < 12)
			time += 24;
		return time;
	}
	
	private static int calcStartToBedPay(int start, int bed, int end)
	{
		if((bed-start) >= 0)
			return ((bed-start))*START_TIME_TO_BED_TIME_PAY;
		else
			return 0;
	}
	
	private static int calcBedToMidnightPay(int start, int bed, int end)
	{
		if((MIDNIGHT-bed) >= 0)
			if(end <= MIDNIGHT)
				if(bed>=start)
					return (end-bed)*BED_TIME_TO_MIDNIGHT_PAY;
				else
					return (end-start)*BED_TIME_TO_MIDNIGHT_PAY;
			else
				return (MIDNIGHT-bed)*BED_TIME_TO_MIDNIGHT_PAY;
		else
			return 0;
	}
	
	private static int calcMidnightToEndPay(int start, int bed, int end)
	{
		if((end-MIDNIGHT) >= 0)
			if(bed <= MIDNIGHT)
					return (end-MIDNIGHT)*AFTER_MIDNIGHT_PAY;
			else
				if(bed>=start)
					return (end-bed)*AFTER_MIDNIGHT_PAY;
				else
					return (end-start)*AFTER_MIDNIGHT_PAY;
		else
			return 0;
	}
	
	public static int calculatePay(int startTime, int bedTime, int endTime)
	{
		int pay = 0;
		int start, bed, end;
		
		start = convertTime(startTime);
		bed = convertTime(bedTime);
		end = convertTime(endTime);
		 
		pay += calcStartToBedPay(start, bed, end);
		pay += calcBedToMidnightPay(start, bed, end);
		pay += calcMidnightToEndPay(start, bed, end);
		
		return pay;
		
		
	}
	
}

