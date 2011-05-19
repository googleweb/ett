package com.ett.drv.mapper.self;

import com.ett.drv.model.self.PicModel;
import com.smartken.kia.core.model.IMapper;

public interface IPicMapper {

	
	public int savePic(PicModel pic);
	
	public PicModel getPic();
}
