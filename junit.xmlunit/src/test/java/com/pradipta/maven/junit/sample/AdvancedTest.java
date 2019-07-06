package com.pradipta.maven.junit.sample;

import org.junit.Assert;
import org.junit.Test;

import com.pradipta.maven.junit.sample.SampleExample;

public class AdvancedTest {

	@Test
	public void test() {
		SampleExample ex1 = new SampleExample();
		ex1.addInteger(10);
		ex1.addInteger(100);
		
		SampleExample ex2 = new SampleExample();
		ex2.addInteger(10);
		ex2.addInteger(100);
		ex2.addInteger(1000);
		
		Assert.assertNotEquals(ex1.getSize(), ex2.getSize());
	}
}
