package com.pradipta.maven.plugins.misc;

import org.junit.Test;
import com.pradipta.maven.plugins.misc.AsciiArtMojo;
import junit.framework.TestCase;
 
public class AsciiArtMojoTest extends TestCase {
	
	@Test
	public void testMojo() throws Exception{
		AsciiArtMojo mojo = new AsciiArtMojo();
		mojo.setDeveloperName("TechWarriorPlugin");
		mojo.execute();
	}
}
