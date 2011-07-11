package com.ett.drv.mapper.admin;

import java.util.ArrayList;
import java.util.List;

import com.ett.drv.model.admin.UserModel;
import com.smartken.kia.core.model.IMapper;



public interface IUserMapper<T> extends IMapper<T> {

	public List<UserModel> selectViewDepartname(int id) throws Exception;
}
