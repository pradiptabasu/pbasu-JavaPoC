
/**
 * HSFEntityWebServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:08:57 BST)
 */

    package com.hyperion.hsf.hsfwebservices;

    /**
     *  HSFEntityWebServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class HSFEntityWebServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public HSFEntityWebServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public HSFEntityWebServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for setScenarioInfo method
            * override this method for handling normal response from setScenarioInfo operation
            */
           public void receiveResultsetScenarioInfo(
                    com.hyperion.hsf.hsfwebservices.SetScenarioInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setScenarioInfo operation
           */
            public void receiveErrorsetScenarioInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enumAccounts method
            * override this method for handling normal response from enumAccounts operation
            */
           public void receiveResultenumAccounts(
                    com.hyperion.hsf.hsfwebservices.EnumAccountsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enumAccounts operation
           */
            public void receiveErrorenumAccounts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enumTimePeriods method
            * override this method for handling normal response from enumTimePeriods operation
            */
           public void receiveResultenumTimePeriods(
                    com.hyperion.hsf.hsfwebservices.EnumTimePeriodsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enumTimePeriods operation
           */
            public void receiveErrorenumTimePeriods(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enumCustomMembers method
            * override this method for handling normal response from enumCustomMembers operation
            */
           public void receiveResultenumCustomMembers(
                    com.hyperion.hsf.hsfwebservices.EnumCustomMembersResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enumCustomMembers operation
           */
            public void receiveErrorenumCustomMembers(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for closeEntity method
            * override this method for handling normal response from closeEntity operation
            */
           public void receiveResultcloseEntity(
                    com.hyperion.hsf.hsfwebservices.CloseEntityResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from closeEntity operation
           */
            public void receiveErrorcloseEntity(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getScenarioInfo method
            * override this method for handling normal response from getScenarioInfo operation
            */
           public void receiveResultgetScenarioInfo(
                    com.hyperion.hsf.hsfwebservices.GetScenarioInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getScenarioInfo operation
           */
            public void receiveErrorgetScenarioInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createEntity method
            * override this method for handling normal response from createEntity operation
            */
           public void receiveResultcreateEntity(
                    com.hyperion.hsf.hsfwebservices.CreateEntityResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createEntity operation
           */
            public void receiveErrorcreateEntity(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEntityDataCells method
            * override this method for handling normal response from getEntityDataCells operation
            */
           public void receiveResultgetEntityDataCells(
                    com.hyperion.hsf.hsfwebservices.GetEntityDataCellsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEntityDataCells operation
           */
            public void receiveErrorgetEntityDataCells(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for exportExtendedAnalytics method
            * override this method for handling normal response from exportExtendedAnalytics operation
            */
           public void receiveResultexportExtendedAnalytics(
                    com.hyperion.hsf.hsfwebservices.ExportExtendedAnalyticsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from exportExtendedAnalytics operation
           */
            public void receiveErrorexportExtendedAnalytics(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setEntityDataCells method
            * override this method for handling normal response from setEntityDataCells operation
            */
           public void receiveResultsetEntityDataCells(
                    com.hyperion.hsf.hsfwebservices.SetEntityDataCellsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setEntityDataCells operation
           */
            public void receiveErrorsetEntityDataCells(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enumScenarios method
            * override this method for handling normal response from enumScenarios operation
            */
           public void receiveResultenumScenarios(
                    com.hyperion.hsf.hsfwebservices.EnumScenariosResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enumScenarios operation
           */
            public void receiveErrorenumScenarios(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for calculate method
            * override this method for handling normal response from calculate operation
            */
           public void receiveResultcalculate(
                    com.hyperion.hsf.hsfwebservices.CalculateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from calculate operation
           */
            public void receiveErrorcalculate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for releaseEntityLock method
            * override this method for handling normal response from releaseEntityLock operation
            */
           public void receiveResultreleaseEntityLock(
                    com.hyperion.hsf.hsfwebservices.ReleaseEntityLockResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from releaseEntityLock operation
           */
            public void receiveErrorreleaseEntityLock(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enumCustomDimensions method
            * override this method for handling normal response from enumCustomDimensions operation
            */
           public void receiveResultenumCustomDimensions(
                    com.hyperion.hsf.hsfwebservices.EnumCustomDimensionsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enumCustomDimensions operation
           */
            public void receiveErrorenumCustomDimensions(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEntityLockInfo method
            * override this method for handling normal response from getEntityLockInfo operation
            */
           public void receiveResultgetEntityLockInfo(
                    com.hyperion.hsf.hsfwebservices.GetEntityLockInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEntityLockInfo operation
           */
            public void receiveErrorgetEntityLockInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enumMeasures method
            * override this method for handling normal response from enumMeasures operation
            */
           public void receiveResultenumMeasures(
                    com.hyperion.hsf.hsfwebservices.EnumMeasuresResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enumMeasures operation
           */
            public void receiveErrorenumMeasures(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for openEntity method
            * override this method for handling normal response from openEntity operation
            */
           public void receiveResultopenEntity(
                    com.hyperion.hsf.hsfwebservices.OpenEntityResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from openEntity operation
           */
            public void receiveErroropenEntity(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setForecastInfo method
            * override this method for handling normal response from setForecastInfo operation
            */
           public void receiveResultsetForecastInfo(
                    com.hyperion.hsf.hsfwebservices.SetForecastInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setForecastInfo operation
           */
            public void receiveErrorsetForecastInfo(java.lang.Exception e) {
            }
                


    }
    