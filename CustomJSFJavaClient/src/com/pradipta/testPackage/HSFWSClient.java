package com.pradipta.testPackage;

import com.hyperion.hsf.hsfwebservices.*;

public class HSFWSClient 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try
		{
			String server = "HSFServer";
			String database = "Oil_n_Gas";
			String entity = "Oil_n_Gas";
			Boolean checkOut = false;
			
			HSFWebServiceStub hsfwsClient = new HSFWebServiceStub();
			HSFEntityWebServiceStub hsfentitywsClient = new HSFEntityWebServiceStub();
			
			CreateSession createSessionReq = new CreateSession();
			createSessionReq.setUserName("admin");
			createSessionReq.setPassword("Welcome1");
			CreateSessionResponse createSessionResp = hsfwsClient.createSession(createSessionReq);
			String sessionID = createSessionResp.getCreateSessionResult();
			System.out.println("Session ID : " + sessionID);
			
			OpenServer openServerReq = new OpenServer();
			openServerReq.setSessionID(sessionID);
			openServerReq.setServer(server);
			OpenServerResponse openServerResponse = hsfwsClient.openServer(openServerReq);
			System.out.println("server " + server + " opened");
			
			OpenDatabase openDatabaseReq = new OpenDatabase();
			openDatabaseReq.setSessionID(sessionID);
			openDatabaseReq.setDatabase(database);
			OpenDatabaseResponse openDatabaseResponse = hsfwsClient.openDatabase(openDatabaseReq);
			System.out.println("database " + database + " opened");
			
			OpenEntity openEntityReq = new OpenEntity();
			openEntityReq.setSessionID(sessionID);
			openEntityReq.setEntity(entity);
			openEntityReq.setCheckOut(checkOut);
			OpenEntityResponse openEntityResponse = hsfentitywsClient.openEntity(openEntityReq);
			System.out.println("entity " + entity + " opened");
			
			GetEntityDataCells getEntityDataCellsReq = new GetEntityDataCells();
			getEntityDataCellsReq.setSessionID(sessionID);
			DataCellLocators_type0 param = new DataCellLocators_type0();
			param.setSchema(param);
			param.setExtraElement(param);
			getEntityDataCellsReq.setDataCellLocators(param);
			GetEntityDataCellsResponse getEntityDataCellsResponse = hsfentitywsClient.getEntityDataCells(getEntityDataCellsReq);
			
		}
		catch(Exception e)
		{
			
		}
	}

}
