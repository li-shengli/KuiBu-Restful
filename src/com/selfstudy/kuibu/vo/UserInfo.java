package com.selfstudy.kuibu.vo;

import com.datastax.driver.mapping.annotations.Column;
import com.selfstudy.kuibu.constants.Gender;
import com.selfstudy.kuibu.persistence.UserInfoEntity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserInfo {
    private String username;

    private String password;

    private UUID id;

    private String nickName;

    private Gender gender;

    private String mail;

    private String profileUrl;

    private List<UUID> tasklist;

    private Date createTime;

    private Date lastUpdateTime;

    private UserInfo() {}

    public UserInfo (UserInfoEntity entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.nickName = entity.getNickName();
        this.tasklist = entity.getTasklist();
    }

    public UserInfoEntity toEntity() {
        UserInfoEntity entity = new UserInfoEntity();
        entity.setId(this.id);
        entity.setUsername(this.username);
        entity.setPassword(this.password);
        entity.setNickName(this.nickName);
        entity.setTasklist(this.tasklist);
        return entity;
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public List<UUID> getTasklist() {
        return tasklist;
    }

    public void setTasklist(List<UUID> tasklist) {
        this.tasklist = tasklist;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
