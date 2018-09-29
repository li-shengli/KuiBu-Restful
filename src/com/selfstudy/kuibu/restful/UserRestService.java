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
    public UserInfo login(UserInfo user) throws IllegalStateException{
        if (logger.isDebugEnabled()) {
            logger.debug("User ["+user.getUsername()+"] login in.");
        }
        UserInfoEntity entity = authService.login(user.getUsername(),user.getPassword());

        if(entity != null) {
            if (logger.isDebugEnabled()) {
                logger.debug("User ["+user.getUsername()+"] exist.");
            }
            return new UserInfo(entity);
        }
        throw new IllegalStateException("Cannot find the User with username = " + user.getUsername());
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
