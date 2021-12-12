package tracker.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init filter");
        //Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpRequest.getSession();

        if(session.getAttribute("user") == null) {
            RequestDispatcher rd = httpRequest.getRequestDispatcher("/templates/log.jsp");
            rd.include(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy(){}
}
