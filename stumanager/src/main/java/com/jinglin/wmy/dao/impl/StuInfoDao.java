package com.jinglin.wmy.dao.impl;


import java.util.List;
import java.util.Map;


import com.jinglin.wmy.dao.IDao;
import com.jinglin.wmy.model.StuInfo;

public interface StuInfoDao extends IDao<StuInfo> {

	 List<StuInfo> stuPage(Map<String,Object> map);
	 int stuCount(Map<String,Object> map);
}
