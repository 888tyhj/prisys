/**      
 * ResourceDaoImpl.java Create on 2015-6-3     
 * Copyright (c) 2015-6-3 by http://www.zy-iot.com        
 * @author <a href="yangl@zy-iot.com">YangLei</a>         
 */
package com.prisys.web.dao.impl; 

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.prisys.web.base.dao.BaseDao;
import com.prisys.web.dao.ResourceDao;
import com.prisys.web.entity.Organization;
import com.prisys.web.entity.Resource;

@SuppressWarnings("all")
@Repository
public class ResourceDaoImpl implements ResourceDao {

	@javax.annotation.Resource
	private BaseDao<Resource> baseDao;
	
	public Long deleteByPrimaryKey(Long id) {
		return baseDao.count("delete from Resource where id=?", new Object[]{id});
	}

	public void deleteResource(Resource r){
		baseDao.delete(r);
	}
	public Long deleteByIdAndParentIds(String ids) {
		return baseDao.executeSql("delete from sys_resource where parent_ids like '"+ids+"%' ").longValue();
	}

	public Long insert(Resource record) {
		return (Long) baseDao.save(record);
	}

	public Resource selectByPrimaryKey(Long id) {
		return baseDao.get(Resource.class, id);
	}

	public List<Resource> selectAll() {
		return baseDao.find("from Resource");
	}
	
	public List<Resource> selectByParam(String param) {
		return baseDao.find("from Resource where 1=1 "+(param==null?"":param));
	}

	public void updateByPrimaryKey(Resource record) {
		 baseDao.update(record);
	}

	@Override
	public List<Resource> queryResourceByParam(String param, Integer page,
			Integer rows) {
		Query q=baseDao.createQuery("from Resource where 1=1 "+(param==null?"":param));
//		//设置每页显示多少个
//		q.setMaxResults(rows);
//		//设置起点
//		q.setFirstResult((rows*(page-1)));
		return q.list();
	}

	@Override
	public Long queryResourceTotalByParam(String param) {
		return baseDao.count("select count(*) from Resource where 1=1 "+ (param==null?"":param));
	}
	
	public List<Resource> selectAllByParentId(Long parentId) {
		return baseDao.find("from Resource where  parent_id=?", new Object[]{parentId});
	}

	public List<Resource> selectAllByParentId(Long parentId, String username){
		String sql="select d.* from  sys_user a inner join sys_role b "
					+" on a.role_ids=b.role  "
					+" inner join sys_roleres c on b.id=c.role_id "
					+" inner join sys_resource d on c.res_id=d.id "
					+" where a.username='"+username+"' and d.parent_id="+parentId;
		return baseDao.createSQLQuery(sql).addEntity(Resource.class).list();
	}
}
 