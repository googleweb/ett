package com.ett.drv.model.preinput;

import java.io.IOException;

import org.json.JSONObject;

import com.smartken.kia.core.model.impl.BaseModel;
import com.smartken.kia.core.util.FileUtil;

public class StudentApplyInfoModel extends BaseModel {

	
	public static enum F { 
		  Id,Sfzmhm,Sfzmmc,IHmcd,IXb,CCsrq,CGj,CDjzsxzqh,CDjzsxxdz,CLxzsxzqh,CLxzsxxdz,
		CLxzsyzbm,CLy,CXzqh,CLxdh,CZzzm,CZkzmbh,CDabh,CZkcx,CJxmc,CDzyx,
		CSjhm,CSg,IZsl,IYsl,IBsl,ITl,ISz,IZxz,IYxz,IQgjb,
		CTjrq,CTjyymc,CPhotoSrc,BlobPhoto,IPhotoSyn,CJxdm,CLsh,CXm,CCheckResult,CCheckOperator,
		CCheckDate,IChecked,CPhotoSyn  
		 } 

		private Integer Id;         //ID  NUMBER 38
		private String Sfzmhm;         //SFZMHM  VARCHAR2 18
		private String Sfzmmc;         //SFZMMC  VARCHAR2 6
		private Integer IHmcd;         //I_HMCD  NUMBER 38
		private Integer IXb;         //I_XB  NUMBER 38
		private String CCsrq;         //C_CSRQ  VARCHAR2 10
		private String CGj;         //C_GJ  VARCHAR2 20
		private String CDjzsxzqh;         //C_DJZSXZQH  VARCHAR2 20
		private String CDjzsxxdz;         //C_DJZSXXDZ  VARCHAR2 200
		private String CLxzsxzqh;         //C_LXZSXZQH  VARCHAR2 20
		private String CLxzsxxdz;         //C_LXZSXXDZ  VARCHAR2 200
		private String CLxzsyzbm;         //C_LXZSYZBM  VARCHAR2 20
		private String CLy;         //C_LY  VARCHAR2 20
		private String CXzqh;         //C_XZQH  VARCHAR2 20
		private String CLxdh;         //C_LXDH  VARCHAR2 20
		private String CZzzm;         //C_ZZZM  VARCHAR2 20
		private String CZkzmbh;         //C_ZKZMBH  VARCHAR2 20
		private String CDabh;         //C_DABH  VARCHAR2 20
		private String CZkcx;         //C_ZKCX  VARCHAR2 20
		private String CJxmc;         //C_JXMC  VARCHAR2 200
		private String CDzyx;         //C_DZYX  VARCHAR2 60
		private String CSjhm;         //C_SJHM  VARCHAR2 20
		private String CSg;         //C_SG  VARCHAR2 20
		private String IZsl;         //I_ZSL  VARCHAR2 20
		private String IYsl;         //I_YSL  VARCHAR2 20
		private Integer IBsl;         //I_BSL  NUMBER 38
		private Integer ITl;         //I_TL  NUMBER 38
		private Integer ISz;         //I_SZ  NUMBER 38
		private Integer IZxz;         //I_ZXZ  NUMBER 38
		private Integer IYxz;         //I_YXZ  NUMBER 38
		private Integer IQgjb;         //I_QGJB  NUMBER 38
		private String CTjrq;         //C_TJRQ  VARCHAR2 10
		private String CTjyymc;         //C_TJYYMC  VARCHAR2 200
		private String CPhotoSrc;         //C_PHOTO_SRC  VARCHAR2 200
		private byte[] BlobPhoto;         //BLOB_PHOTO  BLOB 100
		private Integer IPhotoSyn;         //I_PHOTO_SYN  NUMBER 38
		private String CJxdm;         //C_JXDM  VARCHAR2 30
		private String CLsh;         //C_LSH  VARCHAR2 100
		private String CXm;         //C_XM  VARCHAR2 30
		private String CCheckResult;         //C_CHECK_RESULT  VARCHAR2 4,000
		private String CCheckOperator;         //C_CHECK_OPERATOR  VARCHAR2 30
		private String CCheckDate;         //C_CHECK_DATE  VARCHAR2 30
		private Integer IChecked;         //I_CHECKED  NUMBER 38
		private Integer CPhotoSyn;         //C_PHOTO_SYN  NUMBER 38
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getSfzmhm() {
			return Sfzmhm;
		}
		public void setSfzmhm(String sfzmhm) {
			Sfzmhm = sfzmhm;
		}
		public String getSfzmmc() {
			return Sfzmmc;
		}
		public void setSfzmmc(String sfzmmc) {
			Sfzmmc = sfzmmc;
		}
		public Integer getIHmcd() {
			return IHmcd;
		}
		public void setIHmcd(Integer iHmcd) {
			IHmcd = iHmcd;
		}
		public Integer getIXb() {
			return IXb;
		}
		public void setIXb(Integer iXb) {
			IXb = iXb;
		}
		public String getCCsrq() {
			return CCsrq;
		}
		public void setCCsrq(String cCsrq) {
			CCsrq = cCsrq;
		}
		public String getCGj() {
			return CGj;
		}
		public void setCGj(String cGj) {
			CGj = cGj;
		}
		public String getCDjzsxzqh() {
			return CDjzsxzqh;
		}
		public void setCDjzsxzqh(String cDjzsxzqh) {
			CDjzsxzqh = cDjzsxzqh;
		}
		public String getCDjzsxxdz() {
			return CDjzsxxdz;
		}
		public void setCDjzsxxdz(String cDjzsxxdz) {
			CDjzsxxdz = cDjzsxxdz;
		}
		public String getCLxzsxzqh() {
			return CLxzsxzqh;
		}
		public void setCLxzsxzqh(String cLxzsxzqh) {
			CLxzsxzqh = cLxzsxzqh;
		}
		public String getCLxzsxxdz() {
			return CLxzsxxdz;
		}
		public void setCLxzsxxdz(String cLxzsxxdz) {
			CLxzsxxdz = cLxzsxxdz;
		}
		public String getCLxzsyzbm() {
			return CLxzsyzbm;
		}
		public void setCLxzsyzbm(String cLxzsyzbm) {
			CLxzsyzbm = cLxzsyzbm;
		}
		public String getCLy() {
			return CLy;
		}
		public void setCLy(String cLy) {
			CLy = cLy;
		}
		public String getCXzqh() {
			return CXzqh;
		}
		public void setCXzqh(String cXzqh) {
			CXzqh = cXzqh;
		}
		public String getCLxdh() {
			return CLxdh;
		}
		public void setCLxdh(String cLxdh) {
			CLxdh = cLxdh;
		}
		public String getCZzzm() {
			return CZzzm;
		}
		public void setCZzzm(String cZzzm) {
			CZzzm = cZzzm;
		}
		public String getCZkzmbh() {
			return CZkzmbh;
		}
		public void setCZkzmbh(String cZkzmbh) {
			CZkzmbh = cZkzmbh;
		}
		public String getCDabh() {
			return CDabh;
		}
		public void setCDabh(String cDabh) {
			CDabh = cDabh;
		}
		public String getCZkcx() {
			return CZkcx;
		}
		public void setCZkcx(String cZkcx) {
			CZkcx = cZkcx;
		}
		public String getCJxmc() {
			return CJxmc;
		}
		public void setCJxmc(String cJxmc) {
			CJxmc = cJxmc;
		}
		public String getCDzyx() {
			return CDzyx;
		}
		public void setCDzyx(String cDzyx) {
			CDzyx = cDzyx;
		}
		public String getCSjhm() {
			return CSjhm;
		}
		public void setCSjhm(String cSjhm) {
			CSjhm = cSjhm;
		}
		public String getCSg() {
			return CSg;
		}
		public void setCSg(String cSg) {
			CSg = cSg;
		}
		public String getIZsl() {
			return IZsl;
		}
		public void setIZsl(String iZsl) {
			IZsl = iZsl;
		}
		public String getIYsl() {
			return IYsl;
		}
		public void setIYsl(String iYsl) {
			IYsl = iYsl;
		}
		public Integer getIBsl() {
			return IBsl;
		}
		public void setIBsl(Integer iBsl) {
			IBsl = iBsl;
		}
		public Integer getITl() {
			return ITl;
		}
		public void setITl(Integer iTl) {
			ITl = iTl;
		}
		public Integer getISz() {
			return ISz;
		}
		public void setISz(Integer iSz) {
			ISz = iSz;
		}
		public Integer getIZxz() {
			return IZxz;
		}
		public void setIZxz(Integer iZxz) {
			IZxz = iZxz;
		}
		public Integer getIYxz() {
			return IYxz;
		}
		public void setIYxz(Integer iYxz) {
			IYxz = iYxz;
		}
		public Integer getIQgjb() {
			return IQgjb;
		}
		public void setIQgjb(Integer iQgjb) {
			IQgjb = iQgjb;
		}
		public String getCTjrq() {
			return CTjrq;
		}
		public void setCTjrq(String cTjrq) {
			CTjrq = cTjrq;
		}
		public String getCTjyymc() {
			return CTjyymc;
		}
		public void setCTjyymc(String cTjyymc) {
			CTjyymc = cTjyymc;
		}
		public String getCPhotoSrc() {
			return CPhotoSrc;
		}
		public void setCPhotoSrc(String cPhotoSrc) {
			CPhotoSrc = cPhotoSrc;
		}
		public byte[] getBlobPhoto() {
			return BlobPhoto;
		}
		public void setBlobPhoto(byte[] blobPhoto) {
			BlobPhoto = blobPhoto;
		}
		public Integer getIPhotoSyn() {
			return IPhotoSyn;
		}
		public void setIPhotoSyn(Integer iPhotoSyn) {
			IPhotoSyn = iPhotoSyn;
		}
		public String getCJxdm() {
			return CJxdm;
		}
		public void setCJxdm(String cJxdm) {
			CJxdm = cJxdm;
		}
		public String getCLsh() {
			return CLsh;
		}
		public void setCLsh(String cLsh) {
			CLsh = cLsh;
		}
		public String getCXm() {
			return CXm;
		}
		public void setCXm(String cXm) {
			CXm = cXm;
		}
		public String getCCheckResult() {
			return CCheckResult;
		}
		public void setCCheckResult(String cCheckResult) {
			CCheckResult = cCheckResult;
		}
		public String getCCheckOperator() {
			return CCheckOperator;
		}
		public void setCCheckOperator(String cCheckOperator) {
			CCheckOperator = cCheckOperator;
		}
		public String getCCheckDate() {
			return CCheckDate;
		}
		public void setCCheckDate(String cCheckDate) {
			CCheckDate = cCheckDate;
		}
		public Integer getIChecked() {
			return IChecked;
		}
		public void setIChecked(Integer iChecked) {
			IChecked = iChecked;
		}
		public Integer getCPhotoSyn() {
			return CPhotoSyn;
		}
		public void setCPhotoSyn(Integer cPhotoSyn) {
			CPhotoSyn = cPhotoSyn;
		}
		
		
		

	
}
