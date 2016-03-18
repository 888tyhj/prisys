package com.prisys.web.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Tree implements Serializable {

	/**
	 * @author yangl
	 * @Fields serialVersionUID : TODO
	 */

	private static final long serialVersionUID = -8121304715809190821L;

	private String id;
	private String text;
	private String iconCls;
	private String checked;
	private String state = "open";
	private Map<String, Object> attributes;
	private List<Tree> children;
	private String person;
	private Integer type;
	private String url;
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public List<Tree> getChildren() {
		return children;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
