package com.ett.drvinterface.first;

public class VioProxy implements com.ett.drvinterface.first.Vio {
  private String _endpoint = null;
  private com.ett.drvinterface.first.Vio vio = null;
  
  public VioProxy() {
    _initVioProxy();
  }
  
  public VioProxy(String endpoint) {
    _endpoint = endpoint;
    _initVioProxy();
  }
  
  private void _initVioProxy() {
    try {
      vio = (new com.ett.drvinterface.first.VioServiceLocator()).getVio();
      if (vio != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)vio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)vio)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (vio != null)
      ((javax.xml.rpc.Stub)vio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ett.drvinterface.first.Vio getVio() {
    if (vio == null)
      _initVioProxy();
    return vio;
  }
  
  public java.lang.String write_yhdz(java.lang.String arg_0_0, java.lang.String arg_1_0, java.lang.String arg_2_0, long arg_3_0, long arg_4_0, java.lang.String arg_5_0, java.lang.String arg_6_0, java.lang.String arg_7_0, java.lang.String arg_8_0, java.lang.String arg_9_0, java.lang.String arg_10_0) throws java.rmi.RemoteException{
    if (vio == null)
      _initVioProxy();
    return vio.write_yhdz(arg_0_0, arg_1_0, arg_2_0, arg_3_0, arg_4_0, arg_5_0, arg_6_0, arg_7_0, arg_8_0, arg_9_0, arg_10_0);
  }
  
  public java.lang.String write_surveil(java.lang.String arg_0_1, java.lang.String arg_1_1, java.lang.String arg_2_1, java.lang.String arg_3_1, java.lang.String arg_4_1, java.lang.String arg_5_1, java.lang.String arg_6_1, java.lang.String arg_7_1, java.lang.String arg_8_1, java.lang.String arg_9_1, java.lang.String arg_10_1, java.lang.String arg_11_1, java.lang.String arg_12_1, java.lang.String arg_13_1, java.lang.String arg_14_1, java.lang.String arg_15_1, java.lang.String arg_16_1, java.lang.String arg_17_1, java.lang.String arg_18_1, java.lang.String arg_19_1, long arg_20_1, java.lang.String arg_21_1, java.lang.String arg_22_1, long arg_23_1, long arg_24_1, java.lang.String arg_25_1) throws java.rmi.RemoteException{
    if (vio == null)
      _initVioProxy();
    return vio.write_surveil(arg_0_1, arg_1_1, arg_2_1, arg_3_1, arg_4_1, arg_5_1, arg_6_1, arg_7_1, arg_8_1, arg_9_1, arg_10_1, arg_11_1, arg_12_1, arg_13_1, arg_14_1, arg_15_1, arg_16_1, arg_17_1, arg_18_1, arg_19_1, arg_20_1, arg_21_1, arg_22_1, arg_23_1, arg_24_1, arg_25_1);
  }
  
  public java.lang.String write_violation_jy(java.lang.String arg_0_2, java.lang.String arg_1_2, java.lang.String arg_2_2, java.lang.String arg_3_2, java.lang.String arg_4_2, java.lang.String arg_5_2, java.lang.String arg_6_2, java.lang.String arg_7_2, java.lang.String arg_8_2, java.lang.String arg_9_2, java.lang.String arg_10_2, java.lang.String arg_11_2, java.lang.String arg_12_2, java.lang.String arg_13_2, java.lang.String arg_14_2, java.lang.String arg_15_2, java.lang.String arg_16_2, java.lang.String arg_17_2, long arg_18_2, long arg_19_2, long arg_20_2, java.lang.String arg_21_2, java.lang.String arg_22_2, java.lang.String arg_23_2, java.lang.String arg_24_2, java.lang.String arg_25_2, java.lang.String arg_26_2, java.lang.String arg_27_2, java.lang.String arg_28_2, java.lang.String arg_29_2, java.lang.String arg_30_2, java.lang.String arg_31_2, java.lang.String arg_32_2, java.lang.String arg_33_2, long arg_34_2, long arg_35_2, java.lang.String arg_36_2) throws java.rmi.RemoteException{
    if (vio == null)
      _initVioProxy();
    return vio.write_violation_jy(arg_0_2, arg_1_2, arg_2_2, arg_3_2, arg_4_2, arg_5_2, arg_6_2, arg_7_2, arg_8_2, arg_9_2, arg_10_2, arg_11_2, arg_12_2, arg_13_2, arg_14_2, arg_15_2, arg_16_2, arg_17_2, arg_18_2, arg_19_2, arg_20_2, arg_21_2, arg_22_2, arg_23_2, arg_24_2, arg_25_2, arg_26_2, arg_27_2, arg_28_2, arg_29_2, arg_30_2, arg_31_2, arg_32_2, arg_33_2, arg_34_2, arg_35_2, arg_36_2);
  }
  
  public java.lang.String write_force(java.lang.String arg_0_3, java.lang.String arg_1_3, java.lang.String arg_2_3, java.lang.String arg_3_3, java.lang.String arg_4_3, java.lang.String arg_5_3, java.lang.String arg_6_3, java.lang.String arg_7_3, java.lang.String arg_8_3, java.lang.String arg_9_3, java.lang.String arg_10_3, java.lang.String arg_11_3, java.lang.String arg_12_3, java.lang.String arg_13_3, java.lang.String arg_14_3, java.lang.String arg_15_3, java.lang.String arg_16_3, java.lang.String arg_17_3, java.lang.String arg_18_3, java.lang.String arg_19_3, java.lang.String arg_20_3, java.lang.String arg_21_3, java.lang.String arg_22_3, java.lang.String arg_23_3, java.lang.String arg_24_3, java.lang.String arg_25_3, java.lang.String arg_26_3, java.lang.String arg_27_3, java.lang.String arg_28_3, java.lang.String arg_29_3, java.lang.String arg_30_3, java.lang.String arg_31_3, java.lang.String arg_32_3, long arg_33_3, long arg_34_3, java.lang.String arg_35_3) throws java.rmi.RemoteException{
    if (vio == null)
      _initVioProxy();
    return vio.write_force(arg_0_3, arg_1_3, arg_2_3, arg_3_3, arg_4_3, arg_5_3, arg_6_3, arg_7_3, arg_8_3, arg_9_3, arg_10_3, arg_11_3, arg_12_3, arg_13_3, arg_14_3, arg_15_3, arg_16_3, arg_17_3, arg_18_3, arg_19_3, arg_20_3, arg_21_3, arg_22_3, arg_23_3, arg_24_3, arg_25_3, arg_26_3, arg_27_3, arg_28_3, arg_29_3, arg_30_3, arg_31_3, arg_32_3, arg_33_3, arg_34_3, arg_35_3);
  }
  
  public java.lang.String getVehViolation(java.lang.String arg_0_4, java.lang.String arg_1_4, java.lang.String arg_2_4) throws java.rmi.RemoteException{
    if (vio == null)
      _initVioProxy();
    return vio.getVehViolation(arg_0_4, arg_1_4, arg_2_4);
  }
  
  public java.lang.String getDrvViolation(java.lang.String arg_0_5, java.lang.String arg_1_5, java.lang.String arg_2_5) throws java.rmi.RemoteException{
    if (vio == null)
      _initVioProxy();
    return vio.getDrvViolation(arg_0_5, arg_1_5, arg_2_5);
  }
  
  public java.lang.String write_mid_jdczp(java.lang.String arg_0_6, java.lang.String arg_1_6, java.lang.String arg_2_6, java.lang.String arg_3_6, java.lang.String arg_4_6, java.lang.String arg_5_6, java.lang.String arg_6_6, java.lang.String arg_7_6) throws java.rmi.RemoteException{
    if (vio == null)
      _initVioProxy();
    return vio.write_mid_jdczp(arg_0_6, arg_1_6, arg_2_6, arg_3_6, arg_4_6, arg_5_6, arg_6_6, arg_7_6);
  }
  
  
}