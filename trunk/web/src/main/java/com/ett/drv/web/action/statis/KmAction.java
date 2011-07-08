package com.ett.drv.web.action.statis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.ett.drv.web.action.BaseDrvAction;
import com.smartken.kia.core.enums.ResultEnum;
import com.smartken.kia.core.util.EasyUiUtil;
import com.smartken.kia.core.util.StringUtil;

@SuppressWarnings("serial")
public class KmAction extends BaseDrvAction {

	/*
	 * 接受页面传递的二个参数
	 * 向页面输出json数据
	 * */
	@SuppressWarnings("unchecked")
	public void datagrid_km3kscc() {
		String fzjg = "11";
		String begindate = this.getParameter("begindate");
		String enddate = this.getParameter("enddate");
		SimpleDateFormat parseTime = new SimpleDateFormat("yyyy-MM-dd");
		Date begindate1;
		Date enddate1;
		try {
			if(StringUtil.isNotBlank(begindate)&&StringUtil.isNotBlank(enddate)&&StringUtil.isNotBlank(fzjg)) {
				begindate1 = parseTime.parse(begindate);
				enddate1 = parseTime.parse(enddate);
				List list = this.statisBiz.selectViewKm3KscsGt50(fzjg,
						begindate1, enddate1);
				JSONObject jsonDG = EasyUiUtil.toJsonDataGrid(list,
						this.adminBiz.count());
				this.writePlainText(jsonDG.toString());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void clear() {
	}

	public String to_km3kscc() {
		return ResultEnum.jsp.name();
	}
}
