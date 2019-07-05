package com.pradipta.maven.plugins.misc;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * 
 * When processing the source tree to find mojos, plugin-tools looks for classes
 * with either
 * 
 * @Mojo Java 5 annotation or "goal" javadoc annotation. @goal annotaion is used
 *       in AsciiArtMojo
 * 
 *       Any class with this annotation are included in the plugin configuration
 *       file.
 *
 */
@Mojo(name = "PradiptaMavenPluginMojoOrGoal")
public class PradiptaMavenPluginMojo extends AbstractMojo {

	@Parameter(property = "PradiptaMavenPluginMojoOrGoal.greetingMessage", defaultValue = "Hello World !!!")
	private String greeting;

	@Parameter(property = "PradiptaMavenPluginMojoOrGoal.count", defaultValue = "3")
	private int count;

	public void execute() throws MojoExecutionException, MojoFailureException {
		// TODO Auto-generated method stub
		while(count-- > 0)
		{
			getLog().info(greeting);
		}
	}

}
