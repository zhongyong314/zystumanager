package com.jinglin.wmy.dao.impl;


import java.util.List;
import java.util.Map;


import com.jinglin.wmy.dao.IDao;
import com.jinglin.wmy.model.StuInfo;

public interface StuInfoDao extends IDao<StuInfo> {

	 /**
	  * 查询的是学生的信息
	 * @param map
	 * @return
	 */
	List<StuInfo> stuPage(Map<String,Object> map);
	
	 /**
	  * 学生的总数
	 * @param map
	 * @return
	 */
	int stuCount(Map<String,Object> map);
}
