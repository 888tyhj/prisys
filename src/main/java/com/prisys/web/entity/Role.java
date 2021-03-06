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
* @ClassName: Role
* @Description: TODO
* @author yangl
* @date 2015-6-3 下午3:58:01
*
 */
@Entity
@Table(name="sys_role")
public class Role implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8184492862529514757L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; //编号
	@Column
    private String role; //角色标识 程序中判断使用,如"admin"
	@Column
    private String name; //角色名称
	@Column
    private String description; //角色描述
	@Column(name="resource_ids")
    private String resourceIds; //拥有的资源
	@Column
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户
	
	@Column
	private Integer isshow=2;//1、不显示  2、显示

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role() {
    }

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Long> getResourceIds() {
//        if(resourceIds == null) {
//            resourceIds = new ArrayList<Long>();
//        }
//        return resourceIds;
//    }

//    public void setResourceIds(List<Long> resourceIds) {
//        this.resourceIds = resourceIds;
//    }
//
//    public String getResourceIdsStr() {
//        if(CollectionUtils.isEmpty(resourceIds)) {
//            return "";
//        }
//        StringBuilder s = new StringBuilder();
//        for(Long resourceId : resourceIds) {
//            s.append(resourceId);
//            s.append(",");
//        }
//        return s.toString();
//    }

//    public void setResourceIdsStr(String resourceIdsStr) {
//        if(StringUtils.isEmpty(resourceIdsStr)) {
//            return;
//        }
//        String[] resourceIdStrs = resourceIdsStr.split(",");
//        for(String resourceIdStr : resourceIdStrs) {
//            if(StringUtils.isEmpty(resourceIdStr)) {
//                continue;
//            }
//            getResourceIds().add(Long.valueOf(resourceIdStr));
//        }
//    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getIsshow() {
		return isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", resourceIds=" + resourceIds +
                ", available=" + available +
                '}';
    }

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}
}
