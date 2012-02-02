package com.ett.visual.mapper.admin;

import java.util.ArrayList;
import java.util.List;


import com.ett.visual.model.admin.UserModel;
import com.smartken.toyz4j.model.IMapper;



public interface IUserMapper<T> extends IMapper<T> {

	public List<UserModel> selectViewDepartname(int id) throws Exception;
}
