package test;

import static org.junit.Assert.*;
import main.babySitter;

import org.junit.Test;

public class babySitterTests {
	
	@Test
	public void whenStartTimeAndBedTimeAreSameAndOneHourBeforeEndTime()
	{
		assertEquals(8, babySitter.calculatePay(21, 21, 22));
	}
	
	@Test
	public void whenStartTimeAndBedTimeAreSameAndTwoHoursBeforeEndTime()
	{
		assertEquals(16, babySitter.calculatePay(21, 21, 23));
	}
	
	@Test
	public void whenStartTimeAndBedTimeAreSameAndThreeHoursBeforeEndTime()
	{
		assertEquals(24, babySitter.calculatePay(21, 21, 24));
	}
	
	@Test
	public void whenBedTimeAndEndTimeAreSameAndOneHourAfterStartTime()
	{
		assertEquals(12, babySitter.calculatePay(21, 22, 22));
	}
	
	@Test
	public void whenBedTimeAndEndTimeAreSameAndTwoHoursAfterStartTime()
	{
		assertEquals(24, babySitter.calculatePay(21, 23, 23));
	}
	
	@Test
	public void whenStartTimeIsEqualToBedTimeIsEqualToEndTime()
	{
		assertEquals(0, babySitter.calculatePay(21, 21, 21));
	}
	
	@Test
	public void whenAllTimesAreDifferent()
	{
		assertEquals(20, babySitter.calculatePay(21, 22, 23));
	}
	
	@Test
	public void whenAllTimesAreDifferentScenario2()
	{
		assertEquals(40, babySitter.calculatePay(20, 22, 24));
	}
	
	@Test
	public void whenStartTimeAndBedTimeAreSameAndOneHourBeforeEndTimeAfterMidnight()
	{
		assertEquals(16, babySitter.calculatePay(1, 1, 2));
	}
	
	
	

}
