/**
 * DrvServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ett.drvinterface.first;

public class DrvServiceLocator extends org.apache.axis.client.Service implements com.ett.drvinterface.first.DrvService {

    public DrvServiceLocator() {
    }


    public DrvServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DrvServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Drv
    private java.lang.String Drv_address = "http://59.41.46.245:9080/servweb/services/Drv";

    public java.lang.String getDrvAddress() {
        return Drv_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DrvWSDDServiceName = "Drv";

    public java.lang.String getDrvWSDDServiceName() {
        return DrvWSDDServiceName;
    }

    public void setDrvWSDDServiceName(java.lang.String name) {
        DrvWSDDServiceName = name;
    }

    public com.ett.drvinterface.first.Drv getDrv() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Drv_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDrv(endpoint);
    }

    public com.ett.drvinterface.first.Drv getDrv(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.ett.drvinterface.first.DrvSoapBindingStub _stub = new com.ett.drvinterface.first.DrvSoapBindingStub(portAddress, this);
            _stub.setPortName(getDrvWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDrvEndpointAddress(java.lang.String address) {
        Drv_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.ett.drvinterface.first.Drv.class.isAssignableFrom(serviceEndpointInterface)) {
                com.ett.drvinterface.first.DrvSoapBindingStub _stub = new com.ett.drvinterface.first.DrvSoapBindingStub(new java.net.URL(Drv_address), this);
                _stub.setPortName(getDrvWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Drv".equals(inputPortName)) {
            return getDrv();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.ws.tmri.com", "DrvService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.ws.tmri.com", "Drv"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Drv".equals(portName)) {
            setDrvEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
