package testXMLParsing;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class ABC {

//	public static void main(String[] args) 
//	{
//		// TODO Auto-generated method stub
//		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder documentBuilder;
//        
//		try 
//		{
//			String path="D:\\amu.xml";
//			File file = new File(path);
//			documentBuilder = builderFactory.newDocumentBuilder();
////			Document xml = documentBuilder.parse(new InputSource(new StringReader(xmlResponse)));
//			builderFactory.setNamespaceAware(true);
//			Document xml = documentBuilder.parse(file);
//			
//			System.out.println("xml.."+xml.getNodeName());
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) 
	{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try 
		{
		    builder = builderFactory.newDocumentBuilder();
		    Document document = builder.parse(new FileInputStream("D:\\amu2.xml"));
		    XPath xPath =  XPathFactory.newInstance().newXPath();
//		    String expression = "/resourceorderlistresponse[@messagecode='0']/resourceorderresponse[@messagecode='0']/roiassignments/roi[@archivetime='']/roitransaction[@activationerror='']/bbroi/dslassignments[@activitycode='C']/dslassignment[@activitycode='C']//dslport[1]";
		    String expression = "/*[local-name()='resourceorderlistresponse']/*[local-name()='resourceorderresponse']/*[local-name()='roiassignments']/*[local-name()='roi']/*[local-name()='roitransaction']/*[local-name()='bbroi']/*[local-name()='dslassignments']/*[local-name()='dslassignment'][(@activitycode=\"I\" or @activitycode=\"O\" or @activitycode=\"C\")]/*[local-name()='dslport'][(@activitycode=\"I\" or @actvitiycode=\"R\")]";
		    
		    Node node = (Node) xPath.compile(expression).evaluate(document, XPathConstants.NODE);
		    System.out.println(node.getNodeName());
		} 
		catch (Exception e) {
		    e.printStackTrace();  
		}
	}

	
//	public static AsaOntCpePort parseFibreResponse(String cfsAction, String xmlResponse) {
//        AsaOntCpePort asaOntCpePort = null;
//
//        if (xmlResponse == null) {
//            logger.error("", "System Error ASA : xml repsonse from ASA is null");
//            return null;
//        }
//
//            // Convert string to xml
//            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
//            Document xml = documentBuilder.parse(new InputSource(new StringReader(xmlResponse)));
//
//            // Defect #11433 - Checking for the Version of ASA Response
//            String resourceOrderComVersion = null;
//            resourceOrderComVersion = getResourceOrderComVersion(xml);
//            if (resourceOrderComVersion != null
//                    && (resourceOrderComVersion.equalsIgnoreCase("4.1") || resourceOrderComVersion.contains("4.1"))) {
//                logErrorMsg("System Error ASA : Cannot parse ASA v4.1", xmlResponse, null);
//                return null;
//            }
//
//            // Apply XPATH expressions to extract fibre ont details
//            XPath xPath = XPathFactory.newInstance().newXPath();
//            String gponExpression = AsaConstants.GPON_PORT_XPATH_EXPRESSION_ACTION_MAP.get(cfsAction);
//
//
//            Node gponPortElement = (Node) xPath.evaluate(gponExpression, xml, XPathConstants.NODE);
//
//	}

}
