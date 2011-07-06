package com.ett.drv.mapper.statis;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ett.drv.view.StatisDriverView;

public interface IStatisDriverMapper {

	
	public List<StatisDriverView> selectViewAddreesRepeatGt
	(@Param("fzjg")String fzjg,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("gtTimes")Integer gtTimes ) throws Exception;
	
	public List<StatisDriverView> selectViewYdsl
	(@Param("fzjg")String fzjg,@Param("glbm")String glbm,@Param("startDate")Date startDate,@Param("endDate")Date endDate) throws Exception;
	
	public List<StatisDriverView> selectViewYdKsqkGt
	(@Param("fzjg")String fzjg,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("gtTimes")Integer gtTimes) throws Exception;
	
	public List<StatisDriverView> selectViewZzzRepeatGt
    (@Param("fzjg")String fzjg,@Param("startDate")Date startDate,@Param("endDate")Date endDate,@Param("gtTimes")Integer gtTimes) throws Exception;

}
