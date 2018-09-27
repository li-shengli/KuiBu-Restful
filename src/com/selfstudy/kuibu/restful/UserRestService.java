package com.selfstudy.kuibu.restful;

import com.selfstudy.kuibu.persistence.UserInfoEntity;
import com.selfstudy.kuibu.service.api.IAuthenticationService;
import com.selfstudy.kuibu.vo.UserInfo;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/user")
@Produces({ "text/xml", "application/json" })
public class UserRestService {
    @Inject
    private IAuthenticationService authService;

    @Path("/login")
    @POST
    @Produces("application/json")
    public UserInfo login(String username, String password) throws IllegalStateException{
        UserInfoEntity entity = authService.login(username,password);

        if(entity != null) {
            return new UserInfo(entity);
        }
        throw new IllegalStateException("Cannot find the User with username = " + username);
    }

    @Path("/register")
    @POST
    @Produces("application/json")
    public void register (UserInfo user) {
        authService.register(user);
    }
}
