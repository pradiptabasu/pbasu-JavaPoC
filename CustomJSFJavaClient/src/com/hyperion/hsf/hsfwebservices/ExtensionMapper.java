
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.3  Built on : May 30, 2016 (04:09:26 BST)
 */

        
            package com.hyperion.hsf.hsfwebservices;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://hyperion.com/hsf/hsfwebservices/".equals(namespaceURI) &&
                  "EnumOpenedEntitiesResult_type0".equals(typeName)){
                   
                            return  com.hyperion.hsf.hsfwebservices.EnumOpenedEntitiesResult_type0.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://hyperion.com/hsf/hsfwebservices/".equals(namespaceURI) &&
                  "ArrayOfString".equals(typeName)){
                   
                            return  com.hyperion.hsf.hsfwebservices.ArrayOfString.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://hyperion.com/hsf/hsfwebservices/".equals(namespaceURI) &&
                  "GetSessionInfoResult_type0".equals(typeName)){
                   
                            return  com.hyperion.hsf.hsfwebservices.GetSessionInfoResult_type0.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://hyperion.com/hsf/hsfwebservices/".equals(namespaceURI) &&
                  "EnumEntitiesResult_type0".equals(typeName)){
                   
                            return  com.hyperion.hsf.hsfwebservices.EnumEntitiesResult_type0.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    