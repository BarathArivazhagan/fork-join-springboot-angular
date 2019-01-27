package com.barath.gateway.app.filter;

import java.lang.invoke.MethodHandles;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import com.netflix.zuul.context.RequestContext;

@Component
public class CustomErrorFilter extends SendErrorFilter {

    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Value("${error.path:/error}")
    private String errorPath;


    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            HttpServletRequest request = ctx.getRequest();

            request.setAttribute("javax.servlet.error.status_code", exception.getStatusCode());

            logger.warn("Error during filtering", exception.getThrowable());
            request.setAttribute("javax.servlet.error.exception", exception.getThrowable());

            if (StringUtils.hasText(exception.getErrorCause())) {
                request.setAttribute("javax.servlet.error.message", exception.getErrorCause());
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    this.errorPath);
            if (dispatcher != null) {
                ctx.set(SEND_ERROR_FILTER_RAN, true);
                if (!ctx.getResponse().isCommitted()) {
                    ctx.setResponseStatusCode(exception.getStatusCode());
                    dispatcher.forward(request, ctx.getResponse());
                }
            }
        }
        catch (Exception ex) {

            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }



}
