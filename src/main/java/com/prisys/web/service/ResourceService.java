package com.prisys.web.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.prisys.web.bean.Tree;
import com.prisys.web.entity.Resource;


/**
* @ClassName: ResourceService
* @Description: TODO
* @author yangl
* @date 2015-6-3 下午1:09:51
*
 */
public interface ResourceService {


	String createResource(Resource resource);
	String updateResource(Resource resource);
    void deleteResource(Long resourceId);

    Resource findOne(Long resourceId);
    List<Resource> findAll();

    /**
     * 得到资源对应的权限字符串
     * @param resourceIds
     * @return
     */
    Set<String> findPermissions(Set<Long> resourceIds);

    /**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    List<Resource> findMenus(Set<String> permissions);
    
    Map<String,Object> queryResourceByParam(String param, Integer page, Integer rows);
    
    List<Tree> ajaxResourceTree();
    
    List<Tree> findMenuResourceTree(String username);
}
