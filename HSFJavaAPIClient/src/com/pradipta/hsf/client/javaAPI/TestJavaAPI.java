package com.pradipta.hsf.client.javaAPI;

import com.hyperion.hsf.beans.ACM;
import com.hyperion.hsf.beans.Account;
import com.hyperion.hsf.beans.ECM;
//import com.hyperion.hsf.client.javaAPI.HSFJavaAPIConnector;
import com.hyperion.hsf.common.DataCellInfo;
import com.hyperion.hsf.excp.HSFException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Vector;

@SuppressWarnings("unused")
public class TestJavaAPI
{
	static Vector<String> servers = null;
	static Vector<String> databases = null;
	static Vector<String> entities = null;

	public static void main(String[] args)
	{
		String hostName = "";
		String portNumber = "";
		String userName = "";
		String password = "";
		if ((args == null) || (args.length == 0))
		{
			//below sections commented to add the lines after return inside this if block
			/*
			System.out.println("This is a sample program which tests HSF Java APIs");
			System.out.println("\nUsage : \n");
			System.out.println("HSFJavaAPISample [/H:hostName] [/P:portNumber] [/U:userName] [/F:password]");
			System.out.println("Where....");
			System.out.println("    /H:hostName    Specifies the name or IP address of the host machine running HSF Web App. If not specified \"localhost\" is used.");
			System.out.println("    /P:portNumber  Specifies the port number on which HSF Web App is listening.If not specified \"8900\" is used.");
			System.out.println("    /U:userName    A User name to login.If not specified \"admin\" is used.");
			System.out.println("    /F:password    User Password.If not specified \"password\" is used.");
			System.out.println("    *              Any other key will use default values for all parameters.");
			return;
			*/
			hostName = "oa8050.us.oracle.com";
			portNumber = "12000";
			userName = "admin";
			password = "Welcome1";
		}
		for (int i = 0; i < args.length; i++)
		{
			String arg = args[i];
			if (arg != null) {
				if (arg.regionMatches(true, 0, "/H:", 0, 3))
				{
					hostName = arg.substring(3);
					if ((hostName == null) || (hostName.trim().length() == 0)) {
						System.out.println("A host name must be specified with the /H: switch.");
					}
				}
				else if (arg.regionMatches(true, 0, "/P:", 0, 3))
				{
					portNumber = arg.substring(3);
					if ((portNumber == null) || (portNumber.trim().length() == 0)) {
						System.out.println("A port number must be specified with the /P: switch.");
					}
				}
				else if (arg.regionMatches(true, 0, "/U:", 0, 3))
				{
					userName = arg.substring(3);
					if ((userName == null) || (userName.trim().length() == 0)) {
						System.out.println("A user name must be specified with the /U: switch.");
					}
				}
				else if (arg.regionMatches(true, 0, "/F:", 0, 3))
				{
					password = arg.substring(3);
					if ((password == null) || (password.trim().length() == 0))
					{
						System.out.println("A password must be specified with the /F: switch.");
						return;
					}
				}
			}
		}
		if (hostName.isEmpty()) {
			hostName = "localhost";
		}
		if (portNumber.isEmpty()) {
			portNumber = "8900";
		}
		if (userName.isEmpty()) {
			userName = "admin";
		}
		if (password.isEmpty()) {
			password = "password";
		}
		TestJavaAPI javaAPI = new TestJavaAPI();
		System.out.println("Running HSF Java APIs using the following parameters...");
		System.out.println("Host Name = " + hostName);
		System.out.println("Port Number = " + portNumber);
		System.out.println("User Name = " + userName);
		System.out.println("Password = " + password);
		javaAPI.Run(hostName, portNumber, userName, password);
	}
	
	public void Run(String hostName, String portNumber, String userName, String password)
	{
		boolean loggedIn = true;
		HSFJavaAPIConnector connector = new HSFJavaAPIConnector(hostName, portNumber);
		try
		{
			System.out.println("Calling Login().....");
			if (connector.Login(userName, password, ""))
			{
				System.out.println("Login Succeeded");
			}
			else
			{
				System.out.println("Login Failed");
				loggedIn = false;
				return;
			}
			System.out.println("Calling EnumerateServers()......");
			servers = connector.EnumerateServers();
			if ((servers != null) && (servers.size() > 0))
			{
				System.out.println("EnumerateServers returned " + servers.size() + " server(s)");
				for (String svr : servers) {
					System.out.println("\t" + svr);
				}
				System.out.println("Calling OpenServer() on " + (String)servers.get(0));
				if (connector.OpenServer((String)servers.get(0))) {
					System.out.println("OpenServer Succeeded");
				} else {
					System.out.println("OpenServer Failed");
				}
			}
			else
			{
				System.out.println("There are no HSF servers created on the target machine.");
				return;
			}
			System.out.println("Calling EnumerateDatabases()......");
			databases = connector.EnumerateDatabases();
			if ((databases != null) && (databases.size() > 0))
			{
				System.out.println("EnumerateDatabases returned " + databases.size() + " database(s)");

				int index = -1;
				for (int i = 0; i < databases.size(); i++)
				{
					System.out.println("\t" + (String)databases.get(i));
					if (((String)databases.get(i)).equalsIgnoreCase("Uptime")) {
						index = i;
					}
				}
				if (index == -1) {
					index = 0;
				}
				System.out.println("Calling OpenDatabase() on " + (String)databases.get(index));
				if (connector.OpenDatabase((String)databases.get(index)))
				{
					System.out.println("OpenDatabase Succeeded");
				}
				else
				{
					System.out.println("OpenDatabase Failed");
					return;
				}
			}
			else
			{
				System.out.println("There are no databases created.");
				return;
			}
			System.out.println("Calling EnumerateEntities()......");
			entities = connector.EnumerateEntities("", "children");
			if ((entities != null) && (entities.size() > 0))
			{
				System.out.println("EnumerateEntities returned " + entities.size() + " entity(s)");
				for (String entity : entities) {
					System.out.println("\t" + entity);
				}
				System.out.println("Calling OpenEntity() on " + (String)entities.get(0));
				if (connector.OpenEntity((String)entities.get(0), Boolean.valueOf(true))) {
					System.out.println("OpenEntity Succeeded");
				} else {
					System.out.println("OpenEntity Failed");
				}
			}
			else
			{
				System.out.println("There are no entities under this database.");
				return;
			}
			System.out.println("Calling EnumerateAccounts()......");
			
			
			
//			Vector<Account> accounts = connector.EnumerateAccounts((String)entities.get(0));
//			if ((accounts != null) && (accounts.size() > 0))
//			{
//				System.out.println("EnumerateAccounts returned " + accounts.size() + " accounts");
//				System.out.println("You need to navigate through each vector to print account details.");
//			}
//			else
//			{
//				System.out.println("There are no Accounts under " + (String)entities.get(0));
//			}
			System.out.println("Calling EnumerateScenarios()......");
			Vector<String> scenarios = connector.EnumerateScenarios((String)entities.get(0));
			if ((scenarios != null) && (scenarios.size() > 0))
			{
				System.out.println("EnumerateScenarios returned " + scenarios.size() + " Scenarios");
				for (String scn : scenarios) {
					System.out.println("\t" + scn);
				}
			}
			else
			{
				System.out.println("There are no Scenarios under " + (String)entities.get(0));
			}
			System.out.println("Calling EnumerateTimePeriods()......");
			Vector<String> timePeriods = connector.EnumerateTimePeriods((String)entities.get(0));
			if ((timePeriods != null) && (timePeriods.size() > 0))
			{
				System.out.println("EnumerateTimePeriods returned " + timePeriods.size() + " Time Periods");
				for (String tp : timePeriods) {
					System.out.println("\t" + tp);
				}
			}
			else
			{
				System.out.println("There are no Time Periods under " + (String)entities.get(0));
			}
			System.out.println("Calling EnumerateCustomDimenions()......");
			Vector<String> custDimenions = connector.EnumerateCustomDimensions((String)entities.get(0));
			if ((custDimenions != null) && (custDimenions.size() > 0))
			{
				System.out.println("EnumerateCustomDimenions returned " + custDimenions.size() + " Custom Dimenions");
				for (String custDim : custDimenions) {
					System.out.println("\t" + custDim);
				}
				System.out.println("Calling EnumerateCustomMembers() on " + (String)custDimenions.get(0));
				Vector<String> custMbrs = connector.EnumerateCustomMembers((String)custDimenions.get(0));
				if ((custMbrs != null) && (custMbrs.size() > 0))
				{
					System.out.println("EnumerateCustomMembers returned " + custMbrs.size() + " Custom Members");
					for (String custMbr : custMbrs) {
						System.out.println("\t" + custMbr);
					}
				}
				else
				{
					System.out.println("There are no custom members for " + (String)custDimenions.get(0));
				}
			}
			else
			{
				System.out.println("There are no custom dimensions for " + (String)entities.get(0));
			}
			System.out.println("Calling GetEntityLockInfo() on " + (String)entities.get(0));
			String lockInfo = connector.GetEntityLockInfo((String)entities.get(0));
			if (!lockInfo.isEmpty()) {
				System.out.println("GetEntityLockInfo returned " + lockInfo);
			}
			System.out.println("Calling GetEntityDataCells()......");
			String account = "100.00.000";
			//String time = "2010";
			String time = "All";
			String scenario = "Crude High";
			String measure = "Output";
			String value = connector.GetEntityDataCells("Oil_n_Gas", account, time, scenario, measure);
			connector.GetEntityDataCellsMultiple("Oil_n_Gas", account, time, scenario, measure);
			if (!value.isEmpty()) {
				System.out.println("GetEntityDataCells for \n\tAccount = " + account + "\n\tTime = " + time + "\n\tScenario = " + scenario + "\n\tmeasure = " + measure + " is " + value);
			}
			else
			{
				System.out.println("GetEntityDataCells is empty");
			}
			value = "112";
			DataCellInfo[] dataCellArr = new DataCellInfo[4];
			dataCellArr[0] = new DataCellInfo("100.00.000", "2020", "Crude High", "Output", value);
			dataCellArr[1] = new DataCellInfo("315.00.000", "2007", "Base", "Input", "113000000.000000");
			dataCellArr[2] = new DataCellInfo("320.00.000", "2007", "Base", "Input", "114000000.000000");
			dataCellArr[3] = new DataCellInfo("325.00.000", "2007", "Base", "Input", "115000000.000000");

			System.out.println("Calling SetEntityDataCells().....");
			if (connector.SetEntityDataCells((String)entities.get(0), dataCellArr)) {
				System.out.println("SetEntityDataCells Succeeded");
			} else {
				System.out.println("SetEntityDataCells Failed");
			}
			System.out.println("Verifying the value set by SetEntityDataCells....");
			String newValue = connector.GetEntityDataCells((String)entities.get(0), account, time, scenario, measure);
			if ((!newValue.isEmpty()) && (newValue.equalsIgnoreCase(value))) {
				System.out.println("Verification Successful.");
			} else {
				System.out.println("Verification Failed.");
			}
			value = connector.GetEntityDataCells((String)entities.get(0), "315.00.000", time, scenario, measure);
			if (!value.isEmpty()) {
				System.out.println("GetEntityDataCells for Account 315.00.000 = " + value);
			}
			value = connector.GetEntityDataCells((String)entities.get(0), "320.00.000", time, scenario, measure);
			if (!value.isEmpty()) {
				System.out.println("GetEntityDataCells for Account 320.00.000 = " + value);
			}
			value = connector.GetEntityDataCells((String)entities.get(0), "325.00.000", time, scenario, measure);
			if (!value.isEmpty()) {
				System.out.println("GetEntityDataCells for Account 325.00.000 = " + value);
			}
			System.out.println("Calling CloseEntity()......");
			if (connector.CloseEntity((String)entities.get(0), Boolean.valueOf(true), Boolean.valueOf(true))) {
				System.out.println("CloseEntity Succeeded");
			} else {
				System.out.println("CloseEntity Failed");
			}
			System.out.println("Calling EnumerateConsolidations()......");
			Vector<String> consolidations = connector.EnumerateConsolidations();
			if ((consolidations != null) && (consolidations.size() > 0))
			{
				System.out.println("EnumerateConsolidations returned " + consolidations.size() + " consolidation(s)");
				for (String consol : consolidations) {
					System.out.println("\t" + consol);
				}
				System.out.println("Calling RunConsolidation() on " + (String)consolidations.get(0));
				String transactionId = connector.RunConsolidation((String)consolidations.get(0), "Entity1", "Base");
				if (!transactionId.isEmpty())
				{
					System.out.println("RunConsolidation returned transaction ID = " + transactionId);
					String status = "";
					do
					{
						System.out.println("Calling GetTransactionStatus()......");
						status = connector.GetTransactionStatus(transactionId);
						if (!status.isEmpty()) {
							System.out.println("GetTransactionStatus returned " + status);
						}
					} while (!status.equalsIgnoreCase("Finished"));
				}
			}
			else
			{
				System.out.println("There are no consolidation structures created.");
			}
			System.out.println("Calling EnumerateECMs()......");
			Vector<ECM> ecms = connector.EnumerateECMs();
			if ((ecms != null) && (ecms.size() > 0))
			{
				System.out.println("EnumerateECMs returned " + ecms.size() + " ECM(s)");
				for (ECM ecm : ecms) {
					System.out.println(ecm.toString());
				}
				System.out.println("Calling RunECM() on " + ((ECM)ecms.get(0)).getName());
				String transId = connector.RunECM(((ECM)ecms.get(0)).getName());
				if (!transId.isEmpty())
				{
					System.out.println("RunECM returned transaction ID = " + transId);
					String status = "";
					do
					{
						System.out.println("Calling GetTransactionStatus()......");
						status = connector.GetTransactionStatus(transId);
						if (!status.isEmpty()) {
							System.out.println("GetTransactionStatus returned " + status);
						}
					} while (!status.equalsIgnoreCase("Finished"));
				}
				else
				{
					System.out.println("RunECM Failed.");
				}
			}
			else
			{
				System.out.println("There are no ECMs created.");
			}
			System.out.println("Calling EnumerateACMs()......");
			Vector<ACM> acms = connector.EnumerateACMs();
			if ((acms != null) && (acms.size() > 0))
			{
				System.out.println("EnumerateACMs returned " + acms.size() + " ACM(s)");
				for (ACM acm : acms) {
					System.out.println(acm.toString());
				}
				System.out.println("Calling RunACM() on " + ((ACM)acms.get(0)).getName());
				String transId = connector.RunACM(((ACM)acms.get(0)).getName());
				if (!transId.isEmpty())
				{
					System.out.println("RunACM returned transaction ID = " + transId);
					String status = "";
					do
					{
						System.out.println("Calling GetTransactionStatus()......");
						status = connector.GetTransactionStatus(transId);
						if (!status.isEmpty()) {
							System.out.println("GetTransactionStatus returned " + status);
						}
					} while (!status.equalsIgnoreCase("Finished"));
				}
				else
				{
					System.out.println("RunACM Failed.");
				}
			}
			else
			{
				System.out.println("There are no ACMs created.");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (loggedIn)
			{
				System.out.println("Calling Logout().........");
				try
				{
					if (connector.Logout()) {
						System.out.println("Logout Succeeded");
					} else {
						System.out.println("Logout Failed");
					}
				}
				catch (Exception e) {}
			}
		}
	}

}
