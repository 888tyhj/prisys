package com.prisys.web.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.prisys.web.base.dao.BaseDao;
import com.prisys.web.dao.OrganizationDao;
import com.prisys.web.entity.Organization;

/**      
 * OrganizationDaoImpl.java Create on 20l15-6-3     
 * Copyright (c) 20l15-6-3 by http://www.zy-iot.com        
 * @author <a href="yangl@zy-iot.com">YangLei</a>         
 */
@Repository
public class OrganizationDaoImpl implements OrganizationDao {
	
	@Resource
	private BaseDao<Organization> baseDao;

	public Long deleteByPrimaryKey(Long id) {
		return baseDao.count("delete from Organization where id=?", new Object[]{id});
	}

	public Long deleteFromParentIdsById(String ids) {
		return baseDao.executeSql("delete from sys_organization where parent_ids like '"+ids+"%' ").longValue();
	}
	
	public void deleteFromParentIdsById(Organization org) {
		baseDao.delete(org);
	}

	public Long insert(Organization record) {
		return (Long) baseDao.save(record);
	}


	public Organization selectByPrimaryKey(Long id) {
		return baseDao.get(Organization.class, id);
	}

	public List<Organization> selectAll() {
		return baseDao.find("from Organization");
	}

	public List<Organization> selectAllWithExclude(Organization record) {
		return baseDao.find("from Organization where id=? and parent_ids not like ?", 
				new Object[]{record.getId(),record.getParentIds()+record.getId()+"/%"});
	}
	
	public List<Organization> selectAllByParentId(Long parentId) {
		return baseDao.find("from Organization where  parent_id=?", new Object[]{parentId});
	}


	public void updateByPrimaryKey(Organization record) {
		baseDao.update(record);
	}

	public void moveByPrimaryKey(Long parentId, String parentIds, Long id) {
		Organization o=this.selectByPrimaryKey(id);
		o.set_parentId(parentId);
		o.setParentIds(parentIds);
		baseDao.update(o);
	}

	public int moveSourceDescendants(String targetParentIds,
			String sourceParentIds) {
		String sql="update sys_organization "
	    +" set   parent_ids = "+targetParentIds+"+substring(parent_ids, length("+sourceParentIds+")) "
	    +" where parent_ids like '"+sourceParentIds+"%' ";
		return baseDao.executeSql(sql);
	}

	@Override
	public List<Organization> selectByParam(String param) {
		return baseDao.find("from Organization where 1=1 "+ (param==null?"":param));
	}

}
 