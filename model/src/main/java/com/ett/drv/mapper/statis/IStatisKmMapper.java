package com.ett.drv.mapper.statis;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ett.drv.view.StatisKmView;

public interface IStatisKmMapper {

	
	public List<StatisKmView> selectViewKm3KscsGt
	(@Param("fzjg")String fzjg,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("gtTimes")Integer gtTimes) throws Exception;
}
