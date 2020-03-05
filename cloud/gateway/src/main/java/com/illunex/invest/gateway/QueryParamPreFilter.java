package com.illunex.invest.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

public class QueryParamPreFilter extends ZuulFilter {
    private final Logger log = LoggerFactory.getLogger(QueryParamPreFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return !ctx.containsKey(FORWARD_TO_KEY) && !ctx.containsKey(SERVICE_ID_KEY);
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.debug("Request Method : " + request.getMethod());
        log.debug("Request URL : " + request.getRequestURL().toString());
        System.out.println("==========================1");
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println(authorizationHeader);
        System.out.println("==========================2");
        ctx.addZuulRequestHeader("Authorization", authorizationHeader);
//        if (!validateToken(authorizationHeader)) {
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseBody("API key not authorized");
//            ctx.getResponse().setHeader("Content-Type", "text/plain;charset=UTF-8");
//            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
//        }
        return null;
    }

    private boolean validateToken(String tokenHeader) {
        // do something to validate the token
        return true;
    }
}
