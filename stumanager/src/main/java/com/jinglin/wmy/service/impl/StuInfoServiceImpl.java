package com.jinglin.wmy.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jinglin.wmy.dao.impl.StuInfoDao;
import com.jinglin.wmy.model.StuInfo;
import com.jinglin.wmy.service.StuInfoService;

/*@Service("stuInfoService")*/
public class StuInfoServiceImpl implements StuInfoService {

	@Resource(name="stuInfoDao")
	private StuInfoDao stuInfoDao;
	public List<StuInfo> getstus(Map<String, Object> map) {
		return stuInfoDao.stuPage(map);
	}

	public int getcount(Map<String, Object> map) {
		return stuInfoDao.stuCount(map);
	}

}
