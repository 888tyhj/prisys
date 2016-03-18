package com.prisys.web.controller;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prisys.web.bean.Tree;
import com.prisys.web.entity.Organization;
import com.prisys.web.service.OrganizationService;
import com.prisys.web.utils.BaseController;

/**
 * 
* @ClassName: OrganizationController
* @Description: TODO
* @author yangl
* @date 2015-6-5 下午1:12:00
*
 */
@Controller
@RequestMapping("/organization")
public class OrganizationController extends BaseController{

    @Resource
    private OrganizationService organizationService;

    @RequiresPermissions("organization:view")
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        return "persys/organization/index";
    }

    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public String showTree(Model model) {
        model.addAttribute("organizationList", organizationService.findAll());
        return "persys/organization/tree";
    }
    
    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/ajaxtree", method = RequestMethod.POST)
    @ResponseBody
    public List<Tree> showAjaxTree() {
		return organizationService.ajaxOrganizationTree();
    }

    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.GET)
    public String showAppendChildForm(@PathVariable("parentId") Long parentId, Model model) {
        Organization parent = organizationService.findOne(parentId);
        model.addAttribute("parent", parent);
        Organization child = new Organization();
        child.set_parentId(parentId);
        child.setParentIds(parent.makeSelfAsParentIds());
        model.addAttribute("child", child);
        model.addAttribute("op", "新增");
        return "persys/organization/appendChild";
    }

    @RequiresPermissions("organization:create")
    @RequestMapping(value = "/{parentId}/appendChild", method = RequestMethod.POST)
    @ResponseBody
    public String create(Organization organization, @PathVariable("parentId") Long parentId) {
        String message="录入成功";
    	try {
    		organization.set_parentId(parentId);
    		message=organizationService.createOrganization(organization);
		} catch (Exception e) {
			message="录入失败";
			logger.error(e.getMessage());
		}
        return message;
    }

    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{id}/maintain", method = RequestMethod.GET)
    public String showMaintainForm(@PathVariable("id") Long id, Model model) {
    	Organization o=organizationService.findOne(id);
        model.addAttribute("organization", o);
        model.addAttribute("parentId", o.get_parentId());
        return "persys/organization/maintain";
    }

    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(Organization organization, @RequestParam("parentId") Long parentId) {
        String message="修改成功";
    	try {
    		organization.set_parentId(parentId);
    		message=organizationService.updateOrganization(organization);
		} catch (Exception e) {
			message="修改失败";
			logger.error(e.getMessage());
		}
        return message;
    }

    @RequiresPermissions("organization:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("id") Long id) {
        String message="删除成功";
    	try {
    		organizationService.deleteOrganization(id);
		} catch (Exception e) {
			message="删除失败";
			logger.error(e.getMessage());
		}
        return message;
    }


    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{sourceId}/move", method = RequestMethod.GET)
    public String showMoveForm(@PathVariable("sourceId") Long sourceId, Model model) {
        Organization source = organizationService.findOne(sourceId);
        model.addAttribute("source", source);
        model.addAttribute("targetList", organizationService.findAllWithExclude(source));
        return "persys/organization/move";
    }

    @RequiresPermissions("organization:update")
    @RequestMapping(value = "/{sourceId}/move", method = RequestMethod.POST)
    public String move(
            @PathVariable("sourceId") Long sourceId,
            @RequestParam("targetId") Long targetId) {
        Organization source = organizationService.findOne(sourceId);
        Organization target = organizationService.findOne(targetId);
        organizationService.move(source, target);
        return "redirect:/organization/success";
    }

    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success() {
        return "persys/organization/success";
    }
    
    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/left", method = RequestMethod.GET)
    public String left() {
        return "persys/organization/left";
    }
    
    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/right", method = RequestMethod.GET)
    public String right() {
        return "persys/organization/right";
    }
    
    @RequiresPermissions("organization:view")
    @RequestMapping(value = "/listRight", method = RequestMethod.GET)
    public String listRight() {
        return "persys/organization/list";
    }

    @RequiresPermissions("organization:view")
    @RequestMapping(value="/listPage",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject listPage(String param) {
    	JSONObject json=JSONObject.fromObject(organizationService.selectByParam(param));
		return json;
    }

}
