package com.tiborbotos.patterns;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tiborbotos.patterns.Option.ValueEmpty;

public class OptionTest {
	
	@Test
	public void testOptionNoneIsEmpty() {
		Option<Long> number = Option.none();
		
		Assert.assertTrue(number.isEmpty());
		Assert.assertFalse(number.isDefined());
	}
	
	@Test
	public void testOptionHasValue() {
		Option<Long> number = Option.of(5L);
		
		Assert.assertFalse(number.isEmpty());
		Assert.assertTrue(number.isDefined());
		Assert.assertTrue(number.get().equals(5L));
	}
	
	@Test
	public void testGetOrElse() {
		Option<Long> number = Option.none();
		
		Long value = number.getOrElse(0L);
		Assert.assertTrue(value.equals(0L));
	}
	
	@Test(expectedExceptions = RuntimeException.class)
	public void testGetOrElseWithException() {
		Option<Long> number = Option.none();
		
		@SuppressWarnings("unused")
		Long value = number.getOrElse(new ValueEmpty<Long>() {
			@Override
			public Long get() {
				throw new RuntimeException();
			}
		});
	}
}
