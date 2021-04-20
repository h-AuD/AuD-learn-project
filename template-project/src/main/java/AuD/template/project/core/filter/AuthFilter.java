package AuD.template.project.core.filter;


import AuD.component.common.server.ServerResultHandle;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @program: demo
 * @description: used for authorization {@Component ## for all api}
 * @author: Li.Yang
 * @create: 2021-01-19 20:59
 **/
@Slf4j
@WebFilter(filterName="signatureFilter", urlPatterns="/template/test")
public class AuthFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String signature = req.getHeader("test");
        if("aaa".equalsIgnoreCase(signature)){
            log.info("auth success");
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            log.info("auth failed {} ",signature);
            servletResponse.getWriter().println(JSON.toJSONString(ServerResultHandle.of(123,"auth failed")));
        }

    }

    @Override
    public void destroy() {

    }
}
