package com.ett.drv.model.booked;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.smartken.kia.core.util.DateTimeUtil;
import com.smartken.kia.core.util.ObjectUtil;
import com.smartken.kia.core.model.impl.BaseModel;

public class BookedWeekRecordModel extends BaseModel{

	public static int CHECKED_UNVAILDATE=0;
	public static int CHECKED_VAILDATE=1;
	
	
	public static enum F{
		id,weekNum,week1Km1Num,week1Km1Fp,week1Km2Num,week1Km2Fp,week1Km3Num,week1Km3Fp,week2Km1Num,week2Km1Fp,week2Km2Num,
		week2Km2Fp,week2Km3Num,week2Km3Fp,week3Km1Num,week3Km1Fp,week3Km2Num,week3Km2Fp,week3Km3Num,week3Km3Fp,week4Km1Num,
		week4Km1Fp,week4Km2Num,week4Km2Fp,week4Km3Num,week4Km3Fp,week5Km1Num,week5Km1Fp,week5Km2Num,week5Km2Fp,week5Km3Num,
		week5Km3Fp,week6Km1Num,week6Km1Fp,week6Km2Num,week6Km2Fp,week6Km3Num,week6Km3Fp,week7Km1Num,week7Km1Fp,week7Km2Num,
		week7Km2Fp,week7Km3Num,week7Km3Fp,checkOperator,checkDate,checked,weekRange
	}
	
	private Integer id;         //ID  NUMBER 38
	private Integer weekNum;         //I_WEEK_NUM  NUMBER 38
	private Integer week1Km1Num;         //I_WEEK1_KM1_NUM  NUMBER 38
	private String week1Km1Fp;         //I_WEEK1_KM1_FP  VARCHAR2 600
	private Integer week1Km2Num;         //I_WEEK1_KM2_NUM  NUMBER 38
	private String week1Km2Fp;         //I_WEEK1_KM2_FP  VARCHAR2 600
	private Integer week1Km3Num;         //I_WEEK1_KM3_NUM  NUMBER 38
	private String week1Km3Fp;         //I_WEEK1_KM3_FP  VARCHAR2 600
	private Integer week2Km1Num;         //I_WEEK2_KM1_NUM  NUMBER 38
	private String week2Km1Fp;         //I_WEEK2_KM1_FP  VARCHAR2 600
	private Integer week2Km2Num;         //I_WEEK2_KM2_NUM  NUMBER 38
	private String week2Km2Fp;         //I_WEEK2_KM2_FP  VARCHAR2 600
	private Integer week2Km3Num;         //I_WEEK2_KM3_NUM  NUMBER 38
	private String week2Km3Fp;         //I_WEEK2_KM3_FP  VARCHAR2 600
	private Integer week3Km1Num;         //I_WEEK3_KM1_NUM  NUMBER 38
	private String week3Km1Fp;         //I_WEEK3_KM1_FP  VARCHAR2 600
	private Integer week3Km2Num;         //I_WEEK3_KM2_NUM  NUMBER 38
	private String week3Km2Fp;         //I_WEEK3_KM2_FP  VARCHAR2 600
	private Integer week3Km3Num;         //I_WEEK3_KM3_NUM  NUMBER 38
	private String week3Km3Fp;         //I_WEEK3_KM3_FP  VARCHAR2 600
	private Integer week4Km1Num;         //I_WEEK4_KM1_NUM  NUMBER 38
	private String week4Km1Fp;         //I_WEEK4_KM1_FP  VARCHAR2 600
	private Integer week4Km2Num;         //I_WEEK4_KM2_NUM  NUMBER 38
	private String week4Km2Fp;         //I_WEEK4_KM2_FP  VARCHAR2 600
	private Integer week4Km3Num;         //I_WEEK4_KM3_NUM  NUMBER 38
	private String week4Km3Fp;         //I_WEEK4_KM3_FP  VARCHAR2 600
	private Integer week5Km1Num;         //I_WEEK5_KM1_NUM  NUMBER 38
	private String week5Km1Fp;         //I_WEEK5_KM1_FP  VARCHAR2 600
	private Integer week5Km2Num;         //I_WEEK5_KM2_NUM  NUMBER 38
	private String week5Km2Fp;         //I_WEEK5_KM2_FP  VARCHAR2 600
	private Integer week5Km3Num;         //I_WEEK5_KM3_NUM  NUMBER 38
	private String week5Km3Fp;         //I_WEEK5_KM3_FP  VARCHAR2 600
	private Integer week6Km1Num;         //I_WEEK6_KM1_NUM  NUMBER 38
	private String week6Km1Fp;         //I_WEEK6_KM1_FP  VARCHAR2 600
	private Integer week6Km2Num;         //I_WEEK6_KM2_NUM  NUMBER 38
	private String week6Km2Fp;         //I_WEEK6_KM2_FP  VARCHAR2 600
	private Integer week6Km3Num;         //I_WEEK6_KM3_NUM  NUMBER 38
	private String week6Km3Fp;         //I_WEEK6_KM3_FP  VARCHAR2 600
	private Integer week7Km1Num;         //I_WEEK7_KM1_NUM  NUMBER 38
	private String week7Km1Fp;         //I_WEEK7_KM1_FP  VARCHAR2 600
	private Integer week7Km2Num;         //I_WEEK7_KM2_NUM  NUMBER 38
	private String week7Km2Fp;         //I_WEEK7_KM2_FP  VARCHAR2 600
	private Integer week7Km3Num;         //I_WEEK7_KM3_NUM  NUMBER 38
	private String week7Km3Fp;         //I_WEEK7_KM3_FP  VARCHAR2 600
	private String checkOperator;         //C_CHECK_OPERATOR  VARCHAR2 60
	private String checkDate;         //C_CHECK_DATE  VARCHAR2 30
	private Integer checked;         //I_CHECKED  NUMBER 38
	private String weekRange;         //C_WEEK_RANGE  VARCHAR2 60
	
	
	private Integer year;
	private Integer week1Km1Assgined=0;
	private Integer week1Km2Assgined=0;
	private Integer week1Km3Assgined=0;
	private Integer week2Km1Assgined=0;
	private Integer week2Km2Assgined=0;
	private Integer week2Km3Assgined=0;
	private Integer week3Km1Assgined=0;
	private Integer week3Km2Assgined=0;
	private Integer week3Km3Assgined=0;
	private Integer week4Km1Assgined=0;
	private Integer week4Km2Assgined=0;
	private Integer week4Km3Assgined=0;
	private Integer week5Km1Assgined=0;
	private Integer week5Km2Assgined=0;
	private Integer week5Km3Assgined=0;
	private Integer week6Km1Assgined=0;
	private Integer week6Km2Assgined=0;
	private Integer week6Km3Assgined=0;
	private Integer week7Km1Assgined=0;
	private Integer week7Km2Assgined=0;
	private Integer week7Km3Assgined=0;

	private Date monday;
	private Date tuesday;
	private Date wednesday;
	private Date thursday;
	private Date friday;
	private Date saturday;
	private Date sunday;
	
	private Map<String, BookedLimitModel> limits;
	
	public Object generalPK() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	private void loadWeekDays()
	{
		if(this.weekNum==null||this.year==null)return;
		ArrayList<Date> lWeekDays= DateTimeUtil.getWeekDays(this.year, this.weekNum);
		this.monday=lWeekDays.get(DateTimeUtil.MONDAY);
		this.tuesday=lWeekDays.get(DateTimeUtil.TUESDAY);
		this.wednesday=lWeekDays.get(DateTimeUtil.WEDNESDAY);
		this.thursday=lWeekDays.get(DateTimeUtil.THURSDAY);
		this.friday=lWeekDays.get(DateTimeUtil.FRIDAY);
		this.saturday=lWeekDays.get(DateTimeUtil.SATURDAY);
		this.sunday=lWeekDays.get(DateTimeUtil.SUNDAY);
	}






	



	public Date getMonday() {
		return monday;
	}

	public Date getTuesday() {
		return tuesday;
	}

	public Date getWednesday() {
		return wednesday;
	}

	public Date getThursday() {
		return thursday;
	}

	public Date getFriday() {
		return friday;
	}

	public Date getSaturday() {
		return saturday;
	}

	public Date getSunday() {
		return sunday;
	}




	public Integer getYear() {
		return year;
	}
	
	private void clearAssigned()
	{
		this.week1Km1Assgined=0;
		this.week1Km2Assgined=0;
		this.week1Km3Assgined=0;
		
		this.week2Km1Assgined=0;
		this.week2Km2Assgined=0;
		this.week2Km3Assgined=0;
		
		this.week3Km1Assgined=0;
		this.week3Km2Assgined=0;
		this.week3Km3Assgined=0;
		
		this.week4Km1Assgined=0;
		this.week4Km2Assgined=0;
		this.week4Km3Assgined=0;
		
		this.week5Km1Assgined=0;
		this.week5Km2Assgined=0;
		this.week5Km3Assgined=0;
		
		this.week6Km1Assgined=0;
		this.week6Km2Assgined=0;
		this.week6Km3Assgined=0;
		
		this.week7Km1Assgined=0;
		this.week7Km2Assgined=0;
		this.week7Km3Assgined=0;
		

	}
	
	public void calLimitAssgined()
	{
		if(this.limits==null)return;
		Map<String, BookedLimitModel> mapLimt =this.limits;
		this.clearAssigned();
		for(Iterator<String> itKey=mapLimt.keySet().iterator();itKey.hasNext();)
		{
			String tempKey=itKey.next();
			BookedLimitModel tempLimit=mapLimt.get(tempKey);
			int dow=tempLimit.getDayofweek();
			int km=tempLimit.getKm();
			String assignName=MessageFormat.format("week{0}Km{1}Assgined", dow,km);
			try {
				int assgin= Integer.parseInt(this.eval(assignName).toString()); 
				assgin+=tempLimit.getTotal();
				this.eval(assignName, assgin);
			} catch (Exception e) {System.err.println(e.getMessage());}		
			
		}
			
	}

	public Map<String, BookedLimitModel> getLimits() {
		return limits;
	}

	
	


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public void setLimits(Map<String, BookedLimitModel> limits) {
		this.limits = limits;
	}


	public Integer getWeekNum() {
		return weekNum;
	}



	public void setWeekNum(Integer weekNum) {
		this.weekNum = weekNum;
		this.loadWeekDays();
	}



	public Integer getWeek1Km1Num() {
		return week1Km1Num;
	}



	public void setWeek1Km1Num(Integer week1Km1Num) {
		this.week1Km1Num = week1Km1Num;
	}



	public String getWeek1Km1Fp() {
		return week1Km1Fp;
	}



	public void setWeek1Km1Fp(String week1Km1Fp) {
		this.week1Km1Fp = week1Km1Fp;
	}



	public Integer getWeek1Km2Num() {
		return week1Km2Num;
	}



	public void setWeek1Km2Num(Integer week1Km2Num) {
		this.week1Km2Num = week1Km2Num;
	}



	public String getWeek1Km2Fp() {
		return week1Km2Fp;
	}



	public void setWeek1Km2Fp(String week1Km2Fp) {
		this.week1Km2Fp = week1Km2Fp;
	}



	public Integer getWeek1Km3Num() {
		return week1Km3Num;
	}



	public void setWeek1Km3Num(Integer week1Km3Num) {
		this.week1Km3Num = week1Km3Num;
	}



	public String getWeek1Km3Fp() {
		return week1Km3Fp;
	}



	public void setWeek1Km3Fp(String week1Km3Fp) {
		this.week1Km3Fp = week1Km3Fp;
	}



	public Integer getWeek2Km1Num() {
		return week2Km1Num;
	}



	public void setWeek2Km1Num(Integer week2Km1Num) {
		this.week2Km1Num = week2Km1Num;
	}



	public String getWeek2Km1Fp() {
		return week2Km1Fp;
	}



	public void setWeek2Km1Fp(String week2Km1Fp) {
		this.week2Km1Fp = week2Km1Fp;
	}



	public Integer getWeek2Km2Num() {
		return week2Km2Num;
	}



	public void setWeek2Km2Num(Integer week2Km2Num) {
		this.week2Km2Num = week2Km2Num;
	}



	public String getWeek2Km2Fp() {
		return week2Km2Fp;
	}



	public void setWeek2Km2Fp(String week2Km2Fp) {
		this.week2Km2Fp = week2Km2Fp;
	}



	public Integer getWeek2Km3Num() {
		return week2Km3Num;
	}



	public void setWeek2Km3Num(Integer week2Km3Num) {
		this.week2Km3Num = week2Km3Num;
	}



	public String getWeek2Km3Fp() {
		return week2Km3Fp;
	}



	public void setWeek2Km3Fp(String week2Km3Fp) {
		this.week2Km3Fp = week2Km3Fp;
	}



	public Integer getWeek3Km1Num() {
		return week3Km1Num;
	}



	public void setWeek3Km1Num(Integer week3Km1Num) {
		this.week3Km1Num = week3Km1Num;
	}



	public String getWeek3Km1Fp() {
		return week3Km1Fp;
	}



	public void setWeek3Km1Fp(String week3Km1Fp) {
		this.week3Km1Fp = week3Km1Fp;
	}



	public Integer getWeek3Km2Num() {
		return week3Km2Num;
	}



	public void setWeek3Km2Num(Integer week3Km2Num) {
		this.week3Km2Num = week3Km2Num;
	}



	public String getWeek3Km2Fp() {
		return week3Km2Fp;
	}



	public void setWeek3Km2Fp(String week3Km2Fp) {
		this.week3Km2Fp = week3Km2Fp;
	}



	public Integer getWeek3Km3Num() {
		return week3Km3Num;
	}



	public void setWeek3Km3Num(Integer week3Km3Num) {
		this.week3Km3Num = week3Km3Num;
	}



	public String getWeek3Km3Fp() {
		return week3Km3Fp;
	}



	public void setWeek3Km3Fp(String week3Km3Fp) {
		this.week3Km3Fp = week3Km3Fp;
	}



	public Integer getWeek4Km1Num() {
		return week4Km1Num;
	}



	public void setWeek4Km1Num(Integer week4Km1Num) {
		this.week4Km1Num = week4Km1Num;
	}



	public String getWeek4Km1Fp() {
		return week4Km1Fp;
	}



	public void setWeek4Km1Fp(String week4Km1Fp) {
		this.week4Km1Fp = week4Km1Fp;
	}



	public Integer getWeek4Km2Num() {
		return week4Km2Num;
	}



	public void setWeek4Km2Num(Integer week4Km2Num) {
		this.week4Km2Num = week4Km2Num;
	}



	public String getWeek4Km2Fp() {
		return week4Km2Fp;
	}



	public void setWeek4Km2Fp(String week4Km2Fp) {
		this.week4Km2Fp = week4Km2Fp;
	}



	public Integer getWeek4Km3Num() {
		return week4Km3Num;
	}



	public void setWeek4Km3Num(Integer week4Km3Num) {
		this.week4Km3Num = week4Km3Num;
	}



	public String getWeek4Km3Fp() {
		return week4Km3Fp;
	}



	public void setWeek4Km3Fp(String week4Km3Fp) {
		this.week4Km3Fp = week4Km3Fp;
	}



	public Integer getWeek5Km1Num() {
		return week5Km1Num;
	}



	public void setWeek5Km1Num(Integer week5Km1Num) {
		this.week5Km1Num = week5Km1Num;
	}



	public String getWeek5Km1Fp() {
		return week5Km1Fp;
	}



	public void setWeek5Km1Fp(String week5Km1Fp) {
		this.week5Km1Fp = week5Km1Fp;
	}



	public Integer getWeek5Km2Num() {
		return week5Km2Num;
	}



	public void setWeek5Km2Num(Integer week5Km2Num) {
		this.week5Km2Num = week5Km2Num;
	}



	public String getWeek5Km2Fp() {
		return week5Km2Fp;
	}



	public void setWeek5Km2Fp(String week5Km2Fp) {
		this.week5Km2Fp = week5Km2Fp;
	}



	public Integer getWeek5Km3Num() {
		return week5Km3Num;
	}



	public void setWeek5Km3Num(Integer week5Km3Num) {
		this.week5Km3Num = week5Km3Num;
	}



	public String getWeek5Km3Fp() {
		return week5Km3Fp;
	}



	public void setWeek5Km3Fp(String week5Km3Fp) {
		this.week5Km3Fp = week5Km3Fp;
	}



	public Integer getWeek6Km1Num() {
		return week6Km1Num;
	}



	public void setWeek6Km1Num(Integer week6Km1Num) {
		this.week6Km1Num = week6Km1Num;
	}



	public String getWeek6Km1Fp() {
		return week6Km1Fp;
	}



	public void setWeek6Km1Fp(String week6Km1Fp) {
		this.week6Km1Fp = week6Km1Fp;
	}



	public Integer getWeek6Km2Num() {
		return week6Km2Num;
	}



	public void setWeek6Km2Num(Integer week6Km2Num) {
		this.week6Km2Num = week6Km2Num;
	}



	public String getWeek6Km2Fp() {
		return week6Km2Fp;
	}



	public void setWeek6Km2Fp(String week6Km2Fp) {
		this.week6Km2Fp = week6Km2Fp;
	}



	public Integer getWeek6Km3Num() {
		return week6Km3Num;
	}



	public void setWeek6Km3Num(Integer week6Km3Num) {
		this.week6Km3Num = week6Km3Num;
	}



	public String getWeek6Km3Fp() {
		return week6Km3Fp;
	}



	public void setWeek6Km3Fp(String week6Km3Fp) {
		this.week6Km3Fp = week6Km3Fp;
	}



	public Integer getWeek7Km1Num() {
		return week7Km1Num;
	}



	public void setWeek7Km1Num(Integer week7Km1Num) {
		this.week7Km1Num = week7Km1Num;
	}



	public String getWeek7Km1Fp() {
		return week7Km1Fp;
	}



	public void setWeek7Km1Fp(String week7Km1Fp) {
		this.week7Km1Fp = week7Km1Fp;
	}



	public Integer getWeek7Km2Num() {
		return week7Km2Num;
	}



	public void setWeek7Km2Num(Integer week7Km2Num) {
		this.week7Km2Num = week7Km2Num;
	}



	public String getWeek7Km2Fp() {
		return week7Km2Fp;
	}



	public void setWeek7Km2Fp(String week7Km2Fp) {
		this.week7Km2Fp = week7Km2Fp;
	}



	public Integer getWeek7Km3Num() {
		return week7Km3Num;
	}



	public void setWeek7Km3Num(Integer week7Km3Num) {
		this.week7Km3Num = week7Km3Num;
	}



	public String getWeek7Km3Fp() {
		return week7Km3Fp;
	}



	public void setWeek7Km3Fp(String week7Km3Fp) {
		this.week7Km3Fp = week7Km3Fp;
	}



	public String getCheckOperator() {
		return checkOperator;
	}



	public void setCheckOperator(String checkOperator) {
		this.checkOperator = checkOperator;
	}



	public String getCheckDate() {
		return checkDate;
	}



	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}



	public Integer getChecked() {
		return checked;
	}



	public void setChecked(Integer checked) {
		this.checked = checked;
	}



	public String getWeekRange() {
		return weekRange;
	}



	
	public void setWeekRange(String weekRange) {
		this.weekRange = weekRange;
		String lStrYear="";
		try{
		lStrYear=this.weekRange.substring(0,4);
		this.year=Integer.parseInt(lStrYear);
		}catch(Exception ex)
		{
			Calendar c=Calendar.getInstance();
			this.year=c.get(Calendar.YEAR);
		}finally
		{
			this.loadWeekDays();
		}
		
	}



	public Integer getWeek1Km1Assgined() {
		return week1Km1Assgined;
	}



	public Integer getWeek1Km2Assgined() {
		return week1Km2Assgined;
	}



	public Integer getWeek1Km3Assgined() {
		return week1Km3Assgined;
	}



	public Integer getWeek2Km1Assgined() {
		return week2Km1Assgined;
	}



	public Integer getWeek2Km2Assgined() {
		return week2Km2Assgined;
	}



	public Integer getWeek2Km3Assgined() {
		return week2Km3Assgined;
	}



	public Integer getWeek3Km1Assgined() {
		return week3Km1Assgined;
	}



	public Integer getWeek3Km2Assgined() {
		return week3Km2Assgined;
	}



	public Integer getWeek3Km3Assgined() {
		return week3Km3Assgined;
	}



	public Integer getWeek4Km1Assgined() {
		return week4Km1Assgined;
	}



	public Integer getWeek4Km2Assgined() {
		return week4Km2Assgined;
	}



	public Integer getWeek4Km3Assgined() {
		return week4Km3Assgined;
	}



	public Integer getWeek5Km1Assgined() {
		return week5Km1Assgined;
	}



	public Integer getWeek5Km2Assgined() {
		return week5Km2Assgined;
	}



	public Integer getWeek5Km3Assgined() {
		return week5Km3Assgined;
	}



	public Integer getWeek6Km1Assgined() {
		return week6Km1Assgined;
	}



	public Integer getWeek6Km2Assgined() {
		return week6Km2Assgined;
	}



	public Integer getWeek6Km3Assgined() {
		return week6Km3Assgined;
	}



	public Integer getWeek7Km1Assgined() {
		return week7Km1Assgined;
	}



	public Integer getWeek7Km2Assgined() {
		return week7Km2Assgined;
	}



	public Integer getWeek7Km3Assgined() {
		return week7Km3Assgined;
	}



	public void setWeek1Km1Assgined(Integer week1Km1Assgined) {
		this.week1Km1Assgined = week1Km1Assgined;
	}



	public void setWeek1Km2Assgined(Integer week1Km2Assgined) {
		this.week1Km2Assgined = week1Km2Assgined;
	}



	public void setWeek1Km3Assgined(Integer week1Km3Assgined) {
		this.week1Km3Assgined = week1Km3Assgined;
	}



	public void setWeek2Km1Assgined(Integer week2Km1Assgined) {
		this.week2Km1Assgined = week2Km1Assgined;
	}



	public void setWeek2Km2Assgined(Integer week2Km2Assgined) {
		this.week2Km2Assgined = week2Km2Assgined;
	}



	public void setWeek2Km3Assgined(Integer week2Km3Assgined) {
		this.week2Km3Assgined = week2Km3Assgined;
	}



	public void setWeek3Km1Assgined(Integer week3Km1Assgined) {
		this.week3Km1Assgined = week3Km1Assgined;
	}



	public void setWeek3Km2Assgined(Integer week3Km2Assgined) {
		this.week3Km2Assgined = week3Km2Assgined;
	}



	public void setWeek3Km3Assgined(Integer week3Km3Assgined) {
		this.week3Km3Assgined = week3Km3Assgined;
	}



	public void setWeek4Km1Assgined(Integer week4Km1Assgined) {
		this.week4Km1Assgined = week4Km1Assgined;
	}



	public void setWeek4Km2Assgined(Integer week4Km2Assgined) {
		this.week4Km2Assgined = week4Km2Assgined;
	}



	public void setWeek4Km3Assgined(Integer week4Km3Assgined) {
		this.week4Km3Assgined = week4Km3Assgined;
	}



	public void setWeek5Km1Assgined(Integer week5Km1Assgined) {
		this.week5Km1Assgined = week5Km1Assgined;
	}



	public void setWeek5Km2Assgined(Integer week5Km2Assgined) {
		this.week5Km2Assgined = week5Km2Assgined;
	}



	public void setWeek5Km3Assgined(Integer week5Km3Assgined) {
		this.week5Km3Assgined = week5Km3Assgined;
	}



	public void setWeek6Km1Assgined(Integer week6Km1Assgined) {
		this.week6Km1Assgined = week6Km1Assgined;
	}



	public void setWeek6Km2Assgined(Integer week6Km2Assgined) {
		this.week6Km2Assgined = week6Km2Assgined;
	}



	public void setWeek6Km3Assgined(Integer week6Km3Assgined) {
		this.week6Km3Assgined = week6Km3Assgined;
	}



	public void setWeek7Km1Assgined(Integer week7Km1Assgined) {
		this.week7Km1Assgined = week7Km1Assgined;
	}



	public void setWeek7Km2Assgined(Integer week7Km2Assgined) {
		this.week7Km2Assgined = week7Km2Assgined;
	}



	public void setWeek7Km3Assgined(Integer week7Km3Assgined) {
		this.week7Km3Assgined = week7Km3Assgined;
	}


   

	

	
	
	
    
}
