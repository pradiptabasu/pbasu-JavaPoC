package com.pradipta.maven.testng.sample;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.pradipta.maven.testng.sample.SampleExample;

public class SimpleTest {
	
	@Test
	public void test() {
		SampleExample example = new SampleExample();
		example.addInteger(10);
		example.addInteger(100);
		AssertJUnit.assertEquals(example.getSize(), 2);
	}
}
