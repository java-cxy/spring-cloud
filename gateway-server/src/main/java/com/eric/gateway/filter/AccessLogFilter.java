package com.eric.gateway.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 请求结束之后执行的filter
 * @Date 2019/4/3 18:25
 * @Author LSM
 **/
@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        //需要从request中获取访问链接
        HttpServletRequest request = context.getRequest();
        Long startTime = (Long) context.get("startTime");
        String uri = request.getRequestURI();
        //请求所消耗的时间
        long duration = System.currentTimeMillis() - startTime;
        log.info("===========AccessLogFilter==========");
        log.info("uri : " + uri + ", duration : " + duration/100 + "ms");
        return null;
    }
}
