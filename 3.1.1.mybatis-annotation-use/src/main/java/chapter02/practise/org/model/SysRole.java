package chapter02.practise.org.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 角色表
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = 6320941908222932112L;
    /**
     * 角色ID
     */
    private Long id;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 用户信息
     */
    private SysUser user;

    private List<SysPrivilege> privileges;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<SysPrivilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<SysPrivilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", user=" + user +
                ", privileges=" + privileges +
                '}';
    }
}
