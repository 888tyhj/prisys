/*
 * 文件名：SysJobServiceImpl.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prisys.shiro.spring.SpringUtils;
import com.prisys.shiro.web.bind.annotation.ServiceLog;
import com.prisys.web.dao.SysJobDao;
import com.prisys.web.entity.SysJob;
import com.prisys.web.service.SysJobService;
import com.prisys.web.utils.DateUtil;

@Service
public class SysJobServiceImpl implements SysJobService {
	
	@Resource
	private SysJobDao sysJobDao;

	@Override
	@ServiceLog("添加定时任务")
	public String insert(SysJob record) {
		if(SpringUtils.containsBean(record.getBeanName())){
			record.setCreatetime(DateUtil.getyyyyMMddHHmmsssplit());
			sysJobDao.insert(record);
			return "录入成功";
		}else{
			return "1";//bean不存在
		}
		
	}

	@Override
	@ServiceLog("更新定时任务")
	public String updateByPrimaryKey(SysJob record) {
		if(SpringUtils.containsBean(record.getBeanName())){
			sysJobDao.updateByPrimaryKey(record);
			return "修改成功";
		}else{
			return "1";//bean不存在
		}
	}

	@Override
	public Map<String, Object> querySysJobList(String param) {
		Map<String, Object> map=new HashMap<String, Object>();
		List<SysJob> list=sysJobDao.querySysJobList(param);
		for(SysJob job:list){
			String endtime=job.getEndtime();
			String nowtime=DateUtil.getyyyyMMddHHmmsssplit();
			if(endtime!=null&&!endtime.equals("")){
				if(nowtime.compareTo(endtime)>0){
					job.setState(2);//停止
					this.updateByPrimaryKey(job);
				}
			}
		}
		map.put("rows", list);
		map.put("total", list.size());
		return map;
	}

}
