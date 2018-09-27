package com.selfstudy.kuibu.service.api;

import com.selfstudy.kuibu.persistence.UserInfoEntity;
import com.selfstudy.kuibu.vo.UserInfo;

public interface IAuthenticationService {
    UserInfoEntity login(String username, String password);

    boolean register (UserInfo userEntity);
}
