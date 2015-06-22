package main;

public class babySitter {

	private static final int TIME_MODULO_CONST = 24;
	private static final int NOON_TIME = 12;
	private static final int MIDNIGHT_TIME = 24;
	private static final int AFTER_MIDNIGHT_PAY = 16;
	private static final int BED_TIME_TO_END_TIME_PAY_BEFORE_MIDNIGHT = 8;
	private static final int START_TIME_TO_BED_TIME_PAY_BEFORE_MIDNIGHT = 12;
	
	private static int whenBabySitterStartsBeforeMidnightAndBedTime(int startTime, int bedTime, int endTime) {
		
		if(bedTime<=MIDNIGHT_TIME)
		{
			if(endTime<=MIDNIGHT_TIME)
				return ((bedTime-startTime)*START_TIME_TO_BED_TIME_PAY_BEFORE_MIDNIGHT 
						+ (endTime-bedTime)*BED_TIME_TO_END_TIME_PAY_BEFORE_MIDNIGHT);
			
			else
				return ((bedTime-startTime)*START_TIME_TO_BED_TIME_PAY_BEFORE_MIDNIGHT 
						+ (MIDNIGHT_TIME-bedTime)*BED_TIME_TO_END_TIME_PAY_BEFORE_MIDNIGHT 
						+ (endTime-MIDNIGHT_TIME)*AFTER_MIDNIGHT_PAY);
		}
		
		else
		{
			if(endTime>MIDNIGHT_TIME)
				return ((MIDNIGHT_TIME-startTime)*START_TIME_TO_BED_TIME_PAY_BEFORE_MIDNIGHT 
						+ (bedTime-MIDNIGHT_TIME)*AFTER_MIDNIGHT_PAY 
						+ (endTime-bedTime)*AFTER_MIDNIGHT_PAY);
			
			else
				return ((endTime-startTime)*START_TIME_TO_BED_TIME_PAY_BEFORE_MIDNIGHT);
		}
	}
	
	private static int whenBabySitterStartsBeforeMidnightAndAfterBedTime(int startTime, int bedTime, int endTime)
	{
		if(endTime<MIDNIGHT_TIME)
			return ((endTime-startTime)*BED_TIME_TO_END_TIME_PAY_BEFORE_MIDNIGHT);
		
		else
			return ((MIDNIGHT_TIME-startTime)*BED_TIME_TO_END_TIME_PAY_BEFORE_MIDNIGHT 
					+ (endTime-MIDNIGHT_TIME)*AFTER_MIDNIGHT_PAY);
	}
	
	public static long calculatePay(int startTime, int bedTime, int endTime)
	{
		if(startTime<NOON_TIME)
			startTime += TIME_MODULO_CONST;
		
		if(bedTime<NOON_TIME)
			bedTime += TIME_MODULO_CONST;
		
		if (endTime<NOON_TIME)
			endTime += TIME_MODULO_CONST;
		
		if(startTime<=MIDNIGHT_TIME)
		{			
			if(startTime<=bedTime)
				return whenBabySitterStartsBeforeMidnightAndBedTime(startTime, bedTime, endTime);
			
			else
				return whenBabySitterStartsBeforeMidnightAndAfterBedTime(startTime, bedTime, endTime);
				
		}
		
		else
			if(startTime>bedTime)
				return (endTime-startTime)*AFTER_MIDNIGHT_PAY;
			else
				return (endTime-bedTime)*AFTER_MIDNIGHT_PAY;
	}

}
