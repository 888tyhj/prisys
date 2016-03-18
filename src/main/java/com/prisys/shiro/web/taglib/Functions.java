package com.prisys.shiro.web.taglib;


import org.springframework.util.StringUtils;

import com.prisys.shiro.spring.SpringUtils;
import com.prisys.web.entity.Organization;
import com.prisys.web.entity.Resource;
import com.prisys.web.entity.Role;
import com.prisys.web.service.OrganizationService;
import com.prisys.web.service.ResourceService;
import com.prisys.web.service.RoleService;

/**
 * 
* @ClassName: Functions
* @Description: TODO
* @author yangl
* @date 2015-6-3 下午1:16:16
*
 */
public class Functions {

    public static boolean in(String targetIds, Long element) {
        if(targetIds == null) {
            return false;
        }
        int i=targetIds.indexOf(String.valueOf(element));
        return i>-1;
    }

    public static String organizationName(Long organizationId) {
        Organization organization = getOrganizationService().findOne(organizationId);
        if(organization == null) {
            return "";
        }
        return organization.getName();
    }

    public static String organizationNames(String organizationIds) {
        if(StringUtils.isEmpty(organizationIds)) {
            return "";
        }
        String[] strArr=organizationIds.split(",");
        StringBuilder s = new StringBuilder();
        for(String organizationId : strArr) {
        	if(StringUtils.isEmpty(organizationId)){
        		continue;
        	}
            Organization organization = getOrganizationService().findOne(Long.valueOf(organizationId));
            if(organization == null) {
                return "";
            }
            s.append(organization.getName());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }
    public static String roleName(Long roleId) {
        Role role = getRoleService().findOne(roleId);
        if(role == null) {
            return "";
        }
        return role.getDescription();
    }

    public static String roleNames(String roleIds) {
        if(StringUtils.isEmpty(roleIds)) {
            return "";
        }
        String[] strArr=roleIds.split(",");
        StringBuilder s = new StringBuilder();
        for(String roleId : strArr) {
        	if(StringUtils.isEmpty(roleId)){
        		continue;
        	}
            Role role = getRoleService().findOne(Long.valueOf(roleId));
            if(role == null) {
                return "";
            }
            s.append(role.getDescription());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }
    public static String resourceName(Long resourceId) {
        Resource resource = getResourceService().findOne(resourceId);
        if(resource == null) {
            return "";
        }
        return resource.getName();
    }
    public static String resourceNames(String resourceIds) {
        if(StringUtils.isEmpty(resourceIds)) {
            return "";
        }
        String[] strArr=resourceIds.split(",");
        StringBuilder s = new StringBuilder();
        for(String resourceId : strArr) {
        	if(StringUtils.isEmpty(resourceId)){
        		continue;
        	}
            Resource resource = getResourceService().findOne(Long.valueOf(resourceId));
            if(resource == null) {
                return "";
            }
            s.append(resource.getName());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }

    private static OrganizationService organizationService;
    private static RoleService roleService;
    private static ResourceService resourceService;

    public static OrganizationService getOrganizationService() {
        if(organizationService == null) {
            organizationService = SpringUtils.getBean(OrganizationService.class);
        }
        return organizationService;
    }

    public static RoleService getRoleService() {
        if(roleService == null) {
            roleService = SpringUtils.getBean(RoleService.class);
        }
        return roleService;
    }

    public static ResourceService getResourceService() {
        if(resourceService == null) {
            resourceService = SpringUtils.getBean(ResourceService.class);
        }
        return resourceService;
    }
}

