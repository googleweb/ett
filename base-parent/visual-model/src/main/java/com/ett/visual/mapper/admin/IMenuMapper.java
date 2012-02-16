package com.ett.visual.mapper.admin;

import java.lang.reflect.Array;
import java.util.ArrayList;


import com.smartken.toyz4j.model.IMapper;


public interface IMenuMapper<T> extends IMapper<T> {

	
	public ArrayList selectInToken(ArrayList<String> lListToken);
}
