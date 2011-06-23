package com.ett.drv.mapper.admin;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.smartken.kia.core.model.IMapper;

public interface IBusAllInfoMapper<T> extends IMapper<T>{

	public List selectGroupByOperaction(@Param("startDate")Date startDate,@Param("endDates")Date endDate) throws Exception;
	
	public List selectGroupByHospital(@Param("startDate")Date startDate,@Param("endDates")Date endDate) throws Exception;
	
}
