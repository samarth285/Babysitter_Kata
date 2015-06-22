package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.babySitter;

public class babySitterTests {
	
	@Test
	public void whenStartTimeIsEqualToSleepTimeAndOneHourBeforeEndTimeBeforeMidnight()
	{
		assertEquals(8, babySitter.calculatePay(21, 21, 22));
	}

	@Test
	public void whenStartTimeIsEqualToSleepTimeAndTwoHoursBeforeEndTimeBeforeMidnight()
	{
		assertEquals(16, babySitter.calculatePay(21, 21, 23));
	}
	
	@Test
	public void whenBedTimeIsEqualToEndTimeAndOneHourAfterStartTimeBeforeMidNight()
	{
		assertEquals(12, babySitter.calculatePay(22, 23, 23));
	}
	
	@Test
	public void whenBedTimeIsEqualToEndTimeAndTwoHoursAfterStartTimeBeforeMidNight()
	{
		assertEquals(24, babySitter.calculatePay(21, 23, 23));
	}
	
	@Test
	public void whenBedTimeIsLessThanBedTimeIsLessThanEndTimeAndBeforeMidNight()
	{
		assertEquals(64, babySitter.calculatePay(21, 23, 2));
	}
	
	@Test
	public void whenStartTimeIsAfteBedTimeAndOneHourBeforeEndTimeAfterMidnight()
	{
		assertEquals(16, babySitter.calculatePay(2, 21, 3));
	}
	
	@Test
	public void whenStartTimeIsAfterBedTimeOneHourBeforeEndTimeAfterMidnight()
	{
		assertEquals(8, babySitter.calculatePay(22, 21, 23));
	}
	
	@Test
	public void whenStartTimeIsAfterBedTimeTwoHoursBeforeEndTimeAfterMidnight()
	{
		assertEquals(16, babySitter.calculatePay(22, 21, 24));
	}
	
	@Test
	public void whenStartTimeIsAfterBedTimeSixHoursBeforeEndTimeAfterMidnight()
	{
		assertEquals(80, babySitter.calculatePay(22, 21, 4));
	}
	
	@Test
	public void whenStartTimeIsBeforeBedTimeBeforeMidnightAndEndTimeIsAfterOneHourOfStartTimeAndTwoHoursBeforeSleepTime()
	{
		assertEquals(12, babySitter.calculatePay(22, 1, 23));
	}
	
	@Test
	public void whenStartTimeIsBeforeBedTimeBeforeMidnightAndEndTimeIsAfterTwoHoursOfStartTimeAndTwoHoursBeforeSleepTime()
	{
		assertEquals(24, babySitter.calculatePay(22, 1, 24));
	}
	
	@Test
	public void whenStartTimeIsBeforeBedTimeAfterMidnightAndEndTimeIsAfterOneHourAfterStartTimeAndFourHoursBeforeSleepTime()
	{
		assertEquals(16, babySitter.calculatePay(24, 4, 1));
	}
	
	@Test
	public void whenStartTimeIsBeforeBedTimeAfterMidnightAndEndTimeIsAfterTwoHoursAfterStartTimeAndThreeHoursBeforeSleepTime()
	{
		assertEquals(32, babySitter.calculatePay(24, 3, 2));
	}
}
