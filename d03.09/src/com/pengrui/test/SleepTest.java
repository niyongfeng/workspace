package com.pengrui.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class SleepTest {
	Sleep s = new Sleep();
	@Test
	public void test1() {
		assertTrue("周末非假期需要休息",s.shouldSleep(true, false));
		assertFalse("非周末费假期不需要休息",s.shouldSleep(false, false));
	}
	
	@Test
	public void test2() {
		assertTrue("非周末假期不需要休息",s.shouldSleep(false, true));
	}
}
