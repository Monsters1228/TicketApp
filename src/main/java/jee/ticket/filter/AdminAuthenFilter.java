package jee.ticket.filter;

import jee.ticket.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminAuthenFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Object u = session.getAttribute("loginUser");
        if(u == null){
            response.sendRedirect(request.getContextPath() + "/login");
        }else{
            User user = (User)u;
            if(!"ROLE_ADMIN".equals(user.getRole())){
                response.sendRedirect(request.getContextPath()+"/login");
            }else{
                chain.doFilter(req,resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }
}
