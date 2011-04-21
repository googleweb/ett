package com.ett.drvinterface.second;


public interface TmriJaxRpcOutAccessService extends javax.xml.rpc.Service {
    public java.lang.String getTmriOutAccessAddress();

    public TmriJaxRpcOutAccess getTmriOutAccess() throws javax.xml.rpc.ServiceException;

    public TmriJaxRpcOutAccess getTmriOutAccess(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
