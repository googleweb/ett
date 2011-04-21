/**
 * Drv.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.ett.drvinterface.first;

public interface Drv extends java.rmi.Remote {
    public java.lang.String getDrvCodeByDmlb(java.lang.String arg_0_0, java.lang.String arg_1_0) throws java.rmi.RemoteException;
    public java.lang.String getDrvPresignByLshkskm(java.lang.String arg_0_1, java.lang.String arg_1_1, java.lang.String arg_2_1) throws java.rmi.RemoteException;
    public java.lang.String getDrvperson(java.lang.String arg_0_2, java.lang.String arg_1_2) throws java.rmi.RemoteException;
    public java.lang.String getDrvExamcardByLsh(java.lang.String arg_0_3, java.lang.String arg_1_3) throws java.rmi.RemoteException;
    public java.lang.String del_drvtempmid(java.lang.String arg_0_4, java.lang.String arg_1_4, java.lang.String arg_2_4) throws java.rmi.RemoteException;
    public java.lang.String getDrvArchalt(java.lang.String arg_0_5, java.lang.String arg_1_5, java.lang.String arg_2_5, java.lang.String arg_3_5) throws java.rmi.RemoteException;
    public java.lang.String getDrvEnter(java.lang.String arg_0_6, java.lang.String arg_1_6, java.lang.String arg_2_6, java.lang.String arg_3_6) throws java.rmi.RemoteException;
    public java.lang.String getDrvExamcard(java.lang.String arg_0_7, java.lang.String arg_1_7, java.lang.String arg_2_7) throws java.rmi.RemoteException;
    public java.lang.String getDrvExchange(java.lang.String arg_0_8, java.lang.String arg_1_8, java.lang.String arg_2_8, java.lang.String arg_3_8) throws java.rmi.RemoteException;
    public java.lang.String getDrvExist(java.lang.String arg_0_9, java.lang.String arg_1_9, java.lang.String arg_2_9) throws java.rmi.RemoteException;
    public java.lang.String getDrvFlow(java.lang.String arg_0_10, java.lang.String arg_1_10, java.lang.String arg_2_10, java.lang.String arg_3_10) throws java.rmi.RemoteException;
    public java.lang.String getDrvHealth(java.lang.String arg_0_11, java.lang.String arg_1_11, java.lang.String arg_2_11, java.lang.String arg_3_11) throws java.rmi.RemoteException;
    public java.lang.String getDrvImage(java.lang.String arg_0_12, java.lang.String arg_1_12, java.lang.String arg_2_12) throws java.rmi.RemoteException;
    public java.lang.String getDrvLimited(java.lang.String arg_0_13, java.lang.String arg_1_13, java.lang.String arg_2_13, java.lang.String arg_3_13) throws java.rmi.RemoteException;
    public java.lang.String getDrvLogout(java.lang.String arg_0_14, java.lang.String arg_1_14, java.lang.String arg_2_14, java.lang.String arg_3_14) throws java.rmi.RemoteException;
    public java.lang.String getDrvNight(java.lang.String arg_0_15, java.lang.String arg_1_15) throws java.rmi.RemoteException;
    public java.lang.String getDrvPresign(java.lang.String arg_0_16, java.lang.String arg_1_16, java.lang.String arg_2_16, java.lang.String arg_3_16, java.lang.String arg_4_16, java.lang.String arg_5_16, java.lang.String arg_6_16, java.lang.String arg_7_16) throws java.rmi.RemoteException;
    public java.lang.String getDrvKm2Presign(java.lang.String arg_0_17, java.lang.String arg_1_17, java.lang.String arg_2_17) throws java.rmi.RemoteException;
    public java.lang.String getDrvKm2Result(java.lang.String arg_0_18, java.lang.String arg_1_18, java.lang.String arg_2_18, java.lang.String arg_3_18) throws java.rmi.RemoteException;
    public java.lang.String getDrvKm2YyResult(java.lang.String arg_0_19, java.lang.String arg_1_19, java.lang.String arg_2_19, java.lang.String arg_3_19, java.lang.String arg_4_19) throws java.rmi.RemoteException;
    public java.lang.String getDrvPrint(java.lang.String arg_0_20, java.lang.String arg_1_20, java.lang.String arg_2_20, java.lang.String arg_3_20) throws java.rmi.RemoteException;
    public java.lang.String getDrvSchool(java.lang.String arg_0_21) throws java.rmi.RemoteException;
    public java.lang.String getDrvZt(java.lang.String arg_0_22, java.lang.String arg_1_22, java.lang.String arg_2_22) throws java.rmi.RemoteException;
    public java.lang.String getDrvWorkPart(java.lang.String arg_0_23, java.lang.String arg_1_23, java.lang.String arg_2_23, java.lang.String arg_3_23) throws java.rmi.RemoteException;
    public java.lang.String getDrvQueryPart(java.lang.String arg_0_24, java.lang.String arg_1_24, java.lang.String arg_2_24) throws java.rmi.RemoteException;
    public java.lang.String getDrvWorkFull(java.lang.String arg_0_25, java.lang.String arg_1_25, java.lang.String arg_2_25, java.lang.String arg_3_25) throws java.rmi.RemoteException;
    public java.lang.String getDrvQueryFull(java.lang.String arg_0_26, java.lang.String arg_1_26, java.lang.String arg_2_26) throws java.rmi.RemoteException;
    public java.lang.String write_km1(java.lang.String arg_0_27, java.lang.String arg_1_27, java.lang.String arg_2_27, java.lang.String arg_3_27, int arg_4_27, int arg_5_27, java.lang.String arg_6_27, java.lang.String arg_7_27, java.lang.String arg_8_27, java.lang.String arg_9_27, java.lang.String arg_10_27) throws java.rmi.RemoteException;
    public java.lang.String write_km2(java.lang.String arg_0_28, int arg_1_28, java.lang.String arg_2_28, int arg_3_28, java.lang.String arg_4_28, java.lang.String arg_5_28, java.lang.String arg_6_28, java.lang.String arg_7_28, java.lang.String arg_8_28, java.lang.String arg_9_28, java.lang.String arg_10_28) throws java.rmi.RemoteException;
    public java.lang.String write_km3(java.lang.String arg_0_29, int arg_1_29, java.lang.String arg_2_29, int arg_3_29, java.lang.String arg_4_29, java.lang.String arg_5_29, java.lang.String arg_6_29, java.lang.String arg_7_29, java.lang.String arg_8_29, java.lang.String arg_9_29, java.lang.String arg_10_29) throws java.rmi.RemoteException;
    public java.lang.String write_driver_zt(java.lang.String arg_0_30, java.lang.String arg_1_30, int arg_2_30, java.lang.String arg_3_30) throws java.rmi.RemoteException;
    public java.lang.String write_ljjf(java.lang.String arg_0_31, int arg_1_31, int arg_2_31, java.lang.String arg_3_31) throws java.rmi.RemoteException;
    public java.lang.String write_drvimage(java.lang.String arg_0_32, java.lang.String arg_1_32, java.lang.String arg_2_32, java.lang.String arg_3_32) throws java.rmi.RemoteException;
    public java.lang.String write_drvtempmid(java.lang.String arg_0_33, java.lang.String arg_1_33, java.lang.String arg_2_33, java.lang.String arg_3_33, java.lang.String arg_4_33, java.lang.String arg_5_33, java.lang.String arg_6_33, java.lang.String arg_7_33, java.lang.String arg_8_33, java.lang.String arg_9_33, java.lang.String arg_10_33, java.lang.String arg_11_33, java.lang.String arg_12_33, java.lang.String arg_13_33, java.lang.String arg_14_33, java.lang.String arg_15_33, java.lang.String arg_16_33, java.lang.String arg_17_33, java.lang.String arg_18_33, java.lang.String arg_19_33, java.lang.String arg_20_33, java.lang.String arg_21_33, java.lang.String arg_22_33, java.lang.String arg_23_33, java.lang.String arg_24_33, java.lang.String arg_25_33, java.lang.String arg_26_33, java.lang.String arg_27_33, java.lang.String arg_28_33, java.lang.String arg_29_33, java.lang.String arg_30_33, java.lang.String arg_31_33) throws java.rmi.RemoteException;
    public java.lang.String write_yyxx(java.lang.String arg_0_34, java.lang.String arg_1_34, float arg_2_34, java.lang.String arg_3_34, java.lang.String arg_4_34, java.lang.String arg_5_34, java.lang.String arg_6_34, java.lang.String arg_7_34, java.lang.String arg_8_34, java.lang.String arg_9_34, java.lang.String arg_10_34, java.lang.String arg_11_34) throws java.rmi.RemoteException;
    public java.lang.String getDrvFlowByYwlx(java.lang.String arg_0_35, java.lang.String arg_1_35, java.lang.String arg_2_35, java.lang.String arg_3_35) throws java.rmi.RemoteException;
    public java.lang.String upd_drvprintqueque_glbm(java.lang.String arg_0_36, java.lang.String arg_1_36, java.lang.String arg_2_36) throws java.rmi.RemoteException;
    public java.lang.String upd_drvflow_glbm(java.lang.String arg_0_37, java.lang.String arg_1_37, java.lang.String arg_2_37) throws java.rmi.RemoteException;
    public java.lang.String write_drvlog(java.lang.String arg_0_38, java.lang.String arg_1_38, java.lang.String arg_2_38, java.lang.String arg_3_38, java.lang.String arg_4_38, java.lang.String arg_5_38, java.lang.String arg_6_38, java.lang.String arg_7_38, java.lang.String arg_8_38, java.lang.String arg_9_38, java.lang.String arg_10_38) throws java.rmi.RemoteException;
    public java.lang.String upd_drvba(java.lang.String arg_0_39, java.lang.String arg_1_39, java.lang.String arg_2_39, java.lang.String arg_3_39, java.lang.String arg_4_39) throws java.rmi.RemoteException;
}
