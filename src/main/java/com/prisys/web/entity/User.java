package com.prisys.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
* @ClassName: User
* @Description: TODO
* @author yangl
* @date 2015-6-3 下午4:00:00
*
 */
@Entity
@Table(name="sys_user")
public class User implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5771007650355811634L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; //编号
	@Column(name="organization_id")
    private String organizationId; //所属公司
	@Column
    private String username; //用户名
	@Column
    private String realname; //真实姓名
	@Column
    private String password; //密码
	@Column
    private String salt; //加密密码的盐
	@Column(name="role_ids")
    private String roleIds; //拥有的角色列表
	@Column(name="isshow")
	private Integer isshow=2;//1、不显示  2、显示
	@Column
    private Boolean locked = Boolean.FALSE;
	
	@Column
	private Integer age;
	@Transient
	private String orgName;//组织名称
	@Transient
	private String roleName;//角色名称

    public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }
    
    

//    public List<Long> getRoleIds() {
//        if(roleIds == null) {
//            roleIds = new ArrayList<Long>();
//        }
//        return roleIds;
//    }

//    public void setRoleIds(List<Long> roleIds) {
//        this.roleIds = roleIds;
//    }


//    public String getRoleIdsStr() {
//        if(CollectionUtils.isEmpty(roleIds)) {
//            return "";
//        }
//        StringBuilder s = new StringBuilder();
//        for(Long roleId : roleIds) {
//            s.append(roleId);
//            s.append(",");
//        }
//        return s.toString();
//    }

//    public void setRoleIdsStr(String roleIdsStr) {
//        if(StringUtils.isEmpty(roleIdsStr)) {
//            return;
//        }
//        String[] roleIdStrs = roleIdsStr.split(",");
//        for(String roleIdStr : roleIdStrs) {
//            if(StringUtils.isEmpty(roleIdStr)) {
//                continue;
//            }
//            getRoleIds().add(Long.valueOf(roleIdStr));
//        }
//    }
    
    public Integer getIsshow() {
		return isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", roleIds=" + roleIds +
                ", locked=" + locked +
                '}';
    }

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
}
