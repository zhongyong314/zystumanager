package com.jinglin.wmy.service;

import java.util.List;
import java.util.Map;

import com.jinglin.wmy.model.StuInfo;

public interface StuInfoService {

	List<StuInfo> getstus(Map<String,Object> map);
	int getcount(Map<String,Object> map);
	
}
