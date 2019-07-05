package com.pradipta.maven.plugins.misc;

import org.junit.Test;
import com.pradipta.maven.plugins.misc.PradiptaMavenPluginMojo;
import junit.framework.TestCase;
 
public class PradiptaMavenPluginMojoTest extends TestCase {
	
	@Test
	public void testMojo() throws Exception{
		PradiptaMavenPluginMojo mojo = new PradiptaMavenPluginMojo();
		mojo.execute();
	}
}
