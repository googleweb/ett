package com.ett.visual.mapper.admin;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.smartken.toyz4j.mybatis.IToyzMapper;






public interface IMenuMapper<T> extends IToyzMapper<T> {

	
	public ArrayList selectInToken(ArrayList<String> lListToken);
}
