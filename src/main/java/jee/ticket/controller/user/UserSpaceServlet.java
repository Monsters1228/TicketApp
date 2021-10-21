package jee.ticket.controller.user;

import jee.ticket.dao.TicketDao;
import jee.ticket.dao.UserDao;
import jee.ticket.domain.Ticket;
import jee.ticket.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/u")
public class UserSpaceServlet extends HttpServlet {
    //处理GET请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null)
            action = "view";
        switch (action) {
            case "view":
                this.viewUser(req, resp);
                break;
            default:
                break;
        }
    }




    //查看详情
    public void viewUser(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

}
