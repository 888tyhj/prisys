/**      
 * RoleDaoImpl.java Create on 20l15-6-3     
 * Copyright (c) 20l15-6-3 by http://www.zy-iot.com        
 * @author <a href="yangl@zy-iot.com">YangLei</a>         
 */
package com.prisys.web.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.prisys.web.base.dao.BaseDao;
import com.prisys.web.dao.RoleDao;
import com.prisys.web.entity.Role;

@SuppressWarnings("all")
@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Resource
	private BaseDao<Role> baseDao;

	public Integer deleteByPrimaryKey(Long id) {
		return baseDao.executeHql("delete from Role where id=?", new Object[]{id});
	}

	public Long insert(Role record) {
		return (Long) baseDao.save(record);
	}

	public Role selectByPrimaryKey(Long id) {
		return baseDao.get(Role.class, id);
	}

	public List<Role> selectAll() {
		return baseDao.find("from Role");
	}
	
	public List<Role> selectByParam(String param) {
		return baseDao.find("from Role where 1=1 " + (param==null ? "" : param));
	}

	public void updateByPrimaryKey(Role record) {
		baseDao.update(record);
	}

	@Override
	public List<Role> queryRoleByParam(String param, Integer page, Integer rows) {
		Query q=baseDao.createQuery("from Role where isshow=2 "+ (param==null?"":param));
		//设置每页显示多少个
		q.setMaxResults(rows);
		//设置起点
		q.setFirstResult((rows*(page-1)));
		return q.list();
	}

	@Override
	public Long queryRoleTotalByParam(String param) {
		return baseDao.count("select count(*) from Role where isshow=2 "+ (param==null?"":param));
	}

}
 