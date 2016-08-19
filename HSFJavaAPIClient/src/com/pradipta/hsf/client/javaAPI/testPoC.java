package com.pradipta.hsf.client.javaAPI;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.hyperion.hsf.common.HSFUtils;
import com.hyperion.hsf.common.XmlFunctions;
import com.hyperion.hsf.managers.EntityGatewayManager;



public class testPoC 
{

	public static void main(String abc[]) 
	{
		try 
		{
			
			BufferedReader br = null;
			String sCurrentLine;
			String fullFile="";
			
			String fileName = "EnumerateAccountsDecoded";
			br = new BufferedReader(new FileReader("D:\\WorkSpace\\EclipseLuna_Hyperion_HSF\\HSFJavaAPIClient\\"+ fileName +".xml"));

			while ((sCurrentLine = br.readLine()) != null) 
			{
				fullFile = fullFile + sCurrentLine;
			}
			
			br.close();
			
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		    domFactory.setIgnoringElementContentWhitespace(true);
		    DocumentBuilder builder = domFactory.newDocumentBuilder();
		    InputStream inStream = new ByteArrayInputStream(fullFile.getBytes("UTF-8"));
		    
		    System.out.println("partial before doc parse aaaaa");
		    
		    Document document = builder.parse(inStream);
		    
		    System.out.println("partial aaaaa");
		    
		    
		    Document document1 = XmlFunctions.loadXML(fullFile);
		    EntityGatewayManager.accountsFromXML(HSFUtils.xmlDecode(fullFile));
		    
		    System.out.println("aaaaa");
		    
		      
		} catch (Exception e) {

		}
	}
}
