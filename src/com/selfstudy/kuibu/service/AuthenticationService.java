package com.selfstudy.kuibu.service;

import com.datastax.driver.mapping.Mapper;
import com.selfstudy.kuibu.persistence.UserInfoEntity;
import com.selfstudy.kuibu.service.api.IAuthenticationService;
import com.selfstudy.kuibu.util.MD5Util;
import com.selfstudy.kuibu.vo.UserInfo;

public class AuthenticationService extends AbstractService implements IAuthenticationService {

    @Override
    public UserInfoEntity login(String username, String password) {
        UserInfoEntity entity = accessor.getUserInfo(username).one();
        String userPassword = MD5Util.md5Encode(password);

        if (entity.getPassword().equals(userPassword)) {
            return entity;
        }
        return null;
    }

    @Override
    public boolean register(UserInfo user) {
        UserInfoEntity exist = accessor.getUserInfo(user.getUsername()).one();

        if (exist != null){
            throw new IllegalStateException("User with same login name exist, login name = " + user.getUsername());
        }

        UserInfoEntity userEntity = user.toEntity();
        userEntity.setPassword(MD5Util.md5Encode(user.getPassword()));
        Mapper<UserInfoEntity> activityMapper = manager.mapper(UserInfoEntity.class);
        activityMapper.save(userEntity);

        return true;
    }
}
