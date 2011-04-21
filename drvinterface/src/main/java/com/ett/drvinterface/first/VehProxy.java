package com.ett.drvinterface.first;

public class VehProxy implements com.ett.drvinterface.first.Veh {
  private String _endpoint = null;
  private com.ett.drvinterface.first.Veh veh = null;
  
  public VehProxy() {
    _initVehProxy();
  }
  
  public VehProxy(String endpoint) {
    _endpoint = endpoint;
    _initVehProxy();
  }
  
  private void _initVehProxy() {
    try {
      veh = (new com.ett.drvinterface.first.VehServiceLocator()).getVeh();
      if (veh != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)veh)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)veh)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (veh != null)
      ((javax.xml.rpc.Stub)veh)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.ett.drvinterface.first.Veh getVeh() {
    if (veh == null)
      _initVehProxy();
    return veh;
  }
  
  public java.lang.String getVehOwnermodify(java.lang.String arg_0_0, java.lang.String arg_1_0, java.lang.String arg_2_0, java.lang.String arg_3_0) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehOwnermodify(arg_0_0, arg_1_0, arg_2_0, arg_3_0);
  }
  
  public java.lang.String getVehFlowByLsh(java.lang.String arg_0_1, java.lang.String arg_1_1) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehFlowByLsh(arg_0_1, arg_1_1);
  }
  
  public java.lang.String getVehFlowByYwlxywyy(java.lang.String arg_0_2, java.lang.String arg_1_2, java.lang.String arg_2_2, java.lang.String arg_3_2, java.lang.String arg_4_2) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehFlowByYwlxywyy(arg_0_2, arg_1_2, arg_2_2, arg_3_2, arg_4_2);
  }
  
  public java.lang.String getVehCodeByDmlb(java.lang.String arg_0_3, java.lang.String arg_1_3) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehCodeByDmlb(arg_0_3, arg_1_3);
  }
  
  public java.lang.String del_vehtempmid(java.lang.String arg_0_4, java.lang.String arg_1_4, java.lang.String arg_2_4) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.del_vehtempmid(arg_0_4, arg_1_4, arg_2_4);
  }
  
  public java.lang.String getFinalpara(java.lang.String arg_0_5, java.lang.String arg_1_5, java.lang.String arg_2_5, java.lang.String arg_3_5) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getFinalpara(arg_0_5, arg_1_5, arg_2_5, arg_3_5);
  }
  
  public java.lang.String getVehByTzxx(java.lang.String arg_0_6, java.lang.String arg_1_6, java.lang.String arg_2_6) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehByTzxx(arg_0_6, arg_1_6, arg_2_6);
  }
  
  public java.lang.String getVehCheck(java.lang.String arg_0_7, java.lang.String arg_1_7, java.lang.String arg_2_7, java.lang.String arg_3_7) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehCheck(arg_0_7, arg_1_7, arg_2_7, arg_3_7);
  }
  
  public java.lang.String getVehCorrectarchives(java.lang.String arg_0_8, java.lang.String arg_1_8, java.lang.String arg_2_8, java.lang.String arg_3_8) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehCorrectarchives(arg_0_8, arg_1_8, arg_2_8, arg_3_8);
  }
  
  public java.lang.String getVehExchange(java.lang.String arg_0_9, java.lang.String arg_1_9, java.lang.String arg_2_9, java.lang.String arg_3_9) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehExchange(arg_0_9, arg_1_9, arg_2_9, arg_3_9);
  }
  
  public java.lang.String getVehFlow(java.lang.String arg_0_10, java.lang.String arg_1_10, java.lang.String arg_2_10) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehFlow(arg_0_10, arg_1_10, arg_2_10);
  }
  
  public java.lang.String getVehFlowByXL(java.lang.String arg_0_11, java.lang.String arg_1_11, java.lang.String arg_2_11, java.lang.String arg_3_11, java.lang.String arg_4_11) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehFlowByXL(arg_0_11, arg_1_11, arg_2_11, arg_3_11, arg_4_11);
  }
  
  public java.lang.String getVehImage(java.lang.String arg_0_12, java.lang.String arg_1_12, java.lang.String arg_2_12, java.lang.String arg_3_12) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehImage(arg_0_12, arg_1_12, arg_2_12, arg_3_12);
  }
  
  public java.lang.String getVehImpawn(java.lang.String arg_0_13, java.lang.String arg_1_13, java.lang.String arg_2_13, java.lang.String arg_3_13) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehImpawn(arg_0_13, arg_1_13, arg_2_13, arg_3_13);
  }
  
  public java.lang.String getVehIn(java.lang.String arg_0_14, java.lang.String arg_1_14, java.lang.String arg_2_14, java.lang.String arg_3_14) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehIn(arg_0_14, arg_1_14, arg_2_14, arg_3_14);
  }
  
  public java.lang.String getVehInsure(java.lang.String arg_0_15, java.lang.String arg_1_15, java.lang.String arg_2_15, java.lang.String arg_3_15) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehInsure(arg_0_15, arg_1_15, arg_2_15, arg_3_15);
  }
  
  public java.lang.String getVehLock(java.lang.String arg_0_16, java.lang.String arg_1_16, java.lang.String arg_2_16, java.lang.String arg_3_16) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehLock(arg_0_16, arg_1_16, arg_2_16, arg_3_16);
  }
  
  public java.lang.String getVehLogout(java.lang.String arg_0_17, java.lang.String arg_1_17, java.lang.String arg_2_17, java.lang.String arg_3_17, java.lang.String arg_4_17, java.lang.String arg_5_17, java.lang.String arg_6_17) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehLogout(arg_0_17, arg_1_17, arg_2_17, arg_3_17, arg_4_17, arg_5_17, arg_6_17);
  }
  
  public java.lang.String getVehLszt(java.lang.String arg_0_18, java.lang.String arg_1_18, java.lang.String arg_2_18, java.lang.String arg_3_18) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehLszt(arg_0_18, arg_1_18, arg_2_18, arg_3_18);
  }
  
  public java.lang.String getVehModify(java.lang.String arg_0_19, java.lang.String arg_1_19, java.lang.String arg_2_19, java.lang.String arg_3_19) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehModify(arg_0_19, arg_1_19, arg_2_19, arg_3_19);
  }
  
  public java.lang.String getVehOut(java.lang.String arg_0_20, java.lang.String arg_1_20, java.lang.String arg_2_20, java.lang.String arg_3_20) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehOut(arg_0_20, arg_1_20, arg_2_20, arg_3_20);
  }
  
  public java.lang.String getVehPart(java.lang.String arg_0_21, java.lang.String arg_1_21, java.lang.String arg_2_21, java.lang.String arg_3_21, java.lang.String arg_4_21, java.lang.String arg_5_21, java.lang.String arg_6_21) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehPart(arg_0_21, arg_1_21, arg_2_21, arg_3_21, arg_4_21, arg_5_21, arg_6_21);
  }
  
  public java.lang.String getVehPrint(java.lang.String arg_0_22, java.lang.String arg_1_22, java.lang.String arg_2_22, java.lang.String arg_3_22) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehPrint(arg_0_22, arg_1_22, arg_2_22, arg_3_22);
  }
  
  public java.lang.String getVehQueryFull(java.lang.String arg_0_23, java.lang.String arg_1_23, java.lang.String arg_2_23) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehQueryFull(arg_0_23, arg_1_23, arg_2_23);
  }
  
  public java.lang.String getVehQueryPart(java.lang.String arg_0_24, java.lang.String arg_1_24, java.lang.String arg_2_24) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehQueryPart(arg_0_24, arg_1_24, arg_2_24);
  }
  
  public java.lang.String getVehTemp(java.lang.String arg_0_25, java.lang.String arg_1_25, java.lang.String arg_2_25, java.lang.String arg_3_25, java.lang.String arg_4_25) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehTemp(arg_0_25, arg_1_25, arg_2_25, arg_3_25, arg_4_25);
  }
  
  public java.lang.String getVehTempMid(java.lang.String arg_0_26, java.lang.String arg_1_26, java.lang.String arg_2_26, java.lang.String arg_3_26, java.lang.String arg_4_26) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehTempMid(arg_0_26, arg_1_26, arg_2_26, arg_3_26, arg_4_26);
  }
  
  public java.lang.String getVehWorkFull(java.lang.String arg_0_27, java.lang.String arg_1_27, java.lang.String arg_2_27, java.lang.String arg_3_27) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehWorkFull(arg_0_27, arg_1_27, arg_2_27, arg_3_27);
  }
  
  public java.lang.String getVehWorkFullByLsh(java.lang.String arg_0_28, java.lang.String arg_1_28, java.lang.String arg_2_28, java.lang.String arg_3_28) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehWorkFullByLsh(arg_0_28, arg_1_28, arg_2_28, arg_3_28);
  }
  
  public java.lang.String getVehWorkPart(java.lang.String arg_0_29, java.lang.String arg_1_29, java.lang.String arg_2_29, java.lang.String arg_3_29) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehWorkPart(arg_0_29, arg_1_29, arg_2_29, arg_3_29);
  }
  
  public java.lang.String write_vehcheck(java.lang.String arg_0_30, java.lang.String arg_1_30, java.lang.String arg_2_30, java.lang.String arg_3_30, java.lang.String arg_4_30, java.lang.String arg_5_30, java.lang.String arg_6_30) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.write_vehcheck(arg_0_30, arg_1_30, arg_2_30, arg_3_30, arg_4_30, arg_5_30, arg_6_30);
  }
  
  public java.lang.String write_vehzt(java.lang.String arg_0_31, java.lang.String arg_1_31, java.lang.String arg_2_31, int arg_3_31, java.lang.String arg_4_31) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.write_vehzt(arg_0_31, arg_1_31, arg_2_31, arg_3_31, arg_4_31);
  }
  
  public java.lang.String write_vehicle_hphm_sn(java.lang.String arg_0_32, java.lang.String arg_1_32, java.lang.String arg_2_32, java.lang.String arg_3_32) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.write_vehicle_hphm_sn(arg_0_32, arg_1_32, arg_2_32, arg_3_32);
  }
  
  public java.lang.String write_bxxx(java.lang.String arg_0_33, java.lang.String arg_1_33, java.lang.String arg_2_33, java.lang.String arg_3_33, long arg_4_33, java.lang.String arg_5_33, java.lang.String arg_6_33, java.lang.String arg_7_33, java.lang.String arg_8_33) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.write_bxxx(arg_0_33, arg_1_33, arg_2_33, arg_3_33, arg_4_33, arg_5_33, arg_6_33, arg_7_33, arg_8_33);
  }
  
  public java.lang.String write_vehimage(java.lang.String arg_0_34, java.lang.String arg_1_34, java.lang.String arg_2_34, java.lang.String arg_3_34, java.lang.String arg_4_34) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.write_vehimage(arg_0_34, arg_1_34, arg_2_34, arg_3_34, arg_4_34);
  }
  
  public java.lang.String write_vehlzxx(java.lang.String arg_0_35, java.lang.String arg_1_35) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.write_vehlzxx(arg_0_35, arg_1_35);
  }
  
  public java.lang.String write_vehtempmid(java.lang.String arg_0_36, java.lang.String arg_1_36, java.lang.String arg_2_36, java.lang.String arg_3_36, java.lang.String arg_4_36, java.lang.String arg_5_36, java.lang.String arg_6_36, java.lang.String arg_7_36, java.lang.String arg_8_36, java.lang.String arg_9_36, java.lang.String arg_10_36, java.lang.String arg_11_36, java.lang.String arg_12_36, java.lang.String arg_13_36, java.lang.String arg_14_36, java.lang.String arg_15_36, java.lang.String arg_16_36, java.lang.String arg_17_36, java.lang.String arg_18_36, java.lang.String arg_19_36, java.lang.String arg_20_36, java.lang.String arg_21_36, java.lang.String arg_22_36, java.lang.String arg_23_36, java.lang.String arg_24_36, java.lang.String arg_25_36, java.lang.String arg_26_36, java.lang.String arg_27_36, java.lang.String arg_28_36, java.lang.String arg_29_36, java.lang.String arg_30_36, java.lang.String arg_31_36, java.lang.String arg_32_36, java.lang.String arg_33_36, java.lang.String arg_34_36, java.lang.String arg_35_36, java.lang.String arg_36_36, java.lang.String arg_37_36, java.lang.String arg_38_36, java.lang.String arg_39_36, java.lang.String arg_40_36, java.lang.String arg_41_36, java.lang.String arg_42_36, java.lang.String arg_43_36, java.lang.String arg_44_36, java.lang.String arg_45_36, java.lang.String arg_46_36, java.lang.String arg_47_36, java.lang.String arg_48_36, java.lang.String arg_49_36, java.lang.String arg_50_36, java.lang.String arg_51_36, java.lang.String arg_52_36, java.lang.String arg_53_36, java.lang.String arg_54_36, java.lang.String arg_55_36, java.lang.String arg_56_36, java.lang.String arg_57_36, java.lang.String arg_58_36, java.lang.String arg_59_36, java.lang.String arg_60_36, java.lang.String arg_61_36, java.lang.String arg_62_36, java.lang.String arg_63_36, java.lang.String arg_64_36, java.lang.String arg_65_36, java.lang.String arg_66_36, java.lang.String arg_67_36, java.lang.String arg_68_36, java.lang.String arg_69_36, java.lang.String arg_70_36, java.lang.String arg_71_36, java.lang.String arg_72_36, java.lang.String arg_73_36, java.lang.String arg_74_36, java.lang.String arg_75_36, java.lang.String arg_76_36, java.lang.String arg_77_36, java.lang.String arg_78_36, java.lang.String arg_79_36, java.lang.String arg_80_36, java.lang.String arg_81_36, java.lang.String arg_82_36, java.lang.String arg_83_36, java.lang.String arg_84_36, java.lang.String arg_85_36, java.lang.String arg_86_36, java.lang.String arg_87_36, java.lang.String arg_88_36, java.lang.String arg_89_36, java.lang.String arg_90_36, java.lang.String arg_91_36, java.lang.String arg_92_36, java.lang.String arg_93_36, java.lang.String arg_94_36, java.lang.String arg_95_36, java.lang.String arg_96_36, java.lang.String arg_97_36, java.lang.String arg_98_36, java.lang.String arg_99_36, java.lang.String arg_100_36, java.lang.String arg_101_36, java.lang.String arg_102_36, java.lang.String arg_103_36, java.lang.String arg_104_36, java.lang.String arg_105_36, java.lang.String arg_106_36, java.lang.String arg_107_36, java.lang.String arg_108_36, java.lang.String arg_109_36, java.lang.String arg_110_36, java.lang.String arg_111_36, java.lang.String arg_112_36, java.lang.String arg_113_36, java.lang.String arg_114_36) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.write_vehtempmid(arg_0_36, arg_1_36, arg_2_36, arg_3_36, arg_4_36, arg_5_36, arg_6_36, arg_7_36, arg_8_36, arg_9_36, arg_10_36, arg_11_36, arg_12_36, arg_13_36, arg_14_36, arg_15_36, arg_16_36, arg_17_36, arg_18_36, arg_19_36, arg_20_36, arg_21_36, arg_22_36, arg_23_36, arg_24_36, arg_25_36, arg_26_36, arg_27_36, arg_28_36, arg_29_36, arg_30_36, arg_31_36, arg_32_36, arg_33_36, arg_34_36, arg_35_36, arg_36_36, arg_37_36, arg_38_36, arg_39_36, arg_40_36, arg_41_36, arg_42_36, arg_43_36, arg_44_36, arg_45_36, arg_46_36, arg_47_36, arg_48_36, arg_49_36, arg_50_36, arg_51_36, arg_52_36, arg_53_36, arg_54_36, arg_55_36, arg_56_36, arg_57_36, arg_58_36, arg_59_36, arg_60_36, arg_61_36, arg_62_36, arg_63_36, arg_64_36, arg_65_36, arg_66_36, arg_67_36, arg_68_36, arg_69_36, arg_70_36, arg_71_36, arg_72_36, arg_73_36, arg_74_36, arg_75_36, arg_76_36, arg_77_36, arg_78_36, arg_79_36, arg_80_36, arg_81_36, arg_82_36, arg_83_36, arg_84_36, arg_85_36, arg_86_36, arg_87_36, arg_88_36, arg_89_36, arg_90_36, arg_91_36, arg_92_36, arg_93_36, arg_94_36, arg_95_36, arg_96_36, arg_97_36, arg_98_36, arg_99_36, arg_100_36, arg_101_36, arg_102_36, arg_103_36, arg_104_36, arg_105_36, arg_106_36, arg_107_36, arg_108_36, arg_109_36, arg_110_36, arg_111_36, arg_112_36, arg_113_36, arg_114_36);
  }
  
  public java.lang.String getVehLog(java.lang.String arg_0_37, java.lang.String arg_1_37, java.lang.String arg_2_37) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getVehLog(arg_0_37, arg_1_37, arg_2_37);
  }
  
  public java.lang.String getMototempBySfzmhm(java.lang.String arg_0_38, java.lang.String arg_1_38) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getMototempBySfzmhm(arg_0_38, arg_1_38);
  }
  
  public java.lang.String getMotoBySyr(java.lang.String arg_0_39, java.lang.String arg_1_39, java.lang.String arg_2_39) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getMotoBySyr(arg_0_39, arg_1_39, arg_2_39);
  }
  
  public java.lang.String getMotoBySfzmhm(java.lang.String arg_0_40, java.lang.String arg_1_40) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.getMotoBySfzmhm(arg_0_40, arg_1_40);
  }
  
  public java.lang.String upd_vehprintqueque_glbm(java.lang.String arg_0_41, java.lang.String arg_1_41, java.lang.String arg_2_41) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.upd_vehprintqueque_glbm(arg_0_41, arg_1_41, arg_2_41);
  }
  
  public java.lang.String upd_vehflow_glbm(java.lang.String arg_0_42, java.lang.String arg_1_42, java.lang.String arg_2_42) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.upd_vehflow_glbm(arg_0_42, arg_1_42, arg_2_42);
  }
  
  public java.lang.String upd_vehtemp_glbm(java.lang.String arg_0_43, java.lang.String arg_1_43, java.lang.String arg_2_43) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.upd_vehtemp_glbm(arg_0_43, arg_1_43, arg_2_43);
  }
  
  public java.lang.String write_vehlog(java.lang.String arg_0_44, java.lang.String arg_1_44, java.lang.String arg_2_44, java.lang.String arg_3_44, java.lang.String arg_4_44, java.lang.String arg_5_44, java.lang.String arg_6_44, java.lang.String arg_7_44, java.lang.String arg_8_44, java.lang.String arg_9_44, java.lang.String arg_10_44, java.lang.String arg_11_44, java.lang.String arg_12_44) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.write_vehlog(arg_0_44, arg_1_44, arg_2_44, arg_3_44, arg_4_44, arg_5_44, arg_6_44, arg_7_44, arg_8_44, arg_9_44, arg_10_44, arg_11_44, arg_12_44);
  }
  
  public java.lang.String upd_vehba(java.lang.String arg_0_45, java.lang.String arg_1_45, java.lang.String arg_2_45, java.lang.String arg_3_45, java.lang.String arg_4_45, java.lang.String arg_5_45, java.lang.String arg_6_45, java.lang.String arg_7_45, java.lang.String arg_8_45) throws java.rmi.RemoteException{
    if (veh == null)
      _initVehProxy();
    return veh.upd_vehba(arg_0_45, arg_1_45, arg_2_45, arg_3_45, arg_4_45, arg_5_45, arg_6_45, arg_7_45, arg_8_45);
  }
  
  
}