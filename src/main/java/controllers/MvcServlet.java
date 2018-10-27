package controllers;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xzinoviou
 * 26/10/2018
 */
@WebServlet(name="MvcServlet", urlPatterns = "/mvc-servlet")
public class MvcServlet extends javax.servlet.http.HttpServlet {

    private UserDao userDao = new UserDao();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        processRequest(request,response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        processRequest(request,response);
    }


    /**
     * This is where all the process of the requests takes place
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        String email = request.getParameter("email");
        String password = request.getParameter("password");

        boolean isUserValid = userDao.isUserPresentInDB(email,password);


        if(isUserValid){

            User user = userDao.findUserByCredentials(email,password);

            request.setAttribute("user",user);
            RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher("/WEB-INF/menu.jsp");
            requestDispatcher.forward(request,response);

        } else{
            response.sendRedirect("login.jsp");
        }



    }

}
