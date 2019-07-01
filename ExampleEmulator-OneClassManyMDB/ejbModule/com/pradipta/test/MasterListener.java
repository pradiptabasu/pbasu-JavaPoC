package com.pradipta.test;

import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.lang3.StringUtils;

/**
 * Message-Driven Bean implementation class for: MasterListener
 */
@MessageDriven()
public class MasterListener implements MessageListener {

	@Resource(name="DESTINATION_JNDI") String destinationName;
	@Resource(name="CONNECTION_FACTORY_JNDI") String connetionFactoryName;  
	@Resource(name="XQUERY_SCRIPT") String xqueryUri;  
	
    /**
     * Default constructor. 
     */
    public MasterListener() {
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        TextMessage tmsg = (TextMessage) message;
        try {
			System.out.println(tmsg.getText());
			System.out.println("*********************************"+StringUtils.substringBetween(tmsg.getText(), ">", "</"));
			final InitialContext initialCtx = new InitialContext();
			
			//String destinationName = (String) initialCtx.lookup("java:comp/env/DESTINATION_JNDI");
			//String connetionFactoryName = (String) initialCtx.lookup("java:comp/env/CONNECTION_FACTORY_JNDI");
			//URI xqueryUri = new URI((String) initialCtx.lookup("java:comp/env/XQUERY_SCRIPT"));
			
			Destination reqDest = (Destination) initialCtx.lookup(destinationName);
			ConnectionFactory factory = (ConnectionFactory) initialCtx.lookup(connetionFactoryName);
			Connection connection = factory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(reqDest);
            connection.start();
	        producer.setPriority(message.getJMSPriority());
	        producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
    }

}
