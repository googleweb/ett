/**
 * DrvService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ett.drvinterface.first;

public interface DrvService extends javax.xml.rpc.Service {
    public java.lang.String getDrvAddress();

    public com.ett.drvinterface.first.Drv getDrv() throws javax.xml.rpc.ServiceException;

    public com.ett.drvinterface.first.Drv getDrv(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
