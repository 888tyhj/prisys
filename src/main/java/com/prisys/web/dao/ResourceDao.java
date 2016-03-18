package com.prisys.web.dao;


import java.util.List;

import com.prisys.web.entity.Resource;

public interface ResourceDao {
	Long deleteByPrimaryKey(Long id);
    
	Long  deleteByIdAndParentIds(String ids);

	Long insert(Resource record);


    Resource selectByPrimaryKey(Long id);
    
    List<Resource>  selectAll();
    
    void updateByPrimaryKey(Resource record);

	List<Resource> queryResourceByParam(String param, Integer page, Integer rows);

	Long queryResourceTotalByParam(String param);
	
	void deleteResource(Resource r);
	
	List<Resource> selectAllByParentId(Long parentId);
	
	List<Resource> selectByParam(String param);
	
	List<Resource> selectAllByParentId(Long parentId, String username);
}