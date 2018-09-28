package com.selfstudy.kuibu.restful;

import com.selfstudy.kuibu.persistence.UserInfoEntity;
import com.selfstudy.kuibu.service.api.IAuthenticationService;
import com.selfstudy.kuibu.vo.UserInfo;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@Produces({ "text/xml", "application/json" })
public class UserRestService {

    private static Logger logger = Logger.getLogger(UserRestService.class);

    @Inject
    private IAuthenticationService authService;

    @Path("/user/login")
    @POST
    @Produces("application/json")
    public UserInfo login(String username, String password) throws IllegalStateException{
        if (logger.isDebugEnabled()) {
            logger.debug("User ["+username+"] login in.");
        }
        UserInfoEntity entity = authService.login(username,password);

        if(entity != null) {
            if (logger.isDebugEnabled()) {
                logger.debug("User ["+username+"] exist.");
            }
            return new UserInfo(entity);
        }
        throw new IllegalStateException("Cannot find the User with username = " + username);
    }

    @Path("/user/register")
    @POST
    @Produces("application/json")
    public void register (UserInfo user) {
        if (logger.isDebugEnabled()) {
            logger.debug("User ["+user.getNickName()+"] registered.");
        }
        authService.register(user);
    }
}
