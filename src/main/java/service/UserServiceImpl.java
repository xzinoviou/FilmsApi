package service;

import dao.UserDao;
import model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by xzinoviou
 * 27/10/2018
 */

@Path("/user")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(){
        super();
        userDao = new UserDao();
    }



    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object fetch(@PathParam("id") Long id) {

        User user = userDao.findUserById(id);

        return user!=null ? user : "{\"error\":\"Such information is not present in database\"}";
    }
}
