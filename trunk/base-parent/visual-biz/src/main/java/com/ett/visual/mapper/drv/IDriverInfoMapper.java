package com.ett.visual.mapper.drv;


import com.ett.visual.model.drv.DriverInfoModel;
import com.smartken.toyz4j.annotation.TableConfig;
import com.smartken.toyz4j.mybatis.IToyzMapper;


@TableConfig(
table="drv_info",pk="id"
		)
public interface IDriverInfoMapper extends IToyzMapper<DriverInfoModel> {

}
