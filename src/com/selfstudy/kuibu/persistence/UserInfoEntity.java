package com.selfstudy.kuibu.persistence;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.selfstudy.kuibu.constants.Gender;

@Table(keyspace = "KuiBu", name = "userInformation", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class UserInfoEntity {
    @PartitionKey
    @Column(name = "longinName")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "userId")
    private UUID id;

    @Column(name = "nickname")
    private String nickName;

    @Enumerated (value = EnumType.ORDINAL)
    @Column(name = "gender")
    private Gender gender = Gender.MAIL;

    @Column(name = "mail")
    private String mail;

    @Column(name = "profileUrl")
    private String profileUrl;

    @Column(name = "tasklist")
    private List<UUID> tasklist;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "lastUpdateTime")
    private Date lastUpdateTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
