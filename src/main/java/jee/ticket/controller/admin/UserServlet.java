package jee.ticket.controller.admin;

import jee.ticket.dao.UserDao;
import jee.ticket.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

//管理员的用户管理功能
@WebServlet("/admin/user")
public class UserServlet extends HttpServlet {
    //处理GET请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null) action = "list";
        switch (action){
            case "view":
                this.viewUser(req,resp);
                break;
            case "del":
                this.delUser(req,resp);
                break;
            case "list":
                this.listUser(req, resp);
                break;
            case "create":
                this.toCreate(req, resp);
                break;
            default:
                break;
        }
    }
    //处理POST请求,提供两种添加用户的操作，一个是后台创建用户，一个是用户注册
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        switch (action){
            case "create":
                this.createUser(req, resp);
            case "register":
                this.register(req, resp);
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) {
    }

    //后台添加用户
    public void createUser(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setCreateDate(new Date());
        user.setEmail(email);
        user.setRegisterIp(req.getRemoteAddr());
        userDao.insert(user);
        resp.sendRedirect("/admin/user");
    }
    //跳转到添加用户界面
    public void toCreate(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/template/admin/user/add.jsp").forward(req, resp);
    }

    //删除用户
    public void delUser(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 获取用户ID
        UserDao userDao = new UserDao();
        Long id = Long.parseLong(req.getParameter("id"));
        userDao.deleteById(id);
        resp.sendRedirect("/admin/user");
    }
    //查看用户列表
    public void listUser(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //获取用户列表
        UserDao userDao = new UserDao();
        List list  = userDao.findAll();
        System.out.println(list);
        req.setAttribute("userList", list);
        req.getRequestDispatcher("/WEB-INF/template/admin/user/list.jsp").forward(req, resp);
    }
    //查看详情
    public void viewUser(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //获取用户id
        Long id = Long.parseLong(req.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.findById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/template/admin/user/view.jsp").forward(req, resp);
    }
}
