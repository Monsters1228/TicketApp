package jee.ticket.controller;

import jee.ticket.dao.UserDao;
import jee.ticket.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.NoSuchElementException;

//用户登录，使用自身数据库验证
//servlet url映射
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean bSuccess = false;
        UserDao userDao = new UserDao();
        User user;
        try {
            user = userDao.findByUsernamePassWord(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);
            if("ROLE_ADMIN".equals(user.getRole())){
                response.sendRedirect("/admin/user");
            } else if ("ROLE_USER".equals(user.getRole())){
                response.sendRedirect("/ticket");
            }
        } catch (NoSuchElementException e) {
            request.setAttribute("msg","用户名活密码错误，请重新输入");
            request.getRequestDispatcher("/WEB-INF/template/login.jsp").forward(request,response);
            e.printStackTrace();
        }
    }
    //跳转到登录页面
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("msg","");
        request.getRequestDispatcher("/WEB-INF/template/login.jsp")
                .forward(request, response);
    }
}
