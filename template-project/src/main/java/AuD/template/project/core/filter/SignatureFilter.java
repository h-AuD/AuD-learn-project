package AuD.template.project.core.filter;

import AuD.template.project.core.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 使用{@link OncePerRequestFilter} 作用拦截器
 *
 * @author AuD/胡钊
 * @ClassName SignatureFilter
 * @date 2021/4/27 16:59
 * @Version 1.0
 */
@Slf4j
//@Component
public class SignatureFilter extends OncePerRequestFilter {

    /**
     *
     * @param request
     * @return true:不拦截请求,false:拦截请求
     * @throws ServletException
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return super.shouldNotFilter(request);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        throw new BusinessException(1,"");
    }
}
