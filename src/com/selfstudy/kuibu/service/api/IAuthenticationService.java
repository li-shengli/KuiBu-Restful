package com.selfstudy.kuibu.service.api;

import com.selfstudy.kuibu.persistence.UserInfoEntity;

public interface IAuthenticationService {
    UserInfoEntity login(String username, String password);

    boolean register (UserInfoEntity userEntity);
}
