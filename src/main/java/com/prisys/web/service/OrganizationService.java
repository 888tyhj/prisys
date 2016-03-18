package com.prisys.web.service;

import java.util.List;
import java.util.Map;

import com.prisys.web.bean.Tree;
import com.prisys.web.entity.Organization;

/**
* @ClassName: OrganizationService
* @Description: TODO
* @author yangl
* @date 2015-6-3 下午1:09:04
*
 */
public interface OrganizationService {

	String createOrganization(Organization organization);
    
	String updateOrganization(Organization organization);
    
    void deleteOrganization(Long organizationId);

    Organization findOne(Long organizationId);
    
    Organization findOne(String organizationId);
    
    List<Organization> findAll();

    Object findAllWithExclude(Organization excludeOraganization);

    void move(Organization source, Organization target);
    
    List<Tree> ajaxOrganizationTree();
    
    Map<String,Object> selectByParam(String param);
	
}
