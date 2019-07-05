package com.pradipta.jms.sender;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class WeblogicJMSSender {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	
	public Properties getBundledJmsJndiProperties() throws IOException
	{
		InputStream is = null;
        Properties prop = new Properties();
        is = this.getClass().getResourceAsStream("jmsConfig.properties");
        prop.load(is);
        return prop;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws IOException {

		WeblogicJMSSender wlsJmsSender = new WeblogicJMSSender();
		InitialContext ctx = null;
		QueueConnectionFactory qcf = null;
		QueueConnection qc = null;
		QueueSession qsess = null;
		Queue q = null;
		QueueSender qsndr = null;
		TextMessage message = null;
		
		String QCF_NAME = null;
		String QUEUE_NAME = null;
		
		InputStream is = null;
        Properties prop = new Properties();
    	
        boolean propertyLoaded = false;
        
		if(args.length <= 0)
		{
			System.out.println("No jndi files passed as argument. Reading from internal config directory");
			System.out.println("To pass your own config file please use following format \n\t java -jar JMSClient <absolute_path_to_jndi_properties_file>");
			prop = wlsJmsSender.getBundledJmsJndiProperties();
			propertyLoaded = true;
		}
		else
		{
			File propertyFile = new File(args[0]);
			if(propertyFile.exists())
			{
				is = new FileInputStream(args[0]);
				prop.load(is);
				propertyLoaded = true;
			}
			else
			{
				System.out.println("Property file doesn't exist in the location provided ----->>>>> " + args[0]);
			}
		}
		
        if(propertyLoaded == true)
        {
        	Hashtable properties = new Hashtable();
    		properties.put(Context.INITIAL_CONTEXT_FACTORY, prop.getProperty("INITIAL_CONTEXT_FACTORY"));
    		properties.put(Context.PROVIDER_URL, prop.getProperty("PROVIDER_URL"));
    		properties.put(Context.SECURITY_PRINCIPAL, prop.getProperty("SECURITY_PRINCIPAL_USERNAME"));
    		properties.put(Context.SECURITY_CREDENTIALS, prop.getProperty("SECURITY_CREDENTIALS_PASSWORD"));
    		
    		QCF_NAME = prop.getProperty("QueueConnectionFactoryJNDI");
    		QUEUE_NAME = prop.getProperty("QueueJNDI");
    		
    		try {
    			ctx = new InitialContext(properties);
    		} catch (NamingException ne) {
    			ne.printStackTrace(System.err);
    			System.exit(0);
    		}
    		System.out.println("Got InitialContext " + ctx.toString());
    		// create QueueConnectionFactory
    		try {
    			qcf = (QueueConnectionFactory) ctx.lookup(QCF_NAME);
    		} catch (NamingException ne) {
    			ne.printStackTrace(System.err);
    			System.exit(0);
    		}
    		System.out.println("Got QueueConnectionFactory " + qcf.toString());
    		// create QueueConnection
    		try {
    			qc = qcf.createQueueConnection();
    		} catch (JMSException jmse) {
    			jmse.printStackTrace(System.err);
    			System.exit(0);
    		}
    		System.out.println("Got QueueConnection " + qc.toString());
    		// create QueueSession
    		try {
    			qsess = qc.createQueueSession(false, 0);
    		} catch (JMSException jmse) {
    			jmse.printStackTrace(System.err);
    			System.exit(0);
    		}
    		System.out.println("Got QueueSession " + qsess.toString());
    		// lookup Queue
    		try {
    			q = (Queue) ctx.lookup(QUEUE_NAME);
    		} catch (NamingException ne) {
    			ne.printStackTrace(System.err);
    			System.exit(0);
    		}
    		System.out.println("Got Queue " + q.toString());
    		// create QueueSender
    		try {
    			qsndr = (QueueSender) qsess.createSender(q);
    		} catch (JMSException jmse) {
    			jmse.printStackTrace(System.err);
    			System.exit(0);
    		}
    		System.out.println("Got QueueSender " + qsndr.toString());
    		// create TextMessage
    		try {
    			message = qsess.createTextMessage();
    		} catch (JMSException jmse) {
    			jmse.printStackTrace(System.err);
    			System.exit(0);
    		}
    		System.out.println("Got TextMessage " + message.toString());
    		// set message text in TextMessage
    		try {
    			message.setText(prop.getProperty("JMS_Message"));
    		} catch (JMSException jmse) {
    			jmse.printStackTrace(System.err);
    			System.exit(0);
    		}
    		System.out.println("Set text in TextMessage " + message.toString());
    		// send message
    		try {
    			qsndr.send(message);
    		} catch (JMSException jmse) {
    			jmse.printStackTrace(System.err);
    			System.exit(0);
    		}
    		System.out.println("Sent message ");
    		// clean up
    		try {
    			message = null;
    			qsndr.close();
    			qsndr = null;
    			q = null;
    			qsess.close();
    			qsess = null;
    			qc.close();
    			qc = null;
    			qcf = null;
    			ctx = null;
    		} catch (JMSException jmse) {
    			jmse.printStackTrace(System.err);
    		}
    		System.out.println("Cleaned up and done.");
        }
        else
        {
        	
        }
    }
}
