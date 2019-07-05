package com.pradipta.maven.plugins.misc;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
 
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
 
/**
 * Goal which shows a cool ascii art at start of the run
 * 
 * @goal ascii
 * 
 */
public class AsciiArtMojo extends AbstractMojo {
 
	/**
	 * The string to print in ascii art
	 * 
	 * @parameter property="developerName" default-value="${project.artifactId}"
	 */
	private String developerName;
 
	public void execute() throws MojoExecutionException, MojoFailureException {
 
		int width = 200;
		int height = 30;
 
		System.out.println("Building: \n");
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("Arial", Font.BOLD, 16));
 
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString(developerName, 0, 20);
 
		for (int y = 0; y < height; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < width; x++) {
 
				sb.append(image.getRGB(x, y) == -16777216 ? " " : "$");
 
			}
 
			if (sb.toString().trim().isEmpty()) {
				continue;
			}
 
			System.out.println(sb);
		}
 
	}
 
	/**
	 * For testing purpose
	 * 
	 * @param designerDirectory
	 */
	public void setDeveloperName(String aName) {
		this.developerName = aName;
	}
 
}