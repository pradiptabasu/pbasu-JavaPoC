
/**
 * HSFWebServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */

    package com.hyperion.hsf.hsfwebservices;

    /**
     *  HSFWebServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class HSFWebServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public HSFWebServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public HSFWebServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for closeSession method
            * override this method for handling normal response from closeSession operation
            */
           public void receiveResultcloseSession(
                    com.hyperion.hsf.hsfwebservices.CloseSessionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from closeSession operation
           */
            public void receiveErrorcloseSession(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for closeDatabase method
            * override this method for handling normal response from closeDatabase operation
            */
           public void receiveResultcloseDatabase(
                    com.hyperion.hsf.hsfwebservices.CloseDatabaseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from closeDatabase operation
           */
            public void receiveErrorcloseDatabase(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enumServers method
            * override this method for handling normal response from enumServers operation
            */
           public void receiveResultenumServers(
                    com.hyperion.hsf.hsfwebservices.EnumServersResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enumServers operation
           */
            public void receiveErrorenumServers(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for closeServer method
            * override this method for handling normal response from closeServer operation
            */
           public void receiveResultcloseServer(
                    com.hyperion.hsf.hsfwebservices.CloseServerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from closeServer operation
           */
            public void receiveErrorcloseServer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for closeAllEntities method
            * override this method for handling normal response from closeAllEntities operation
            */
           public void receiveResultcloseAllEntities(
                    com.hyperion.hsf.hsfwebservices.CloseAllEntitiesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from closeAllEntities operation
           */
            public void receiveErrorcloseAllEntities(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for openDatabase method
            * override this method for handling normal response from openDatabase operation
            */
           public void receiveResultopenDatabase(
                    com.hyperion.hsf.hsfwebservices.OpenDatabaseResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from openDatabase operation
           */
            public void receiveErroropenDatabase(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enumOpenedEntities method
            * override this method for handling normal response from enumOpenedEntities operation
            */
           public void receiveResultenumOpenedEntities(
                    com.hyperion.hsf.hsfwebservices.EnumOpenedEntitiesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enumOpenedEntities operation
           */
            public void receiveErrorenumOpenedEntities(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createSessionFromToken method
            * override this method for handling normal response from createSessionFromToken operation
            */
           public void receiveResultcreateSessionFromToken(
                    com.hyperion.hsf.hsfwebservices.CreateSessionFromTokenResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createSessionFromToken operation
           */
            public void receiveErrorcreateSessionFromToken(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for openServer method
            * override this method for handling normal response from openServer operation
            */
           public void receiveResultopenServer(
                    com.hyperion.hsf.hsfwebservices.OpenServerResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from openServer operation
           */
            public void receiveErroropenServer(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enumEntities method
            * override this method for handling normal response from enumEntities operation
            */
           public void receiveResultenumEntities(
                    com.hyperion.hsf.hsfwebservices.EnumEntitiesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enumEntities operation
           */
            public void receiveErrorenumEntities(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createSession method
            * override this method for handling normal response from createSession operation
            */
           public void receiveResultcreateSession(
                    com.hyperion.hsf.hsfwebservices.CreateSessionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createSession operation
           */
            public void receiveErrorcreateSession(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enumDatabases method
            * override this method for handling normal response from enumDatabases operation
            */
           public void receiveResultenumDatabases(
                    com.hyperion.hsf.hsfwebservices.EnumDatabasesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enumDatabases operation
           */
            public void receiveErrorenumDatabases(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSessionInfo method
            * override this method for handling normal response from getSessionInfo operation
            */
           public void receiveResultgetSessionInfo(
                    com.hyperion.hsf.hsfwebservices.GetSessionInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSessionInfo operation
           */
            public void receiveErrorgetSessionInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enumCubes method
            * override this method for handling normal response from enumCubes operation
            */
           public void receiveResultenumCubes(
                    com.hyperion.hsf.hsfwebservices.EnumCubesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enumCubes operation
           */
            public void receiveErrorenumCubes(java.lang.Exception e) {
            }
                


    }
    