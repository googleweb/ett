package com.ett.drv.mapper.dict;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ett.drv.model.dict.AreaModel;
import com.smartken.kia.core.model.IMapper;

public interface IDrvCodeMapper<T> extends IMapper<T> {
	public List<AreaModel> selectArea(@Param("area")String area)throws Exception;

}
