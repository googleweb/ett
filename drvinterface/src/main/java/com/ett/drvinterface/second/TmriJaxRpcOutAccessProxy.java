package com.ett.drvinterface.second;


public class TmriJaxRpcOutAccessProxy implements TmriJaxRpcOutAccess {
  private String _endpoint = null;
  private TmriJaxRpcOutAccess tmriJaxRpcOutAccess = null;
  
  public TmriJaxRpcOutAccessProxy() {
    _initTmriJaxRpcOutAccessProxy();
  }
  
  public TmriJaxRpcOutAccessProxy(String endpoint) {
    _endpoint = endpoint;
    _initTmriJaxRpcOutAccessProxy();
  }
  
  private void _initTmriJaxRpcOutAccessProxy() {
    try {
      tmriJaxRpcOutAccess = (new TmriJaxRpcOutAccessServiceLocator()).getTmriOutAccess();
      if (tmriJaxRpcOutAccess != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tmriJaxRpcOutAccess)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tmriJaxRpcOutAccess)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tmriJaxRpcOutAccess != null)
      ((javax.xml.rpc.Stub)tmriJaxRpcOutAccess)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public TmriJaxRpcOutAccess getTmriJaxRpcOutAccess() {
    if (tmriJaxRpcOutAccess == null)
      _initTmriJaxRpcOutAccessProxy();
    return tmriJaxRpcOutAccess;
  }
  
  public java.lang.String queryObject(java.lang.String xtlb, java.lang.String jkxlh, java.lang.String jkid, java.lang.String encrptXmlDoc) throws java.rmi.RemoteException{
    if (tmriJaxRpcOutAccess == null)
      _initTmriJaxRpcOutAccessProxy();
    return tmriJaxRpcOutAccess.queryObject(xtlb, jkxlh, jkid, encrptXmlDoc);
  }
  
  public java.lang.String writeObject(java.lang.String xtlb, java.lang.String jkxlh, java.lang.String jkid, java.lang.String encrptXmlDoc) throws java.rmi.RemoteException{
    if (tmriJaxRpcOutAccess == null)
      _initTmriJaxRpcOutAccessProxy();
    return tmriJaxRpcOutAccess.writeObject(xtlb, jkxlh, jkid, encrptXmlDoc);
  }
  
  
}