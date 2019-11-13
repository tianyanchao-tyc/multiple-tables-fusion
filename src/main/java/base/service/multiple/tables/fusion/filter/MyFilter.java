package base.service.multiple.tables.fusion.filter;

import io.swagger.models.auth.In;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

/**
 * 过滤器
 *
 * @author tyc
 * date 2019-11-12
 */
@Component
@Order
@WebFilter(filterName = "MyFilter", urlPatterns = {"/fusion/**"})
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Instant start = Instant.now();
        chain.doFilter(request,response);
        Instant ent = Instant.now();
        System.out.println("耗时 --> " + Duration.between(start,ent));
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter 销毁了");
    }
}
