package com.ett.drv.mapper.statis;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ett.drv.view.StatisSchoolView;

public interface IStatisSchoolMapper {

	
	public List<StatisSchoolView> selectViewFirstQuery
	(@Param("glbm")String glbm,@Param("startDate")Date startDate,@Param("endDate")Date endDate) throws Exception;
	
	public List<StatisSchoolView> selectViewSecondQuery
	(@Param("glbm")String glbm,@Param("startDate")Date startDate,@Param("endDate")Date endDate) throws Exception;
	
	public List<StatisSchoolView> selectViewOnStudyQuery
	(@Param("glbm")String glbm,@Param("startDate")Date startDate,@Param("endDate")Date endDate) throws Exception;
	
	public List<StatisSchoolView> selectViewKm1DkQuery
	(@Param("glbm")String glbm,@Param("startDate")Date startDate,@Param("endDate")Date endDate) throws Exception;
	
	public List<StatisSchoolView> selectViewZkDkQuery
	(@Param("glbm")String glbm,@Param("startDate")Date startDate,@Param("endDate")Date endDate) throws Exception;
	
	public List<StatisSchoolView> selectViewCdDkQuery
	(@Param("glbm")String glbm,@Param("startDate")Date startDate,@Param("endDate")Date endDate) throws Exception;
	
	public List<StatisSchoolView> selectViewKm3DkQuery
	(@Param("glbm")String glbm,@Param("startDate")Date startDate,@Param("endDate")Date endDate) throws Exception;
	
}
