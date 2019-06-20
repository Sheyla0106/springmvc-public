package com.sheyla.springmvc.bean.user;

import java.util.Date;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/19 0:06
 * @Modified By：
 */
public class UserBean {
    private Long id;
    private String userId;
    private String name;
    private Boolean status;
    private String creator;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
