package com.ett.drv.mapper.statis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ett.drv.view.StatisCoachCarView;

public interface IStatisCoachCarMapper {

	
	public List<StatisCoachCarView> selectViewCoachCar(@Param("fzjg")String fzjg ,@Param("idCard")String idCard,@Param("hphm")String hphm) throws Exception;
}
