package com.ett.drv.mapper.exam;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ett.drv.model.exam.ExamTKcnModel;
import com.smartken.kia.core.model.IMapper;

public interface IExamTKcnMapper<T> extends IMapper<T> {
	public List<ExamTKcnModel> selectTopic(@Param("cartype")String cartype)throws Exception;

}
