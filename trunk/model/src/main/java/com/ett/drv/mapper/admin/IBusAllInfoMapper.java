package com.ett.drv.mapper.admin;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;


import com.smartken.kia.core.model.IMapper;

public interface IBusAllInfoMapper<T> extends IMapper<T>{

	public List selectGroupByOperaction(Date startDate,Date endDate);
	
	public List selectGroupByHospital(Date startDate,Date endDate);
	
}
