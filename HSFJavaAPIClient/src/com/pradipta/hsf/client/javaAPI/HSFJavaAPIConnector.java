package com.pradipta.hsf.client.javaAPI;

import com.hyperion.hsf.beans.ACM;
import com.hyperion.hsf.beans.Account;
import com.hyperion.hsf.beans.ECM;
import com.hyperion.hsf.common.DataCellInfo;
import com.hyperion.hsf.common.HSFUtils;
import com.hyperion.hsf.common.HttpReqResp;
import com.hyperion.hsf.common.Util;
import com.hyperion.hsf.excp.HSFException;
import com.hyperion.hsf.managers.DatabaseGatewayManager;
import com.hyperion.hsf.managers.EntityGatewayManager;
import com.hyperion.hsf.odl.HSFLogComponent;
import com.hyperion.hsf.odl.HSFODLLogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Vector;

public class HSFJavaAPIConnector
{
  private String hostName = "localhost";
  private String portNumber = "8900";
  private String sessionId = "";
  private String server = "";
  private String database = "";
  private String entity = "";
  private static final HSFODLLogger logger = HSFODLLogger.getLogger(HSFLogComponent.JAVAAPI);
  
  public HSFJavaAPIConnector(String hostName, String portNumber)
  {
    if ((hostName != null) && (!hostName.isEmpty())) {
      this.hostName = hostName;
    }
    if ((portNumber != null) && (!portNumber.isEmpty())) {
      this.portNumber = portNumber;
    }
  }
  
  private void setSessionId(String sessionId)
  {
    this.sessionId = sessionId;
  }
  
  private String getSessionId()
  {
    return this.sessionId;
  }
  
  private void setServer(String server)
  {
    this.server = server;
  }
  
  private void setDatabase(String database)
  {
    this.database = database;
  }
  
  private void setEntity(String entity)
  {
    this.entity = entity;
  }
  
  private boolean isSessionOpen()
  {
    return !this.sessionId.isEmpty();
  }
  
  private boolean isServerOpen()
  {
    return !this.server.isEmpty();
  }
  
  private boolean isDatabaseOpen()
  {
    return !this.database.isEmpty();
  }
  
  private boolean isEntityOpen()
  {
    return !this.entity.isEmpty();
  }
  
  public boolean Login(String userName, String password, String token)
    throws HSFException
  {
    logger.entering(new Object[] { userName, password, token });
    boolean retVal = false;
    try
    {
      if (isSessionOpen()) {
        Logout();
      }
      String request = "<req_Login><usr>" + userName + "</usr><pwd>" + password + "</pwd><token>";
      if (token != null) {
        request = request + token;
      }
      request = request + "</token></req_Login>";
      
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase("")))
      {
        String sId = Util.getNodeValue(response, "sID");
        if ((sId != null) && (!sId.equalsIgnoreCase("")))
        {
          setSessionId(sId);
          retVal = true;
        }
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in Login() : " + e, new Object[0]);
      throw new HSFException("Login: " + e.toString());
    }
    logger.exiting();
    return retVal;
  }
  
  public boolean Logout()
    throws HSFException
  {
    logger.entering(new Object[0]);
    boolean retVal = false;
    try
    {
      if (isSessionOpen())
      {
        if (isDatabaseOpen()) {
          CloseDatabase();
        }
        if (isServerOpen()) {
          CloseServer();
        }
        String request = "<req_Logout><sID>" + this.sessionId + "</sID></req_Logout>";
        String response = SendRequest(request);
        if ((response != null) && (!response.equalsIgnoreCase("")))
        {
          String status = Util.getNodeValue(response, "result");
          if ((status != null) && (status.equalsIgnoreCase("success")))
          {
            setSessionId("");
            retVal = true;
          }
        }
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in Logout() : " + e, new Object[0]);
      throw new HSFException("Logout: " + e.toString());
    }
    logger.exiting();
    return retVal;
  }
  
  public Vector<String> EnumerateServers()
    throws HSFException
  {
    logger.entering(new Object[0]);
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    String request = "<req_EnumServers><sID>" + this.sessionId + "</sID></req_EnumServers>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.extractListFromString(response, "srvs");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in EnumerateServers() : " + e, new Object[0]);
      throw new HSFException("EnumerateServers: " + e.toString());
    }
    logger.exiting();
    return null;
  }
  
  public boolean OpenServer(String server)
    throws HSFException
  {
    logger.entering(new Object[] { server });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (isServerOpen()) {
      CloseServer();
    }
    boolean retVal = false;
    String request = "<req_OpenServer><sID>" + this.sessionId + "</sID><server>" + server + "</server></req_OpenServer>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase("")))
      {
        String status = Util.getNodeValue(response, "result");
        if ((status != null) && (status.equalsIgnoreCase("success")))
        {
          setServer(server);
          retVal = true;
        }
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in OpenServer() : " + e, new Object[0]);
      throw new HSFException("OpenServer: " + e.toString());
    }
    logger.exiting();
    return retVal;
  }
  
  public boolean CloseServer()
    throws HSFException
  {
    logger.entering(new Object[0]);
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      return true;
    }
    if (isDatabaseOpen()) {
      CloseDatabase();
    }
    boolean retVal = false;
    String request = "<req_CloseServer><sID>" + this.sessionId + "</sID><server>" + this.server + "</server></req_CloseServer>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase("")))
      {
        String status = Util.getNodeValue(response, "result");
        if ((status != null) && (status.equalsIgnoreCase("success")))
        {
          setServer("");
          retVal = true;
        }
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in CloseServer() : " + e, new Object[0]);
      throw new HSFException("CloseServer: " + e.toString());
    }
    logger.exiting();
    return retVal;
  }
  
  public Vector<String> EnumerateDatabases()
    throws HSFException
  {
    logger.entering(new Object[0]);
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    String request = "<req_EnumDatabases><sID>" + this.sessionId + "</sID></req_EnumDatabases>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.extractListFromString(response, "dbs");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in EnumerateDatabases() : " + e, new Object[0]);
      throw new HSFException("EnumerateDatabases: " + e.toString());
    }
    logger.exiting();
    return null;
  }
  
  public boolean OpenDatabase(String database)
    throws HSFException
  {
    logger.entering(new Object[] { database });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      CloseDatabase();
    }
    boolean retVal = false;
    String request = "<req_OpenDatabase><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + database + "</database></req_OpenDatabase>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase("")))
      {
        String status = Util.getNodeValue(response, "result");
        if ((status != null) && (status.equalsIgnoreCase("success")))
        {
          setDatabase(database);
          retVal = true;
        }
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in OpenDatabase() : " + e, new Object[0]);
      throw new HSFException("OpenDatabase: " + e.toString());
    }
    logger.exiting();
    return retVal;
  }
  
  public boolean CloseDatabase()
    throws HSFException
  {
    logger.entering(new Object[0]);
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      return true;
    }
    boolean retVal = false;
    String request = "<req_CloseDatabase><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database></req_CloseDatabase>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase("")))
      {
        String status = Util.getNodeValue(response, "result");
        if ((status != null) && (status.equalsIgnoreCase("success")))
        {
          setDatabase("");
          retVal = true;
        }
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in CloseDatabase() : " + e, new Object[0]);
      throw new HSFException("CloseDatabase: " + e.toString());
    }
    logger.exiting();
    return retVal;
  }
  
  public Vector<String> EnumerateEntities(String parent, String action)
    throws HSFException
  {
    logger.entering(new Object[] { parent, action });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_EnumEntities><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + parent + "</entity><action>" + action + "</action></req_EnumEntities>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.extractListFromString(response, "entities");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in EnumerateEntities() : " + e, new Object[0]);
      throw new HSFException("EnumerateEntities: " + e.toString());
    }
    logger.exiting();
    return null;
  }
  
  public boolean OpenEntity(String entity, Boolean checkOut)
    throws HSFException
  {
    logger.entering(new Object[] { entity, checkOut });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    boolean retVal = false;
    String request = "<req_OpenEntity><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + entity + "</entity><checkOut>" + checkOut.toString() + "</checkOut></req_OpenEntity>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase("")))
      {
        String status = Util.getNodeValue(response, "result");
        if ((status != null) && (status.equalsIgnoreCase("success")))
        {
          setEntity(entity);
          retVal = true;
        }
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in OpenEntity() : " + e, new Object[0]);
      throw new HSFException("OpenEntity: " + e.toString());
    }
    logger.exiting();
    return retVal;
  }
  
  public boolean CloseEntity(String entity, Boolean checkIn, Boolean releaseLock)
    throws HSFException
  {
    logger.entering(new Object[] { entity, checkIn, releaseLock });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    if (!isEntityOpen()) {
      return true;
    }
    boolean retVal = false;
    String request = "<req_CloseEntity><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + entity + "</entity><checkIn>" + checkIn.toString() + "</checkIn><releaseLock>" + releaseLock.toString() + "</releaseLock></req_CloseEntity>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase("")))
      {
        String status = Util.getNodeValue(response, "result");
        if ((status != null) && (status.equalsIgnoreCase("success")))
        {
          setEntity("");
          retVal = true;
        }
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in CloseEntity() : " + e, new Object[0]);
      throw new HSFException("CloseEntity: " + e.toString());
    }
    logger.exiting();
    return retVal;
  }
  
  public Vector<Account> EnumerateAccounts(String entity)
    throws HSFException
  {
    logger.entering(new Object[] { entity });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_EnumAccounts><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + entity + "</entity></req_EnumAccounts>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
    	   writeToFile("EnumerateAccounts",response);
    	   writeToFile("EnumerateAccountsDecoded",HSFUtils.xmlDecode(response));
        return EntityGatewayManager.accountsFromXML(HSFUtils.xmlDecode(response));
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in EnumerateAccounts() : " + e, new Object[0]);
      throw new HSFException("EnumerateAccounts: " + e.toString());
    }
    logger.exiting();
    return null;
  }
  
  public Vector<String> EnumerateScenarios(String entity)
    throws HSFException
  {
    logger.entering(new Object[] { entity });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_EnumScenarios><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + entity + "</entity></req_EnumScenarios>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.extractListFromString(response, "scenarios");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in EnumerateScenarios() : " + e, new Object[0]);
      throw new HSFException("EnumerateScenarios: " + e.toString());
    }
    logger.exiting();
    return null;
  }
  
  public Vector<String> EnumerateTimePeriods(String entity)
    throws HSFException
  {
    logger.entering(new Object[] { entity });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_EnumTimePeriods><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + entity + "</entity></req_EnumTimePeriods>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.extractListFromString(response, "timePeriods");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in EnumerateTimePeriods() : " + e, new Object[0]);
      throw new HSFException("EnumerateTimePeriods: " + e.toString());
    }
    logger.exiting();
    return null;
  }
  
  public Vector<String> EnumerateCustomDimensions(String entity)
    throws HSFException
  {
    logger.entering(new Object[] { entity });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_EnumCustomDimensions><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + entity + "</entity></req_EnumCustomDimensions>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.extractListFromString(response, "CustomDimensions");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in EnumerateCustomDimensions() : " + e, new Object[0]);
      throw new HSFException("EnumerateCustomDimensions: " + e.toString());
    }
    logger.exiting();
    return null;
  }
  
  public Vector<String> EnumerateCustomMembers(String dimension)
    throws HSFException
  {
    logger.entering(new Object[] { dimension });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    if (!isEntityOpen()) {
      throw new HSFException("No entity opened");
    }
    String request = "<req_EnumCustomMembers><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + this.entity + "</entity><dimension>" + dimension + "</dimension></req_EnumCustomMembers>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.extractListFromString(response, "CustomMembers");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in EnumerateCustomMembers() : " + e, new Object[0]);
      throw new HSFException("EnumerateCustomMembers: " + e.toString());
    }
    logger.exiting();
    return null;
  }
  
  public String GetEntityLockInfo(String entity)
    throws HSFException
  {
    logger.entering(new Object[] { entity });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_GetEntityLockInfo><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + entity + "</entity></req_GetEntityLockInfo>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.getNodeValue(response, "lockInfo");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in GetEntityLockInfo() : " + e, new Object[0]);
      throw new HSFException("GetEntityLockInfo: " + e.toString());
    }
    logger.exiting();
    return "";
  }
  
  public String GetEntityDataCells(String entity, String account, String time, String scenario, String measure)
    throws HSFException
  {
    logger.entering(new Object[] { entity, account, time, scenario, measure });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_GetEntityDataCells><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + entity + "</entity><account>" + account + "</account><time>" + time + "</time>" + "<scenario>" + scenario + "</scenario><measure>" + measure + "</measure></req_GetEntityDataCells>";
    System.out.println(request);
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.getNodeValue(response, "value");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in SetEntityDataCells() : " + e, new Object[0]);
      throw new HSFException("SetEntityDataCells: " + e.toString());
    }
    logger.exiting();
    return "";
  }
  
  
  public String GetEntityDataCellsMultiple(String entity, String account, String time, String scenario, String measure)
		    throws HSFException
		  {
		    logger.entering(new Object[] { entity, account, time, scenario, measure });
		    if (!isSessionOpen()) {
		      throw new HSFException("Invalid session");
		    }
		    if (!isServerOpen()) {
		      throw new HSFException("No server opened");
		    }
		    if (!isDatabaseOpen()) {
		      throw new HSFException("No database opened");
		    }
		    //String request = "<req_GetEntityDataCells><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + entity + "</entity><account>" + account + "</account><time>" + time + "</time>" + "<scenario>" + scenario + "</scenario><measure>" + measure + "</measure></req_GetEntityDataCells>";
		    String request = "<req_GetEntityDataCells><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + entity + "</entity><account>" + account + "</account><time>" + time + "</time></req_GetEntityDataCells>";
		    try
		    {
		      String response = SendRequest(request);
		      if ((response != null) && (!response.equalsIgnoreCase(""))) {
		    	  writeToFile("GetEntityDataCellsMultipleMeasure",response);
		    	  //writeToFile("EnumerateAccountsDecoded",HSFUtils.xmlDecode(response)); 
		        //return Util.getNodeValue(response, "value");
		      }
		    }
		    catch (Exception e)
		    {
		      logger.fine("Exception in SetEntityDataCells() : " + e, new Object[0]);
		      throw new HSFException("SetEntityDataCells: " + e.toString());
		    }
		    logger.exiting();
		    return "";
		  }
  
  
  
  public boolean SetEntityDataCells(String entity, DataCellInfo[] dataCellArr)
    throws HSFException
  {
    logger.entering(new Object[] { entity });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    boolean retVal = false;
    String request = getRequest(entity, dataCellArr);
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase("")))
      {
        String status = Util.getNodeValue(response, "result");
        if ((status != null) && (status.equalsIgnoreCase("success"))) {
          retVal = true;
        }
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in SetEntityDataCells() : " + e, new Object[0]);
      throw new HSFException("SetEntityDataCells: " + e.toString());
    }
    logger.exiting();
    return retVal;
  }
  
  public Vector<String> EnumerateConsolidations()
    throws HSFException
  {
    logger.entering(new Object[0]);
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_EnumConsolidations><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database></req_EnumConsolidations>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.extractListFromString(response, "consolidations");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in EnumerateConsolidations() : " + e, new Object[0]);
      throw new HSFException("EnumerateConsolidations: " + e.toString());
    }
    logger.exiting();
    return null;
  }
  
  public String RunConsolidation(String consName, String parent, String scenario)
    throws HSFException
  {
    logger.entering(new Object[] { consName, parent, scenario });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_RunConsolidation><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<consName>" + consName + "</consName><parent>" + parent + "</parent><scenario>" + scenario + "</scenario></req_RunConsolidation>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.getNodeValue(response, "transactionID");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in RunConsolidation() : " + e, new Object[0]);
      throw new HSFException("RunConsolidation: " + e.toString());
    }
    logger.exiting();
    return "";
  }
  
  public String GetTransactionStatus(String transactionID)
    throws HSFException
  {
    logger.entering(new Object[] { transactionID });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_GetTransactionStatus><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<transactionID>" + transactionID + "</transactionID></req_GetTransactionStatus>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.getNodeValue(response, "status");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in GetTransactionStatus() : " + e, new Object[0]);
      throw new HSFException("GetTransactionStatus: " + e.toString());
    }
    logger.exiting();
    return "";
  }
  
  public Vector<ECM> EnumerateECMs()
    throws HSFException
  {
    logger.entering(new Object[0]);
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_EnumerateECMs><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database></req_EnumerateECMs>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return DatabaseGatewayManager.ecmsFromXML(Util.getNodeValue(response, "ecmData"));
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in EnumerateECMs() : " + e, new Object[0]);
      throw new HSFException("EnumerateECMs: " + e.toString());
    }
    logger.exiting();
    return null;
  }
  
  public Vector<ACM> EnumerateACMs()
    throws HSFException
  {
    logger.entering(new Object[0]);
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_EnumerateACMs><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database></req_EnumerateACMs>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return DatabaseGatewayManager.acmsFromXML(Util.getNodeValue(response, "acmData"));
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in EnumerateACMs() : " + e, new Object[0]);
      throw new HSFException("EnumerateACMs: " + e.toString());
    }
    logger.exiting();
    return null;
  }
  
  public String RunECM(String ecmName)
    throws HSFException
  {
    logger.entering(new Object[] { ecmName });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_RunECM><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<ecmName>" + ecmName + "</ecmName></req_RunECM>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.getNodeValue(response, "transactionID");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in RunECM() : " + e, new Object[0]);
      throw new HSFException("RunECM: " + e.toString());
    }
    logger.exiting();
    return "";
  }
  
  public String RunACM(String acmName)
    throws HSFException
  {
    logger.entering(new Object[] { acmName });
    if (!isSessionOpen()) {
      throw new HSFException("Invalid session");
    }
    if (!isServerOpen()) {
      throw new HSFException("No server opened");
    }
    if (!isDatabaseOpen()) {
      throw new HSFException("No database opened");
    }
    String request = "<req_RunACM><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<acmName>" + acmName + "</acmName></req_RunACM>";
    try
    {
      String response = SendRequest(request);
      if ((response != null) && (!response.equalsIgnoreCase(""))) {
        return Util.getNodeValue(response, "transactionID");
      }
    }
    catch (Exception e)
    {
      logger.fine("Exception in RunACM() : " + e, new Object[0]);
      throw new HSFException("RunACM: " + e.toString());
    }
    logger.exiting();
    return "";
  }
  
  private String SendRequest(String request)
  {
    String response = null;
    try
    {
      logger.finest("Sending request : {0}", new Object[] { request });
      HttpReqResp httpReq = new HttpReqResp();
      //System.out.println("JavaAPI URL: " + getJavaAPIUrl());
      response = httpReq.sendRequest(getJavaAPIUrl(), null, null, request);
      logger.finest("Received response : {0}", new Object[] { response });
    }
    catch (Exception e)
    {
      logger.fine("Exception while trying to send HTTP request: " + e, new Object[0]);
    }
    return response;
  }
  
  private String getJavaAPIUrl()
  {
    String url = "http://";
    url = url + this.hostName + ":" + this.portNumber;
    url = url + "/StrategicPlanning/JavaAPI";
    return url;
  }
  
  private String getRequest(String entity, DataCellInfo[] dataCellArr)
  {
    String request = "<req_SetEntityDataCells><sID>" + this.sessionId + "</sID><server>" + this.server + "</server><database>" + this.database + "</database>" + "<entity>" + entity + "</entity><DataCells>";
    for (int i = 0; i < dataCellArr.length; i++)
    {
      request = request + "<DataCell account=\"" + dataCellArr[i].account + "\" ";
      request = request + "time=\"" + dataCellArr[i].time + "\" ";
      request = request + "scenario=\"" + dataCellArr[i].scenario + "\" ";
      request = request + "measure=\"" + dataCellArr[i].measure + "\" ";
      request = request + "value=\"" + dataCellArr[i].value + "\" />";
    }
    request = request + "</DataCells></req_SetEntityDataCells>";
    System.out.println("multiRow Req : " + request);
    return request;
  }

  public void writeToFile(String fileName, String content)
	{
		try
		{
			File file = new File("D:\\WorkSpace\\EclipseLuna_Hyperion_HSF\\HSFJavaAPIClient\\"+ fileName +".xml");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
