package com.prisys.web.dao;


import java.util.List;

import com.prisys.web.entity.Organization;

public interface OrganizationDao {
    Long deleteByPrimaryKey(Long id);
    
    Long deleteFromParentIdsById(String ids);

    Long insert(Organization record);


    Organization selectByPrimaryKey(Long id);
    
    List<Organization> selectAll();
    
    List<Organization> selectAllWithExclude(Organization record);

    void updateByPrimaryKey(Organization record);
    
    void moveByPrimaryKey(Long parentId,String parentIds,Long id);
    
    int moveSourceDescendants(String targetParentIds,String sourceParentIds);
    
    List<Organization> selectAllByParentId(Long parentId);
    
    void deleteFromParentIdsById(Organization org);

	List<Organization> selectByParam(String string);
    
}