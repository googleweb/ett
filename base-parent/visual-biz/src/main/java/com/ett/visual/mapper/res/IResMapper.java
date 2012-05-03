package com.ett.visual.mapper.res;

import com.ett.visual.model.res.ResModel;

import com.smartken.toyz4j.annotation.TableConfig;
import com.smartken.toyz4j.mybatis.IToyzMapper;

@TableConfig(
		table="res",pk="id",oracleSeqId="seq_visual_res"
)
public interface IResMapper extends IToyzMapper<ResModel> {

}
