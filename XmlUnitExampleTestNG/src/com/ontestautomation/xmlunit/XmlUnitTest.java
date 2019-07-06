package com.ontestautomation.xmlunit;

import java.util.Iterator;

import javax.xml.transform.Source;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;
import org.xmlunit.validation.Languages;
import org.xmlunit.validation.ValidationProblem;
import org.xmlunit.validation.ValidationResult;
import org.xmlunit.validation.Validator;
import org.xmlunit.xpath.JAXPXPathEngine;
import org.xmlunit.xpath.XPathEngine;

public class XmlUnitTest {
	
	@BeforeSuite
	public void init() {
		
		//System.setProperty("http.proxyHost","proxynlb.intern.wehkamp.nl");
		//System.setProperty("http.proxyPort","8080");
	}
	
	@Test
	public void aFirstTest() {
		
		Source source = Input.fromString("<foo>bar</foo>").build();
		XPathEngine xpath = new JAXPXPathEngine();
		String content = xpath.evaluate("/foo/text()", source);
		Assert.assertEquals(content, "bar");
	}
	
	@Test
	public void restCallTest() {
		
		Source source = Input.fromURI("http://parabank.parasoft.com/parabank/services/bank/customers/12212").build();
		XPathEngine xpath = new JAXPXPathEngine();
		String content = xpath.evaluate("//city/text()", source);
		Assert.assertEquals(content, "Beverly Hills");
	}
	
	@Test
	public void compareTest() {
		
		DiffBuilder db = DiffBuilder.compare(Input.fromFile("messages/response.xml")).withTest(Input.fromURI("http://parabank.parasoft.com/parabank/services/bank/customers/12212").build());
		Diff d = db.build();
		
		if(d.hasDifferences()) {
			Iterator<Difference> diffs = d.getDifferences().iterator();
			while(diffs.hasNext()) {
				Reporter.log(diffs.next().toString());
			}
		}
		
		Assert.assertEquals(d.hasDifferences(), false);
	}
	
	@Test
	public void validationTest() {
		
		Validator v = Validator.forLanguage(Languages.W3C_XML_SCHEMA_NS_URI);
		v.setSchemaSources(Input.fromFile("messages/orderschema.xsd").build());
		ValidationResult result = v.validateInstance(Input.fromFile("messages/order.xml").build());
		
		Iterator<ValidationProblem> problems = result.getProblems().iterator();
		
		while (problems.hasNext()) {
			Reporter.log(problems.next().toString());
		}
		
		Assert.assertEquals(result.isValid(), true);
	}
}