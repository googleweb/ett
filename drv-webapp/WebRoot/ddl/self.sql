prompt PL/SQL Developer import file
prompt Created on 2011-04-14 by Administrator
set feedback off
set define off
prompt Creating DRIVINGLICENSE...
create table DRIVINGLICENSE
(
  DABH   CHAR(12) not null,
  SFZMHM CHAR(18) not null,
  ZJCX   VARCHAR2(15),
  YZJCX  VARCHAR2(10),
  QFRQ   DATE not null,
  SYRQ   DATE,
  CCLZRQ DATE not null,
  CCFZJG VARCHAR2(10),
  JZQX   CHAR(1) not null,
  YXQS   DATE not null,
  YXQZ   DATE not null,
  LJJF   NUMBER(3) not null,
  CFRQ   DATE,
  XXTZRQ DATE,
  BZCS   NUMBER(2) not null,
  ZT     VARCHAR2(6) not null,
  LY     CHAR(1) not null,
  JXMC   VARCHAR2(64),
  JLY    VARCHAR2(30),
  XZQH   VARCHAR2(10) not null,
  XZQJ   VARCHAR2(10),
  FZRQ   DATE not null,
  JBR    VARCHAR2(30),
  GLBM   VARCHAR2(10) not null,
  FZJG   VARCHAR2(10) not null,
  GXSJ   DATE not null,
  LSH    CHAR(11),
  XGZL   VARCHAR2(15),
  BZ     VARCHAR2(256),
  JYW    VARCHAR2(256),
  YDABH  CHAR(12),
  SQDM   VARCHAR2(12),
  ZXBH   CHAR(13)
)
tablespace ORADRV
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 1M
    minextents 1
    maxextents unlimited
  );
alter table DRIVINGLICENSE
  add constraint PK_DRIVINGLICENSE primary key (DABH)
  using index 
  tablespace ORADRV
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1M
    minextents 1
    maxextents unlimited
  );
alter table DRIVINGLICENSE
  add constraint UNIQUE_DRIVINGLICENSE_SFZMHM unique (SFZMHM);
create index IDX$DRIVINGLICENSE$ZJCX on DRIVINGLICENSE (ZJCX)
  tablespace ORADRV
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
create index IDX_DRIVINGLICENSE_GLBM on DRIVINGLICENSE (GLBM)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
create index IDX_DRIVINGLICENSE_LJJF on DRIVINGLICENSE (LJJF)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
create index IDX_DRIVINGLICENSE_XZQH on DRIVINGLICENSE (XZQH)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
create index IDX_DRIVINGLICENSE_ZT on DRIVINGLICENSE (ZT)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
create index IDX_DRIVINGLICENSE_ZXBH on DRIVINGLICENSE (ZXBH)
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
create unique index JSZXX_SFZMHM_IDX on DRIVINGLICENSE (SFZMHM)
  tablespace ORADRV
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 1M
    minextents 1
    maxextents unlimited
  );

prompt Creating DRV_FLOW...
create table DRV_FLOW
(
  LSH    VARCHAR2(32),
  SFZMHM VARCHAR2(18),
  DABH   VARCHAR2(32),
  XM     VARCHAR2(32),
  YWLX   VARCHAR2(32),
  YWYY   VARCHAR2(32),
  KSSJ   DATE,
  JSSJ   VARCHAR2(32),
  YWGW   VARCHAR2(32),
  KSKM   VARCHAR2(32),
  XYGW   VARCHAR2(32),
  GLBM   VARCHAR2(32),
  FFBZ   VARCHAR2(32),
  RKBZ   VARCHAR2(32),
  HDBZ   VARCHAR2(32),
  XGZL   VARCHAR2(32),
  ZJCX   VARCHAR2(32)
)
tablespace ORADRV
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating PERSON...
create table PERSON
(
  SFZMHM   CHAR(18) not null,
  SFZMMC   CHAR(1) not null,
  HMCD     CHAR(1),
  XM       VARCHAR2(30) not null,
  XB       CHAR(1) not null,
  CSRQ     DATE not null,
  GJ       CHAR(3) not null,
  DJZSXZQH VARCHAR2(10) not null,
  DJZSXXDZ VARCHAR2(128) not null,
  DJZSYZBM VARCHAR2(6),
  LXZSXZQH VARCHAR2(10),
  LXZSXXDZ VARCHAR2(128),
  LXZSYZBM VARCHAR2(6),
  LXDH     VARCHAR2(20),
  ZZZM     VARCHAR2(18),
  ZZSXZQH  VARCHAR2(10),
  ZZSXXDZ  VARCHAR2(128),
  ZZSYZBM  VARCHAR2(6),
  GXSJ     DATE not null,
  SFBD     CHAR(1),
  ZZFZJG   VARCHAR2(30),
  ZZFZRQ   DATE
)
tablespace ORADRV
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating SELF_TRANSACT_DRIVER...
create table SELF_TRANSACT_DRIVER
(
  ID             INTEGER,
  TRANSACT       VARCHAR2(50),
  APPLICAT       VARCHAR2(100),
  DRIVER_ID_NO   VARCHAR2(20),
  AGENT_ID_NO    VARCHAR2(20),
  DRIVER_ID_NAME VARCHAR2(20),
  AGENT_ID_NAME  VARCHAR2(20),
  CREATE_DATE    DATE,
  VERIFY_DATE    DATE,
  VERIFY_IND     CHAR(1),
  TEL            VARCHAR2(30),
  VERIFYER_FK    VARCHAR2(30),
  REMARK         VARCHAR2(300),
  PAYMENT        VARCHAR2(10),
  RECEIVE        VARCHAR2(20),
  FLOW_NO        VARCHAR2(100),
  PHONE          VARCHAR2(30)
)
tablespace DRV_ADMIN
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating SELF_TRANSACT_VEHICLE...
create table SELF_TRANSACT_VEHICLE
(
  ID             INTEGER,
  TRANSACT       VARCHAR2(50),
  APPLICAT       VARCHAR2(100),
  DRIVER_ID_NO   VARCHAR2(20),
  AGENT_ID_NO    VARCHAR2(20),
  DRIVER_ID_NAME VARCHAR2(20),
  AGENT_ID_NAME  VARCHAR2(20),
  CREATE_DATE    DATE,
  VERIFY_DATE    DATE,
  VERIFY_IND     CHAR(1),
  TEL            VARCHAR2(30),
  VERIFYER_FK    VARCHAR2(30),
  REMARK         VARCHAR2(300),
  PAYMENT        VARCHAR2(10),
  RECEIVE        VARCHAR2(20),
  FLOW_NO        VARCHAR2(100),
  PHONE          VARCHAR2(30),
  REASON         VARCHAR2(50),
  PAY_IND        CHAR(1),
  PRINT_IND      CHAR(1)
)
tablespace DRV_ADMIN
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating VEHICLE...
create table VEHICLE
(
  XH      CHAR(14),
  HPZL    CHAR(2) not null,
  HPHM    VARCHAR2(15) not null,
  CLPP1   VARCHAR2(32),
  CLXH    VARCHAR2(32),
  CLPP2   VARCHAR2(32),
  GCJK    CHAR(1),
  ZZG     CHAR(3),
  ZZCMC   VARCHAR2(84),
  CLSBDH  VARCHAR2(25),
  FDJH    VARCHAR2(30),
  CLLX    CHAR(3),
  CSYS    VARCHAR2(5),
  SYXZ    CHAR(1),
  SFZMHM  VARCHAR2(18),
  SFZMMC  CHAR(1),
  SYR     VARCHAR2(128),
  ZSXZQH  VARCHAR2(10),
  ZSXXDZ  VARCHAR2(128),
  YZBM1   CHAR(6),
  LXDH    VARCHAR2(20),
  ZZZ     VARCHAR2(18),
  ZZXZQH  VARCHAR2(10),
  ZZXXDZ  VARCHAR2(128),
  YZBM2   CHAR(6),
  SYQ     CHAR(1),
  CCDJRQ  DATE,
  DJRQ    DATE,
  YXQZ    DATE,
  QZBFQZ  DATE,
  FZJG    VARCHAR2(10),
  GLBM    VARCHAR2(10),
  FPRQ    DATE,
  FZRQ    DATE,
  FDJRQ   DATE,
  FHGZRQ  DATE,
  BXZZRQ  DATE,
  BPCS    NUMBER(2),
  BZCS    NUMBER(2),
  BDJCS   NUMBER(2),
  DJZSBH  VARCHAR2(15),
  ZDJZSHS NUMBER(2),
  DABH    VARCHAR2(12),
  XZQH    VARCHAR2(10),
  ZT      VARCHAR2(6),
  ZDYZT   VARCHAR2(10),
  DYBJ    CHAR(1),
  JBR     VARCHAR2(30),
  CLLY    CHAR(1),
  LSH     CHAR(11),
  FDJXH   VARCHAR2(20),
  RLZL    VARCHAR2(3),
  PL      NUMBER(4),
  GL      NUMBER(5,1),
  ZXXS    CHAR(1),
  CWKC    NUMBER(5),
  CWKK    NUMBER(4),
  CWKG    NUMBER(4),
  HXNBCD  NUMBER(5),
  HXNBKD  NUMBER(4),
  HXNBGD  NUMBER(4),
  GBTHPS  NUMBER(3),
  ZS      NUMBER(1),
  ZJ      NUMBER(5),
  QLJ     NUMBER(4),
  HLJ     NUMBER(4),
  LTGG    VARCHAR2(20),
  LTS     NUMBER(2),
  ZZL     NUMBER(8),
  ZBZL    NUMBER(8),
  HDZZL   NUMBER(8),
  HDZK    NUMBER(3),
  ZQYZL   NUMBER(8),
  QPZK    NUMBER(1),
  HPZK    NUMBER(1),
  HBDBQK  VARCHAR2(60),
  CCRQ    DATE,
  HDFS    CHAR(1),
  LLPZ1   CHAR(1),
  PZBH1   VARCHAR2(20),
  LLPZ2   CHAR(1),
  PZBH2   VARCHAR2(20),
  XSDW    VARCHAR2(64),
  XSJG    NUMBER(8),
  XSRQ    DATE,
  JKPZ    CHAR(1) default '',
  JKPZHM  VARCHAR2(20) default '',
  HGZBH   VARCHAR2(20) default '',
  NSZM    CHAR(1) default '',
  NSZMBH  VARCHAR2(20) default '',
  GXRQ    DATE,
  XGZL    VARCHAR2(20) default '',
  QMBH    VARCHAR2(15) default '',
  HMBH    VARCHAR2(15) default '',
  BZ      VARCHAR2(128) default '',
  JYW     VARCHAR2(32) default '',
  YXH     VARCHAR2(14) default ''
)
tablespace DRV_ADMIN
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table VEHICLE
  add constraint VEHICLE_PK primary key (HPZL, HPHM)
  using index 
  tablespace DRV_ADMIN
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table VEHICLE
  add constraint VEHICLE_UQI unique (XH)
  using index 
  tablespace DRV_ADMIN
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating VEH_FLOW...
create table VEH_FLOW
(
  LSH    CHAR(20) not null,
  XH     CHAR(14),
  YWLX   CHAR(1),
  YWYY   VARCHAR2(8),
  SYR    VARCHAR2(64),
  CLSBDH VARCHAR2(25),
  HPZL   CHAR(2),
  HPHM   VARCHAR2(15),
  CLPP1  VARCHAR2(32),
  CLXH   VARCHAR2(32),
  CLLX   CHAR(3),
  XZQH   VARCHAR2(10),
  SQRQ   DATE,
  BJRQ   DATE,
  XYGW   CHAR(1),
  YWLC   VARCHAR2(10),
  LSZT   CHAR(1),
  GLBM   VARCHAR2(10),
  FPBJ   CHAR(1),
  FFBJ   CHAR(1),
  RKBJ   CHAR(1)
)
tablespace DRV_ADMIN
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table VEH_FLOW
  add constraint VEH_FLOW_PK primary key (LSH)
  using index 
  tablespace DRV_ADMIN
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for DRIVINGLICENSE...
alter table DRIVINGLICENSE disable all triggers;
prompt Disabling triggers for DRV_FLOW...
alter table DRV_FLOW disable all triggers;
prompt Disabling triggers for PERSON...
alter table PERSON disable all triggers;
prompt Disabling triggers for SELF_TRANSACT_DRIVER...
alter table SELF_TRANSACT_DRIVER disable all triggers;
prompt Disabling triggers for SELF_TRANSACT_VEHICLE...
alter table SELF_TRANSACT_VEHICLE disable all triggers;
prompt Disabling triggers for VEHICLE...
alter table VEHICLE disable all triggers;
prompt Disabling triggers for VEH_FLOW...
alter table VEH_FLOW disable all triggers;
prompt Deleting VEH_FLOW...
delete from VEH_FLOW;
commit;
prompt Deleting VEHICLE...
delete from VEHICLE;
commit;
prompt Deleting SELF_TRANSACT_VEHICLE...
delete from SELF_TRANSACT_VEHICLE;
commit;
prompt Deleting SELF_TRANSACT_DRIVER...
delete from SELF_TRANSACT_DRIVER;
commit;
prompt Deleting PERSON...
delete from PERSON;
commit;
prompt Deleting DRV_FLOW...
delete from DRV_FLOW;
commit;
prompt Deleting DRIVINGLICENSE...
delete from DRIVINGLICENSE;
commit;
prompt Loading DRIVINGLICENSE...
insert into DRIVINGLICENSE (DABH, SFZMHM, ZJCX, YZJCX, QFRQ, SYRQ, CCLZRQ, CCFZJG, JZQX, YXQS, YXQZ, LJJF, CFRQ, XXTZRQ, BZCS, ZT, LY, JXMC, JLY, XZQH, XZQJ, FZRQ, JBR, GLBM, FZJG, GXSJ, LSH, XGZL, BZ, JYW, YDABH, SQDM, ZXBH)
values ('xdfaf       ', '440103198408241530', 'x', 'x', to_date('20-04-2011', 'dd-mm-yyyy'), to_date('11-04-2011', 'dd-mm-yyyy'), to_date('19-04-2011', 'dd-mm-yyyy'), 'd', '1', to_date('12-04-2011', 'dd-mm-yyyy'), to_date('10-04-2011', 'dd-mm-yyyy'), 3, to_date('12-04-2011', 'dd-mm-yyyy'), to_date('18-04-2011', 'dd-mm-yyyy'), 3, '3', '4', '3', 'd', 'd', 'd', to_date('11-04-2011', 'dd-mm-yyyy'), 'e', 'e', 'r', to_date('12-04-2011', 'dd-mm-yyyy'), 'er         ', 'e', 're', 'er', 'er          ', 'er', 'e            ');
commit;
prompt 1 records loaded
prompt Loading DRV_FLOW...
insert into DRV_FLOW (LSH, SFZMHM, DABH, XM, YWLX, YWYY, KSSJ, JSSJ, YWGW, KSKM, XYGW, GLBM, FFBZ, RKBZ, HDBZ, XGZL, ZJCX)
values ('1', '350128198403194910', null, '1name', 'A', null, to_date('01-10-2009 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), null, null, '1', 'O', '440400', null, null, null, null, 'C1');
insert into DRV_FLOW (LSH, SFZMHM, DABH, XM, YWLX, YWYY, KSSJ, JSSJ, YWGW, KSKM, XYGW, GLBM, FFBZ, RKBZ, HDBZ, XGZL, ZJCX)
values ('2', '350128198403194911', null, '2name', 'B', null, to_date('02-10-2009 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), null, null, '2', 'O', '440400', null, null, null, null, 'B1');
insert into DRV_FLOW (LSH, SFZMHM, DABH, XM, YWLX, YWYY, KSSJ, JSSJ, YWGW, KSKM, XYGW, GLBM, FFBZ, RKBZ, HDBZ, XGZL, ZJCX)
values ('3', '350128198403194912', null, '3name', 'A', null, to_date('03-10-2009 10:00:00', 'dd-mm-yyyy hh24:mi:ss'), null, null, '3', 'O', '440400', null, null, null, null, 'A1');
commit;
prompt 3 records loaded
prompt Loading PERSON...
insert into PERSON (SFZMHM, SFZMMC, HMCD, XM, XB, CSRQ, GJ, DJZSXZQH, DJZSXXDZ, DJZSYZBM, LXZSXZQH, LXZSXXDZ, LXZSYZBM, LXDH, ZZZM, ZZSXZQH, ZZSXXDZ, ZZSYZBM, GXSJ, SFBD, ZZFZJG, ZZFZRQ)
values ('440103198408241530', '1', '1', '林海晖', 'M', to_date('24-08-1984', 'dd-mm-yyyy'), 'c  ', 'sss', 'xxx', 'xxx', null, null, null, null, null, null, null, null, to_date('21-04-2011', 'dd-mm-yyyy'), null, null, null);
commit;
prompt 1 records loaded
prompt Loading SELF_TRANSACT_DRIVER...
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (23, 'exchange_plate', 'driver', '440103198408241530', '440103198408241530', '林海晖', '林海晖', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'postOrPull', '220110414342564', '13632254864');
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (21, 'exchange_plate', 'driver', '440103198408241530', null, '林海晖', null, to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'pull', '220110414342564', '13632254864');
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (22, 'exchange_plate', 'driver', '440103198408241530', '440103198408241530', '林海晖', '林海晖', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'post', '220110414342564', '13632254864');
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (24, 'exchange_plate', 'driver', '440103198408241530', '440103198408241530', '林海晖', '林海晖', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'postOrPull', '220110414342564', '13632254864');
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (25, 'exchange_plate', 'driver', '440103198408241530', '440103198408241530', '林海晖', '林海晖', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'postOrPull', '220110414342564', '13632254864');
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (26, 'exchange_plate', 'driver', '440103198408241530', '440103198408241530', '林海晖', '林海晖', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'postOrPull', '220110414342564', '13632254864');
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (27, 'exchange_qualified', 'agent', '440103198408241530', '440103198408241530', '林海晖', '林海晖', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'pull', '220110414342564', '13632254864');
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (28, 'exchange_plate', 'agent', '440103198408241530', '350128198403194910', '林海晖', '陈必武', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'postOrPull', '2201104144602', '13632254864');
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (29, 'exchange_plate', 'agent', '440103198408241530', '350128198403194910', '林海晖', '陈必武', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'postOrPull', '2201104147980', '13632254864');
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (30, 'exchange_plate', 'agent', '440103198408241530', '350128198403194910', '林海晖', '陈必武', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'pull', '22011041465481', '13632254864');
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (2, 'exchange_qualified', 'driver', '440103198408241530', null, '林海晖', null, to_date('13-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'postOrPull', '220110413342564', '13632254864');
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (31, 'exchange_plate', 'agent', '440103198408241530', '350128198403194910', '林海晖', '陈必武', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'cash', 'post', '22011041484680', '13632254864');
insert into SELF_TRANSACT_DRIVER (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE)
values (32, 'exchange_plate', 'driver', '440103198408241530', null, '林海晖', null, to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'cash', 'pull', '22011041497809', '13632254864');
commit;
prompt 13 records loaded
prompt Loading SELF_TRANSACT_VEHICLE...
insert into SELF_TRANSACT_VEHICLE (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE, REASON, PAY_IND, PRINT_IND)
values (2, 'exchange_driver_license', 'agent', '440103198408241530', '350128198403194910', '林海晖', '陈必武', to_date('13-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'postOrPull', '120110413342564', '13632254864', null, null, null);
insert into SELF_TRANSACT_VEHICLE (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE, REASON, PAY_IND, PRINT_IND)
values (21, 'lost_driver_license', 'driver', '440103198408241530', null, '林海晖', null, to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'postOrPull', '120110414342564', '13632254864', null, null, null);
insert into SELF_TRANSACT_VEHICLE (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE, REASON, PAY_IND, PRINT_IND)
values (1, 'destroy_driver_license', 'agent', '440103198408241530', '350128198403194910', '林海晖', '陈必武', to_date('13-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'cash', 'post', '120110413342564', '13632254864', null, null, null);
insert into SELF_TRANSACT_VEHICLE (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE, REASON, PAY_IND, PRINT_IND)
values (22, 'exchange_plate', 'agent', '440103198408241530', '350128198403194910', '林海晖', '陈必武', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'cash', 'postOrPull', '22011041493558', '13632254864', null, null, null);
insert into SELF_TRANSACT_VEHICLE (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE, REASON, PAY_IND, PRINT_IND)
values (23, 'exchange_plate', 'agent', '440103198408241530', '350128198403194910', '林海晖', '陈必武', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'pull', '220110414004652', '13632254864', null, null, null);
insert into SELF_TRANSACT_VEHICLE (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE, REASON, PAY_IND, PRINT_IND)
values (24, 'exchange_vehicle_license', 'agent', '440103198408241530', '350128198403194910', '林海晖', '陈必武', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'post', '220110414002054', '13632254864', null, null, null);
insert into SELF_TRANSACT_VEHICLE (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE, REASON, PAY_IND, PRINT_IND)
values (25, 'exchange_plate', 'driver', '440103198408241530', null, '林海晖', null, to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'cash', 'post', '220110414044599', '13632254864', null, null, null);
insert into SELF_TRANSACT_VEHICLE (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE, REASON, PAY_IND, PRINT_IND)
values (26, 'exchange_qualified', 'driver', '440103198408241530', null, '林海晖', null, to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'post', '220110414096167', '13632254864', null, null, null);
insert into SELF_TRANSACT_VEHICLE (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE, REASON, PAY_IND, PRINT_IND)
values (27, 'exchange_qualified', 'driver', '440103198408241530', null, '林海晖', null, to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'post', '220110414003238', '13632254864', null, null, null);
insert into SELF_TRANSACT_VEHICLE (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE, REASON, PAY_IND, PRINT_IND)
values (28, 'exchange_vehicle_license', 'driver', '440103198408241530', null, '林海晖', null, to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'cash', 'pull', '220110414016756', '13632254864', 'G', null, null);
insert into SELF_TRANSACT_VEHICLE (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE, REASON, PAY_IND, PRINT_IND)
values (29, 'exchange_qualified', 'driver', '440103198408241530', null, '林海晖', null, to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'pull', '220110414043566', '13632254864', 'A', null, null);
insert into SELF_TRANSACT_VEHICLE (ID, TRANSACT, APPLICAT, DRIVER_ID_NO, AGENT_ID_NO, DRIVER_ID_NAME, AGENT_ID_NAME, CREATE_DATE, VERIFY_DATE, VERIFY_IND, TEL, VERIFYER_FK, REMARK, PAYMENT, RECEIVE, FLOW_NO, PHONE, REASON, PAY_IND, PRINT_IND)
values (30, 'exchange_vehicle_license', 'agent', '440103198408241530', '350128198403194910', '林海晖', '陈必武', to_date('14-04-2011', 'dd-mm-yyyy'), null, null, '52442114', null, null, 'pos', 'postOrPull', '220110414037796', '13632254864', 'G', null, null);
commit;
prompt 12 records loaded
prompt Loading VEHICLE...
insert into VEHICLE (XH, HPZL, HPHM, CLPP1, CLXH, CLPP2, GCJK, ZZG, ZZCMC, CLSBDH, FDJH, CLLX, CSYS, SYXZ, SFZMHM, SFZMMC, SYR, ZSXZQH, ZSXXDZ, YZBM1, LXDH, ZZZ, ZZXZQH, ZZXXDZ, YZBM2, SYQ, CCDJRQ, DJRQ, YXQZ, QZBFQZ, FZJG, GLBM, FPRQ, FZRQ, FDJRQ, FHGZRQ, BXZZRQ, BPCS, BZCS, BDJCS, DJZSBH, ZDJZSHS, DABH, XZQH, ZT, ZDYZT, DYBJ, JBR, CLLY, LSH, FDJXH, RLZL, PL, GL, ZXXS, CWKC, CWKK, CWKG, HXNBCD, HXNBKD, HXNBGD, GBTHPS, ZS, ZJ, QLJ, HLJ, LTGG, LTS, ZZL, ZBZL, HDZZL, HDZK, ZQYZL, QPZK, HPZK, HBDBQK, CCRQ, HDFS, LLPZ1, PZBH1, LLPZ2, PZBH2, XSDW, XSJG, XSRQ, JKPZ, JKPZHM, HGZBH, NSZM, NSZMBH, GXRQ, XGZL, QMBH, HMBH, BZ, JYW, YXH)
values ('34667431      ', '2 ', '湘C 32873', null, '5', null, null, null, null, null, null, null, null, null, '440103198408241530', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, to_date('11-04-2011', 'dd-mm-yyyy'), to_date('19-04-2011', 'dd-mm-yyyy'), null, null, null, 2, 5, null, null, null, null, null, '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
insert into VEHICLE (XH, HPZL, HPHM, CLPP1, CLXH, CLPP2, GCJK, ZZG, ZZCMC, CLSBDH, FDJH, CLLX, CSYS, SYXZ, SFZMHM, SFZMMC, SYR, ZSXZQH, ZSXXDZ, YZBM1, LXDH, ZZZ, ZZXZQH, ZZXXDZ, YZBM2, SYQ, CCDJRQ, DJRQ, YXQZ, QZBFQZ, FZJG, GLBM, FPRQ, FZRQ, FDJRQ, FHGZRQ, BXZZRQ, BPCS, BZCS, BDJCS, DJZSBH, ZDJZSHS, DABH, XZQH, ZT, ZDYZT, DYBJ, JBR, CLLY, LSH, FDJXH, RLZL, PL, GL, ZXXS, CWKC, CWKK, CWKG, HXNBCD, HXNBKD, HXNBGD, GBTHPS, ZS, ZJ, QLJ, HLJ, LTGG, LTS, ZZL, ZBZL, HDZZL, HDZK, ZQYZL, QPZK, HPZK, HBDBQK, CCRQ, HDFS, LLPZ1, PZBH1, LLPZ2, PZBH2, XSDW, XSJG, XSRQ, JKPZ, JKPZHM, HGZBH, NSZM, NSZMBH, GXRQ, XGZL, QMBH, HMBH, BZ, JYW, YXH)
values ('34235462      ', '1 ', '粤A 34323', null, '4', null, null, null, null, null, null, null, null, null, '440103198408241530', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, to_date('28-04-2011', 'dd-mm-yyyy'), to_date('18-04-2011', 'dd-mm-yyyy'), null, null, null, 4, 1, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
commit;
prompt 2 records loaded
prompt Loading VEH_FLOW...
insert into VEH_FLOW (LSH, XH, YWLX, YWYY, SYR, CLSBDH, HPZL, HPHM, CLPP1, CLXH, CLLX, XZQH, SQRQ, BJRQ, XYGW, YWLC, LSZT, GLBM, FPBJ, FFBJ, RKBJ)
values ('1                   ', '34667431      ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
insert into VEH_FLOW (LSH, XH, YWLX, YWYY, SYR, CLSBDH, HPZL, HPHM, CLPP1, CLXH, CLLX, XZQH, SQRQ, BJRQ, XYGW, YWLC, LSZT, GLBM, FPBJ, FFBJ, RKBJ)
values ('220110414096167     ', '34667431      ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
insert into VEH_FLOW (LSH, XH, YWLX, YWYY, SYR, CLSBDH, HPZL, HPHM, CLPP1, CLXH, CLLX, XZQH, SQRQ, BJRQ, XYGW, YWLC, LSZT, GLBM, FPBJ, FFBJ, RKBJ)
values ('220110414003238     ', '34667431      ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
insert into VEH_FLOW (LSH, XH, YWLX, YWYY, SYR, CLSBDH, HPZL, HPHM, CLPP1, CLXH, CLLX, XZQH, SQRQ, BJRQ, XYGW, YWLC, LSZT, GLBM, FPBJ, FFBJ, RKBJ)
values ('220110414016756     ', '34667431      ', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
insert into VEH_FLOW (LSH, XH, YWLX, YWYY, SYR, CLSBDH, HPZL, HPHM, CLPP1, CLXH, CLLX, XZQH, SQRQ, BJRQ, XYGW, YWLC, LSZT, GLBM, FPBJ, FFBJ, RKBJ)
values ('220110414043566     ', '34235462      ', null, 'A', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
insert into VEH_FLOW (LSH, XH, YWLX, YWYY, SYR, CLSBDH, HPZL, HPHM, CLPP1, CLXH, CLLX, XZQH, SQRQ, BJRQ, XYGW, YWLC, LSZT, GLBM, FPBJ, FFBJ, RKBJ)
values ('220110414037796     ', '34235462      ', null, 'G', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
commit;
prompt 6 records loaded
prompt Enabling triggers for DRIVINGLICENSE...
alter table DRIVINGLICENSE enable all triggers;
prompt Enabling triggers for DRV_FLOW...
alter table DRV_FLOW enable all triggers;
prompt Enabling triggers for PERSON...
alter table PERSON enable all triggers;
prompt Enabling triggers for SELF_TRANSACT_DRIVER...
alter table SELF_TRANSACT_DRIVER enable all triggers;
prompt Enabling triggers for SELF_TRANSACT_VEHICLE...
alter table SELF_TRANSACT_VEHICLE enable all triggers;
prompt Enabling triggers for VEHICLE...
alter table VEHICLE enable all triggers;
prompt Enabling triggers for VEH_FLOW...
alter table VEH_FLOW enable all triggers;
set feedback on
set define on
prompt Done.
