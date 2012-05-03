package com.ett.visual.mapper.drv;

import com.ett.visual.model.drv.DriverFileModel;
import com.smartken.toyz4j.annotation.TableConfig;
import com.smartken.toyz4j.mybatis.IToyzMapper;



@TableConfig(
		table="drv_file",pk="id",oracleSeqIdRegexp="seq_drv_file.nextval"
		)
public interface IDriverFileMapper extends IToyzMapper<DriverFileModel> {

}
