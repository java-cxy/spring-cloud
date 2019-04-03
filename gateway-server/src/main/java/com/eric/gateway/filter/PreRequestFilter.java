package com.eric.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @Description 请求进来时的过滤器
 * @Date 2019/4/3 17:01
 * @Author LSM
 **/
@Slf4j
@Component
public class PreRequestFilter extends ZuulFilter {

    /**
     * 定义filter类型
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 定义filter之间执行的顺序，数字越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体的业务操作
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //RequestContext使用由zuul提供的类
        RequestContext ctx = RequestContext.getCurrentContext();
        //把请求进来时的时间放到上下文中进行传输
        ctx.set("startTime",System.currentTimeMillis());
        return null;
    }
}
