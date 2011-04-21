package com.ett.self.preasign.biz;

import java.text.ParseException;
import java.util.Date;

import com.ett.model.DrvUser;
import com.ett.self.ISelfBiz;
import com.ett.self.model.PrintObject;
import com.ett.self.model.SelfDeviceObject;
import com.ett.self.preasign.model.Km1CheckRecord;
import com.ett.self.preasign.model.Km1PreasignRecord;

/**
 * @author austin
 * 自助终端预约的业务类
 */
public interface IPreasignBiz extends ISelfBiz {
	
	
	/**
	 * @param idcard 身份证明号码
	 * @param ksdd 考场代码
	 * @return 是否预约过今天的
	 */
	public PrintObject getPrintObject(String idcard,String ksdd,Date ykrq) throws ParseException;
	
	/**
	 * @param idcard 身份证明号码
	 * @param ksdd 考场代码
	 * @param ykrq 约考日期
	 * @return 是否已经签到过
	 * @throws ParseException
	 */
	public boolean getChecked(String idcard,String ksdd,Date ykrq) throws ParseException;
	
	public void createKm1CheckRecord(DrvUser user,SelfDeviceObject device);

	
	
	public void  createPreasignKm1(DrvUser user,SelfDeviceObject device,Date date,String ksddCode) throws ParseException ;


}
