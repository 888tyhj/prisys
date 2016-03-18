package com.prisys.web.controller;

import java.util.List;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prisys.web.bean.Tree;
import com.prisys.web.entity.Resource;
import com.prisys.web.service.ResourceService;
import com.prisys.web.utils.BaseController;

/**
 * 
* @ClassName: ResourceController
* @Description: TODO
* @author yangl
* @date 2015-6-5 下午1:12:13
*
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseController{

    @javax.annotation.Resource
    private ResourceService resourceService;

    @ModelAttribute("types")
    public Resource.ResourceType[] resourceTypes() {
        return Resource.ResourceType.values();
    }

    @RequiresPermissions("resource:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("resourceList", resourceService.findAll());
        return "persys/resource/list";
    }
    
    @RequiresPermissions("resource:view")
    @RequestMapping(value="/{parentId}/addpage", method = RequestMethod.GET)
    public String addpage(@PathVariable("parentId")Long parentId, Model model) {
    	Resource parent = resourceService.findOne(parentId);
        model.addAttribute("parent", parent);
        model.addAttribute("parentIds", parent.makeSelfAsParentIds());
        return "persys/resource/add";
    }
    
    @RequiresPermissions("resource:view")
    @RequestMapping(value="/{id}/editpage", method = RequestMethod.GET)
    public String editpage(@PathVariable("id")Long id, Model model) {
    	Resource res = resourceService.findOne(id);
        model.addAttribute("res", res);
        return "persys/resource/edit";
    }
    
    @RequiresPermissions("resource:view")
    @RequestMapping(value="/listPage",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject listPage(String param, Integer page, Integer rows) {
    	JSONObject json=JSONObject.fromObject(resourceService.queryResourceByParam(param, page, rows));
		return json;
    }

    @RequiresPermissions("resource:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.GET)
    public String showAppendChildForm(@PathVariable("parentId") Long parentId, Model model) {
        Resource parent = resourceService.findOne(parentId);
        model.addAttribute("parent", parent);
        Resource child = new Resource();
        child.set_parentId(parentId);
        child.setParentIds(parent.makeSelfAsParentIds());
        model.addAttribute("resource", child);
        model.addAttribute("op", "新增子节点");
        return "persys/resource/edit";
    }

    @RequiresPermissions("resource:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(Resource resource, @RequestParam("parentId") Long parentId) {
        String message="录入成功";
    	try {
    		resource.set_parentId(parentId);
    		message=resourceService.createResource(resource);
		} catch (Exception e) {
			logger.error(e.getMessage());
			message="录入失败";
		}
        return message;
    }

    @RequiresPermissions("resource:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(Resource resource, @RequestParam("parentId") Long parentId) {
        String message="修改成功";
    	try {
    		resource.set_parentId(parentId);
    		message=resourceService.updateResource(resource);
		} catch (Exception e) {
			logger.error(e.getMessage());
			message="修改失败";
		}
        return message;
    }

    @RequiresPermissions("resource:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("id") Long id) {
        String message="删除成功";
    	try {
    		resourceService.deleteResource(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			message="删除失败";
		}
        return message;
    }

    @RequiresPermissions("resource:view")
    @RequestMapping(value = "/ajaxtree", method = RequestMethod.POST)
    @ResponseBody
    public List<Tree> showAjaxTree() {
		return resourceService.ajaxResourceTree();
    }

}
