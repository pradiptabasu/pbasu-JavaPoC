package com.pradipta.maven.junit.sample;

import org.junit.Assert;
import org.junit.Test;

import com.pradipta.maven.junit.sample.SampleExample;

public class SimpleTest {
	
	@Test
	public void test() {
		SampleExample example = new SampleExample();
		example.addInteger(10);
		example.addInteger(100);
		Assert.assertEquals(example.getSize(), 2);
	}
}
