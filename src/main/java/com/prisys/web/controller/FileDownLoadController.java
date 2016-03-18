package com.prisys.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prisys.web.utils.BaseController;
import com.prisys.web.utils.CommonUtil;


/**
 * 下载
 * @author yangl
 *
 */
@Controller
@RequestMapping(value="/fileDownLoad")
public class FileDownLoadController extends BaseController{
  /**
   * 下载
   * @param fileName
   * @param response
   * @param request
   */
  @RequestMapping(value="/downLoad")
  public void downLoad(String fileName,HttpServletResponse response){
	  //文件路径
	  String path=CommonUtil.getPath();
	 //String path=request.getSession().getServletContext().getRealPath("/")+"upload/";
	  String filePath=path+fileName;
	  
	  ServletOutputStream out=null;
	  FileInputStream in=null;
	  PrintWriter pw=null;
	    try{
	    	File file=new File(filePath);
	    	//文件不存在
		  	  if(!file.exists()){
		  		  response.setContentType("text/html;charset=utf-8");
		  		  pw=response.getWriter();
		  		  pw.write("<script type=\"text/javascript\">alert('文件不存在!')</script>");
		  	  }else{
		  		if(fileName!=null&&fileName.length()>0){
		  			   out=response.getOutputStream();
					   in=new FileInputStream(file);
					   response.setContentType("application/x-msdownload;charset=utf-8");
					   response.setHeader("Content-Disposition", "attachment;filename="+
					     URLEncoder.encode(fileName, "utf-8"));
					   if(in!=null){
						   //读取文件
						   int fileLen=0;
						   byte[] bt=new byte[1024];
						   while((fileLen=in.read(bt, 0, 1024))!=-1){
							   //写入文件
							   out.write(bt, 0, fileLen);
						   }
					   }
				   }
		  	  }
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally{
			try {
				if(out!=null){
					out.flush();
					out.close();
				}
				if(in!=null){
					in.close();
				}
				if(pw!=null){
					pw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
  }
  
  /**
   * 查看
   * @param fileName 文件名
   * @param response
   * @param request
   */
  @RequestMapping(value="/showFile")
  public void showFile(String fileName,HttpServletResponse response){
	  //文件路径
	  String path=CommonUtil.getPath();
	  //String path=request.getSession().getServletContext().getRealPath("/")+"upload/";
	  String filePath=path+fileName;
	  
	  ServletOutputStream out=null;
	  FileInputStream in=null;
	  PrintWriter pw=null;
	    try{
	    	File file=new File(filePath);
	    	//文件不存在
		  	  if(!file.exists()){
		  		  response.setContentType("text/html;charset=utf-8");
		  		  pw=response.getWriter();
		  		  pw.write("<script type=\"text/javascript\">alert('文件不存在!')</script>");
		  	  }else{
		  		if(fileName!=null&&fileName.length()>0){
		  			   out=response.getOutputStream();
					   in=new FileInputStream(file);
					   //文件后缀
					   String extName=fileName.substring(fileName.lastIndexOf(".")).toUpperCase();
					   //根据文件后缀判断文件类型
					 //根据文件后缀判断文件类型
						if(extName.equals(".DOC")){
							response.setHeader("Content-type", "application/msword");
						}else if(extName.equals(".DOCX")){
							response.setHeader("Content-type","application/vnd.openxmlformats-officedocument.wordprocessingml.document");
						}else if(extName.equals(".PDF")){
							response.setHeader("Content-type","application/pdf");
						}else if(extName.equals(".TXT")){
							response.setHeader("Content-type","text/html");
						}else if(extName.equals(".XLS")){
							response.setHeader("Content-type","application/vnd.ms-excel");
						}else if(extName.equals(".XLSX")){
							response.setHeader("Content-type","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
						}else if(extName.equals(".PPT")){
							response.setHeader("Content-type","application/vnd.ms-powerpoint");
						}else if(extName.equals(".PPTX")){
							response.setHeader("Content-type","application/vnd.openxmlformats-officedocument.presentationml.presentation");
						}else if(extName.equals(".BMP")){
							response.setHeader("Content-type","image/bmp");
						}else if(extName.equals(".GIF")){
							response.setHeader("Content-type","image/gif");
						}else if(extName.equals(".IEF")){
							response.setHeader("Content-type","image/ief");
						}else if(extName.equals(".JPEG")){
							response.setHeader("Content-type","image/jpeg");
						}else if(extName.equals(".JPG")){
							response.setHeader("Content-type","image/jpeg");
						}else if(extName.equals(".PNG")){
							response.setHeader("Content-type","image/jpeg");
						}else if(extName.equals(".TIFF")){
							response.setHeader("Content-type","image/tiff");
						}else if(extName.equals(".TIF")){
							response.setHeader("Content-type","image/tif");
						}else{
							response.setHeader("Content-Disposition", "attachment;filename="+
								     URLEncoder.encode(fileName, "utf-8"));
						}
					   
					   if(in!=null){
						   //读取文件
						   int fileLen=0;
						   byte[] bt=new byte[1024];
						   while((fileLen=in.read(bt, 0, 1024))!=-1){
							   //写入文件
							   out.write(bt, 0, fileLen);
						   }
					   }
				   }
		  	  }
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally{
			try {
				if(out!=null){
					out.flush();
					out.close();
				}
				if(in!=null){
					in.close();
				}
				if(pw!=null){
					pw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
  }
}
