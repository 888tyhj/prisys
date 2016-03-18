/*
 * 文件名：Log.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月11日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="sys_log")
public class Log implements Serializable{
	/**
	 * 序列化版本
	 */
	private static final long serialVersionUID = -6922112360576205435L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; //编号
	@Column
    private String opertype; //操作类型
	@Column
    private String content; //操作内容
	@Column
    private Long cost; //耗时（毫秒）
	@Column
    private String createip; //ip地址
	@Column
    private String createuser; //操作用户
	@Column
    private String createtime; //创建时间
	@Column
    private String memo; //备注
	@Column(name="modname")
    private String mod; //模块
	@Column
    private Integer type; //1、正常信息 2、异常信息
	@Column(name="exception_code")
	private String exceptionCode;//异常代码
	@Column(name="exception_detail")
	private String exceptionDetail;//异常描述
	@Column(name="method")
	private String methodName;//方法名
	@Column
	private String params;//请求方法参数
	
	
	public Log(){
		
	}
	
	
	public Log(Long id, String opertype, String content, Long cost,
			String createip, String createuser, String createtime, String memo,
			String mod, Integer type, String exceptionCode,
			String exceptionDetail, String methodName, String params) {
		super();
		this.id = id;
		this.opertype = opertype;
		this.content = content;
		this.cost = cost;
		this.createip = createip;
		this.createuser = createuser;
		this.createtime = createtime;
		this.memo = memo;
		this.mod = mod;
		this.type = type;
		this.exceptionCode = exceptionCode;
		this.exceptionDetail = exceptionDetail;
		this.methodName = methodName;
		this.params = params;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpertype() {
		return opertype;
	}
	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getCost() {
		return cost;
	}
	public void setCost(Long cost) {
		this.cost = cost;
	}
	public String getCreateip() {
		return createip;
	}
	public void setCreateip(String createip) {
		this.createip = createip;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getMod() {
		return mod;
	}
	public void setMod(String mod) {
		this.mod = mod;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionDetail() {
		return exceptionDetail;
	}

	public void setExceptionDetail(String exceptionDetail) {
		this.exceptionDetail = exceptionDetail;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result
				+ ((createip == null) ? 0 : createip.hashCode());
		result = prime * result
				+ ((createtime == null) ? 0 : createtime.hashCode());
		result = prime * result
				+ ((createuser == null) ? 0 : createuser.hashCode());
		result = prime * result
				+ ((exceptionCode == null) ? 0 : exceptionCode.hashCode());
		result = prime * result
				+ ((exceptionDetail == null) ? 0 : exceptionDetail.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((memo == null) ? 0 : memo.hashCode());
		result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
		result = prime * result + ((mod == null) ? 0 : mod.hashCode());
		result = prime * result
				+ ((opertype == null) ? 0 : opertype.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Log other = (Log) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (createip == null) {
			if (other.createip != null)
				return false;
		} else if (!createip.equals(other.createip))
			return false;
		if (createtime == null) {
			if (other.createtime != null)
				return false;
		} else if (!createtime.equals(other.createtime))
			return false;
		if (createuser == null) {
			if (other.createuser != null)
				return false;
		} else if (!createuser.equals(other.createuser))
			return false;
		if (exceptionCode == null) {
			if (other.exceptionCode != null)
				return false;
		} else if (!exceptionCode.equals(other.exceptionCode))
			return false;
		if (exceptionDetail == null) {
			if (other.exceptionDetail != null)
				return false;
		} else if (!exceptionDetail.equals(other.exceptionDetail))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (memo == null) {
			if (other.memo != null)
				return false;
		} else if (!memo.equals(other.memo))
			return false;
		if (methodName == null) {
			if (other.methodName != null)
				return false;
		} else if (!methodName.equals(other.methodName))
			return false;
		if (mod == null) {
			if (other.mod != null)
				return false;
		} else if (!mod.equals(other.mod))
			return false;
		if (opertype == null) {
			if (other.opertype != null)
				return false;
		} else if (!opertype.equals(other.opertype))
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Log [id=" + id + ", opertype=" + opertype + ", content="
				+ content + ", cost=" + cost + ", createip=" + createip
				+ ", createuser=" + createuser + ", createtime=" + createtime
				+ ", memo=" + memo + ", mod=" + mod + ", type=" + type
				+ ", exceptionCode=" + exceptionCode + ", exceptionDetail="
				+ exceptionDetail + ", methodName=" + methodName + ", params=" + params
				+ "]";
	}
	
	

}
