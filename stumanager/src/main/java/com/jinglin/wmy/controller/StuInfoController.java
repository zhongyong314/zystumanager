package com.jinglin.wmy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinglin.wmy.model.PageInfo;
import com.jinglin.wmy.model.StuInfo;
import com.jinglin.wmy.service.StuInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping(value="/stuInfo")
public class StuInfoController {
    
	@Resource(name="stuInfoService")
	private StuInfoService stuInfoService;
	
	@RequestMapping(value="/getstuinfos")
	public void getstuinfos(HttpServletResponse response,
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value="conditional",required=false,defaultValue="") String conditional,
			StuInfo stuInfo) throws Exception{
		
		Map<String,Object> userMap=new HashMap<String, Object>();
		userMap.put("id", stuInfo.getStuid());
		userMap.put("stuname", stuInfo.getStuname());
		userMap.put("age", stuInfo.getAge());
		userMap.put("stusubject", stuInfo.getSubjectname());
		
		PageInfo<StuInfo> stuPage = new PageInfo<StuInfo>();
		Integer pageSize=Integer.parseInt(rows);//获取行号
		stuPage.setPageSize(pageSize);//获取分页大小
		
		// 第几页
		String pageIndex = page;
		if (pageIndex == null || pageIndex == "") {
			pageIndex = "1";
		}
		stuPage.setPageIndex((Integer.parseInt(pageIndex) - 1)
				* pageSize);//算的是起始行号
		 // 取得总页数
		 if(conditional!=null && !conditional.equals("")) {
	        	userMap.put("conditional", conditional);
	     }
			
		int userCount=stuInfoService.getcount(userMap);
		stuPage.setCount(userCount);
		userMap.put("pageIndex", stuPage.getPageIndex());
		userMap.put("pageSize", stuPage.getPageSize());
		
       
		
		List<StuInfo> cusDevPlanList = stuInfoService.getstus(userMap);
		JSONObject json = new JSONObject();//用以构建键值对的数据
		// 把List格式转换成JSON（集合数据)
		JSONArray jsonArray = JSONArray.fromObject(cusDevPlanList);
		json.put("rows", jsonArray);//必须传给easyui的rows，集合
		json.put("total", userCount);//总的数据量
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(json.toString());
	}
	@RequestMapping(value="/rep")
	@ResponseBody
	public String rep(HttpServletResponse response,
			@RequestParam(value = "page",defaultValue="1", required = false) String page,
			@RequestParam(value = "rows",defaultValue="5", required = false) String rows,
			@RequestParam(value="conditional",required=false,defaultValue="") String conditional,
			StuInfo stuInfo) {
		Map<String,Object> userMap=new HashMap<String, Object>();
		userMap.put("id", stuInfo.getStuid());
		userMap.put("stuname", stuInfo.getStuname());
		userMap.put("age", stuInfo.getAge());
		userMap.put("stusubject", stuInfo.getSubjectname());
		
		PageInfo<StuInfo> stuPage = new PageInfo<StuInfo>();
		Integer pageSize=Integer.parseInt(rows);//获取行号
		stuPage.setPageSize(pageSize);//获取分页大小
		
		// 第几页
		String pageIndex = page;
		if (pageIndex == null || pageIndex == "") {
			pageIndex = "1";
		}
		stuPage.setPageIndex((Integer.parseInt(pageIndex) - 1)
				* pageSize);//算的是起始行号
		 // 取得总页数
		 if(conditional!=null && !conditional.equals("")) {
	        	userMap.put("conditional", conditional);
	     }
			
		int userCount=stuInfoService.getcount(userMap);
		stuPage.setCount(userCount);
		userMap.put("pageIndex", stuPage.getPageIndex());
		userMap.put("pageSize", stuPage.getPageSize());
		
		List<StuInfo> cusDevPlanList = stuInfoService.getstus(userMap);
		
		
		//传pagecount和totalrows过去
		Map<String,Object> maplist = new HashMap<String,Object>();
		maplist.put("pagecount", 3);
		maplist.put("totalrows", 102);
		maplist.put("datarows",cusDevPlanList);
		JSONArray jsonarray = JSONArray.fromObject(maplist);
		
		return jsonarray.toString();
	}
	
	
	
}
