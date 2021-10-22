package jee.ticket.controller;

import jee.ticket.dao.TicketDao;
import jee.ticket.domain.Ticket;
import jee.ticket.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@WebServlet("/ticket")
public class TicketServlet extends HttpServlet {
    //处理GET请求
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "list";
        switch (action) {
            case "view":
                this.viewTicket(req,resp);
                break;
            case "del":
                this.delTicket(req,resp);
                break;
            case "list":
                this.listTicket(req,resp);
                break;
            case "create":
                this.toCreate(req,resp);
                break;
            default:
                break;
        }
    }

    //处理POST请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                this.createTicket(req,resp);
                break;
            default:
                break;
        }
    }

    //添加票据
    public void createTicket(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        TicketDao ticketDao = new TicketDao();
        String companyName = req.getParameter("companyName");
        double money = Double.parseDouble(req.getParameter("money"));
        String type = req.getParameter("type");
        String subject = req.getParameter("subject");
        String body = req.getParameter("body");
        Date submitDate = new Date();
        Ticket ticket = new Ticket(companyName,money,subject,body,type,loginUser.getUsername());
        ticket.setSubmitDate(submitDate);
        ticketDao.insert(ticket);
        // 重定向
        resp.sendRedirect("/ticket");
    }

    //跳转到添加票据界面
    public void toCreate(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/template/ticket/add.jsp").forward(req, resp);
    }

    //删除票据
    public void delTicket(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        TicketDao ticketDao = new TicketDao();
        //获取票据id
        long id = Long.parseLong(req.getParameter("id"));
        ticketDao.deleteById(id);
        //重定向到list URL
        resp.sendRedirect("/ticket");
    }

    //查看票据列表
    public void listTicket(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //添加代码，如果是普通用户，只能查看到自己提交的票据
        //管理员则可以看到所有票据
        //获取票据列表
        HttpSession session = req.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        TicketDao ticketDao = new TicketDao();
        List<Ticket> list = ticketDao.findAll();
        System.out.println(list);
        if(loginUser.getRole().equals("ROLE_ADMIN")){
            req.setAttribute("ticketList",list);
        } else {
            List<Ticket> ticketList = (list.stream()
                    .filter(i -> i.getSubmitter()
                            .equals(loginUser.getUsername())))
                    .collect(Collectors.toList());
            req.setAttribute("ticketList",ticketList);
        }
        req.getRequestDispatcher("/WEB-INF/template/ticket/list.jsp").forward(req,resp);
    }

    //查看详情
    public void viewTicket(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //获取票据id
        long id = Long.parseLong(req.getParameter("id"));
        //调用dao的方法
        TicketDao ticketDao = new TicketDao();
        Ticket ticket = ticketDao.findById(id);
        //
        req.setAttribute("ticket",ticket);
        req.getRequestDispatcher("/WEB-INF/template/ticket/view.jsp").forward(req,resp);
    }
}
