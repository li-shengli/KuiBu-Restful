package com.selfstudy.kuibu.service;

import com.selfstudy.kuibu.persistence.UserInfoEntity;
import com.selfstudy.kuibu.service.api.IAuthenticationService;

public class AuthenticationService extends AbstractService implements IAuthenticationService {
    @Override
    public UserInfoEntity login(String username, String password) {

        return null;
    }

    @Override
    public boolean register(UserInfoEntity userEntity) {
        return false;
    }
}
