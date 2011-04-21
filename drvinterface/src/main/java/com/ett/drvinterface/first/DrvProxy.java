package com.ett.drvinterface.first;

public class DrvProxy implements com.ett.drvinterface.first.Drv {
  private String _endpoint = null;
  private com.ett.drvinterface.first.Drv drv = null;
  
  public DrvProxy() {
    _initDrvProxy();
  }
  
  public DrvProxy(String endpoint) {
    _endpoint = endpoint;
    _initDrvProxy();
  }
  
  private void _initDrvProxy() {
    try {
      drv = (new com.ett.drvinterface.first.DrvServiceLocator()).getDrv();
      if (drv != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)drv)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)drv)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (drv != null)
      ((javax.xml.rpc.Stub)drv)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ett.drvinterface.first.Drv getDrv() {
    if (drv == null)
      _initDrvProxy();
    return drv;
  }
  
  public java.lang.String getDrvCodeByDmlb(java.lang.String arg_0_0, java.lang.String arg_1_0) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvCodeByDmlb(arg_0_0, arg_1_0);
  }
  
  public java.lang.String getDrvPresignByLshkskm(java.lang.String arg_0_1, java.lang.String arg_1_1, java.lang.String arg_2_1) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvPresignByLshkskm(arg_0_1, arg_1_1, arg_2_1);
  }
  
  public java.lang.String getDrvperson(java.lang.String arg_0_2, java.lang.String arg_1_2) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvperson(arg_0_2, arg_1_2);
  }
  
  public java.lang.String getDrvExamcardByLsh(java.lang.String arg_0_3, java.lang.String arg_1_3) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvExamcardByLsh(arg_0_3, arg_1_3);
  }
  
  public java.lang.String del_drvtempmid(java.lang.String arg_0_4, java.lang.String arg_1_4, java.lang.String arg_2_4) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.del_drvtempmid(arg_0_4, arg_1_4, arg_2_4);
  }
  
  public java.lang.String getDrvArchalt(java.lang.String arg_0_5, java.lang.String arg_1_5, java.lang.String arg_2_5, java.lang.String arg_3_5) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvArchalt(arg_0_5, arg_1_5, arg_2_5, arg_3_5);
  }
  
  public java.lang.String getDrvEnter(java.lang.String arg_0_6, java.lang.String arg_1_6, java.lang.String arg_2_6, java.lang.String arg_3_6) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvEnter(arg_0_6, arg_1_6, arg_2_6, arg_3_6);
  }
  
  public java.lang.String getDrvExamcard(java.lang.String arg_0_7, java.lang.String arg_1_7, java.lang.String arg_2_7) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvExamcard(arg_0_7, arg_1_7, arg_2_7);
  }
  
  public java.lang.String getDrvExchange(java.lang.String arg_0_8, java.lang.String arg_1_8, java.lang.String arg_2_8, java.lang.String arg_3_8) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvExchange(arg_0_8, arg_1_8, arg_2_8, arg_3_8);
  }
  
  public java.lang.String getDrvExist(java.lang.String arg_0_9, java.lang.String arg_1_9, java.lang.String arg_2_9) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvExist(arg_0_9, arg_1_9, arg_2_9);
  }
  
  public java.lang.String getDrvFlow(java.lang.String arg_0_10, java.lang.String arg_1_10, java.lang.String arg_2_10, java.lang.String arg_3_10) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvFlow(arg_0_10, arg_1_10, arg_2_10, arg_3_10);
  }
  
  public java.lang.String getDrvHealth(java.lang.String arg_0_11, java.lang.String arg_1_11, java.lang.String arg_2_11, java.lang.String arg_3_11) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvHealth(arg_0_11, arg_1_11, arg_2_11, arg_3_11);
  }
  
  public java.lang.String getDrvImage(java.lang.String arg_0_12, java.lang.String arg_1_12, java.lang.String arg_2_12) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvImage(arg_0_12, arg_1_12, arg_2_12);
  }
  
  public java.lang.String getDrvLimited(java.lang.String arg_0_13, java.lang.String arg_1_13, java.lang.String arg_2_13, java.lang.String arg_3_13) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvLimited(arg_0_13, arg_1_13, arg_2_13, arg_3_13);
  }
  
  public java.lang.String getDrvLogout(java.lang.String arg_0_14, java.lang.String arg_1_14, java.lang.String arg_2_14, java.lang.String arg_3_14) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvLogout(arg_0_14, arg_1_14, arg_2_14, arg_3_14);
  }
  
  public java.lang.String getDrvNight(java.lang.String arg_0_15, java.lang.String arg_1_15) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvNight(arg_0_15, arg_1_15);
  }
  
  public java.lang.String getDrvPresign(java.lang.String arg_0_16, java.lang.String arg_1_16, java.lang.String arg_2_16, java.lang.String arg_3_16, java.lang.String arg_4_16, java.lang.String arg_5_16, java.lang.String arg_6_16, java.lang.String arg_7_16) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvPresign(arg_0_16, arg_1_16, arg_2_16, arg_3_16, arg_4_16, arg_5_16, arg_6_16, arg_7_16);
  }
  
  public java.lang.String getDrvKm2Presign(java.lang.String arg_0_17, java.lang.String arg_1_17, java.lang.String arg_2_17) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvKm2Presign(arg_0_17, arg_1_17, arg_2_17);
  }
  
  public java.lang.String getDrvKm2Result(java.lang.String arg_0_18, java.lang.String arg_1_18, java.lang.String arg_2_18, java.lang.String arg_3_18) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvKm2Result(arg_0_18, arg_1_18, arg_2_18, arg_3_18);
  }
  
  public java.lang.String getDrvKm2YyResult(java.lang.String arg_0_19, java.lang.String arg_1_19, java.lang.String arg_2_19, java.lang.String arg_3_19, java.lang.String arg_4_19) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvKm2YyResult(arg_0_19, arg_1_19, arg_2_19, arg_3_19, arg_4_19);
  }
  
  public java.lang.String getDrvPrint(java.lang.String arg_0_20, java.lang.String arg_1_20, java.lang.String arg_2_20, java.lang.String arg_3_20) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvPrint(arg_0_20, arg_1_20, arg_2_20, arg_3_20);
  }
  
  public java.lang.String getDrvSchool(java.lang.String arg_0_21) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvSchool(arg_0_21);
  }
  
  public java.lang.String getDrvZt(java.lang.String arg_0_22, java.lang.String arg_1_22, java.lang.String arg_2_22) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvZt(arg_0_22, arg_1_22, arg_2_22);
  }
  
  public java.lang.String getDrvWorkPart(java.lang.String arg_0_23, java.lang.String arg_1_23, java.lang.String arg_2_23, java.lang.String arg_3_23) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvWorkPart(arg_0_23, arg_1_23, arg_2_23, arg_3_23);
  }
  
  public java.lang.String getDrvQueryPart(java.lang.String arg_0_24, java.lang.String arg_1_24, java.lang.String arg_2_24) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvQueryPart(arg_0_24, arg_1_24, arg_2_24);
  }
  
  public java.lang.String getDrvWorkFull(java.lang.String arg_0_25, java.lang.String arg_1_25, java.lang.String arg_2_25, java.lang.String arg_3_25) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvWorkFull(arg_0_25, arg_1_25, arg_2_25, arg_3_25);
  }
  
  public java.lang.String getDrvQueryFull(java.lang.String arg_0_26, java.lang.String arg_1_26, java.lang.String arg_2_26) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvQueryFull(arg_0_26, arg_1_26, arg_2_26);
  }
  
  public java.lang.String write_km1(java.lang.String arg_0_27, java.lang.String arg_1_27, java.lang.String arg_2_27, java.lang.String arg_3_27, int arg_4_27, int arg_5_27, java.lang.String arg_6_27, java.lang.String arg_7_27, java.lang.String arg_8_27, java.lang.String arg_9_27, java.lang.String arg_10_27) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.write_km1(arg_0_27, arg_1_27, arg_2_27, arg_3_27, arg_4_27, arg_5_27, arg_6_27, arg_7_27, arg_8_27, arg_9_27, arg_10_27);
  }
  
  public java.lang.String write_km2(java.lang.String arg_0_28, int arg_1_28, java.lang.String arg_2_28, int arg_3_28, java.lang.String arg_4_28, java.lang.String arg_5_28, java.lang.String arg_6_28, java.lang.String arg_7_28, java.lang.String arg_8_28, java.lang.String arg_9_28, java.lang.String arg_10_28) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.write_km2(arg_0_28, arg_1_28, arg_2_28, arg_3_28, arg_4_28, arg_5_28, arg_6_28, arg_7_28, arg_8_28, arg_9_28, arg_10_28);
  }
  
  public java.lang.String write_km3(java.lang.String arg_0_29, int arg_1_29, java.lang.String arg_2_29, int arg_3_29, java.lang.String arg_4_29, java.lang.String arg_5_29, java.lang.String arg_6_29, java.lang.String arg_7_29, java.lang.String arg_8_29, java.lang.String arg_9_29, java.lang.String arg_10_29) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.write_km3(arg_0_29, arg_1_29, arg_2_29, arg_3_29, arg_4_29, arg_5_29, arg_6_29, arg_7_29, arg_8_29, arg_9_29, arg_10_29);
  }
  
  public java.lang.String write_driver_zt(java.lang.String arg_0_30, java.lang.String arg_1_30, int arg_2_30, java.lang.String arg_3_30) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.write_driver_zt(arg_0_30, arg_1_30, arg_2_30, arg_3_30);
  }
  
  public java.lang.String write_ljjf(java.lang.String arg_0_31, int arg_1_31, int arg_2_31, java.lang.String arg_3_31) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.write_ljjf(arg_0_31, arg_1_31, arg_2_31, arg_3_31);
  }
  
  public java.lang.String write_drvimage(java.lang.String arg_0_32, java.lang.String arg_1_32, java.lang.String arg_2_32, java.lang.String arg_3_32) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.write_drvimage(arg_0_32, arg_1_32, arg_2_32, arg_3_32);
  }
  
  public java.lang.String write_drvtempmid(java.lang.String arg_0_33, java.lang.String arg_1_33, java.lang.String arg_2_33, java.lang.String arg_3_33, java.lang.String arg_4_33, java.lang.String arg_5_33, java.lang.String arg_6_33, java.lang.String arg_7_33, java.lang.String arg_8_33, java.lang.String arg_9_33, java.lang.String arg_10_33, java.lang.String arg_11_33, java.lang.String arg_12_33, java.lang.String arg_13_33, java.lang.String arg_14_33, java.lang.String arg_15_33, java.lang.String arg_16_33, java.lang.String arg_17_33, java.lang.String arg_18_33, java.lang.String arg_19_33, java.lang.String arg_20_33, java.lang.String arg_21_33, java.lang.String arg_22_33, java.lang.String arg_23_33, java.lang.String arg_24_33, java.lang.String arg_25_33, java.lang.String arg_26_33, java.lang.String arg_27_33, java.lang.String arg_28_33, java.lang.String arg_29_33, java.lang.String arg_30_33, java.lang.String arg_31_33) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.write_drvtempmid(arg_0_33, arg_1_33, arg_2_33, arg_3_33, arg_4_33, arg_5_33, arg_6_33, arg_7_33, arg_8_33, arg_9_33, arg_10_33, arg_11_33, arg_12_33, arg_13_33, arg_14_33, arg_15_33, arg_16_33, arg_17_33, arg_18_33, arg_19_33, arg_20_33, arg_21_33, arg_22_33, arg_23_33, arg_24_33, arg_25_33, arg_26_33, arg_27_33, arg_28_33, arg_29_33, arg_30_33, arg_31_33);
  }
  
  public java.lang.String write_yyxx(java.lang.String arg_0_34, java.lang.String arg_1_34, float arg_2_34, java.lang.String arg_3_34, java.lang.String arg_4_34, java.lang.String arg_5_34, java.lang.String arg_6_34, java.lang.String arg_7_34, java.lang.String arg_8_34, java.lang.String arg_9_34, java.lang.String arg_10_34, java.lang.String arg_11_34) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.write_yyxx(arg_0_34, arg_1_34, arg_2_34, arg_3_34, arg_4_34, arg_5_34, arg_6_34, arg_7_34, arg_8_34, arg_9_34, arg_10_34, arg_11_34);
  }
  
  public java.lang.String getDrvFlowByYwlx(java.lang.String arg_0_35, java.lang.String arg_1_35, java.lang.String arg_2_35, java.lang.String arg_3_35) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.getDrvFlowByYwlx(arg_0_35, arg_1_35, arg_2_35, arg_3_35);
  }
  
  public java.lang.String upd_drvprintqueque_glbm(java.lang.String arg_0_36, java.lang.String arg_1_36, java.lang.String arg_2_36) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.upd_drvprintqueque_glbm(arg_0_36, arg_1_36, arg_2_36);
  }
  
  public java.lang.String upd_drvflow_glbm(java.lang.String arg_0_37, java.lang.String arg_1_37, java.lang.String arg_2_37) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.upd_drvflow_glbm(arg_0_37, arg_1_37, arg_2_37);
  }
  
  public java.lang.String write_drvlog(java.lang.String arg_0_38, java.lang.String arg_1_38, java.lang.String arg_2_38, java.lang.String arg_3_38, java.lang.String arg_4_38, java.lang.String arg_5_38, java.lang.String arg_6_38, java.lang.String arg_7_38, java.lang.String arg_8_38, java.lang.String arg_9_38, java.lang.String arg_10_38) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.write_drvlog(arg_0_38, arg_1_38, arg_2_38, arg_3_38, arg_4_38, arg_5_38, arg_6_38, arg_7_38, arg_8_38, arg_9_38, arg_10_38);
  }
  
  public java.lang.String upd_drvba(java.lang.String arg_0_39, java.lang.String arg_1_39, java.lang.String arg_2_39, java.lang.String arg_3_39, java.lang.String arg_4_39) throws java.rmi.RemoteException{
    if (drv == null)
      _initDrvProxy();
    return drv.upd_drvba(arg_0_39, arg_1_39, arg_2_39, arg_3_39, arg_4_39);
  }
  
  
}