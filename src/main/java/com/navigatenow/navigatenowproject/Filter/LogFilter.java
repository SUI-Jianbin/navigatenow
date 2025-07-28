package com.navigatenow.navigatenowproject.Filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class LogFilter {

   /* @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    String correlationId = UUID.randomUUID().toString();
        MDC.put("correlationId", correlationId);
        chain.doFilter(request,response);
        MDC.clear();
    }*/
}
