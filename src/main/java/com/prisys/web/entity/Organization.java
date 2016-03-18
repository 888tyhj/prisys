package com.prisys.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
* @ClassName: Organization
* @Description: TODO
* @author yangl
* @date 2015-6-3 下午3:50:33
*
 */
@Entity
@Table(name="sys_organization")
public class Organization implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5747888910363913886L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; //编号
	@Column
    private String name; //组织机构名称
	@Column
    private String code; //组织机构代码
	@Column(name="parent_id")
    private Long _parentId; //父编号
	@Column(name="parent_ids")
    private String parentIds; //父编号列表，如1/2/
	@Column
    private Boolean available = Boolean.FALSE;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Long get_parentId() {
		return _parentId;
	}

	public void set_parentId(Long _parentId) {
		this._parentId = _parentId;
	}

	public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public boolean isRootNode() {
        return _parentId == 0;
    }
    
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

    public String makeSelfAsParentIds() {
        return getParentIds() + getId() + "/";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + _parentId +
                ", parentIds='" + parentIds + '\'' +
                ", available=" + available +
                '}';
    }
}
