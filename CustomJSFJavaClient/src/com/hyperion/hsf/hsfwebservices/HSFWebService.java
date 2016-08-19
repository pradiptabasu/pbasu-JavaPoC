

/**
 * HSFWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */

    package com.hyperion.hsf.hsfwebservices;

    /*
     *  HSFWebService java interface
     */

    public interface HSFWebService {
          

        /**
          * Auto generated method signature
          * 
                    * @param closeSession0
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.CloseSessionResponse closeSession(

                        com.hyperion.hsf.hsfwebservices.CloseSession closeSession0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param closeSession0
            
          */
        public void startcloseSession(

            com.hyperion.hsf.hsfwebservices.CloseSession closeSession0,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param closeDatabase2
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.CloseDatabaseResponse closeDatabase(

                        com.hyperion.hsf.hsfwebservices.CloseDatabase closeDatabase2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param closeDatabase2
            
          */
        public void startcloseDatabase(

            com.hyperion.hsf.hsfwebservices.CloseDatabase closeDatabase2,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param enumServers4
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.EnumServersResponse enumServers(

                        com.hyperion.hsf.hsfwebservices.EnumServers enumServers4)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param enumServers4
            
          */
        public void startenumServers(

            com.hyperion.hsf.hsfwebservices.EnumServers enumServers4,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param closeServer6
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.CloseServerResponse closeServer(

                        com.hyperion.hsf.hsfwebservices.CloseServer closeServer6)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param closeServer6
            
          */
        public void startcloseServer(

            com.hyperion.hsf.hsfwebservices.CloseServer closeServer6,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param closeAllEntities8
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.CloseAllEntitiesResponse closeAllEntities(

                        com.hyperion.hsf.hsfwebservices.CloseAllEntities closeAllEntities8)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param closeAllEntities8
            
          */
        public void startcloseAllEntities(

            com.hyperion.hsf.hsfwebservices.CloseAllEntities closeAllEntities8,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param openDatabase10
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.OpenDatabaseResponse openDatabase(

                        com.hyperion.hsf.hsfwebservices.OpenDatabase openDatabase10)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param openDatabase10
            
          */
        public void startopenDatabase(

            com.hyperion.hsf.hsfwebservices.OpenDatabase openDatabase10,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param enumOpenedEntities12
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.EnumOpenedEntitiesResponse enumOpenedEntities(

                        com.hyperion.hsf.hsfwebservices.EnumOpenedEntities enumOpenedEntities12)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param enumOpenedEntities12
            
          */
        public void startenumOpenedEntities(

            com.hyperion.hsf.hsfwebservices.EnumOpenedEntities enumOpenedEntities12,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param createSessionFromToken14
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.CreateSessionFromTokenResponse createSessionFromToken(

                        com.hyperion.hsf.hsfwebservices.CreateSessionFromToken createSessionFromToken14)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param createSessionFromToken14
            
          */
        public void startcreateSessionFromToken(

            com.hyperion.hsf.hsfwebservices.CreateSessionFromToken createSessionFromToken14,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param openServer16
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.OpenServerResponse openServer(

                        com.hyperion.hsf.hsfwebservices.OpenServer openServer16)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param openServer16
            
          */
        public void startopenServer(

            com.hyperion.hsf.hsfwebservices.OpenServer openServer16,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param enumEntities18
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.EnumEntitiesResponse enumEntities(

                        com.hyperion.hsf.hsfwebservices.EnumEntities enumEntities18)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param enumEntities18
            
          */
        public void startenumEntities(

            com.hyperion.hsf.hsfwebservices.EnumEntities enumEntities18,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param createSession20
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.CreateSessionResponse createSession(

                        com.hyperion.hsf.hsfwebservices.CreateSession createSession20)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param createSession20
            
          */
        public void startcreateSession(

            com.hyperion.hsf.hsfwebservices.CreateSession createSession20,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param enumDatabases22
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.EnumDatabasesResponse enumDatabases(

                        com.hyperion.hsf.hsfwebservices.EnumDatabases enumDatabases22)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param enumDatabases22
            
          */
        public void startenumDatabases(

            com.hyperion.hsf.hsfwebservices.EnumDatabases enumDatabases22,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getSessionInfo24
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.GetSessionInfoResponse getSessionInfo(

                        com.hyperion.hsf.hsfwebservices.GetSessionInfo getSessionInfo24)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getSessionInfo24
            
          */
        public void startgetSessionInfo(

            com.hyperion.hsf.hsfwebservices.GetSessionInfo getSessionInfo24,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param enumCubes26
                
         */

         
                     public com.hyperion.hsf.hsfwebservices.EnumCubesResponse enumCubes(

                        com.hyperion.hsf.hsfwebservices.EnumCubes enumCubes26)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param enumCubes26
            
          */
        public void startenumCubes(

            com.hyperion.hsf.hsfwebservices.EnumCubes enumCubes26,

            final com.hyperion.hsf.hsfwebservices.HSFWebServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    