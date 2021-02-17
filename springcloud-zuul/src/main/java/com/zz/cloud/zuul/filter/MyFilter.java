package com.zz.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter {

    /**
     * 此过滤器的类型
     * to classify a filter by type. Standard types in Zuul are "pre" for pre-routing filtering,
     *      * "route" for routing to an origin, "post" for post-routing filters, "error" for error handling.
     *
     *      pre
     *      route
     *      post
     *      error
     * @return
     */
    @Override
    public String filterType() {
        String filterType = "pre";
        return filterType;
    }


    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断当前请求是否要过滤
     * true 过滤执行run
     * false 不过滤直接放行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        //示例
        String signal = request.getParameter("signal");


        return "filter".equals(signal);
    }

    @Override
    public Object run() throws ZuulException {

        System.out.println("当前请求需要过滤");
        return null;
    }
}
