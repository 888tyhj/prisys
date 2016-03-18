package com.prisys.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.prisys.web.utils.BaseController;
import com.prisys.web.utils.CommonUtil;
import com.prisys.web.utils.DateUtil;

/**
 * 上传
 * @author yangl
 *
 */
@Controller
@RequestMapping(value="/fileUpload")
public class FileUploadController extends BaseController{
	/**
	 * 重新命名
	 * @param name 原文件名
	 * @return 重新命名后的名称
	 */
	public String getNewFileName(String name){
		//获取后缀
		String suffix=name.split("\\.")[1];
    	// 生成随机文件名：当前年月日时分秒+五位随机数（为了在实际项目中防止文件同名而进行的处理）
		String rannum = CommonUtil.getRandomNumber(5); // 获取随机数
		return DateUtil.getyyyyMMddHHmmss(new Date())+rannum+"."+suffix;
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file) throws Exception{
		    String newFileName=null;
		    if(!file.isEmpty()){
		    	//获取文件名
		    	String realFileName=file.getOriginalFilename();
		    	//重命名文件
		    	newFileName=this.getNewFileName(realFileName);
		    	//文件路径
		    	//String path=request.getSession().getServletContext().getRealPath("/")+"upload/";
		    	String path=CommonUtil.getPath();
		    	File f=new File(path+newFileName);
		    	//判断文件夹是否存在，不存在则创建
		    	if(!f.exists()){
		    		f.mkdirs();
		    	}
		    	//上传
			    file.transferTo(f);
		    }
		return newFileName;
	}
	
	@RequestMapping(value="/upload1",method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public void upload(HttpServletRequest request,HttpServletResponse response){
		MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest)request;
		CommonsMultipartFile file=(CommonsMultipartFile)multipartRequest.getFile("file");
		String name=multipartRequest.getParameter("name");
		System.out.println("name："+name);
		//获得文件名
		String realFileName=file.getOriginalFilename();
		System.out.println("文件名："+realFileName);
		//获取路径
		String ctxPath=request.getSession().getServletContext().getRealPath("/")+"upload/";
		//创建文件
		File dirPath=new File(ctxPath);
		if(!dirPath.exists()){
			dirPath.mkdirs();
		}
		File uploadFile = new File(ctxPath + realFileName);
		PrintWriter pw=null;
        try {
			FileCopyUtils.copy(file.getBytes(), uploadFile);
			response.setContentType("text/html;charset=utf-8");
			pw=response.getWriter();
			pw.write(realFileName);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally{
			pw.close();
		}
	}
}
